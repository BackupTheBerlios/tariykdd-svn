/*
 * TreeCounter.java
 *
 * Created on 22 de junio de 2006, 11:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author and
 */
public class TreeCounter {
    int rows;
    int columns;
    Attribute root;
    Attribute aux;
    Attribute show;
    nodeVariable columnaVariable;
    nodeVariable rootVariable;
    nodeVariable currentVariable;
    AbstractTableModel dataIn;
    Route route;
    ArrayList atributos_insertados;
    
    /** Creates a new instance of TreeCounter */
    public TreeCounter(AbstractTableModel dataIn, ArrayList ai) {
        this.dataIn = dataIn;
        this.atributos_insertados = ai;
        rows = dataIn.getRowCount();
        columns = dataIn.getColumnCount();
        root = new Attribute(dataIn.getColumnName(columns - 1), null, null, null);
        root.route = "";
        //root.entropia = 0.940;  // ya consigo este valor si no que tengo que traerlo del 1er recorrido
    }
    
    public void createTree(Route route){
        this.route = route;
        boolean bd;
        Attribute auxBrother;
        int size;
        root.frecuence--;
        size = route.getSize(); // slo saque del for de las c
        if(route.firstGain) size = size - 1;
        for(int r = 0; r < rows ; r++ ) {  // recorre por filas
            aux = root;
            root.incrementFrecuence();
            if(route.firstGain){
                route.index = 1;
            } else {
                route.resetIndex();
            }
            for(int c = 0; c < size; c++ ) {  // recorre por columnas seleccionadas   //!!! el 2 no
                String value = (String)dataIn.getValueAt(r, route.getIndex());
                if(aux.son == null){ // si esta vacio
                    aux.son = new Attribute(value, aux, null, null);
                    aux.son.route = findPath(aux.son);
                    searchAttribute(aux.son);
                    if(c == size - 2){//aqui va size - 2 para enlazar el ultimo nivel
                        if(r == 0){
                            rootVariable = new nodeVariable(aux.son);
                            currentVariable = rootVariable;
                        } else {
                            currentVariable.next = new nodeVariable(aux.son);
                            currentVariable = currentVariable.next;
                        }
                    }
                    aux = aux.son;
                } else { // si no esta vacio
                    auxBrother = aux.son;
                    aux = aux.son;
                    bd = true;
                    while(aux != null){
                        if(aux.name.equals(value)){  // busca un item a ver si existe
                            aux.incrementFrecuence();
                            bd = false;
                            break;
                        }
                        auxBrother = aux; // ****************
                        aux = aux.brother;
                    }
                    if(bd){  // si no lo encuetra lo inserta
                        auxBrother.brother = new Attribute(value, auxBrother.father, null, null);
                        auxBrother.brother.route = findPath(auxBrother.brother);
                        searchAttribute(auxBrother.brother);
                        aux = auxBrother.brother;
                    }
                }
            } // cierre del for que recorre por columnas
        }
    }
    
    public double gananciaInicial(){
        double gain = 0.0;
        Attribute auxfirst = root.son;
        float division;
        
        while(auxfirst != null){
            division = ((float)auxfirst.frecuence / (float)auxfirst.father.frecuence);
            gain += (division) * auxfirst.log2(division);
            auxfirst = auxfirst.brother;
        }
        gain = gain * -1;
        return gain;
    }
    
    public void ganancia(myHashMap hm, String pathFather){
        double gain = 0.0;
        boolean flag = false;
        nodeVariable aux = rootVariable;
        double certidumbre;
        while(aux != null){
            certidumbre = 0.0;
            if(aux.attribute.father.equals(this.root)){
                flag = true;
            } else {
                flag = aux.attribute.father.father.route.equals(pathFather);
            }
            if(!aux.attribute.father.parcializado && flag){
                ArrayList attributesColumn = new ArrayList(1);
                Attribute auxBrother = aux.attribute;
                while(auxBrother != null){
                    ///System.out.println(auxBrother.name + ": " + auxBrother.setEntropia());
                    auxBrother.parcializadoValue = auxBrother.son.name;
                    attributesColumn.add(auxBrother);
                    certidumbre += auxBrother.setEntropia();
                    auxBrother = auxBrother.brother;
                }
                gain = aux.attribute.father.entropia - (certidumbre * -1);
                String ColumnName = dataIn.getColumnName(route.posicionVariable);
                Column c = new Column(ColumnName, route.posicionVariable, gain, attributesColumn);
                hm.addColumn(aux.attribute.father.name, c);
                //System.out.println("Ganancia: " + aux.attribute.father.name + " con " + c.toString());
            }
            aux = aux.next;
        }
    }
    
    public void ganancia(String keyFather){
        double gain = 0.0;
        nodeVariable aux = rootVariable;
        double certidumbre;
        certidumbre = 0.0;
        while(aux != null){
            if(aux.attribute.father.name.equals(keyFather)){
                break;
            }
            aux = aux.next;
        }
        if(!aux.attribute.father.parcializado){
            Attribute auxBrother = aux.attribute;
            while(auxBrother != null){
                ///System.out.println(auxBrother.name + ": " + auxBrother.setEntropia());
                certidumbre += auxBrother.setEntropia();
                auxBrother = auxBrother.brother;
            }
            gain = aux.attribute.father.entropia - (certidumbre * -1);
        }
    }
    
    public void showTree(Stack stack) {
        while(aux != null){
            stack.push(aux);
            aux = aux.son;
        }
        if(!stack.empty()){
            show = (Attribute)stack.pop();
            //System.out.println(show.toString());
        }
        if(show.brother == null){
            if(!stack.empty()){
                show = (Attribute)stack.pop();
                //System.out.println(show.toString());
            }
        }
        aux = show.brother;
        if( (!stack.empty()) || (aux != null) ){
            showTree(stack);
        }
    }
    
    public void clearLeaves(){
        nodeVariable auxVariable = this.rootVariable;
        
        while(auxVariable != null){
            Attribute auxAttribute = auxVariable.attribute;
            while(auxAttribute != null){
                auxAttribute.son = null;
                auxAttribute = auxAttribute.brother;
            }
            auxVariable = auxVariable.next;
        }
    }
    
    private boolean searchAttribute(Attribute son) {
        boolean flag = false;
        Iterator it = atributos_insertados.iterator();
        while(it.hasNext()){
            Attribute aux = (Attribute)it.next();
            if( aux.route.equalsIgnoreCase(son.route) ){
                son.entropia = aux.entropia * (-1);
                son.parcializado = aux.parcializado;
                return true;
            }
        }
        return false;
    }
    
    private String findPath(Attribute son) {
        String path = "";
        Attribute auxFather = son;
        while(auxFather.father != null){
            path += auxFather.name;
            auxFather = auxFather.father;
        }
        return path;
    }
    
    public void seeTree(){
        //System.out.println("Para " + dataIn.getColumnName(route.posicionVariable));
        nodeVariable aux = this.rootVariable;
        while(aux != null){
            Attribute auxA = aux.attribute;
            while(auxA != null){
                Attribute auxF = auxA;
                //System.out.println(auxA.son + " - ");
                //System.out.print(auxA.son.brother + " - ");
                while(auxF != null){
                    //System.out.print(auxF + " - ");
                    auxF = auxF.father;
                }
                //System.out.println();
                auxA = auxA.brother;
            }
            aux = aux.next;
        }
    }
}
