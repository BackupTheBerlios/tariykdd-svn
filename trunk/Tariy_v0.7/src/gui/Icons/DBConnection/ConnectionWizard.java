/*
 * frmAsistente.java
 *
 * Created on 10 de abril de 2006, 06:49 AM
 */

package gui.Icons.DBConnection;

import gui.KnowledgeFlow.Chooser;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author  and
 */
public class ConnectionWizard extends javax.swing.JFrame {
    private boolean CONEXION_EXITOSA = false;
    private Connection connection = null;
    private String DriverName;
    private int x = 150, y = 25;
    public SelectorTable selector;
    private DBConnectionIcon myDBConnectionIcon = null;
    
    /** Creates new form frmAsistente */
    public ConnectionWizard() {
        initComponents();
        DriverName = "jdbc:postgresql://";
        spnPuerto.setValue(5432);
        lblStatusBar.setIcon(new ImageIcon(getClass().getResource("/images/no_conectado")));
        selector = null;
    }
    
    public ConnectionWizard(DBConnectionIcon dbci) {
        initComponents();
        myDBConnectionIcon = dbci;
        DriverName = "jdbc:postgresql://";
        spnPuerto.setValue(5432);
        lblStatusBar.setIcon(new ImageIcon(getClass().getResource("/images/no_conectado")));
        selector = null;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        lblDriver = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblBD = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        lblPuerto = new javax.swing.JLabel();
        cbxDriver = new javax.swing.JComboBox();
        txtUsuario = new javax.swing.JTextField();
        txtBD = new javax.swing.JTextField();
        txtHost = new javax.swing.JTextField();
        spnPuerto = new javax.swing.JSpinner();
        btnConectar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lblStatusBar = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")));
        lblDriver.setText("Driver JDBC:");

        lblUsuario.setText("User:");

        lblPassword.setText("Password:");

        lblBD.setText("Data Base:");

        lblHost.setText("Host:");

        lblPuerto.setText("Port:");

        cbxDriver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "org.postgresql.Driver", "com.mysql.jdbc.Driver" }));
        cbxDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDriverActionPerformed(evt);
            }
        });

        txtUsuario.setText("postgres");

        txtBD.setText("mine");

        txtHost.setText("192.168.10.80");

        btnConectar.setText("Connect...");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        txtPassword.setText("postgres1");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblBD)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblHost)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblUsuario)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblDriver))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtBD, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtUsuario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtHost, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblPuerto)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblPassword))
                        .add(12, 12, 12)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(spnPuerto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnConectar))
                            .add(txtPassword)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(116, 116, 116)
                        .add(cbxDriver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDriver)
                    .add(cbxDriver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblUsuario)
                    .add(lblPassword)
                    .add(txtUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblBD)
                    .add(txtBD, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblHost)
                    .add(lblPuerto)
                    .add(txtHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnConectar)
                    .add(spnPuerto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblStatusBar.setFont(new java.awt.Font("Dialog", 0, 10));
        lblStatusBar.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        lblStatusBar.setText("Wait Connection...");
        lblStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblStatusBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnAccept))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAccept)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblStatusBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cbxDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDriverActionPerformed
// TODO add your handling code here:
        switch(cbxDriver.getSelectedIndex()){
            case 0:
                DriverName = "jdbc:postgresql://";
                spnPuerto.setValue(5432);
                break;
            case 1:
                DriverName = "jdbc:mysql://";
                spnPuerto.setValue(3306);
                break;
        }
        
    }//GEN-LAST:event_cbxDriverActionPerformed
    
    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
// TODO add your handling code here:
        myDBConnectionIcon.connection = this.connection;
        myDBConnectionIcon.info = lblStatusBar.getText();
        this.dispose();
    }//GEN-LAST:event_btnAcceptActionPerformed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
        System.gc();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    
    public Connection getConnection() {
        return connection;
    }
    
    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
// TODO add your handling code here:
        String url = new String();
        try{
            Class.forName(cbxDriver.getSelectedItem().toString());
            url = DriverName + txtHost.getText() + ":"
                    + spnPuerto.getValue().toString() + "/"
                    + txtBD.getText();
            connection = DriverManager.getConnection(url, txtUsuario.getText(),
                    new String(txtPassword.getPassword()));
            CONEXION_EXITOSA = true;
            // Conexion exitosa...
            lblStatusBar.setIcon(new ImageIcon(getClass().getResource("/images/conectado")));
            lblStatusBar.setText("Success Connection to " + txtBD.getText()
                                    + " in " + txtHost.getText());
            Chooser.setStatus("Success Connection to " + txtBD.getText()
                                    + " in " + txtHost.getText());
        } catch(SQLException e1){
            Chooser.status.setText("SQLException: " + e1);
        } catch(ClassNotFoundException e){
            Chooser.status.setText("SQLException: " + e);
        }
    }//GEN-LAST:event_btnConectarActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectionWizard().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnConectar;
    private javax.swing.JComboBox cbxDriver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBD;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JLabel lblStatusBar;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JSpinner spnPuerto;
    private javax.swing.JTextField txtBD;
    private javax.swing.JTextField txtHost;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
}
