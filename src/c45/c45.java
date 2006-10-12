/*
 * Main.java
 *
 * Created on 2 de noviembre de 2005, 4:20
 * ALGORITMO DE CLASIFICACION C45
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
 * @author taryi
 */
public class c45 extends JPanel {
    AbstractTableModel datosEntrada;
    
    int columnas;
    int filas;
    
    DefaultMutableTreeNode raiz,rama,papa,aux,papi,pjod;
    DefaultMutableTreeNode auxpas[]; // 30
    JTree arbolC45;
    DefaultTreeModel modeloC45;
    
    public c45(AbstractTableModel dataIn) {
        datosEntrada = dataIn;
        columnas = datosEntrada.getColumnCount();
        filas = datosEntrada.getRowCount();
        auxpas = new DefaultMutableTreeNode[columnas + 1];
        setLayout( new BorderLayout() );
        // ********************* Definicion de Variables **************************
        //JTree ar;
        TreeNode cualpapa[][];
        TreeNode pas[][];
        
        String cual[][];
        int cuantos[][];
        Object atributo[] = new Object[columnas];
        Object parci[] = new Object[columnas - 1];
        String rutasb[][];
        String nameColTarget;
        
        int col[] = new int[columnas + 3];
        int clsmay[] = new int[columnas + 2];
        int colaux[] = new int[columnas + 2];
        int natri[] = new int [columnas + 2];
        int ganadores[];
        int nrtas, pnrtas, pclase=0, bdveri, auxnrtb, nrutasb, ncolsb, eu=0;
        int j, cnp, cclr, cp , bdj, bra, bdpclase, clmy, bdfinal = 0, posp = 0;
        
        double matgain[][];
        Object vecSs[] = new Object[columnas];
        double ganancia[];
        double Sinicial;

        ArrayList estutili = new ArrayList();
        ArrayList auxj = new ArrayList();
        ArrayList auxcnp = new ArrayList();
        // ************************************************************************
        nameColTarget = datosEntrada.getColumnName(columnas-1);
        raiz = new DefaultMutableTreeNode(nameColTarget);
        arbolC45 = new JTree( raiz );
        modeloC45 = (DefaultTreeModel)arbolC45.getModel();
        Contador counter;

        ArrayList valores = this.getAttributeCount();
        Sinicial = new Entropia(valores).entroIni();  // se saca entropia inicial
        
        nrutasb = 1;
        ncolsb = 1;
        rutasb = new String[1][1];
        rutasb[0][0] = nameColTarget;
        
        col[1] = columnas-1;
        posp = 0;
        
        // *** Ciclo hasta que todas las ramas esten parcializadas ***
        
        while(bdfinal == 0 || posp == columnas){
            ganadores = new int[nrutasb];
            matgain = new double[columnas][nrutasb];
            //vecSs =  new double[columnas][nrutasb];
            clmy = 0;
            for(int pos = 0; pos < columnas-1; pos++) { // recorre las columnas de la tabla
                bdveri = 0;
                for(int veri = 0; veri < eu; veri++) { // verificacion de utilizados
                    if((Integer)estutili.get(veri)==pos) {
                        bdveri=1;
                        break;
                    }
                }
                
                if(bdveri==0) {  // si la columan no ha sido utilizada
                    col[posp] = pos;
                    clsmay[clmy] = pos;
                    clmy ++;
                    
                    counter = new Contador(datosEntrada,col,posp+2, valores.size());
                    cualpapa = counter.tupapa();
                    cuantos = counter.cuantoson();
                    cual = counter.cualeson();
                    nrtas = counter.nrutas();
                    
                    parci[pos] = counter.parcializado();
                    
                    if(posp==0) {
                        natri[pos] = counter.nAtriEst();
                        atributo[pos] = counter.atributos();
                    }
                    Entropia entropia = new Entropia(nrtas,cualpapa,cuantos,nrutasb,ncolsb,rutasb);
                    ganancia = entropia.entroS();
                    
                    // llenado de matgain
                    for(int cg=0; cg < nrutasb; cg++) { // recibo la ganancia restada el vecs para cada valor de un columna
                        
                        if(posp==0) {
                            ganancia[cg] = Sinicial-ganancia[cg];
                        } else {
                            ganancia[cg] = (((double[])vecSs[ganadores[cg]])[cg]*-1)-ganancia[cg];
                        }
                        matgain[pos][cg] = ganancia[cg]; // se llena un matriz con dichas ganancias
                    }
                    vecSs[pos] = entropia.vecS();
                }
            }
            pclase = clsmay[0];
            for(int cg=0; cg < nrutasb; cg++) { // escojo la mayor ganancia en ganadores
                bdpclase=0;
                for(int pos = 1; pos < clmy; pos++){
                    if(matgain[pclase][cg] < matgain[clsmay[pos]][cg]){
                        pclase = clsmay[pos];
                    }
                }
                ganadores[cg] = pclase;
                estutili.add(eu,ganadores[cg]);
                eu++;
                pclase = 0;
            }
            
            // ARBOL QUE SE ESTA ARMANDO
            pjod = papa;
            for(int cr=0; cr < nrutasb; cr++) {
                if(posp==0) {
                    papi=raiz;
                } else{ papi=(DefaultMutableTreeNode)modeloC45.getChild(pjod,cr);
                }
                
                if( papi.isLeaf() == true){
                    rama = new DefaultMutableTreeNode( datosEntrada.getColumnName(ganadores[cr]));
                    modeloC45.insertNodeInto( rama,papi,0 );
                    papa = rama;
                    
                    for(int patributo=0; patributo < natri[ganadores[cr]]; patributo++) {
                        rama = new DefaultMutableTreeNode( ((String[])atributo[ganadores[cr]])[patributo] );
                        modeloC45.insertNodeInto( rama,papa,patributo );
                        
                        if(posp==0){
                            if(((String[])parci[ganadores[cr]])[patributo] != null){
                                aux = rama;
                                rama = new DefaultMutableTreeNode( ((String[])parci[ganadores[cr]])[patributo] );
                                modeloC45.insertNodeInto( rama,aux,0 );
                            }
                        } else{
                            colaux = col;
                            colaux[posp] = ganadores[cr];
                            counter = new Contador(datosEntrada,colaux,posp+2, valores.size());
                            pas = counter.tupapa();
                            pnrtas = counter.nrutas();
                            String parcial = parcializados(parci,pas,pnrtas,ganadores[cr],papi.getPath(),((String[])atributo[ganadores[cr]])[patributo],posp);
                            if(parcial != null){
                                aux = rama;
                                rama = new DefaultMutableTreeNode(parcial);
                                modeloC45.insertNodeInto( rama,aux,0 );
                            }
                        }
                        
                    }
                }
            }
            
            
            bra = 0;  j = 0;  cnp = 0;  cclr = 1;  bdj = 0;
            
            papa=(DefaultMutableTreeNode)raiz.getFirstChild();
            
            while(bra==0){
                nrutasb = papa.getChildCount();
                rutasb = new String[nrutasb][columnas + 2];
                if(bdj==1) {
                    j = (Integer)auxj.get(cclr-1);
                    if(j==nrutasb){
                        bra = 1;
                        bdfinal = 1;
                    }
                    bdj = 0;
                } else j = 0;
                
                while( j < nrutasb){
                    rama = (DefaultMutableTreeNode)papa.getChildAt(j);
                    rutasb[j][0] = nameColTarget;
                    cp=cclr;
                    aux=rama;
                    while(cp != 0){
                        rutasb[j][cp] = aux.toString();
                        aux=(DefaultMutableTreeNode) aux.getParent();
                        aux=(DefaultMutableTreeNode) aux.getParent();
                        cp--;
                    }
                    
                    if(rama.isLeaf()==true){
                        j++;
                        if(j==nrutasb){
                            bra=1;
                        }
                    } else if(rama.getChildCount() == 1 && rama.getFirstChild().isLeaf() == true){////////////////////////////////
                        j++;
                        cnp++;
                        if(j==nrutasb){
                            bra=1;
                        }
                    } else{
                        auxpas[cclr-1] = papa;
                        auxj.add(cclr-1,j + 1);
                        auxcnp.add(cclr-1,cnp);
                        papa = (DefaultMutableTreeNode) rama.getFirstChild();
                        j = nrutasb;
                        bra = 0;
                        cclr++;
                        cnp = 0;
                    }
                    if(cnp==nrutasb){
                        cclr--;
                        papa = auxpas[cclr-1];
                        cnp = ((Integer)auxcnp.get(cclr-1)) + 1;
                        bdj = 1;
                        bra = 0;
                    }
                }
            }
            int estado=0;
            while(estado < columnas-1){
                if(papa.toString() == datosEntrada.getColumnName(estado)){
                    break;
                }
                estado++;
            }
            ncolsb = posp+2;
            col[posp] = estado;
            //System.out.println(posp);
                        
            col[posp+2] = columnas-1;
            posp++;
        }
        add( new JScrollPane( arbolC45 ),BorderLayout.CENTER );
        JPanel panel = new JPanel();
        add( panel,BorderLayout.SOUTH );
    }
    
