/*
 * OpenFile.java
 *
 * Created on 8 de junio de 2006, 21:51
 */

package gui.Icons.File;

import Utils.ExampleFileFilter;
import Utils.FileManager;
import javax.swing.AbstractButton;
import javax.swing.table.TableColumn;

/**
 *
 * @author  ivan
 */
public class OpenFile extends javax.swing.JFrame {
    
    private boolean isMarketBasket;
    private String filePath = "";
    private FileIcon myFileIcon;
    private FileTableModel model;
    
    /** Creates new form OpenFile */
    public OpenFile(FileIcon icon) {
        initComponents();
        if (!filePath.equals("")) {
            tblData.setModel(new FileTableModel(filePath));
            lblPreview.setVisible(true);
        }
        radMultivalued.setSelected(true);
        isMarketBasket = false;
        myFileIcon = icon;
        lblPreview.setVisible(false);
        model = null;
    }
    
    public boolean isMarketBasket() {
        return isMarketBasket;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void columnSizes() {
        int columns = model.getColumnCount();
        int csize = 0;
        TableColumn column = null;
        
        for (int i=0; i<columns; i++) {
            column = tblData.getColumnModel().getColumn(i);
            csize = model.getColumnName(i).length();
            column.setPreferredWidth(csize*50);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        openFile = new javax.swing.JFileChooser();
        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        radUnivalued = new javax.swing.JRadioButton();
        radMultivalued = new javax.swing.JRadioButton();
        btnCancel = new javax.swing.JButton();
        lblPreview = new javax.swing.JLabel();

        openFile.setCurrentDirectory(new java.io.File("/home/ivan/tariy/cDatos/arff"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Conexion/file.png")));
        lblFile.setText("Data File");

        txtFile.setEditable(false);

        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        radUnivalued.setText("Market Basket");
        radUnivalued.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radUnivalued.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radUnivalued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radUnivaluedActionPerformed(evt);
            }
        });

        radMultivalued.setText("Multivalued");
        radMultivalued.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radMultivalued.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radMultivalued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMultivaluedActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblPreview.setText("Preview");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(lblFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFile, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnBrowse, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(radUnivalued)
                        .add(16, 16, 16)
                        .add(radMultivalued)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 109, Short.MAX_VALUE)
                        .add(btnAccept)
                        .add(14, 14, 14)
                        .add(btnCancel))
                    .add(lblPreview))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblFile)
                    .add(txtFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBrowse))
                .add(22, 22, 22)
                .add(lblPreview)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(radUnivalued)
                    .add(radMultivalued)
                    .add(btnCancel)
                    .add(btnAccept))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private void radMultivaluedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMultivaluedActionPerformed
        // TODO add your handling code here:
        radMultivalued.setSelected(true);
        radUnivalued.setSelected(false);
        isMarketBasket = false;
    }//GEN-LAST:event_radMultivaluedActionPerformed
    
    private void radUnivaluedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radUnivaluedActionPerformed
        // TODO add your handling code here:
        radUnivalued.setSelected(true);
        radMultivalued.setSelected(false);
        isMarketBasket = true;
    }//GEN-LAST:event_radUnivaluedActionPerformed
    
    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        myFileIcon.filePath = filePath;
        myFileIcon.isMarketBasket = this.isMarketBasket;
        this.dispose();
    }//GEN-LAST:event_btnAcceptActionPerformed
    
    /*
     * showOpenDialog()!!!
     * <ul>
     * <li>JFileChooser.CANCEL_OPTION
     * <li>JFileChooser.APPROVE_OPTION
     * <li>JFileCHooser.ERROR_OPTION if an error occurs or the
     *			dialog is dismissed
     * </ul>
     */
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        ExampleFileFilter filter = new ExampleFileFilter("arff", "Data File");
        openFile.setFileFilter(filter);
        int sel = openFile.showOpenDialog(this);
        if(sel == openFile.APPROVE_OPTION) {
            String file = openFile.getSelectedFile().getAbsolutePath();
            txtFile.setText(file);
            filePath = file;
            model = new FileTableModel(file);
            tblData.setModel(model);
            lblPreview.setVisible(true);
            columnSizes();
        }
    }//GEN-LAST:event_btnBrowseActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenFile().setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JFileChooser openFile;
    private javax.swing.JRadioButton radMultivalued;
    private javax.swing.JRadioButton radUnivalued;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables
    
}