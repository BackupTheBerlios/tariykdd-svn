/*
 * MainMate.java
 *
 * Created on 30 de diciembre de 2006, 1:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.mate;


import algorithm.classification.Value;
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
    
    public void calcEntropy(int score) {
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
        buildTree(winner, values,winatt.getSup());
    }
    
    public void buildTree(String winner, HashMap values, int score) {
        /**
         * System.out.println("");----------------------------------------------
         * System.out.println("Atributo::" + winner); --------------------------
         */
        ArrayList and = null;
        if (desc.isEmpty()) {
            Describe d = new Describe(0,-1, winner, "-1", "-1",null,0);
            desc.add(d);
        }
        int index = desc.size()-1;
        Set set = values.keySet();
        Iterator it = set.iterator();
        ArrayList combinations;
        String classe = dataSrc.getColumnName(dataSrc.getColumnCount()-1);
        while (it.hasNext()) {
            short key = (Short) it.next();
            combinations = (ArrayList) values.get(key);
            //System.out.print(" Value " + decode(key));------------------------
            if (combinations.size() == 2) {
                
                boolean flag = false;
                Iterator i = combinations.iterator();
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
                                    String cad2 = decode(s[0]);
                                    StringTokenizer st2 = new StringTokenizer(cad2, "=");
                                    st2.nextToken();
                                    value = st2.nextToken();
                                    and = counterClass(values, classe,value);
                                    value = fixCounter(and);
                                    d = new Describe(l+1,l, attr, value, "-1", and,score);
                                    flag = false;
                                } else {
                                    and = counterClass(values, classe,value);
                                    d = new Describe(desc.size(),index,attr, value, classe,and,score);
                                    flag = true;
                                }
                                desc.add(d);
                            }
                            score = ((Value)and.get(and.size()-1)).getFrecuence();
                            //Aqui puede ir el score del papa
                            /**-------------------------------------------------
                             * if (s[h] != key) {
                             * System.out.print(" parcilized " + decode(s[h]));
                             * }-------------------------------------------------*/
                        }
                        if(flag){
                            int l = desc.size()-2;
                            Describe a = (Describe) desc.get(l);
                            a.setFather(l+1);
                            desc.set(l,a);
                        }
                        //System.out.println("");-------------------------------
                    }
                }
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
                and = counterClass(values, classe,value);
                Describe d = new Describe(desc.size(),index, winner, value, "-1",and,score);
                desc.add(d);
                score = ((Value)and.get(and.size()-1)).getFrecuence();
                int so = 0;
                if(!and.isEmpty()){
                       so = getF(and);
                }
                dataCombination();
                if (!attributes.isEmpty()) {
                    calcEntropy(score);
                }else{
                //Aqui vamos-----------
                    int l = desc.size()-1;
                    and = counterClass(values, classe,value);
                    value = fixCounter(and);
                    d = new Describe(l+1,l, classe, value, "-1", and,score);
                    desc.add(d);
                }
            }
        }
        int k = dataSrc.getColumnIndex(winner);
        if (winners.containsKey(k)) {
            winners.remove(k);
        }
    }
    
    public int getF(ArrayList a){
        if(a != null){
            Value v = (Value) a.get(a.size()-1);
            return v.getFrecuence();
        }
        return 0;
    }
    public int sum(ArrayList a){
        int aux = 0;
        for(int i = 0; i < a.size(); i++){
            aux += ((Value)a.get(i)).getFrecuence();
        }
        return aux;
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
    
    /**This method returns the number of accurrences of each value of the class
     *for every node
     */
    public ArrayList counterClass(HashMap values, String classe, String value){
        ArrayList<Value> counter = new ArrayList<Value>();
        int frec = 0;
        boolean flag;
        Set set = values.keySet();
        Iterator it = set.iterator();
        ArrayList combinations;
        while (it.hasNext()) {
            short key = (Short) it.next();
            combinations = (ArrayList) values.get(key);
            Iterator i = combinations.iterator();
                while (i.hasNext()) {
                    Object elem = (Object) i.next();
                    if (elem instanceof ItemSet) {
                        short[] elements = ((ItemSet) elem).getItems();
                        flag = false;
                        for (int j=0; j<elements.length; j++) {
                            String str1 = decode(elements[j]);
                            StringTokenizer st = new StringTokenizer(str1,"=");
                            String attr = st.nextToken();
                            String valu = st.nextToken();
                            if(value.compareTo(valu)==0) flag = true;
                            if(classe.compareTo(attr) == 0 && flag == true){
                                if(!counter.isEmpty()){
                                    Value w = isIn(counter,valu);
                                    if(w != null){
                                        frec += ((ItemSet)elem).getSupport();
                                        w.incFrecuence(((ItemSet)elem).getSupport());
                                    }else{
                                        frec += ((ItemSet)elem).getSupport();
                                        Value v = new Value(valu,((ItemSet)elem).getSupport());
                                        counter.add(v);
                                    }
                                }else{
                                    frec += ((ItemSet)elem).getSupport();
                                    Value v = new Value(valu,((ItemSet)elem).getSupport());
                                    counter.add(v);
                                } 
                            }
                        }
                    }    
                }    
        }    
        Value v = new Value("",frec);
        counter.add(v);
        return counter;
    }
    
    public String fixCounter(ArrayList a){
        int b = ((Value)a.get(0)).getFrecuence();
        String str1 = ((Value)a.get(0)).getName();
        for(int i = 1; i<a.size()-1; i++){
            int c = ((Value)a.get(i)).getFrecuence();
            if(b < c){
                b = c;
                str1 = ((Value)a.get(i)).getName();
            }
        }
        a.clear();
        Value d = new Value(str1,b);
        a.add(d);
        return str1;
    }
    public Value isIn(ArrayList a, String v){
        for(int i = 0; i< a.size(); i++){
            String s = ((Value) a.get(i)).getName();
            if(s.compareTo(v) == 0){
                return (Value) a.get(i);
            }
        }
        return null;
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
    
    /**
     * Muestra el diccionario.
     */
    public String showDictionary() {
        return dictionary.toString();
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
        Collections.sort(desc, new compareDaddy());
        for (int i = 0; i < desc.size(); i++){
            Describe a = (Describe) desc.get(i);
            System.out.println("Nod: "+a.getNode()+" Dad: "+a.getFather()+" Attr: "+
                    a.getAttribute() +" Value: "+a.getValue()+" Classe: "+a.getClasse()+
                    " MyFrec: "+ getF(a.getCounter())+" DadFrec: "+a.getDadScore());
        }
    }
    
    public TreeCounter erectTree(){
        Describe a1 = (Describe) desc.get(0);
        Attribute root = new Attribute(a1.getAttribute(),getF(a1.getCounter()),a1.getDadScore());
        c = new TreeCounter();
        Attribute aux2;
        for(int i = 1; i < desc.size(); i++){
            a1 = (Describe) desc.get(i);
            String str = a1.getAttribute();
            str = str + "=" + a1.getValue();
            aux2 = (Attribute) c.searchTreeDesc(root,a1.getFather());
            Attribute a2 = new Attribute(str,getF(a1.getCounter()),a1.getDadScore());
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
        c.root = root;
        c.pruneLeafs();
        root.viewWekaTree();
        return c;
    }
    
    public static void main(String args[]) {
        MainMate mm = new MainMate(new gui.Icons.Filters.TariyTableModel());
        mm.buildDictionary();
        mm.dataCombination();
        mm.calcEntropy(0);
        mm.showDesc();
        mm.erectTree();
        //mm.showAttributes();
    }
}
