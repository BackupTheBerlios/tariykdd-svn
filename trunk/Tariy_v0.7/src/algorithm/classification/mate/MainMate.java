/*
 * MainMate.java
 *
 * Created on 30 de diciembre de 2006, 1:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.mate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import utils.ItemSet;

/**
 *
 * @author ivan
 */
public class MainMate {
    
    /** Fuente de datos */
    private TariyTableModel dataSrc;
    
    /** Diccionario de datos */
    private ArrayList dictionary;
    
    /** Mapa de atributos ganadores */
    private HashMap winners;
    
    /** Mapa de objetos Attribute */
    private HashMap attributes;
    
    /**
     * Almacena objetos tipo Describe. Estructura para construir el arbol de
     * decision.
     */
    private ArrayList desc;
    
    /** Creates a new instance of MainMate */
    public MainMate() {
        dataSrc = new TariyTableModel();
        dictionary = new ArrayList();
        winners = new HashMap();
        desc = new ArrayList();
    }
    
    /**
     * Construye el diccionario de datos en un arraylist.
     */
    public void buildDictionary() {
        // To concatenate the attribute name and the attribute value
        String aux;
        
        //->Dictionary building
        for(int i = 0; i < dataSrc.getColumnCount(); i++) {
            for(int j = 0; j < dataSrc.getRowCount(); j++) {
                aux = dataSrc.getColumnName(i);
                aux = aux + "=" + (String) dataSrc.getValueAt(j, i);
                if(dictionary.isEmpty()){
                    dictionary.add("?");
                }else{
                    if(!dictionary.contains(aux)) {
                        dictionary.add(aux);
                    }
                }
            }
        }
        // Ordena alfabeticamente el diccionario
        Collections.sort(dictionary);
    }
    
    /**
     * Muestra el diccionario.
     */
    public String showDictionary() {
        return dictionary.toString();
    }
    
    public void dataCombination() {
        // Indice de la clase del conjunto de datos
        int classInd;
        // Conjunto de datos
        Object[][] datos = dataSrc.datos;
        // Almacena las combinaciones atributo-ganadores
        Vector comb = new Vector();
        // Vector de ganadores
        Vector win;
        // To concatenate the attribute name and the attribute value
        String value;
        // Codifica a los elementos del conjunto de datos
        short cod;
        Attribute attrib;
        // Un nuevo HashMap por cada nivel del arbol
        attributes = new HashMap();
        for (int r=0; r<dataSrc.datos.length; r++) {
            win = winnersIn(datos[r]);
            classInd = dataSrc.getColumnCount()-1;
            value = dataSrc.getColumnName(classInd);
            value = value + "=" + (String) datos[r][classInd];
            cod = code(value);
            if (win != null) {
                for (int c=0; c<classInd; c++) {
                    if (!winners.containsKey(c)) {
                        value = dataSrc.getColumnName(c);
                        if (!attributes.containsKey(c)) {
                            attrib = new Attribute(value);
                            attributes.put(c, attrib);
                        } else {
                            attrib = (Attribute) attributes.get(c);
                        }
                        value = value + "=" + (String) datos[r][c];
                        comb.addElement(code(value));
                        comb.addAll(win);
                        comb.addElement(cod);
                        attrib.addCombination(comb, c);
                        comb.clear();
                    }
                }
            }
        }
    }
    
    /**
     * Verifica que los valores de los atributos ganadores se encuentren en un
     * determinado registro del conjunto de datos.
     */
    public Vector winnersIn(Object[] data) {
        Set set = winners.keySet();
        Iterator it = set.iterator();
        int key;
        String value;
        Vector aux = new Vector();
        while (it.hasNext()) {
            key = (Integer) it.next();
            value = (String) winners.get(key);
            String var = (String) data[key];
            if (value.compareTo(var) != 0) {
                return null;
            } else {
                value = dataSrc.getColumnName(key);
                value = value + "=" + (String) data[key];
                aux.addElement(code(value));
            }
        }
        return aux;
    }
    
    /**
     * Codifica un elemento de la fuente de datos por su valor en el diccionario.
     */
    public short code(String attr) {
        return (short) Collections.binarySearch(dictionary, attr);
    }
    
    /**
     * Decodifica un dato.
     */
    public String decode(short i) {
        return (String) dictionary.get(i);
    }
    
