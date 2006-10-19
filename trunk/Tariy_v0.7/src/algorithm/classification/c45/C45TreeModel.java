/*
 * TariyNTreeModel.java
 *
 * Created on April 12, 2006, 2:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.Vector;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Tariy
 */

/*Clase que implementa la interfaz TreeModel y sus metodos 
 *
 */
public class C45TreeModel implements TreeModel {
    private Vector treeModelListeners = new Vector();
    private Node root;
    
    /** Creates a new instance of TariyNTreeModel */
    public C45TreeModel(Node root) {
        this.root = root;
    }
    
    // Implementacion de los metodos de la interfaz TreeModel  
    // aqui utilizamos los metodos que escribimos en la clase Node
    
    public void addTreeModelListener(TreeModelListener l) {
        treeModelListeners.addElement(l);
    }
    
    public Object getChild(Object parent, int index) {
        Node n = (Node) parent;
        return n.getChild(index);
    }
    
    public int getChildCount(Object parent) {
        Node n = (Node) parent;
        return n.getChildCount();
    }
    
    public int getIndexOfChild(Object parent, Object child) {
        Node n = (Node) parent;
        return n.getIndexOfChild(child);
    }
    
    public Object getRoot() {
        return this.root;
    }
    
    public boolean isLeaf(Object node) {
        Node n = (Node) node;
        return n.isLeaf() == null;
    }
    
    public void removeTreeModelListener(TreeModelListener l) {
        treeModelListeners.removeElement(l);
    }
    
    public void valueForPathChanged(TreePath path, Object newValue) {
//        System.out.println("*** valueForPathChanged : "
//                           + path + " --> " + newValue);
    }
}
