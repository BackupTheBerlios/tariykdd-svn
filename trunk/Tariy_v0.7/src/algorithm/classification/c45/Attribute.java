/*
 * Attribute.java
 *
 * Created on 22 de junio de 2006, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

/**
 *
 * @author and
 */
public class Attribute implements Comparable{
    String name;
    String route;
    boolean parcializado;
    String parcializadoValue;
    double entropia;
    int frecuence;
    Attribute father;
    Attribute son;
    Attribute brother;
    
    /** Creates a new instance of Attribute */
    public Attribute(String name, Attribute father, Attribute son, Attribute brother) {
        this.name = name;
        frecuence = 1;
        parcializado = false;
        entropia = 0.0;
        parcializadoValue = "";
        this.father = father;
        this.son = son;
        this.brother = brother;
    }

    public double getEntropiaInterna() {
        return entropia;
    }

    public int getFrecuence() {
        return frecuence;
    }
    
    public void incrementFrecuence(){
        frecuence++;
    }


    public void setParcializado(String parcializado) {
        this.parcializado = true;
        this.parcializadoValue = parcializado;
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
        divExt =  (float)this.frecuence / (float)this.father.frecuence;
        ///System.out.println(this.toString());
        return divExt * probabilidadInterna;
    }
    
    public double log2(double value){ // lo cambie de private a public
        if(value == 0.0) return 0.0;
        return Math.log(value)/Math.log(2);
    }
    
    public String toString(){
        return new String("[" + this.name + ", " + this.frecuence + ", " +
                this.entropia + "," +this.route + "]");
    }

    public int compareTo(Object o) {
        Attribute attribute = (Attribute)o;
                
        return this.name.compareToIgnoreCase(attribute.name);
    }
    
    
}

class nodeVariable{
    Attribute attribute;
    nodeVariable next;
    
    nodeVariable(Attribute at){
        attribute = at;
        next = null;
    }
}