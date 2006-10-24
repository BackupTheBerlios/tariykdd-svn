/*
 * Chooser.java
 *
 * Created on 26 de abril de 2006, 06:15 AM it work!!!
 */

package gui.KnowledgeFlow;

import gui.frmCredits;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 

/**
 *
 * @author  andress c use SVN from NetBeans 5.0
 */
public class Chooser extends javax.swing.JFrame {
    Contenedor c1;
    pnlPreprocesamiento pre;
    pnlAlgoritmos alg;
    pnlVisores vis;
    pnlFilters fil;
    MyCanvas canvas;
    JPanel p = null;
    
    private int backup_select = -1;
    /** Creates new form Chooser */
    public Chooser() {
        initComponents();
        pre = new pnlPreprocesamiento();
        alg = new pnlAlgoritmos();
        vis = new pnlVisores();
        fil = new pnlFilters();
        canvas = new MyCanvas();
        c1 = new Contenedor(pre, canvas);
        chooser.addTab("Connections", c1);
        chooser.addTab("Filters", p);
        chooser.addTab("Algorithms", p);
        chooser.addTab("Views", p);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDialog1 = new javax.swing.JDialog();
        jOptionPane1 = new javax.swing.JOptionPane();
        chooser = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnuActions = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuAbout = new javax.swing.JMenuItem();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jOptionPane1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animation/j1.png")));

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jOptionPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jOptionPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Tariy");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        chooser.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        chooser.setNextFocusableComponent(this);
        chooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooserMouseClicked(evt);
            }
        });

        jMenu2.setText("Actions");
        mnuActions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_play.png")));
        mnuActions.setMnemonic('n');
        mnuActions.setText("New Experiment");
        mnuActions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuActionsActionPerformed(evt);
            }
        });

        jMenu2.add(mnuActions);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("About");
        mnuAbout.setText("About ...");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });

        jMenu1.add(mnuAbout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(chooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(chooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuActionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuActionsActionPerformed
// TODO add your handling code here:
        canvas.conexiones.clear();
        canvas.removeAll();
        canvas.repaint();
    }//GEN-LAST:event_mnuActionsActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
// TODO add your handling code here:
//        JOptionPane.showMessageDialog(this, "The Tariy Project\nUniversidad de Nariño",
//                "The Tariy Project.",JOptionPane.INFORMATION_MESSAGE);
        //jOptionPane1.showMessageDialog(this, "The Tariy Project\nUniversidad de Nariño");
        new frmCredits().setVisible(true);
    }//GEN-LAST:event_mnuAboutActionPerformed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
        System.out.println("Todo Borrado Closing!!!");
        
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing
    
    private void chooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooserMouseClicked
// TODO add your handling code here:
        int select = chooser.getSelectedIndex();
        switch(select){
            case 0:
                if(backup_select == select){
                    c1.cambiarPanel(p);
                    backup_select = -1;
                } else {
                    c1.cambiarPanel(pre);
                    backup_select = select;
                }
                break;
            case 1:
                if(backup_select == select){
                    c1.cambiarPanel(p);
                    backup_select = -1;
                } else {
                    c1.cambiarPanel(fil);
                    backup_select = select;
                }
                break;
            case 2:
                if(backup_select == select){
                    c1.cambiarPanel(p);
                    backup_select = -1;
                } else {
                    c1.cambiarPanel(alg);
                    backup_select = select;
                }
                break;
            case 3:
                if(backup_select == select){
                    c1.cambiarPanel(p);
                    backup_select = -1;
                } else {
                    c1.cambiarPanel(vis);
                    backup_select = select;
                }
                break;
        }

    }//GEN-LAST:event_chooserMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chooser().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane chooser;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuActions;
    // End of variables declaration//GEN-END:variables
    
}
