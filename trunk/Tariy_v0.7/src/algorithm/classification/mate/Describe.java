/*
 * Tree.java
 *
 * Created on 3 de enero de 2007, 23:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.mate;

import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public class Describe {
    public static int node=0;
    private int father;
    private String attribute;
    private String value;
    private String classe;
    
    /** Creates a new instance of Tree */
    public Describe(int father, String attribute, String value, String classe) {
        this.father = father;
        this.attribute = attribute;
        this.value = value;
        this.classe = classe;
    }
    
    public Describe() {
    }
    
    public void incNode() {
        node++;
    }

    public int getNode() {
        return node;
    }
    
    public int getFather(){
        return father;
    }
    
    public String getAttribute(){
        return attribute;
    }
    
    public String getValue(){
        return value;
    }
    
    public String getClasse(){
        return classe;
    }
    
    public void setFather(int i){
        father = i;
    }
}
