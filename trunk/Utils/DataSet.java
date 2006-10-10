/*
 * DataSet.java
 *
 * Created on January 28, 2006, 3:51 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package Utils;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Tariy
 */

public class DataSet {
    
    private String name;
    private NodeNoF root;
    private NodeNoF current;
    public NodeF lroot;
    public NodeF lcurrent;
    public NodeNoF lnode;
    public short frecuency;
    private AvlTree candidatesOne;
    private int ntransactions;
    private ArrayList dictionary;
    
    /**
     * Creates a new instance of DataSet
     */
    public DataSet(String n) {
        this.name = n;
        this.root = new NodeNoF();
        this.current = root;
        this.lroot = null;
        this.candidatesOne = new AvlTree();
        this.ntransactions = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getDictionary() {
        return dictionary;
    }
    
    public void buildMultiValuedDictionary(ArrayList array){
        dictionary = array;
        Collections.sort(dictionary);
    }
    
    public void buildDictionary(ResultSet rs){
        try {
            rs.last();
            dictionary = new ArrayList(rs.getRow());
            rs.first();
            
            String typeColumn = rs.getMetaData().getColumnClassName(1);
            if(typeColumn.equals("java.lang.Short")){
                buildShortDictionary(rs);
            } else if(typeColumn.equals("java.lang.String")){
                buildStringDictionary(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Collections.sort(dictionary);
    }
    
    private void buildShortDictionary(ResultSet rs){
        try {
            dictionary.add(Short.toString(rs.getShort(1)));
            //dictionary.add(rs.getShort(1));
            while(rs.next()){
                dictionary.add(Short.toString(rs.getShort(1)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    private void buildStringDictionary(ResultSet rs){
        try {
            dictionary.add(rs.getString(1));
            while(rs.next()){
                dictionary.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    

    public short codeAttribute(String attr){
        return (short)Collections.binarySearch(dictionary, attr);
    }
    
    public void showDictionary(){
        Iterator it = dictionary.iterator();
        int i = 1;
        while(it.hasNext()){
            System.out.println((i++) + " " + (String)it.next() + ", ");
        }
    }
    
    public void setNtransactions(int ntransactions) {
        this.ntransactions = ntransactions;
    }
    
    public int getNtransactions() {
        return ntransactions;
    }
    
    public void buildNTree(short n, int id) {
        ItemSet itemset1 = new ItemSet(1);
        itemset1.addItem(n);
        candidatesOne.insertItemsetOne(itemset1);
        NodeF leaf = null;
        if((id == 0 || id == -2) && current != root ) {
            current = root;
            ntransactions++;
        }  else if(current == root){
            ntransactions++;
        }
        if(current.son == null) {
            current = current.addSon(n, id);
            if(id == -1 || id == -2) {
                linkLeaf((NodeF) current);
            }
        } else {
            NodeNoF aux = current.findBro(n, id);
           
            if(aux.getItem() == n) {
                current = aux;
                if((id == -1 || id == -2) && ((NodeF)current).getFrec() == 1){
                    linkLeaf((NodeF) current);
                }
            } else {
                current = aux.addBro(n, id);
                if(id == -1 || id == -2){
                    linkLeaf((NodeF) current);
                }
            }
        }
    }
    
    public AvlTree getCandidatesOne() {
        return candidatesOne;
    }
    
    public void pruneCandidatesOne(int minSupport, AvlTree frequentsOne ){
        pruneCandidatesOne( candidatesOne.getRoot(), minSupport, frequentsOne);
    }
    
    private void pruneCandidatesOne( AvlNode t, int minSupport, AvlTree frequentsOne){
        if( t != null ){
            pruneCandidatesOne( t.left, minSupport, frequentsOne);
            if(t.element.getSupport() >= minSupport){
                frequentsOne.insert(t.element);
            }
            pruneCandidatesOne( t.right, minSupport, frequentsOne);
        }
    }
    
    public void linkLeaf(NodeF leaf) {
        if(lroot == null) {
            lroot = leaf;
            lcurrent = lroot;
        } else if(leaf != current.son || leaf != current.bro) {
            lcurrent.next = leaf;
            lcurrent = leaf;
        }
    }
    
    public NodeNoF getRoot() {
        return this.root;
    }
    
    public void setPointers(){
        lcurrent = this.lroot;
        lnode = this.lroot;
        frecuency = lcurrent.getFrec();
    }
    
    public short getNode() {
        short item = -1;
        if(lnode.dad != null){
            item = lnode.getItem();
            lnode = (NodeNoF)lnode.dad;
        }else if(lcurrent.next != null){
            item = lnode.getItem();
            if(--frecuency == 0){
                lcurrent = lcurrent.next;
                frecuency = lcurrent.getFrec();
            }
            lnode = lcurrent;
        }
        return item;
    }
    
    public void showNTree() {
        int i = 0;
        NodeF aux = this.lroot;
        while(aux != null) {
            System.out.println(++i + " " +aux.getPath());
            aux = aux.next;
        }
    }
    
    public void saveTree(String path) {
        FileManager aa = new FileManager(path);
        NodeNoF aux = getRoot().son;
        NodeF nf = null;
        while(aux.bro != null || aux.dad != null) {
            if(aux.son != null) {
                aa.writeItem((short) aux.getItem());
                if(aux.getClass().getSimpleName().compareTo("NodeF") == 0) {
                    aa.writeItem((short) -3);
                    nf = (NodeF) aux;
                    aa.writeItem(nf.getFrec());
                }
                aa.writeItem((short) -1);
                aux = aux.son;
            } else {
                aa.writeItem(aux.getItem());
                aa.writeItem((short) -3);
                nf = (NodeF) aux;
                aa.writeItem(nf.getFrec());
                if(aux.bro != null)
                    aux = aux.bro;
                else {
                    // si no entra en tiene hijo? no escriba cierra parentesis
                    aa.writeItem((short) -2);
                    aux = aux.dad;
                    while(aux.bro == null && aux.dad.getItem() != -5) {
                        aa.writeItem((short) -2);
                        aux = aux.dad;
                    }
                    if(aux.bro != null)
                        aux = aux.bro;
                    else if(aux.dad.getItem() == -5)
                        aux = getRoot();
                }
            }
        }
        //aa.readFile(0);
        aa.closeFile();
        System.out.println();
    }
    
    public void rollBackTree(String path) {
        DataSet rTree = new DataSet("rollBackTree");
        FileManager aa = new FileManager(path);
        short s = 0, aux = 0;
        int pos = 0;
        try {
            aa.setOutChannel(pos);
            s = aa.outChannel.readShort();
            pos += 2;
            rTree.current = rTree.current.addSon(s, 1);
            while(true) {
                s = aa.outChannel.readShort();
                pos += 2;
                while(s == -1) {
                    s = aa.outChannel.readShort();
                    pos += 2;
                    aux = s;
                    s = aa.outChannel.readShort();
                    pos += 2;
                    if(s == -1)
                        rTree.current = rTree.current.addSon(aux, 1);
                }
                if(s == -3) {
                    s = aa.outChannel.readShort();
                    pos += 2;
                    rTree.current = rTree.current.addSon(aux, s);
                    rTree.linkLeaf((NodeF) rTree.current);
                    /**********/
                    s = aa.outChannel.readShort();
                    pos += 2;
                    while(s >= 0) {
                        aux = s;
                        s = aa.outChannel.readShort();
                        pos += 2;
                        if(s == -3) {
                            s = aa.outChannel.readShort();
                            pos += 2;
                            rTree.current = rTree.current.addBro(aux, s);
                            rTree.linkLeaf((NodeF) rTree.current);
                            s = aa.outChannel.readShort();
                            pos += 2;
                        } else if(s == -1 || s == -2) {
                            pos -= 2;
                            aa.setOutChannel(pos);
                        }
                    }
                    if(s == -1 || s == -2) {
                        pos -= 2;
                        aa.setOutChannel(pos);
                    }
                    /**********/
                } else {
                    while(s == -2) {
                        rTree.current = rTree.current.dad;
                        s = aa.outChannel.readShort();
                        pos += 2;
                        if(s >= 0) {
                            aux = s;
                            s = aa.outChannel.readShort();
                            pos += 2;
                        }
                    }
                    if(s == -3) {
                        s = aa.outChannel.readShort();
                        pos += 2;
                        rTree.current = rTree.current.addBro(aux, s); // hermano con frecuencia
                        rTree.linkLeaf((NodeF) rTree.current);
                        /**********/
                        s = aa.outChannel.readShort();
                        pos += 2;
                        while(s >= 0) {
                            aux = s;
                            s = aa.outChannel.readShort();
                            pos += 2;
                            if(s == -3) {
                                s = aa.outChannel.readShort();
                                pos += 2;
                                rTree.current = rTree.current.addBro(aux, s);
                                rTree.linkLeaf((NodeF) rTree.current);
                                s = aa.outChannel.readShort();
                                pos += 2;
                            } else if(s == -1 || s == -2) {
                                pos -= 2;
                                aa.setOutChannel(pos);
                            }
                        }
                        if(s == -1 || s == -2) {
                            pos -= 2;
                            aa.setOutChannel(pos);
                        }
                        /**********/
                    } else if(s == -1) {
                        rTree.current = rTree.current.addBro(aux, 1); // hermano sin frecuencia
                        pos -= 2;
                        aa.setOutChannel(pos);
                    }
                }
            }
        } catch(EOFException e1) {
            rTree.showNTree();
            aa.closeFile();
            aa.deleteFile();
        } catch(IOException e2) {
            e2.printStackTrace();
        }
    }
}
