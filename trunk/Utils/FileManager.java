/*
 * FileManager.java
 *
 * Created on 3 de abril de 2005, 08:54 AM
 */

package Utils;

import java.io.*;
import java.util.*;

/**
 *
 * @author  Tariy
 */

public class FileManager {
    File out;
    RandomAccessFile outChannel;
    private int n = 0;
    private ArrayList dictionary;
    private ArrayList columns;
    
    public FileManager(String archivo) {
        try{
            out = new File( archivo );
            outChannel = new RandomAccessFile( out, "rw" );
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public ArrayList getDictionary() {
        return dictionary;
    }
    
    public int getTransactions() {
        return n;
    }
    
    public void writeItem(short s) {
        try{
            outChannel.seek( out.length() );
            outChannel.writeShort(s);
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public void writeString(String s){
        byte b[];
        try{
            b = s.getBytes();
            outChannel.seek( out.length() );
            outChannel.write(b);
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public long getFileSize() {
        return out.length();
    }
    
    public String getFileName() {
        return out.getName();
    }
    
    public void closeFile() {
        try{
            outChannel.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteFile() {
        out.deleteOnExit();
    }
    
    
    public void setOutChannel(int pos) throws IOException {
        outChannel.seek(pos);
    }
    
    public void ReadTransaction(int readposition) {
        try{
            outChannel.seek(readposition);
            short s;
            while( true ) {
                s = outChannel.readShort();
                if(s != 0)
                    System.out.print(s + " ");
                else
                    System.out.println();
            }
        } catch(EOFException e1) {
            this.closeFile();
        } catch(IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public void readFile(int initposition) {
        try{
            outChannel.seek(initposition);
            short s;
            while( true ) {
                s = outChannel.readShort();
                System.out.print(s + " ");
            }
        } catch(EOFException e1) {
            this.closeFile();
        } catch(IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public DataSet readFile() {
        DataSet tree = new DataSet("contact");
        
        try{
            short node;
            String attr = "";
            String cad = "start";
            StringTokenizer data;
            int tokenSize;
            boolean flagSortDictionary = true;
            // Se establece la capacidad inicial del diccionario.
            dictionary = new ArrayList(10);
            // Se adiciona el primer dato del diccionario, el elemento nulo.
            dictionary.add(new String("?"));
            outChannel.seek(0);
            
            while(true) {
                if(!cad.equalsIgnoreCase("@data")) {
                    cad = outChannel.readLine();
                    if(cad.length()>10 && cad.substring(0, 10).equalsIgnoreCase("@attribute")) {
                        this.buildDictionary(cad);
                    }
                } else {
                    if(flagSortDictionary){
                        Collections.sort(dictionary);
                        flagSortDictionary = false;
                    }
                    attr = outChannel.readLine();
                    data = new StringTokenizer(attr, ",");
                    tokenSize = data.countTokens();
                    for(int index=0; index<tokenSize-1; index++) {
                        attr = data.nextToken();
                        node = encodeAttribute(attr.trim());
                        if(node >= 0){
                            tree.buildNTree(node, index);
                        }
                    }
                    attr = data.nextToken();
                    node = encodeAttribute(attr.trim());
                    if(node >= 0){
                        tree.buildNTree(node, -1);
                    }
                }
            }
        } catch(EOFException e1) {
            this.closeFile();
        } catch(IOException e2) {
            e2.printStackTrace();
        } finally {
            //tree.showNTree();
            return tree;
            //tree.saveTree("/home/and/Reportes/ntree.tariy");
            //tree.rollBackTree("/home/and/Reportes/ntree.tariy");
        }
    }
    
    public void buildDictionary(int psize, String attributes) {
        String att = "", aux = "";
        int intSize = 0;
        dictionary = new ArrayList(psize);
        while(psize > 0) {
            int beg = attributes.indexOf('{');
            int end = attributes.indexOf('}');
            
            for(beg=beg+1; beg<end; beg++) {
                if(attributes.charAt(beg) != ',' && attributes.charAt(beg) != 32)
                    att = att + attributes.charAt(beg);
                else {
                    if(attributes.charAt(beg) == ',') {
                        intSize++;
                        att = att + ",";
                    }
                }
            }
            columns = new ArrayList(intSize+2);
            columns.add("?");
            for(int i=0; i<att.length(); i++) {
                if(att.charAt(i) != ',')
                    aux = aux + att.charAt(i);
                else {
                    columns.add(aux);
                    aux = "";
                }
            }
            columns.add(aux);
            dictionary.add(columns);
            attributes = attributes.substring(end+1, attributes.length());
            att = "";
            aux = "";
            intSize = 0;
            psize--;
        }
        
    }
    
    public short findAtt(String attribute, int index) {
        short node = 0;
        ArrayList al = (ArrayList) dictionary.get(index);
        Iterator it = al.iterator();
        while( it.hasNext() ) {
            if( !it.next().toString().equalsIgnoreCase(attribute) )
                node++;
            else
                break;
        }
        return node;
    }
    
    private void buildDictionary(String cad) {
        StringTokenizer attributes;
        String attr;
        int beg = cad.indexOf('{');
        int end = cad.indexOf('}');
        
        cad = cad.substring(beg+1, end);
        attributes = new StringTokenizer(cad, ",");
        
        while(attributes.hasMoreTokens()) {
            attr = attributes.nextToken();
            dictionary.add(attr.trim());
        }
    }
    
    private short encodeAttribute(String attr) {
        short index = (short) Collections.binarySearch(dictionary, attr);//dictionary.indexOf(attr);
        return index;
    }
    
    static void sout(String s) {
        System.out.println(s);
    }
    
    public static void main(String[] arg) {
        FileManager ar = new FileManager("/home/ivan/tariy/cDatos/arff/newMarket.arff");
        DataSet dataset = ar.readFile();
        dataset.showNTree();
    }
}
