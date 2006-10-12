/*
 * EquipAsso.java
 *
 * Created on 10 de marzo de 2005, 10:13 AM
 *
 * Proyecto Tariy
 */

package EquipAsso;

import Utils.*;
import gui.KnowledgeFlow.AnimationLabel;
import java.util.*;

public class EquipAsso extends Thread{
    /** Soporte con el que se van a evaluar los datos.*/
    public static short support;
    
    /**
     * Vector de arboles AvlTree donde se almacenan los distintos itemsets
     * frecuentes.
     */
    private Vector Trees;
    
    /**
     * Indica el tipo o tamaño de los itemsets frecuentes que se desean
     * obtener.
     */
    private int type;
    
    /** Los datos a minar contenidos en un arbol N-Ario. */
    public static DataSet dataset;
    
    /** Árbol que almacena itemsets candidatos para su posterior poda. */
    AvlTree treeCandidates = new AvlTree();

    private AnimationLabel animation;
    
    /**
     * Construye una instancia de la clase EquipAsso.
     *
     *  @param dataset Conjunto de datos contenidos en un arbol N-Ario.
     *  @param support Soporte con el que los datos seran minados.
     */
    public EquipAsso(DataSet dataset, short support) {
        this.support = support;
        AvlTree frequentsOne = new AvlTree();
        dataset.pruneCandidatesOne(support, frequentsOne);
        Trees = new Vector(2,1);
        Trees.addElement(frequentsOne);
        this.dataset = dataset;
    }
    
    /**
     * Recorre el dataset, carga cada transaccion, realiza todas sus
     * combinaciones y cuenta su soporte, aquellos itemsets que sobrepasen o
     * igualen el soporte minimo del sistema se consideran frecuentes y se
     * almacenan en un árbol Avl.
     *
     * @param type Indica el tipo o tamaño de los itemsets frecuentes que se
     *             desean obtener.
     * @return <code>true</code>  si el nuevo árbol de itemsets frecuentes tiene
     *                            elementos;
     *         <code>false</code> en caso contrario.
     */
    public boolean findInDataset(int type){
        this.type = type;
        Transaction t = new Transaction();
        Combinations c;
        AvlTree treeFrequents = new AvlTree();
        long size, i = 1, nt = 1;
        
        // Inicializa punteros para recorrer dataset.
        dataset.setPointers();
        while(i > 0){
            int j = 0;
            // Carga cada transaccion.
            i = t.loadItemsets(dataset, (AvlTree) Trees.elementAt(0));
            // Calcula las combinaciones, arma los itemset y los guarda
            // en los arboles Avl
            if(t.getSize() > 1){
                c = new Combinations(type, t.getArticles());
                c.letsCombine(treeCandidates);
            }
            // Reinicia para una nueva transaccion
            t.clearTransaction();
        }
        this.pruneCandidates(treeCandidates, treeFrequents);
        if(treeFrequents.howMany() > 0){
            Trees.addElement(treeFrequents);
            treeCandidates.makeEmpty();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Recorre el árbol de itemsets candidatos verificando que el soporte de
     * cada uno de los elementos sea mayor o igual al soporte minimo del
     * sistema, si es así, el itemset en cuestión se adiciona a un nuevo árbol
     * Avl.
     *
     * @param treeCandidates Árbol Avl que contiene los itemsets candidatos.
     * @param treeFrequents  Árbol Avl que contiene los itemsets candidatos que
     *                       pasan poda, itemsets frecuentes.
     */
    public void pruneCandidates(AvlTree treeCandidates, AvlTree treeFrequents){
        pruneCandidates(treeCandidates.getRoot(), treeFrequents);
    }
    
    private void pruneCandidates(AvlNode node, AvlTree treeFrequents){
        if(node != null){
            pruneCandidates(node.getLeft(), treeFrequents);
            ItemSet i = node.getItemset();
            if(i.getSupport() >= support){
                i.sortItems();
                treeFrequents.insertItemsetOne(i);
            }
            pruneCandidates(node.getRight(), treeFrequents);
        }
    }
    
    /**
     * Retorna el vector de arboles AvlTree donde se almacenan los distintos
     * itemsets frecuentes.
     *
     * @return El vector de arboles AvlTree.
     */
    public Vector getFrequents() {
        return Trees;
    }
    
    /**
     * Representación tipo cadena de los itemsets frecuentes.
     */
    public void showFrequents(){
        AvlTree arbol;
        
        for(int j = 0; j < Trees.size(); j++){
            arbol = (AvlTree) Trees.elementAt(j);
            System.out.println("Type " + arbol.getTipo());
            arbol.printTree();
        }
    }
    
    /**
     * Borra todos los arboles contenidos en el vector de itemsets frecuentes.
     */
    public void clearFrequents(){
        this.Trees.clear();
    }
    
    public void run() {
        long time = System.currentTimeMillis();
        
        int type = 2;
        while(this.findInDataset(type++));
        
        long executionTime = System.currentTimeMillis() - time;
        this.showFrequents();
        System.out.println("EquipAsso en " + executionTime + "ms " + "Soporte: " + support);
        animation.stop();
    }
    
    public void setAnimation(AnimationLabel animation){
        this.animation = animation;
    }
    
    public static void main(String args[]){
        FileManager fm = new FileManager("/home/ivan/tariy/cDatos/arff/marketb.arff");
        EquipAsso equi = new EquipAsso(fm.readFile(), (short) 2);
        
        int type = 2;
        while(equi.findInDataset(type));
        Vector frequents = equi.getFrequents();
        AvlTree petitTree;
        for(int j = 0; j < frequents.size(); j++){
            petitTree = (AvlTree) frequents.elementAt(j);
            if(petitTree.isEmpty() != true){
                petitTree.printTree();
            }
        }
        equi.clearFrequents();
    }
}
