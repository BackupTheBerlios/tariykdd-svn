/*
 * compareConfidence.java
 *
 * Created on 26 de diciembre de 2006, 12:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45_1;
import java.util.*;

/**
 *
 * @author Proyecto Taryi
 */
public class compareConfidence implements Comparator {
    
    public int compare(Object obj1, Object obj2) {
        int s1 = ((Leaf)obj1).leaf.frecuenceFather;
        int s2 = ((Leaf)obj2).leaf.frecuenceFather;
        
        return s2 - s1;
    }
}
