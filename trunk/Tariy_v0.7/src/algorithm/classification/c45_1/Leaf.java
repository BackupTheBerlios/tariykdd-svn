/*
 * Leaf.java
 *
 * Created on 26 de diciembre de 2006, 11:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author and
 */
public class Leaf {
    String path;
    Attribute leaf;
    /** Creates a new instance of Leaf */
    public Leaf(Attribute leaf, LinkedList path) {
        this.leaf = leaf;
        this.path = this.buildStringPath(path);
    }
    
    private String buildStringPath(LinkedList path){
        StringBuffer str = new StringBuffer();
        int size = path.size();
        
        for(int i = 0; i < size; i++){
            if(i % 2 == 0){
                str.append(path.get(i) + "=");
            }else{
                if(i != size - 1){
                    str.append(path.get(i) + " and ");
                } else {
                    str.append(path.get(i));
                }
            }
        }
        return str.toString();
    }
    
    public String toString() {
        return path + " --> " + leaf;
    }
}
