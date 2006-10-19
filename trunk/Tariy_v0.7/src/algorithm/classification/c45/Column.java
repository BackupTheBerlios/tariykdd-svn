/*
 * Column.java
 *
 * Created on 27 de junio de 2006, 17:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author and
 */
public class Column {
    String name;
    double gain;
    int position;
    ArrayList attributes;
            
    /** Creates a new instance of Column */
    public Column(String n, int p, double g, ArrayList at) {
        this.name = n;
        this.position = p;
        this.gain = g;
        this.attributes = at;
    }
    
    public String toString(){
        String str = "[";
        str += name + ", " + position + ", " + gain + " " + attributes +"]";
        return str;
    }
    
}

class compareColumns implements Comparator {
    
    public int compare(Object obj1, Object obj2) {
        double i1 = ((Column)obj1).gain;
        double i2 = ((Column)obj2).gain;

        if(i1 < i2){
            return -1;
        } else if(i1 == i2){
            return 0;
        } else {
            return 1;
        }
    }
}

