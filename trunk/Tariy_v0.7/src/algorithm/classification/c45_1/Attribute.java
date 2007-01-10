/*
 * Attribute.java
 *
 * Created on 22 de junio de 2006, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45_1;

import java.util.LinkedList;

/**
 *
 * @author and
 */
public class Attribute {
    String name;
    double entropia;
    int frecuence;
    int frecuenceFather;
    int id;
    Attribute son;
    Attribute brother;
    public LinkedList childrens;
    
    /** Creates a new instance of Attribute */
    public Attribute(String name,Attribute son, Attribute brother) {
        this.name = name;
        frecuence = 1;
        entropia = 0.0;
        id = 0;
        this.son = son;
        this.brother = brother;
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
    
    public Attribute bestChild(String target){
        Attribute major = this.son;
        Attribute next = this.son.brother;
        
        while(next != null){
            if(major.frecuence < next.frecuence){
                major = next;
            }
            next = next.brother;
        }
        major.name = target + "=" + major.name;
        major.frecuenceFather = this.frecuence;
        major.brother = null;
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
            return name;
        }
    }
}