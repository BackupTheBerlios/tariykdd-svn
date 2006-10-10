/*
 * showRules.java
 *
 * Created on 27 de mayo de 2006, 06:25 AM
 */

package gui.Icons.Rules;

import Utils.AssocRules;
import Utils.ExampleFileFilter;
import Utils.FileManager;

/**
 *
 * @author  and
 */
public class showRules extends javax.swing.JFrame {
    /** Las reglas de asociación. */
    private AssocRules rules;
    
    /** Tabla analizada. */
    private String table;
    
    /** Soporte minimo del sistema. */
    private String support;
    
    /** Confianza. */
    private String confidence;
    
    /** Creates new form ShowRules */
    public showRules(AssocRules rules, String table, String support, String confidence) {
        this.rules = rules;
        this.table = table;
        this.support = support;
        this.confidence = confidence;
        
        initComponents();
        
        if(rules.getRules().size() != 0) {
            txtRules.setText(rules.toString());
        } else {
            txtRules.setText("No se obtuvieron resultados...");
        }
        
        lblTable.setText(table);
        lblSupport.setText(support + "%");
        lblConfidence.setText(confidence + "%");
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        Save = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        lblTable = new javax.swing.JLabel();
        lblSupport = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblConfidence = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRules = new javax.swing.JTextPane();

        Save.setCurrentDirectory(new java.io.File("/home/ivan/tariy/Reportes"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rules Viewer");
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_text_justify.png")));
        jLabel1.setText("Analized Table:");

        lblTable.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lblTable.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.focus"), 1, true));

        lblSupport.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lblSupport.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.focus"), 1, true));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/text_strike.png")));
        jLabel2.setText("System Support:");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rules.png")));
        jLabel3.setText("Confidence:");

        lblConfidence.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lblConfidence.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.focus"), 1, true));

        btnSave.setIcon(new javax.swing.ImageIcon("/usr/share/icons/crystalsvg/22x22/actions/save_all.png"));
        btnSave.setText("Save Report");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btn_atras.setIcon(new javax.swing.ImageIcon("/usr/share/icons/Bluecurve/20x20/actions/back.png"));
        btn_atras.setText("Back");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        txtRules.setEditable(false);
        txtRules.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 10));
        jScrollPane1.setViewportView(txtRules);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(btn_atras)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 431, Short.MAX_VALUE)
                        .add(btnSave))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblTable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblConfidence, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblSupport, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(lblTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(lblSupport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(lblConfidence, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btn_atras)
                    .add(btnSave))
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-691)/2, (screenSize.height-387)/2, 691, 387);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
// TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
// TODO add your handling code here:
        ExampleFileFilter ext = new ExampleFileFilter(".tux", "Archivo de reglas");
        String path;
        FileManager fm;
        
        Save.addChoosableFileFilter(ext);
        int saveOK = Save.showSaveDialog(this);
        if(saveOK == Save.APPROVE_OPTION) {
            path = Save.getSelectedFile().getAbsolutePath();
            path += ".tux";
            fm = new FileManager(path);
            fm.writeString("ASSOCIATION RULES\n\nMined with: " + table + "\n" +
                    "Support: " + support + "%\n" + "Confidence: " + confidence +
                    "%\n\n" + rules.toString());
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new showRules().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Save;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConfidence;
    private javax.swing.JLabel lblSupport;
    private javax.swing.JLabel lblTable;
    private javax.swing.JTextPane txtRules;
    // End of variables declaration//GEN-END:variables
    
}