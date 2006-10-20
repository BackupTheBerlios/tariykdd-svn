/*
 * ViewerClasification.java
 *
 * Created on 24 de julio de 2006, 10:50
 */

package gui.Icons.Tree;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author  endimeon
 */
public class ViewerClasification extends javax.swing.JFrame {
    
    /** Creates new form ViewerClasification */
    public ViewerClasification(JPanel panel, ArrayList rules) {
        initComponents();
        jScrollPane7 = new javax.swing.JScrollPane();
        TextRules = new javax.swing.JTextArea();
        jScrollPane7.setViewportView(TextRules);
        TextRules.setText(rules.toString());
        TabPanel.addTab("Tree", panel);
        TabPanel.addTab("Rules", jScrollPane7);
        
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

    private JScrollPane jScrollPane7;

    private JTextArea TextRules;
    
}
