/*
 * frmCredits.java
 *
 * Created on 12 de octubre de 2006, 20:58
 */

package gui.Icons.File;

import java.util.Locale;

/**
 *
 * @author  and
 */
public class HelpFile extends javax.swing.JFrame {
    
    /** Creates new form frmCredits */
    public HelpFile() {
        initComponents();
        jButton1.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Close_Help..."));
        jButton1.setToolTipText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Return_Aplication"));
        jTextArea9.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p01"));
        jTextArea10.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p02"));
        jTextArea11.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p03"));
        jLabel19.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Connection_File"));
        jTextArea12.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p04"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jTextArea9 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jTextArea11 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextArea12 = new javax.swing.JTextArea();
        btnEn = new javax.swing.JToggleButton();
        btnEs = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit2.png")));
        jButton1.setMnemonic('c');
        jButton1.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Close_Help..."));
        jButton1.setToolTipText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Return_Aplication"));
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(51, 51, 51)));
        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jTextArea9.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p01"));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tariy11")));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/interrogacion.jpg")));
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/conectFile.png")));
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jTextArea10.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p02"));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/loadFile.png")));
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jTextArea11.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p03"));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel19.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("Connection_File"));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/confFile.png")));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jTextArea12.setText(java.util.ResourceBundle.getBundle("resource/translations/FileHelp").getString("p04"));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(45, 45, 45)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel19)
                            .add(jLabel21)
                            .add(jTextArea10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextArea9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(44, 44, 44)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel18)
                            .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(jLabel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 532, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel16)
                        .add(34, 34, 34))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel15)
                        .add(52, 52, 52)))
                .add(jLabel19)
                .add(14, 14, 14)
                .add(jTextArea9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel17)
                .add(35, 35, 35)
                .add(jTextArea10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel21)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(jLabel18)
                .add(18, 18, 18)
                .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jScrollPane2.setViewportView(jPanel3);

        btnEn.setBackground(new java.awt.Color(255, 255, 255));
        btnEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EN")));
        btnEn.setText("English");
        btnEn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnActionPerformed(evt);
            }
        });

        btnEs.setBackground(new java.awt.Color(255, 255, 255));
        btnEs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CO")));
        btnEs.setText("Espa\u00f1ol");
        btnEs.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnEs)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 363, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnEn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {btnEn, btnEs}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 403, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {btnEn, btnEs}, org.jdesktop.layout.GroupLayout.VERTICAL);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-627)/2, (screenSize.height-523)/2, 627, 523);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsActionPerformed
        Locale.setDefault(new Locale("es", "CO"));
        new HelpFile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEsActionPerformed

    private void btnEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnActionPerformed
// TODO add your handling code here:
        Locale.setDefault(new Locale("en", "US"));
        new HelpFile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpFile().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEn;
    private javax.swing.JToggleButton btnEs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea9;
    // End of variables declaration//GEN-END:variables
    
}
