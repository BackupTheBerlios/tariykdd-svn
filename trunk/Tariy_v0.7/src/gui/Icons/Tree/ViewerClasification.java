/*
 * ViewerClasification.java
 *
 * Created on 24 de julio de 2006, 10:50
 */

package gui.Icons.Tree;

import algorithm.classification.c45_1.Attribute;
import algorithm.classification.c45_1.C45TreeGUI;
import algorithm.classification.c45_1.TreeCounter;
import algorithm.classification.c45_1.TreeViewer;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author  endimeon
 */
public class ViewerClasification extends javax.swing.JFrame {
    private LinkedList rules;
    /** Creates new form ViewerClasification */
    
    public ViewerClasification(Attribute root) {
        initComponents();
        JPanel TreePanel = C45TreeGUI.createAndShowGUI(new TreeViewer(root));
        TreeCounter c =  new TreeCounter();//  Clase provisional para general reglas en formato texto
        //  debe cambiar a un TreeTableModel
        StringBuffer RulesText = c.seeLeafs(root);
        scrollTree = new javax.swing.JScrollPane();
        TextRules = new javax.swing.JTextArea();
        scrollTree.setViewportView(TextRules);
        TextRules.setText(RulesText.toString());
        TabPanel.addTab("Tree", TreePanel);
        TabPanel.addTab("Rules", scrollTree);
        scrollTable = new javax.swing.JScrollPane();
        tblRules = new javax.swing.JTable();
        rules = root.getLeafs();
        TreeTableModel tblModel = new TreeTableModel(rules);
        tblRules.setModel(tblModel);
        tblRules.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ShowClassificationRules.setOptimalColumnWidth(tblRules);
        
        scrollTable.setViewportView(tblRules);
        TabPanel.addTab("Table", scrollTable);
        this.addJTableHeaderListener();
        root.viewWekaTree();
    }
    
    public void addJTableHeaderListener() {
        MouseAdapter mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                TableColumnModel columnModel = tblRules.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column = tblRules.convertColumnIndexToModel(viewColumn);
                if(e.getClickCount() == 1 && column != -1) {
                    if(column == 2) {
                        Collections.sort(rules, new compareClass());
                        tblRules.updateUI();
                    } else if(column == 3) {
                        Collections.sort(rules, new compareConfidence());
                        Collections.sort(rules, new compareFrecuence());
                        tblRules.updateUI();
                    }
                }
            }
        };
        JTableHeader header = tblRules.getTableHeader();
        header.addMouseListener(mouseListener);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        TabPanel = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Viewer Clasification");
        jPanel2.setBackground(new java.awt.Color(81, 81, 133));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(TabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(TabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    private JScrollPane scrollTree;
    private JTextArea TextRules;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tblRules;
}
