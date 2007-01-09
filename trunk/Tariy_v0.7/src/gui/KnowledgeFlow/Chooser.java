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
 * @author andress
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
        setStatus("The TariyKDD Project \nis Running...");
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
        status = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAction = new javax.swing.JMenu();
        optNew = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenu();
        optAbout = new javax.swing.JMenuItem();

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
        setTitle("The TariyKDD Project");
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

        status.setFont(new java.awt.Font("Verdana", 0, 10));
        status.setText("Running...");
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 213)));

        mnuAction.setText("Actions");
        optNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_play.png")));
        optNew.setMnemonic('n');
        optNew.setText("New Experiment");
        optNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNewActionPerformed(evt);
            }
        });

        mnuAction.add(optNew);

        jMenuBar1.add(mnuAction);

        mnuAbout.setText("About");
        optAbout.setText("About ...");
        optAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAboutActionPerformed(evt);
            }
        });

        mnuAbout.add(optAbout);

        jMenuBar1.add(mnuAbout);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, status, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, chooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(chooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(status, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-991)/2, (screenSize.height-685)/2, 991, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void optNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNewActionPerformed
// TODO add your handling code here:
        canvas.conexiones.clear();
        canvas.removeAll();
        canvas.repaint();
    }//GEN-LAST:event_optNewActionPerformed

    private void optAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAboutActionPerformed
// TODO add your handling code here:
        new frmCredits().setVisible(true);
    }//GEN-LAST:event_optAboutActionPerformed
    
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
    
    public static void setStatus(String str){
        status.setText(str);
        str = str.replaceAll("\n", "<p>");
        str = "<html>".concat(str).concat("</html>");
        status.setToolTipText(str);
    }
    
    public static String getStatus(){
        return status.getText();
    }
    
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JMenu mnuAbout;
    private javax.swing.JMenu mnuAction;
    private javax.swing.JMenuItem optAbout;
    private javax.swing.JMenuItem optNew;
    public static javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
    
}
