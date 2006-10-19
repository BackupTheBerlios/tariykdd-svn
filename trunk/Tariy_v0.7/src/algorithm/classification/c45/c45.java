/*
 * c45.java
 *
 * Created on 22 de junio de 2006, 12:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author and
 */
public class c45 {
    ArrayList gains;
    AbstractTableModel data;
    ArrayList col;
    TreeCounter tree;
    ArrayList trees = new ArrayList();
    ArrayList atributos_insertados = new ArrayList(1);
    ListParcializados nodesParcializados = null;
    ListParcializados currentNode = null;
    ListParcializados nodesParcializados2 = null;
    ListParcializados currentNode2 = null;
    boolean bdf = false;
    ArrayList leaves = new ArrayList(1);
    
//    String n = "";
    
    private Tree finalTree;
    
    private Stack stack;
    
    /** Creates a new instance of c45 */
    public c45(AbstractTableModel dataIn) {
        data = dataIn;
        gains = new ArrayList(1);
        col = new ArrayList(1);
        tree = new TreeCounter(data, atributos_insertados);
    }
    
    public void start(){
        
        stack = new Stack();
        int columnCount = data.getColumnCount();
        Route route = new Route(columnCount - 1);  // nombre del la col obj
        //route.index = 1;
        TreeCounter treeIni = new TreeCounter(data, atributos_insertados);
        route.firstGain = true;
        treeIni.createTree(route);
        double FirtsGain = treeIni.gananciaInicial();
        route.firstGain = false;
        int gradelevel;
        
        //instancio el arbol final (finalTree) de tipo Tree con el nombre de la columna objetivo
        finalTree = new Tree(new Node(data.getColumnName(columnCount - 1)));
        //la clase Tree esta en el mismo archivo de la clase Node
        //inserto como hijo de la raiz el nombre de la columna ganadora
        Node auxiliar = finalTree.root;//ubico el nodo auxiliar en el primer hijo de la raiz
        boolean flag;
        //while(flag){
        while(auxiliar != null){
            finalTree.print(finalTree.root);
            ///System.out.println("FUNCIONA " + finalTree.show);
            //auxiliar = finalTree.search(auxiliar);
            auxiliar = finalTree.show;
            if(auxiliar == null){
                ///System.out.println("Termine");
                Clearequalsparcializados();
                rules();
                break;
            }
            ArrayList positionFix = this.buildRoute(auxiliar);
            route.setPosicionesFijas(positionFix);
            myHashMap hm = new myHashMap();
            String pathFather;
            for(int i = 0; i < columnCount - 1; i++){
                route.resetIndex();
                if(route.setPosicionVariable(i)) continue;
                TreeCounter tree = new TreeCounter(data, atributos_insertados);
                tree.root.entropia = FirtsGain;
                tree.createTree(route);
                tree.seeTree();
                if(auxiliar.father == null){
                    pathFather = "";
                } else {
                    pathFather = findPath(auxiliar.father.father);
                }
                tree.ganancia(hm, pathFather);
                ///System.out.println("");
                
            }
            myHashMap Columnswinner = hm.searchColumnsWinner();
            Iterator it = Columnswinner.keys.iterator();
            Node auxiliar2 = auxiliar;
            while(it.hasNext()){
                myKey key = (myKey)it.next();;
                
                while(auxiliar != null){
                    if(auxiliar.name.equals(key.name)){
                        break;
                    }
                    auxiliar = auxiliar.brother;
                }
                Column win = (Column)key.values.get(0);
                auxiliar.addSon(win.position, win.name, -1.0, ""); //este es un nodo que no necesita ganancia ni parcializado
                auxiliar = auxiliar.son;
                
                Node auxSon;
                int childsCount = 0;
                int childsParcializados = 0;
                Iterator i = win.attributes.iterator();
                
                boolean bd = false;
                while(i.hasNext()){
                    Attribute aux = (Attribute)i.next();
                    auxSon = auxiliar.addSon(win.position, aux.name, aux.entropia, aux.parcializadoValue);
                    childsCount++;
                    if(aux.entropia == 0.0 /*&& auxiliar.father.name.equals(finalTree.root.name)*/){//************** revisar si estamos validando correctamente
                        aux.parcializado = true;
                        Node target = auxSon.addSon(0, finalTree.root.name, -1.0, "");
                        target.addSon(0, aux.son.name+ " [" + aux.son.frecuence + "/" + aux.son.frecuence + "]", 0.0, "");
                        
                        gradelevel = target.getLevel();
                        ///System.out.println(gradelevel);
                        
                        //  leaves.add(target);
                        leaves.add(target.son);
                        
                        if(nodesParcializados == null || target.getLevel() > currentNode.node.getLevel()){ //  meter de alguna forma solo los del mayor nivel 777777777
                            nodesParcializados = new ListParcializados(target);
                            currentNode = nodesParcializados;
                            bd = true;
                        }else if(bd == false && (target.getLevel() == currentNode.node.getLevel())) {
                            currentNode.next = new ListParcializados(target);
                            currentNode = currentNode.next;
                            bd = true;
                        }
                        
                        childsParcializados++;
                        
                    } else if(route.getSize() == data.getColumnCount()){
                        aux.parcializado = true;
                        Node target = auxSon.addSon(0, finalTree.root.name, -1.0, "");
                        Attribute parcial = aux.son;
                        Attribute major = new Attribute("", null, null, null);
                        major.frecuence = 0;
                        int sum = 0;
                        while(parcial != null){
                            ///System.out.println(parcial.father + ": " + parcial.name + " count -> " + parcial.frecuence);
                            sum += parcial.frecuence;
                            if(parcial.frecuence > major.frecuence){
                                major = parcial;
                            }
                            parcial = parcial.brother;
                        }
                        
                        target.addSon(0, major.name + " [" + major.frecuence + "/" + sum + "]", 0.0, "");
                        
                        // if(nodesParcializados == null){  // meter de alguna forma solo los del mayor nivel 777777777
                        
                        //  leaves.add(target);
                        leaves.add(target.son);
                        
                        if(nodesParcializados == null || target.getLevel() > currentNode.node.getLevel()){
                            nodesParcializados = new ListParcializados(target);
                            currentNode = nodesParcializados;
                            bd = true;
                        } //else if(bd == false){
                        else if(bd == false && (target.getLevel() == currentNode.node.getLevel())) {
                            currentNode.next = new ListParcializados(target);
                            currentNode = currentNode.next;
                            bd = true;
                        }
                        
                        childsParcializados++;
                        
                    }
                    aux.route = findPath(auxSon);
                    atributos_insertados.add(aux);
                    aux = aux.brother;
                }
                if(childsCount == childsParcializados){
                    auxiliar.father.parcializado = true;//parcializo el padre de auxiliar
                }
                auxiliar = auxiliar2;
            }
            
            auxiliar = finalTree.root;
            finalTree.show = null;
        }
        //La clase C45TreeGUI es una JFrame que muestra el arbol n-ario dentro de un JTree
        //es necesario pasarle el arbol que quiero mostrar en el constructor y en
        //el metodo createAndShowGUI(Tree tree) por ahora.
        C45TreeGUI view = new C45TreeGUI(finalTree);
        view.createAndShowGUI(finalTree);
        
    }
    
