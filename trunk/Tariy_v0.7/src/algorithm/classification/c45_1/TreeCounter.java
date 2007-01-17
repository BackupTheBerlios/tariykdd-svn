/*
 * TreeCounter.java
 *
 * Created on 22 de junio de 2006, 11:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45_1;

import Utils.GraphDistribution.Grafico;
import Utils.TreeViewer.TreeVisualizer;
import gui.Icons.Clasification.ClasificationIcon;
import gui.Icons.Tree.ShowClassificationRules;
import gui.Icons.Tree.ViewerClasification;
import gui.KnowledgeFlow.AnimationLabel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author and
 */
public class TreeCounter extends Thread{
    int rows;
    int columns;
    static final double LOG2 = Math.log(2);
    public Attribute root;
    Attribute aux;
    AbstractTableModel dataIn;
    public C45TreeGUI view;            //JPanel donde se mostrara el JTree con el arbol de decision
    public int count;
    private int t;
    public String theClass;
    private AnimationLabel animation = null;
    public int MIN_ROWS;
    public TariyTableModel data = null;
    
    public JPanel TreePanel;
    
    public StringBuffer RulesText;
    
    private Attribute backer;
    
    private int totalNodes;

    public ClasificationIcon ci;
    /** Creates a new instance of TreeCounter */
    public TreeCounter() {
        root = new Attribute("I'm the root", null, null);
        totalNodes = 0;
    }
    
    public TreeCounter(int min_rows, TariyTableModel data) {
        this.data = data;
        MIN_ROWS = min_rows;
        theClass = data.getColumnName(data.getColumnCount() - 1);
        root = new Attribute(theClass, null, null);
        root.frecuence = data.getRowCount();
        totalNodes = 0;
    }
    
    public TreeCounter(int min_rows, TariyTableModel data, ClasificationIcon ci) {
        this.ci = ci;
        this.data = data;
        MIN_ROWS = min_rows;
        theClass = data.getColumnName(data.getColumnCount() - 1);
        root = new Attribute(theClass, null, null);
        root.frecuence = data.getRowCount();
        totalNodes = 0;
    }
    
    public int getTotalNodes() {
        return totalNodes;
    }
    
    public void setAnimation(AnimationLabel animation){
        this.animation = animation;
    }
    
    public void setData(AbstractTableModel dataIn){
        this.dataIn = dataIn;
        rows = dataIn.getRowCount();
        columns = dataIn.getColumnCount();
        root = new Attribute("", null, null);
    }
    
    public void countTree(int column){
        Attribute auxValue;
        Attribute oldValue = null;
        Attribute auxTarjet;
        String value;
        String tarjet;
        boolean flag;
        
        root.son = null;
        root.frecuence = column;
        root.name = dataIn.getColumnName(column);
        for(int r = 0; r < rows ; r++ ) {
            value = (String)dataIn.getValueAt(r, column);
            tarjet = (String)dataIn.getValueAt(r, columns-1);
            if(root.son == null){
                root.son = new Attribute(value, null, null);
                root.son.son = new Attribute(tarjet, null, null);
            } else {
                auxValue = root.son;
                while(auxValue != null){
                    flag = true;
                    if(auxValue.name.equals(value)){
                        auxValue.incrementFrecuence();
                        auxTarjet = auxValue.son;
                        while(auxTarjet != null){
                            if(auxTarjet.name.equals(tarjet)){
                                auxTarjet.incrementFrecuence();
                                flag = false;
                                break;
                            }
                            auxTarjet = auxTarjet.brother;
                        }
                        if(auxTarjet == null){
                            auxTarjet = new Attribute(tarjet, null, null);
                            auxTarjet.brother = auxValue.son;
                            auxValue.son = auxTarjet;
                            flag = false;
                        }
                    }
                    if(!flag){
                        break;
                    }
                    oldValue = auxValue;
                    auxValue = auxValue.brother;
                }
                if(auxValue == null){
                    auxValue = new Attribute(value, null, null);
                    auxValue.son = new Attribute(tarjet, null, null);
                    oldValue.brother = auxValue;
                }
            }
        }
    }
    
    public double getEntropy(double frecuence){
        Attribute attribute;
        Attribute tarjet;
        double entropy = 0.0;
        
        attribute = root.son;
        while(attribute != null){
            entropy += ((double)(attribute.frecuence)/frecuence)*attribute.setEntropia();
            attribute = attribute.brother;
        }
        return entropy * (-1.0);
    }
    
    public void seeTree(){
        seeTree(root.son);
    }
    