    /**
     * Adiciona un valor al mapa de atributos ganadores.
     */
    public void addWinner(int key, String winner) {
        this.winners.put(key, winner);
    }
    
    public void calcEntropy() {
        Attribute winatt = null;
        double entro=-100000.0;
        String winner = new String();
        Collection set = attributes.values();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Attribute elem = (Attribute) it.next();
            elem.entropy();
            if (elem.getEntro() > entro) {
                entro = elem.getEntro();
                winner = elem.getAttribute();
                winatt = elem;
            }
        }
        HashMap values = winatt.getValues();
        buildTree(winner, values);
    }
    
    public void buildTree(String winner, HashMap values) {
        System.out.println(""); //****
        System.out.println("Atributo::" + winner); //****
        
        if (desc.isEmpty()) {
            Describe d = new Describe(-1, winner, "-1", "-1");
            desc.add(d);
        }
        int index = desc.size()-1;
        //Tree t = new Tree(winner, );
        Set set = values.keySet();
        Iterator it = set.iterator();
        ArrayList combinations;
        while (it.hasNext()) {
            short key = (Short) it.next();
            combinations = (ArrayList) values.get(key);
            System.out.print(" Value " + decode(key));  //********
            if (combinations.size() == 2) {
                // Valor parcializado. Construir arbol de decision
                // nombre de la clase
                String classe = dataSrc.getColumnName(dataSrc.getColumnCount()-1);
                boolean flag = false;
                Iterator i = combinations.iterator();  //********
                while (i.hasNext()) {
                    Object elem = (Object) i.next();
                    if (elem instanceof ItemSet) {
                        short[] s = ((ItemSet) elem).getItems();
                        Describe d = null;
                        for (int h=0; h<s.length; h++) {
                            String cad = decode(s[h]);
                            StringTokenizer st = new StringTokenizer(cad, "=");
                            String attr = st.nextToken();
                            String value = st.nextToken();
                            int a = dataSrc.getColumnIndex(attr);
                            if (!(winners.containsValue(value)&& winners.containsKey(a))) {
                                if (attr.compareTo(classe) == 0) {
                                    int l = desc.size()-1;
                                    d = new Describe(l, attr, value, "-1");
                                    flag = false;
                                } else {
                                    
                                    d = new Describe(index,attr, value, classe);
                                    flag = true;
                                }
                                desc.add(d);
                            }
                            if (s[h] != key) {
                                System.out.print(" parcilized " + decode(s[h]));
                            }
                        }
                        if(flag){
                            int l = desc.size()-2;
                            Describe a = (Describe) desc.get(l);
                            a.setFather(l+1);
                            desc.set(l,a);
                        }
                        System.out.println("");
                    }
                } //********
            } else {
                String value = decode((short) key);
                StringTokenizer st = new StringTokenizer(value, "=");
                st.nextToken();
                value = st.nextToken();
                int k = dataSrc.getColumnIndex(winner);
                if (winners.containsKey(k)) {
                    winners.remove(k);
                }
                winners.put(k, value);
                Describe d = new Describe(index, winner, value, "-1");
                desc.add(d);
                dataCombination();
                if (!attributes.isEmpty()) {
                    calcEntropy();
                }
            }
        }
        int k = dataSrc.getColumnIndex(winner);
        if (winners.containsKey(k)) {
            winners.remove(k);
        }
    }
    
    /**
     * Muestra una representacion textual de las combinaciones de cada atributo
     * con los valores de la clase.
     */
    public void showAttributes() {
        Collection set = attributes.values();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Attribute elem = (Attribute) it.next();
            elem.showAttributes();
        }
    }
    
    public void showDesc(){
        System.out.println("\n");
        for (int i = 0; i < desc.size(); i++){
            Describe a = (Describe) desc.get(i);
            System.out.println("Nod: "+i+" Dad: "+a.getFather()+" Attr: "+
            a.getAttribute() +" Value: "+a.getValue()+" Classe: "+a.getClasse());
        }
    }
    
    public static void main(String args[]) {
        MainMate mm = new MainMate();
        mm.buildDictionary();
        mm.dataCombination();
        mm.calcEntropy();
        mm.showDesc();
        //mm.showAttributes();
    }
}
