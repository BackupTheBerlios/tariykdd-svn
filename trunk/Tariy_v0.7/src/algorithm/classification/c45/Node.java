/*
 * Node.java
 *
 * Created on 24 de junio de 2006, 17:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author and
 */


/*La clase Node representa los nodos dentro del arbol final
 *por ahora solo tiene un campo para su nombre y si esta parcializado o no aparte
 *de los punteros a su padre, hijo y hermano.
 */
public class Node {
    String name;
    boolean parcializado;
    double gain;
    Node father;
    Node son;
    Node brother;
    String parcializadoValue;
    int column;
    
    /** Creates a new instance of Node */
    //dos constructures por si quiero pasarle el padre o no
    public Node(String name) {
        this.name = name;
        father = null;
        son = null;
        brother = null;
        parcializado = false;
        column = -2;
    }
    
    public Node(int position, String name, Node f){
        this.column = position;
        this.name = name;
        this.father = f;
        son = null;
        brother = null;
        parcializado = false;
    }
    
    //este metodo inserta un hijo a este nodo
    public Node addSon(int position, String name, double gain, String vp){
        //si el nodo no tiene hijos inserta el nodo a su puntero son
        if(position != -1){
            if(this.son == null){
                this.son = new Node(position, name, this);
                this.son.gain = gain;
                if(gain == 0.0){
                    this.son.setParcializado(vp);
                }
                return this.son;
            } else {
                //si ya tiene hijos recorro por sus hermanos hasta encontrar la posicion
                Node aux2 = null;
                Node aux1 = this.son;
                while(aux1 != null){
                    aux2 = aux1;
                    aux1 = aux1.brother;
                }
                aux2.brother = new Node(position, name, this);
                aux2.brother.gain = gain;
                if(gain == 0.0){
                    aux2.brother.setParcializado(vp);
                }
                return aux2.brother;
            }
        }
        return null;
    }
    
    //representacion textual del nodo
    public String toString(){
        return name;
    }
    
    public void setParcializado(String parcializado) {
        this.parcializado = true;
        this.parcializadoValue = parcializado;
    }
    
    //estos cuatro metodos se necesitan para implementar la interfaz TreeModel
    // los utiliza la clase C45TreeModel y se complementan alla.
    //este devuelve el hijo de un nodo de acuerdo al indice que le pasemos
    public Node getChild(int index) {
        Node node = this.son;
        int count = 0;
        
        while(count < index) {
            node = node.brother;
            count++;
        }
        return node;
    }
    
    //este devuelve cuantos hijos tiene este nodo
    public int getChildCount() {
        Node node = this.son;
        int children = 1;
        
        while(node.brother != null) {
            node = node.brother;
            children++;
        }
        return children;
    }
    
    //este devuelve dependiendo el nodo que le pasemos cual es su indice como hijo de este nodo
    public int getIndexOfChild(Object child) {
        Node node = this.son;
        int index = 0;
        
        while(node.brother != null) {
            node = node.brother;
            if(node.equals(child))
                break;
            else
                index++;
        }
        return index;
    }
    
    //devuelve si este nodo es una hoja o no (se complementa en C45TreeModel)
    public Node isLeaf() {
        Node node = this;
        return node.son;
    }
    
    public int getLevel(){
        Node auxiliar = this;
        int conLevel = 0;
        while(auxiliar.father != null){
            conLevel++;
            auxiliar = auxiliar.father;
        }
        return conLevel;
    }
}


//Esta es la clase del arbol final que ya extiende a JTree
class Tree extends JTree{
    C45TreeModel model;
    Node root;
    Node aux;
    Node show;
//    ArrayList rutas = new ArrayList(1);
    
    //al contructor de la clase le paso el nodo raiz del arbol final
    public Tree(Node root){
        //y con este declaro una instancia de C45TreeModel y se la mando al contructor
        //superior de JTree con la instruccion super
        super(new C45TreeModel(root));
        this.root = root;
        //estas lineas son necesarias para setear las propiedades iniciales del JTree
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        Icon personIcon = null;
        renderer.setLeafIcon(personIcon);
        renderer.setClosedIcon(personIcon);
        renderer.setOpenIcon(personIcon);
        setCellRenderer(renderer);
    }
    
    //este metodo muestra el arbol final en modo consola
    public Node getNextNode(Stack stack) {
        while(aux != null){
            stack.push(aux);
            aux = aux.son;
        }
        if(!stack.empty()){
            show = (Node)stack.pop();
            System.out.print(show.toString());
            if(!show.parcializado && show.son == null){
                //System.out.println("  <--- Este es el pizco!!!");
                return show;
            }
        }
        if(show.brother == null){
            if(!stack.empty()){
                show = (Node)stack.pop();
                System.out.print(show.toString());
                if(!show.parcializado && show.son == null){
                 //   System.out.println("  <--- Este es el pizco!!!");
                    return show;
                }
            }
        }
        aux = show.brother;
        if( (!stack.empty()) || (aux != null) ){
            return getNextNode(stack);
        }
        return null;
    }
    
    public Node search(){
        return search(this.root);
    }
    
    public Node search(Node auxiliar){
        if(!auxiliar.parcializado && auxiliar.son == null){
            return auxiliar;
        }
        if(auxiliar.brother != null){
            return search(auxiliar.brother);
        }
        if(auxiliar.son.son != null){
            return search(auxiliar.son.son);
        }
        return null;
    }
    
    public void print(Node auxiliar){
//        if(!auxiliar.parcializado && auxiliar.son == null){
//            return auxiliar;
//        }
        if(auxiliar.brother != null){
            print(auxiliar.brother);
        }
        if(auxiliar.son != null){
            print(auxiliar.son);
        }
        //System.out.println(auxiliar.toString() + " - ");
        if(!auxiliar.parcializado && auxiliar.son == null){
            show = auxiliar;
        }
    }
    
//    public void runOver(Node rootaux){
//        //Node rootaux = this.root;
////        ArrayList rutas = new ArrayList(1);
//        if(rootaux.son != null){
//            rutas.add(rootaux.son);
//            rootaux = rootaux.son;
//            runOver(rootaux);
//        } else if(rootaux.brother != null){
//            rootaux = rootaux.father.father.brother;
//            runOver(rootaux);
//        }
//        System.out.println(rutas);
//    }
}
