/*
 * Contador.java
 *
 * Created on 24 de noviembre de 2005, 22:55
 */

package c45;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.*;

/**
 *
 * @author endimeon
 */
public class Contador{
    
    int p,bd,hi=0,npas=0;
    static int i=0,nrts=0;
    DefaultMutableTreeNode raiz,rama,papa;
    JTree arbol;
    DefaultTreeModel modelo;
    ArrayList conjuntoS = new ArrayList(1);
    String cuales[][];
    int cuantos[][];
    int ntag;
    
    private int numeroRutas;
    int colnul;
    int columnas;
    int filas;
    //////////////////////////////////////////////
    
    /** Creates a new instance of Contador */
    public Contador(AbstractTableModel datosEntrada, int columna[], int colnul, int ntag) {
        this.ntag = ntag;
        this.colnul = colnul;
        filas = datosEntrada.getRowCount();
        columnas = datosEntrada.getColumnCount();
        raiz = new DefaultMutableTreeNode(datosEntrada.getColumnName(columnas-1));
        arbol = new JTree( raiz );
        modelo = (DefaultTreeModel)arbol.getModel();
        i=0;
        numeroRutas = 0;
        for( int fila = 0; fila < filas ; fila++ ) {
            papa=raiz;
            for( int cl=0; cl < colnul ; cl++ ) {
                bd=0;
                hi=papa.getChildCount();
                if(hi==0){
                    rama = new DefaultMutableTreeNode( datosEntrada.getValueAt(fila,columna[cl]));
                    modelo.insertNodeInto( rama,papa,0 );
                    papa=rama;
                    if(cl == colnul - 2){
                        numeroRutas++;
                    }
                    if(cl==colnul-1){
                        conjuntoS.add(rama);
                        i=i+1;
                    }
                } else{
                    for( int s=0; s <hi ; s++ ) {
                        if(modelo.getChild(papa,s).toString().equals(((String)datosEntrada.getValueAt(fila,columna[cl])).trim())==true){  // busca un item a ver si existe
                            papa=(DefaultMutableTreeNode)modelo.getChild(papa,s);
                            if(cl==colnul-1){
                                rama = new DefaultMutableTreeNode( datosEntrada.getValueAt(fila,columna[cl]) );
                                modelo.insertNodeInto( rama,papa,0 );
                            }
                            bd=1; break;
                        }
                    }
                    if(bd==0){
                        rama = new DefaultMutableTreeNode( datosEntrada.getValueAt(fila,columna[cl]) );
                        modelo.insertNodeInto( rama,papa,0 );
                        papa=rama;
                        if(cl == colnul - 2){
                            numeroRutas++;
                        }
                        if(cl==colnul-1){
                            conjuntoS.add(rama);
                            i=i+1;
                        }
                    }
                }
            }
        }
    }
    
    public JTree armar() {
        return(arbol);
    }
    
    public TreeNode[][] tupapa() {
        cuantos = new int[numeroRutas][ntag + 1];
        cuales = new String[numeroRutas][ntag + 1];
        
        int bdesta=0,ppa=0,bdrev=0,clc=0;
        TreeNode rutas[][] = new TreeNode[numeroRutas][colnul];
        TreeNode ruaux[];
        ///////////////////////
        
        for( int p=0; p <i ; p++ ) {
            ruaux = ((DefaultMutableTreeNode)(conjuntoS.get(p))).getPath();
            ruaux[raiz.getDepth()-1]=null;
            bdesta=0;
            for(int w=0; w < ppa; w++) {
                bdrev=0;
                for(int g=0; g < raiz.getDepth()-1; g++) {
                    if(rutas[w][g]==ruaux[g]){   // si lo encuentra
                        bdrev++;
                    }
                }
                if(bdrev==raiz.getDepth()-1) {
                    clc=0;
                    while(cuantos[w][clc] != 0) { // para ver donde va y donde lo ubico
                        clc++;
                    }
                    cuales[w][clc] = ((DefaultMutableTreeNode)(conjuntoS.get(p))).toString();
                    cuantos[w][clc] = ((DefaultMutableTreeNode)(conjuntoS.get(p))).getChildCount() + 1;
                    bdesta=1;
                }
            }
            if(bdesta==0) {  // primera ves
                clc=0;
                rutas[ppa]=ruaux;
                cuales[ppa][clc] = ((DefaultMutableTreeNode)(conjuntoS.get(p))).toString();
                cuantos[ppa][clc] = ((DefaultMutableTreeNode)(conjuntoS.get(p))).getChildCount()+1;
                ppa++;
                nrts = ppa;
            }
        }
        return(rutas);
    }
    
    public String[][] cualeson() {
        return(cuales);
    }
    
    public int[][] cuantoson() {
        return(cuantos);
    }
    
    public int nrutas() {  //nuero de rutas o filas
        return(nrts);
    }
    
    public int npapis() {
        return(raiz.getDepth()-1);
    }
    
    public int nAtriEst() {  // numero de atributos pertenecientes a un estado
        int nAE;             // prob
        nAE=raiz.getChildCount();
        return(nAE);
    }
    
    public String[] atributos() { // nombre de los atributos de un estado
        int nAE;                  // prob
        nAE=raiz.getChildCount();
        String atri[] = new String[nAE];
        for(int j=0; j < nAE; j++){
            atri[j]=raiz.getChildAt(j).toString();
        }
        return(atri);
    }
    
    public String[] parcializado() {  // numero de atributos pertenecientes a un estado
        int pc;
        String vecparci[] = new String[numeroRutas];
        for(int pf = 0; pf < nrts; pf++) {
            pc=0;
            
            for(int j = 0; j  < cuantos[0].length; j++) {
                if(cuantos[pf][pc] != 0){
                    pc++;
                }
            }
            if(pc==1) {
                vecparci[pf] = cuales[pf][0];
            } else {
                vecparci[pf] = null;
            }
        }
        return(vecparci);
    }
}
