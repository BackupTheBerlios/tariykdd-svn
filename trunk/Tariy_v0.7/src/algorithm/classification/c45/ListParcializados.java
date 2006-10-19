/*
 * ListParcializados.java
 *
 * Created on 13 de julio de 2006, 19:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

/**
 *
 * @author endimeon
 */
public class ListParcializados {
    Node node;
    ListParcializados next;
    
    /** Creates a new instance of ListParcializados */
    public ListParcializados(Node no) {
        node = no;
        next = null;
    }   
}