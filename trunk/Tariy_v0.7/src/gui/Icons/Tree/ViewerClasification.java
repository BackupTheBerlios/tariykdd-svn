/*
 * ViewerClasification.java
 *
 * Created on 24 de julio de 2006, 10:50
 */

package gui.Icons.Tree;

import algorithm.classification.c45_1.Attribute;
import gui.KnowledgeFlow.Chooser;
import gui.KnowledgeFlow.Icon;
import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author  endimeon
 */
public class ViewerClasification extends javax.swing.JFrame {
    private LinkedList rules;
    private Attribute root;
    /** Creates new form ViewerClasification */
    public ViewerClasification(Attribute root, String nameTree, Component compTree, String porErrorM, Icon TreeIcon) {
        this.root = root;
        initComponents();
        LblErrorM.setText(porErrorM + "%");
        TabPanel.addTab(nameTree, compTree);
        panelRules = new PanelTableRules(root, porErrorM);
        Chooser.setStatus("Generate " + panelRules.getRulesCount() + " rules with a confidence of " + porErrorM + "%");
        TreeIcon.setInfo("Generate " + panelRules.getRulesCount() + " rules\nwith a confidence of " + porErrorM + "%");
        TabPanel.addTab("Rules", panelRules);
    }

    public Attribute getRoot() {
        return root;
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
        jLabel3 = new javax.swing.JLabel();
        LblErrorM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Viewer Tree");
        jPanel2.setBackground(new java.awt.Color(81, 81, 133));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confidence Tree : ");

        LblErrorM.setFont(new java.awt.Font("Tahoma", 0, 18));
        LblErrorM.setForeground(new java.awt.Color(255, 255, 255));
        LblErrorM.setText("xxx");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(TabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(LblErrorM)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(TabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(LblErrorM))
                .add(26, 26, 26))
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
    private javax.swing.JLabel LblErrorM;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    private PanelTableRules panelRules;
    private javax.swing.JScrollPane scrollWekaTree;
    private javax.swing.JPanel pnlWekaTree;
}