    public void seeTree(Attribute auxiliar){
        tabs(t);
        System.out.println(auxiliar);
        if(auxiliar.son != null){
            t++;
            seeTree(auxiliar.son);
            t--;
        }
        if(auxiliar.brother != null){
            seeTree(auxiliar.brother);
        }
    }
    
    private void tabs(int t){
        for(int i = 0; i < t; i++){
            System.out.print("|  ");
        }
    }
    
    public StringBuffer seeLeafs(Attribute root){
        StringBuffer orderLeafs = new StringBuffer();
        ArrayList leafs = new ArrayList();
        LinkedList path = new LinkedList();
        seeLeafs(root.son, path, leafs);
        Collections.sort(leafs, new compareConfidence());
        Iterator it = leafs.iterator();
        int order = 1;
        while(it.hasNext()){
            Leaf oneLeaf = (Leaf)it.next();
            orderLeafs.append(order + ") " + oneLeaf + "\n");
            order++;
        }
        return orderLeafs;
    }
    
    private void seeLeafs(Attribute auxiliar, LinkedList path, ArrayList leafs){
        if(auxiliar.son != null){
            path.add(auxiliar);
            seeLeafs(auxiliar.son, path, leafs);
            path.removeLast();
        } else {
            leafs.add(new Leaf(auxiliar, path));
        }
        if(auxiliar.brother != null){
            seeLeafs(auxiliar.brother, path, leafs);
        }
    }
    
    private double log2(double value){
        if(value == 0.0) return 0.0;
        return Math.log(value)/LOG2;
    }
    
    public void pruneLeafs(){
        Attribute auxiliar = this.root;
        Stack stack = new Stack();
        crossTree(auxiliar, stack);
        while(!stack.isEmpty()){
            pruneSameBranch((Attribute)stack.pop());
        }
    }
    
    public void crossTree(Attribute auxiliar, Stack stack){
        if(auxiliar.brother != null){
            crossTree(auxiliar.brother, stack);
        }
        if(auxiliar.son.isLeaf() != null){
            stack.push(auxiliar);
            crossTree(auxiliar.son, stack);
        }
    }
    
    public void pruneSameBranch(Attribute node) {
        if(node.son.son.isLeaf() != null) return;
        String grandSon = node.son.son.name;
        int frecuences = node.son.son.frecuence;
        int frecuencesFather = node.son.son.frecuenceFather;
        Attribute childrens = node.son.brother;
        boolean isEquals = true;
        while(childrens != null){
            if(!childrens.son.name.equals(grandSon)){
                isEquals = false;
                break;
            } else {
                frecuences += childrens.son.frecuence;
                frecuencesFather += childrens.son.frecuenceFather;
            }
            childrens = childrens.brother;
        }
        if(isEquals){
            node.son.frecuence = frecuences;
            node.son.frecuenceFather = frecuencesFather;
            node.son.name = node.son.son.name;
            node.son.valuesClass = node.valuesClass;
            node.son.son = null;
            node.son.brother = null;
        }
    }
    
    public StringBuffer getStringTree(){
        StringBuffer tree = new StringBuffer();
        
        return tree;
    }
    public Attribute searchTreeDesc(Attribute node, int aux){
        if(node.id == aux){
            backer = node;
            return backer;
        }
        if(node.son != null){
            searchTreeDesc(node.son,aux);
        }
        if(node.brother != null){
            searchTreeDesc(node.brother,aux);
        }
        return backer;
    }
    
    public Attribute chooseBestAttribute(AbstractTableModel data){
        TreeCounter finalTree = null;
        int treeFinal = 0;
        int columns = data.getColumnCount();
        double minEntropy = Double.MAX_VALUE;
        double entropy;
        LinkedList trees = new LinkedList();
        
        for(int i = 0; i < columns - 1; i++){
            TreeCounter c = new TreeCounter();
            c.setData(data);
            c.countTree(i);
            entropy = c.getEntropy(c.rows);
            if(entropy < minEntropy){
                minEntropy = entropy;
                finalTree = c;
            }
        }
        return finalTree.root;
    }
    
    public Attribute decisionTree(){
        Attribute attribute = new Attribute("", null, null);
        attribute.entropia = 1.0;
        this.root.son = decisionTree(data, attribute);
        return this.root;
    }
    
