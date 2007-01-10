/*
 * MainMate.java
 *
 * Created on 30 de diciembre de 2006, 1:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.mate;


import algorithm.classification.c45_1.Attribute;
import algorithm.classification.c45_1.TreeCounter;
import algorithm.classification.c45_1.TreeViewer;
import gui.Icons.Tree.ViewerClasification;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import Utils.ItemSet;

/**
 *
 * @author ivan
 */
public class MainMate {
    
    /** Fuente de datos */
    private gui.Icons.Filters.TariyTableModel dataSrc;
    
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

    public TreeCounter c;
    
    /** Creates a new instance of MainMate */
    public MainMate(gui.Icons.Filters.TariyTableModel data) {
        dataSrc = data;
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
        Object[][] datos = dataSrc.data;
        // Almacena las combinaciones atributo-ganadores
        Vector comb = new Vector();
        // Vector de ganadores
        Vector win;
        // To concatenate the attribute name and the attribute value
        String value;
        // Codifica a los elementos del conjunto de datos
        short cod;
        Entropy attrib;
        // Un nuevo HashMap por cada nivel del arbol
        attributes = new HashMap();
        for (int r=0; r<dataSrc.data.length; r++) {
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
                            attrib = new Entropy(value);
                            attributes.put(c, attrib);
                        } else {
                            attrib = (Entropy) attributes.get(c);
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
        Entropy winatt = null;
        double entro=-100000.0;
        String winner = new String();
        Collection set = attributes.values();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Entropy elem = (Entropy) it.next();
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
            Describe d = new Describe(0,-1, winner, "-1", "-1");
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
                                    d = new Describe(l+1,l, attr, value, "-1");
                                    flag = false;
                                } else {
                                    
                                    d = new Describe(desc.size(),index,attr, value, classe);
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
                Describe d = new Describe(desc.size(),index, winner, value, "-1");
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
            Entropy elem = (Entropy) it.next();
            elem.showAttributes();
        }
    }
    
    public void showDesc(){
        System.out.println("\n");
        Collections.sort(desc, new compareDaddy());
        for (int i = 0; i < desc.size(); i++){
            Describe a = (Describe) desc.get(i);
            System.out.println("Nod: "+a.getNode()+" Dad: "+a.getFather()+" Attr: "+
                    a.getAttribute() +" Value: "+a.getValue()+" Classe: "+a.getClasse());
        }
    }
    
    public TreeCounter erectTree(){
        Describe a1 = (Describe) desc.get(0);
        Attribute root = new Attribute(a1.getAttribute(),null,null);
        
        c = new TreeCounter();
        Attribute aux2;
        for(int i = 1; i < desc.size(); i++){
            a1 = (Describe) desc.get(i);
            String str = a1.getAttribute();
            str = str + "=" + a1.getValue();
            
            aux2 = (Attribute) c.searchTreeDesc(root,a1.getFather());
            Attribute a2 = new Attribute(str,null,null);
            a2.setId(a1.getNode());
            if(aux2.getSon() != null){
                aux2 = aux2.getSon();
                aux2 = aux2.getBro(aux2);
                aux2.setBro(a2);
            }else{
                aux2.setSon(a2);
            }
        }
        c.seeTree(root.getSon());
        ViewerClasification vc = new ViewerClasification(
                c.view.createAndShowGUI(new TreeViewer(root)), c.seeLeafs(root));
        vc.setVisible(true);
        
        return c;
    }
    
    public static void main(String args[]) {
        MainMate mm = new MainMate(new gui.Icons.Filters.TariyTableModel());
        mm.buildDictionary();
        mm.dataCombination();
        mm.calcEntropy();
        mm.showDesc();
        mm.erectTree();
        //mm.showAttributes();
    }
}