    public void equalsparcializados(Node node, int con){
        ArrayList valueParci = new ArrayList(1);
        int conequalvals, numChilds, pe, pca, pcc;
        int valnum, valdem, totnum = 0, totdem = 0;
        Node auxnode;
        StringTokenizer st;
        String vl, cad;
        //---------------------
        
//        if(node.father.name.equals(finalTree.root.name)){  // no se si ira
//            bdf = false;
//            n = "";
//        }
        
//        else{
//            if(!n.equals(node.father.father.father.name)){
//                bdf = false;
//            }
        
//            n = node.father.father.father.name;
//        }
        
        valueParci.clear();
        conequalvals = 1;
        
        numChilds = node.getChildCount();
        auxnode = node.son;
        
        for(int i = 0; i < numChilds; i++){
            if(auxnode.son.son.parcializado == true){
                cad = auxnode.son.son.name;
                st = new StringTokenizer(cad,"[");
                vl = st.nextToken();
                
                pe = cad.indexOf("/");
                pca = cad.indexOf("[")+1;
                pcc = cad.indexOf("]");
                
                valnum = Integer.parseInt(cad.substring(pca,pe));
                valdem = Integer.parseInt(cad.substring(pe+1,pcc));
                
                
                if(valueParci.contains(vl)){
                    totnum = totnum + valnum;
                    totdem = totdem + valdem;
                    conequalvals++;
                } else if(valueParci.isEmpty()){
                    totnum = totnum + valnum;
                    totdem = totdem + valdem;
                    valueParci.add(vl);
                }
            }
            auxnode = auxnode.brother;
        }
        
        if(numChilds == conequalvals){
            node.name = finalTree.root.name;
            node.son.name = valueParci.get(0).toString() + "[" + totnum + "/" + totdem + "]";
            node.son.brother = null;
            node.son.son = null;
            node.son.parcializado = true;
            
            leaves.set(con,node.son);
            for(int i = 1; i < numChilds; i++){
                con = con + i;
                leaves.set(con,null);
            }
            
//            if(nodesParcializados2 == null){
            if(nodesParcializados2 == null || node.getLevel() > currentNode2.node.getLevel()){
                nodesParcializados2 = new ListParcializados(node);
                currentNode2 = nodesParcializados2;
                bdf = true;
            } //else if(bdf == false){
            else if(bdf == false && (node.getLevel() == currentNode2.node.getLevel())) {
                currentNode2.next = new ListParcializados(node);
                currentNode2 = currentNode2.next;
                bdf = true;
            }
        }
        
        
    }
    
