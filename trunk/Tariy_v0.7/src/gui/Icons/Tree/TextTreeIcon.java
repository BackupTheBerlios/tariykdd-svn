/*
 * RulesIcon.java
 *
 * Created on 26 de mayo de 2006, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Tree;

import algorithm.classification.c45_1.Attribute;
import algorithm.classification.c45_1.C45TreeGUI;
import algorithm.classification.c45_1.TreeCounter;
import algorithm.classification.c45_1.TreeViewer;
import gui.KnowledgeFlow.Icon;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class TextTreeIcon extends Icon{
    private JMenuItem mnuRun;
    private JMenuItem mnuView;
    public JPanel TreePanel;
    public StringBuffer RulesText;
    public AbstractTableModel dataTest;
    public Attribute root;
    String texErrorM; 

    private JScrollPane scrollTree;

    private JTextArea TextTree;
    
    /** Creates a new instance of DBConnectionIcon */
    public TextTreeIcon(JLabel s, int x, int y) {
        super(s, x, y);
        super.constrainsTo = new ArrayList(0);
        
        mnuRun = new javax.swing.JMenuItem();
        mnuRun.setText("Run...");
        mnuRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        //mnuRun.setEnabled(false);
        super.pupMenu.add(mnuRun);
        
        mnuView = new javax.swing.JMenuItem();
        mnuView.setText("View...");
        mnuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuView);
    }
    
    private void mnuRunActionPerformed(java.awt.event.ActionEvent evt) {

        int f = 0, rows = 0, colnode = 0;
        String cad,atri;
        Attribute auxiliar;
        float ErrorMissing = 0, datosMissing = 0;
        
        rows = dataTest.getRowCount();
        auxiliar = root.son;

        while(f < rows){ 

            StringTokenizer token = new StringTokenizer(auxiliar.name,"=");
            cad = token.nextToken().trim();

            if(auxiliar.son!=null){
              colnode = getColNode(cad);   
            }   
            else colnode = 0; 

            cad = token.nextToken().trim();
            atri = dataTest.getValueAt(f,colnode).toString().trim();

            if(auxiliar.son == null){
               f++;
               auxiliar = root.son;
            }
            else if(auxiliar.son != null && cad.equalsIgnoreCase(atri)){
                auxiliar = auxiliar.son;
            }
            else if(auxiliar.brother != null){
                auxiliar = auxiliar.brother;
            }
            else { 
               datosMissing++; 
               f++;
               auxiliar = root.son;
            }
        }
        if(datosMissing == 0){
           ErrorMissing = 0; 
        }
        else{
        ErrorMissing = ((datosMissing/rows)*100);
        }
        texErrorM = Float.toString(ErrorMissing);
    }
    
    private void mnuViewActionPerformed(java.awt.event.ActionEvent evt) {
        TreeCounter c =  new TreeCounter();//  Clase provisional para general reglas en formato texto
        String tree = c.getTextTree(root);
        scrollTree = new javax.swing.JScrollPane();
        TextTree = new javax.swing.JTextArea();
        scrollTree.setViewportView(TextTree);
        TextTree.setText(tree);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewerClasification(root, "Text Tree", scrollTree, texErrorM).setVisible(true);
            }
        });
    }
    
        public int getColNode(String colt){
        int numcol = 0, columns = 0;
        
        boolean compatibilidad = false;
        columns = dataTest.getColumnCount();
        
        for(int i = 0; i < columns; i++ ){
            if(colt.equalsIgnoreCase(dataTest.getColumnName(i))){
               numcol = i; 
               compatibilidad = true;
               break;
            }
        }
        return numcol;
    }
    
    /** Creates a new instance of AssociationIcon */
    
}
