/*
 * Comparer.java
 *
 * Created on 8 de febrero de 2005, 10:00 AM
 */

package algorithm.classification.c45;
import java.util.*;

/**
 *
 * @author Proyecto Taryi
 */
public class compareRoute implements Comparator {
    
    public int compare(Object obj1, Object obj2) {
        String s1 = ((Attribute)obj1).route;
        String s2 = ((Attribute)obj2).route;
        
        return s1.compareToIgnoreCase(s2);
    }
}
