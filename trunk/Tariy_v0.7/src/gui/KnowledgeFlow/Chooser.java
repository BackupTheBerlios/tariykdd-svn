/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 * Chooser.java
 *
 * Created on 26 de abril de 2006, 06:15 AM
 */

package gui.KnowledgeFlow;

import gui.frmCredits;
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Class for displaying a main form. <p>
 * Click in the left panel to select an icon a release in the Work Area.
 *
 * @author andress
 */
public class Chooser extends javax.swing.JFrame {
    /** The Contenedor class add into JTabbePane */
    Contenedor c1;
    /** The auxiliar JPanel used in JTabbePane construction */
    JPanel p = null;
    
    /** Creates new form Chooser */
    public Chooser() {
        initComponents();
        c1 = new Contenedor();
        chooser.addTab("Connections", c1);
        chooser.addTab("Filters", p);
        chooser.addTab("Algorithms", p);
        chooser.addTab("Views", p);
        setStatus("The TariyKDD Project \nis Running...");
        setPreferredSize(new Dimension(990,680));
        Locale.setDefault(new Locale("en","US"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        chooser = new javax.swing.JTabbedPane();
        status = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAction = new javax.swing.JMenu();
        optNew = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenu();
        optAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The TariyKDD Project");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
                .add(chooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(status, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-999)/2, (screenSize.height-685)/2, 999, 685);
    }// </editor-fold>//GEN-END:initComponents
    
    private void optNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNewActionPerformed
// TODO add your handling code here:
        c1.canvas.conexiones.clear();
        c1.canvas.removeAll();
        c1.canvas.repaint();
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
        c1.changeLeftPanel(select);
    }//GEN-LAST:event_chooserMouseClicked
    
    /**
     * Set the <code>String</code> in the Status Bar.
     *
     * @param str The string to set.
     * @author Proyecto Tariy
     */
    public static void setStatus(String str){
        status.setText(str);
        str = str.replaceAll("\n", "<p>");
        str = "<html>".concat(str).concat("</html>");
        status.setToolTipText(str);
    }
    
    /**
     * Get the <code>String</code> in the Status Bar.
     *
     * @author Proyecto Tariy
     */
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuAbout;
    private javax.swing.JMenu mnuAction;
    private javax.swing.JMenuItem optAbout;
    private javax.swing.JMenuItem optNew;
    public static javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