    public void Clearequalsparcializados(){
        int positionLeaf = 0, vals = 0;
        Node npar;
        if(nodesParcializados != null){
            int lim;
            ListParcializados Nodeaux = nodesParcializados;
            bdf = false;
            while(Nodeaux != null){
                npar = Nodeaux.node.father.father;
                vals = npar.getChildCount();
                equalsparcializados(npar,positionLeaf);
                positionLeaf = positionLeaf + vals;
                Nodeaux = Nodeaux.next;
            }
            nodesParcializados = null;
            nodesParcializados = nodesParcializados2;
            nodesParcializados2 = null;
            Clearequalsparcializados();
        }
    }
    
    static public void main(String arg[]){
        c45 c = new c45(new TariyTableModel());
        c.start();
    }
    
    private ArrayList buildRoute(Node auxiliar) {
        ArrayList pf = new ArrayList(1);
        Node aux = auxiliar;
        while(aux.column != -2){
            pf.add(aux.column);
            aux = aux.father.father;
        }
        Collections.reverse(pf);
        return pf;
    }
    
    private Node searchNode(String name) {
        return null;
    }
    
    private String findPath(Node aux) {
        String path = "";
        Node auxFather = aux;
        while(auxFather.column != -2){
            path += auxFather.name;
            auxFather = auxFather.father.father;
        }
        return path;
    }
    
    public void rules(){
        Node auxr;
        String ruta = "";
        boolean bdand = false;
        
        for(int i = 0; i < leaves.size(); i++){
            leaves.remove(null);
        }
        ///System.out.println(leaves);
        
        ArrayList rutas = new ArrayList(leaves.size());
        
        for(int i =0; i < leaves.size(); i++){
            auxr = (Node)leaves.get(i);
            ruta = auxr.name;
            auxr = auxr.father;
            ruta = " 'THEN'  " + auxr.name + " = " + ruta;
            while(auxr.father.father != null){
                    if(bdand == true){
                        ruta = " 'AND'  " + auxr.father.name + " = " + ruta;
                        bdand = false;
                    } else{
                        ruta = auxr.father.name + " " + ruta;
                        bdand = true;
                    }
                    auxr = auxr.father;
            }
            ruta = ruta.substring(6,ruta.length());
            ruta = "'IF' " + ruta;
            ruta = "\n RULE " + (i+1) + ": " + ruta;
            System.out.println(ruta);
            rutas.add(ruta);
            ruta = "";
        }
    }
}