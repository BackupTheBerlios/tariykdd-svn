/*
 * Route.java
 *
 * Created on 24 de junio de 2006, 9:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author and
 */
public class Route {
    public ArrayList posicionesFijas;
    public int posicionVariable;
    public int posicionObjetivo;
    int index;
    boolean firstGain = false;
    /** Creates a new instance of Route */
    public Route(int pO) {
        posicionesFijas = new ArrayList(1);
        posicionObjetivo = pO;
        index = 0;
    }

    public void setFirstGain(boolean firstGain) {
        this.firstGain = firstGain;
    }

    //avanza en la posicion variable verificando que no se repita
    public void avanceVariable(){
        if(posicionesFijas.contains(posicionVariable) && posicionVariable < posicionObjetivo){
            posicionVariable++;
        }
    }
    
    public void setPosicionesFijas(ArrayList pf){
        this.posicionesFijas = pf;
    }
    
    public boolean setPosicionVariable(int pv){
        if(!posicionesFijas.contains(pv)){
            posicionVariable = pv;
            return false;
        } else {
            return true;
        }
    }
    
    //devuelve el cuantas columnas estan fijas en la ruta
    public int getFixesSize(){
        return posicionesFijas.size();
    }
    
    //devuelve el indice actual de la columna
    public int getIndex(){
        if(index < getFixesSize()){
            index++;
            return (Integer)posicionesFijas.get(index - 1);
        } else if( index == getFixesSize()){
            index++;
            return posicionVariable;
        } else {
            return posicionObjetivo;
        }
    }
    
    //devuelve el tamaño total
    public int getSize(){
        return getFixesSize() + 2;
    }
    
    public void addPosicionFija(int pf){
        posicionesFijas.add(pf);
    }
    
    public void resetIndex(){
        index = 0;
    }

    public String toString() {
        String str = "[ ";
        Iterator it = posicionesFijas.iterator();
        while(it.hasNext()){
            str += " " + (Integer)it.next() + ", ";
        }
        str += posicionVariable + ", " + posicionObjetivo + " ]";
        return str;
    }
}