    private Attribute decisionTree(TariyTableModel data, Attribute byDefault){
        if(byDefault.entropia == 0.0){
            byDefault.son.name = theClass + "=" + byDefault.son.name;
            byDefault.son.frecuenceFather = byDefault.son.frecuence;
            byDefault.son.id = totalNodes++;
            byDefault.son.valuesClass = byDefault.valuesClass;
            return byDefault.son;
        } else if(data.getColumnCount() == 1){
            return byDefault.bestChild(theClass, totalNodes++);
        } else if(data.getRowCount() < MIN_ROWS){
            return byDefault.bestChild(theClass, totalNodes++);
        } else {
            Attribute attribute = null;
            attribute = this.chooseBestAttribute(data);
            LinkedList values = data.splitData(attribute);
            String[] names = data.newNames(attribute.name);
            Iterator it = values.iterator();
            
            Attribute auxiliar = attribute.son;
            while(it.hasNext()){
                auxiliar.name = attribute.name + "=" + auxiliar.name;
                auxiliar.id = totalNodes++;
                Object[][] newData = ((Split)it.next()).data;
                data.setDatos(newData);
                data.setNomcol(names);
                auxiliar.setValuesClass();
                auxiliar.son = decisionTree(data, auxiliar);
                //auxiliar.son.valuesClass = auxiliar.valuesClass;
                auxiliar = auxiliar.brother;
            }
            
            return attribute.son;
        }
    }
    
    public void run(){
        long time = System.currentTimeMillis();
        this.decisionTree();
        this.pruneLeafs();
        long executionTime = System.currentTimeMillis() - time;
        //this.seeTree();
        //this.root.viewWekaTree();
        //new ShowClassificationRules(this.root.getLeafs()).setVisible(true);
//        TreePanel = this.view.createAndShowGUI(new TreeViewer(root));
//        RulesText = this.seeLeafs(root);
        System.out.println("decisionTree : " + executionTime + "ms ");
        root.setRootValuesClass();
        ci.root = root;
        animation.stop();
    }
    
    static public void main(String arg[]){
        TreeCounter c = new TreeCounter(1, new TariyTableModel());
        long time = System.currentTimeMillis();
        Attribute root = c.decisionTree();
        long executionTime = System.currentTimeMillis() - time;
        c.pruneLeafs();
        //c.seeTree();
        System.out.println("decisionTree : " + executionTime + "ms ");
        //System.out.println("digraph J48Tree {\nN0 [label=\"SEX\" ]\nN0->N1 [label=\"= 0\"]\nN1 [label=\"CLASS\" ]\nN1->N2 [label=\"= 0\"]\nN2 [label=\"1 (23.0/3.0)\" shape=box style=filled ]\nN1->N3 [label=\"= 1\"]\nN3 [label=\"1 (145.0/4.0)\" shape=box style=filled ]\nN1->N4 [label=\"= 2\"]\nN4 [label=\"1 (106.0/13.0)\" shape=box style=filled ]\nN1->N5 [label=\"= 3\"]\nN5 [label=\"0 (196.0/90.0)\" shape=box style=filled ]\nN0->N6 [label=\"= 1\"]\nN6 [label=\"CLASS\" ]\nN6->N7 [label=\"= 0\"]\nN7 [label=\"0 (862.0/192.0)\" shape=box style=filled ]\nN6->N8 [label=\"= 1\"]\nN8 [label=\"AGE\" ]\nN8->N9 [label=\"= 0\"]\nN9 [label=\"1 (5.0)\" shape=box style=filled ]\nN8->N10 [label=\"= 1\"]\nN10 [label=\"0 (175.0/57.0)\" shape=box style=filled ]\nN6->N11 [label=\"= 2\"]\nN11 [label=\"AGE\" ]\nN11->N12 [label=\"= 0\"]\nN12 [label=\"1 (11.0)\" shape=box style=filled ]\nN11->N13 [label=\"= 1\"]\nN13 [label=\"0 (168.0/14.0)\" shape=box style=filled ]\nN6->N14 [label=\"= 3\"]\nN14 [label=\"0 (510.0/88.0)\" shape=box style=filled ]\n}\n");
        //System.out.println(root.buildStringTree());
        root.setRootValuesClass();
        //root.valuesClass = root.son.valuesClass;
        //root.viewWekaTree();
        new ViewerClasification(root).setVisible(true);
        //new ShowClassificationRules(root.getLeafs()).setVisible(true);
//        ViewerClasification vc = new ViewerClasification(
//                c.view.createAndShowGUI(new TreeViewer(root)), c.seeLeafs(root));
//        vc.setVisible(true);
//        TreeCounter c = new TreeCounter(2, new TariyTableModel());
//        c.start();
    }
}
