/*
 * NewClass.java
 *
 * Created on 28 de junio de 2006, 11:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author and
 */
public class myHashMap {
    ArrayList keys;
    /** Creates a new instance of NewClass */
    public myHashMap() {
        keys = new ArrayList(1);
    }
    
    public void addColumn(String key, Column c){
        Iterator it = keys.iterator();
        boolean flag = true;
        while(it.hasNext()){
            myKey auxkey = (myKey)it.next();
            if(auxkey.name.equals(key)){
                auxkey.addValue(c);
                flag = false;
            }
        }
        if(flag){
            keys.add(new myKey(key, c));
        }
    }
    
    public myHashMap searchColumnsWinner(){
        myHashMap hash = new myHashMap();
        Iterator it = keys.iterator();
        while(it.hasNext()){
            myKey key = (myKey)it.next();
            Column MaxGain = (Column)Collections.max(key.values, new compareColumns());
            //if(MaxGain.gain != 0.0){
            hash.addColumn(key.name, MaxGain);
            //}
        }
        return hash;
    }
    
    public int getSize(){
        return keys.size();
    }
    
    public String toString(){
        String str = "";
        Iterator it = keys.iterator();
        while(it.hasNext()){
            myKey key = (myKey)it.next();
            str += key.toString() + "\n";
        }
        return str;
    }
}

class myKey {
    String name;
    ArrayList values;
    
    public myKey(String name, Column c){
        this.name = name;
        values = new ArrayList(1);
        addValue(c);
    }
    
    public void addValue(Column c){
        values.add(c);
    }
    
    public String toString(){
        return name + values.toString();
    }
}
