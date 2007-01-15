/*
 * Attribute.java
 *
 * Created on 22 de junio de 2006, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45_1;

import Utils.TreeViewer.Node;
import Utils.TreeViewer.NodePlace;
import Utils.TreeViewer.PlaceNode2;
import Utils.TreeViewer.TreeBuild;
import Utils.TreeViewer.TreeVisualizer;
import algorithm.classification.Value;
import java.awt.Container;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author and
 */
public class Attribute {
    public String name;
    double entropia;
    int frecuence;
    int frecuenceFather;
    int id;
    ArrayList valuesClass;
    public Attribute son;
    public Attribute brother;
    
    private String fatherA;
    
    /** Creates a new instance of Attribute */
    public Attribute(String name,Attribute son, Attribute brother) {
        this.name = name;
        frecuence = 1;
        entropia = 0.0;
        id = 0;
        valuesClass = new ArrayList();
        this.son = son;
        this.brother = brother;
    }
    
    /** Creates a new instance of Attribute for Fercho*/
    public Attribute(String name,int f,int daddyF, ArrayList vc) {
        this.name = name;
        frecuence = f;
        frecuenceFather = daddyF;
        valuesClass = vc;
        entropia = 0.0;
        id = 0;
        this.son = null;
        this.brother = null;
    }
    
    public int getFrecuence() {
        return frecuence;
    }
    
    public void incrementFrecuence(){
        frecuence++;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setValuesClass(){
        Attribute aux = this.son;
        while(aux != null){
            valuesClass.add(new Value(aux.name, aux.frecuence));
            aux = aux.brother;
        }
    }
    
    public ArrayList getValuesClass() {
        return valuesClass;
    }
    
    public double setEntropia(){
        double probabilidadInterna = 0.0;
        float division;
        float divExt;
        Attribute auxSon = this.son;
        while(auxSon != null){
            division = ((float)auxSon.frecuence / (float)this.frecuence);
            probabilidadInterna += (division) * log2(division);
            auxSon = auxSon.brother;
        }
        this.entropia = probabilidadInterna;
        return probabilidadInterna;
    }
    
    public double log2(double value){ // lo cambie de private a public
        if(value == 0.0) return 0.0;
        return Math.log(value)/TreeCounter.LOG2;
    }
    
    public Attribute bestChild(String target, int id){
        Attribute major = this.son;
        Attribute next = this.son.brother;
        
        while(next != null){
            if(major.frecuence <= next.frecuence){
                major = next;
            }
            next = next.brother;
        }
        major.name = target + "=" + major.name;
        major.frecuenceFather = this.frecuence;
        major.brother = null;
        major.id = id;
        major.valuesClass = this.valuesClass;
        return major;
    }
    
    public Attribute getChild(int index) {
        Attribute attribute = this.son;
        int count = 0;
        
        while(count < index) {
            attribute = attribute.brother;
            count++;
        }
        return attribute;
    }

    public Attribute getChild(String name) {
        Attribute attribute = this.son;
        
        while(attribute != null) {
            if(attribute.toString().equals(name)){
                return attribute;
            }
            attribute = attribute.brother;
        }
        return null;
    }
    
    //este devuelve cuantos hijos tiene este nodo
    public int getChildCount() {
        Attribute attribute = this.son;
        int children = 1;
        
        while(attribute.brother != null) {
            attribute = attribute.brother;
            children++;
        }
        return children;
    }
    
    public Attribute getBro(Attribute a){
        while(a.brother != null){
            a = a.brother;
        }
        return a;
    }
    
    public void setBro(Attribute b){
        brother = b;
    }
    //este devuelve dependiendo el nodo que le pasemos cual es su indice como hijo de este nodo
    public int getIndexOfChild(Object child) {
        Attribute attribute = this.son;
        int index = 0;
        
        while(attribute.brother != null) {
            attribute = attribute.brother;
            if(attribute.equals(child))
                break;
            else
                index++;
        }
        return index;
    }
    
    //devuelve si este nodo es una hoja o no (se complementa en C45TreeModel)
    public Attribute isLeaf() {
        Attribute attribute = this;
        return attribute.son;
    }
    
    public Attribute getSon(){
        return son;
    }
    
    public void setSon(Attribute s){
        son = s;
    }
    
    public String toString(){
        if(this.isLeaf() == null){
            return name + " [" + this.frecuence + "/" + this.frecuenceFather + "]";
        } else {
            return name; // + "  |  " + valuesClass;
        }
    }
    
    private String getAfterEqual(){
        return this.toString().substring(toString().indexOf("=") + 1, toString().length());
    }
    
    private String getBeforeEqual(){
        return this.toString().substring(0, toString().indexOf("="));
    }
    
    public String buildStringTree(){
        StringBuffer tree = new StringBuffer();
        LinkedList path = new LinkedList();
        path.addLast(this);
        tree.append("digraph TariyImplementation {\n");
        tree.append(this.son.id + "[label=\"" + this.son.getBeforeEqual() + "\"]\n");
        buildStringTree(this.son, path, tree);
        tree.append("}");
        
        return tree.toString();
    }
    
    private void buildStringTree(Attribute auxiliar, LinkedList path, StringBuffer tree){
        if(auxiliar.son != null){
            tree.append(((Attribute)path.getLast()).son.id + "->");
            tree.append(auxiliar.son.id + "[label=\"" + auxiliar.getAfterEqual() + "\"]\n");
            if(auxiliar.son.isLeaf() == null){
                tree.append(auxiliar.son.id + "[label=\"" + auxiliar.son.getAfterEqual() + "\" shape=box style=filled ]\n");
            } else {
                tree.append(auxiliar.son.id + "[label=\"" + auxiliar.son.getBeforeEqual() + "\"]\n");
            }
            path.addLast(auxiliar);
            buildStringTree(auxiliar.son, path, tree);
            path.removeLast();
        }
        if(auxiliar.brother != null){
            buildStringTree(auxiliar.brother, path, tree);
        }
    }
    public void viewWekaTree() {
        TreeBuild builder = new TreeBuild();
        Node top = null;
        NodePlace arrange = new PlaceNode2();
        top = builder.create(new StringReader(this.buildStringTree()));
        int num = top.getCount(top,0);
        TreeVisualizer a = new TreeVisualizer(null, top, arrange);
        a.setRoot(this);
        a.setSize(800 ,600);
        JFrame f;
        f = new JFrame();
        Container contentPane = f.getContentPane();
        contentPane.add(a);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(800,600);
        f.setVisible(true);
    }
}
