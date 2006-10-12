/*
 * AssocRules.java
 *
 * Created on 13 de mayo de 2006, 16:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Tariy
 */
public class AssocRules {
    private Vector frequents;
    private ArrayList dictionary;
    private int confidence;
    private Vector rules;
    
    /** Creates a new instance of AssocRules */
    public AssocRules(Vector frequents, ArrayList dictionary, int confidence) {
        this.frequents = frequents;
        this.dictionary = dictionary;
        this.confidence = confidence;
        this.rules = new Vector();
    }
    
    public void buildRules() {
        int Fsize = frequents.size();
        AvlTree tree;
        
        for(int i=1; i<Fsize; i++) {
            tree = (AvlTree) frequents.elementAt(i);
            walkTree(tree.getRoot());
        }
    }
    
    public void buildRules2() {
        int Fsize = frequents.size();
        int sizeTree;
        AvlTree tree;
        AvlNode node;
        
        for(int i=1; i<Fsize; i++) {
            tree = (AvlTree) frequents.elementAt(i);
            sizeTree = tree.howMany();
            for(int j=0; j<sizeTree; j++) {
                node = tree.walkTree();

                int size = node.getItemset().getItems().length;
                Vector items = new Vector(size);
                Vector post = new Vector(size);
                for(int k=0; i<size; k++) {
                    items.addElement( node.getItemset().getItems()[k] );
                }
                Combinations(items, size-1, post, node.getItemset().getSupport());
            }
        }
    }
    
    private void walkTree(AvlNode node) {
        if(node != null) {
            walkTree(node.getLeft());
            
            int size = node.getItemset().getItems().length;
            Vector items = new Vector(size);
            Vector post = new Vector(size);
            for(int i=0; i<size; i++) {
                items.addElement( node.getItemset().getItems()[i] );
            }
            Combinations(items, size-1, post, node.getItemset().getSupport());
            
            walkTree(node.getRight());
        }
    }
    
    private void Combinations(Vector items, int x, Vector con, float supFre){
        if(items.size() > 1) {
            for(int i = x; i >= 0; i--) {
                Vector aux = (Vector) items.clone();
                Vector post = (Vector) con.clone();
                aux.remove(i);
                post.addElement(items.elementAt(i));
                Combinations(aux, i - 1, post, supFre);
                post.remove(post.size()-1);
            }
        }
        if(con.size() > 0) {
            ItemSet ant = new ItemSet(items, (short) 0);
            AvlTree prevTree = (AvlTree) frequents.elementAt(ant.getType()-1);
            ant = prevTree.findItemset(ant);
            float supAnt = ant.getSupport();
            float conf = (supFre / supAnt) * 100;
            if(conf >= this.confidence) {
                decodeFrequents(items, con, conf);
            }
        }
    }
    
    private void decodeFrequents(Vector ant, Vector con, float conf) {
        String antecedent = "", concecuent = "";
        int size;
        short element;
        
        size = ant.size();
        for(int i=0; i<size; i++) {
            element = (Short) ant.elementAt(i);
            antecedent = antecedent + (String) dictionary.get(element) + " ~ ";
        }
        antecedent = antecedent.substring(0, antecedent.length()-3);
        
        size = con.size();
        for(int i=0; i<size; i++) {
            element = (Short) con.elementAt(i);
            concecuent = concecuent + (String) dictionary.get(element) + " ~ ";
        }
        concecuent = concecuent.substring(0, concecuent.length()-3);
        rules.addElement( new Rules(antecedent, concecuent, conf) );
    }
    
    public Vector getRules() {
        return rules;
    }
    
    public void showRules() {
        Rules ru = null;
        
        int size = rules.size();
        Collections.sort(rules, new byConfidence());
        for(int i=0; i<size; i++) {
            ru = (Rules) rules.elementAt(i);
            System.out.print(ru.getAntecedent() + " -> " + ru.getConcecuent()
            + " (" + ru.getConfidence() + " %)" + "\n");
        }
    }
        /**
     * Representación textual de las reglas ordenadas descendentemente por 
     * soporte.
     */
    public String toString() {
        String ruls = new String("");
        int size = this.rules.size();

        Collections.sort(rules, new byConfidence());
        for(int i=0; i<size; i++) {
            ruls = ruls + (i+1) + ". " + ((Rules) rules.elementAt(i)).toString() + "\n";
        }
        return ruls;
    }
}