    public ArrayList getAttributeCount(){
        ArrayList valores = new ArrayList(1);
        ArrayList nombres = new ArrayList(1);
        for(int i = 0; i < filas; i++){
            String nombre = (String)datosEntrada.getValueAt(i, columnas - 1);
            nombre = nombre.trim();
            int index = nombres.indexOf(nombre);
            if(index == -1){
                nombres.add(nombre);
                valores.add(1);
            } else {
                valores.set(index, (Integer)valores.get(index) + 1);
            }
        }
        return valores;
    }
    
    public String parcializados(Object parci[], TreeNode pas[][], int nrtas, int cg, TreeNode pis[], String atr, int pposp) {
        String rtparci[] = new String[30];
        int bdesta = 0, crp, prp;
        String valparci = "";
        // **********************
        
        crp=2; prp=0;
        while(crp < pis.length){
            rtparci[prp] = pis[crp].toString();
            crp=crp+2;
            prp++;
        }
        rtparci[prp] = atr;
        
        for(int b=0; b < nrtas; b++){
            bdesta = 0;
            for(int c=1; c < pposp+2; c++){
                if(pas[b][c].toString() == rtparci[c-1]){
                    bdesta++;
                }
            }
            if(bdesta==pposp+1){
                valparci = ((String[])parci[cg])[b];
                break;
            }
        }
        return(valparci);
    }
}



