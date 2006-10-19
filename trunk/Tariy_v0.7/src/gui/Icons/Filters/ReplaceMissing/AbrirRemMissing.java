
// falta ponerle un alert y quitarle la x de la ventana ****************

/*
 * AbrirRemMissing.java
 *
 * Created on 20 de mayo de 2006, 06:11 PM
 */

package gui.Icons.Filters.ReplaceMissing;

import gui.Icons.DBConnection.ScrollableTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author  Tariy
 */
public class AbrirRemMissing extends javax.swing.JFrame {
    AbstractTableModel datosEntrada;
    String atributos[];
    Object remcon;
    int colsel;
    /** Creates new form AbrirRemMissing */
    public AbrirRemMissing(AbstractTableModel datosEntrada) {
        this.datosEntrada = datosEntrada;
        atributos = new String[datosEntrada.getColumnCount()+1];
        atributos[0] = "Seleccionar un Atributo";
        for(int i = 0; i < datosEntrada.getColumnCount(); i++) {
            atributos[i+1] = datosEntrada.getColumnName(i);
        }
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        BtnAplicar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtRemCon = new javax.swing.JTextField();
        CmbAtributos = new javax.swing.JComboBox();
        BtnReset = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abrir Remplazar Missing");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        jPanel1.setBackground(new java.awt.Color(81, 81, 133));
        BtnAplicar.setText("Aplicar");
        BtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAplicarActionPerformed(evt);
            }
        });
        BtnAplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAplicarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Remplazar Con :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atributo            :");

        TxtRemCon.setFont(new java.awt.Font("Tahoma", 0, 12));

        CmbAtributos.setFont(new java.awt.Font("Tahoma", 0, 12));
        CmbAtributos.setModel(new javax.swing.DefaultComboBoxModel(atributos));

        BtnReset.setText("Resetear");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });
        BtnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnResetMouseClicked(evt);
            }
        });

        BtnCerrar.setText("Cerrar");
        BtnCerrar.setEnabled(false);
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(BtnAplicar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(13, 13, 13)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(BtnReset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 44, Short.MAX_VALUE)
                        .add(BtnCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, TxtRemCon, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(CmbAtributos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 226, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE, false)
                    .add(jLabel1)
                    .add(CmbAtributos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(TxtRemCon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(31, 31, 31)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BtnCerrar)
                    .add(BtnAplicar)
                    .add(BtnReset))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        CmbAtributos.setModel(new javax.swing.DefaultComboBoxModel(atributos));
        TxtRemCon.setText("");
    }//GEN-LAST:event_BtnResetActionPerformed
    
    private void BtnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnResetMouseClicked
        
    }//GEN-LAST:event_BtnResetMouseClicked
    
    private void BtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAplicarActionPerformed
        String cad,valmen;
        char uc;
        int bdcadint=0, bdcolint=0,x=0;
        //------------------------
        colsel = datosEntrada.findColumn(CmbAtributos.getModel().getSelectedItem().toString());
        if(colsel == -1){
            TxtRemCon.setText("");
            JOptionPane.showMessageDialog(this, "Debe seleccionar algun Atributo",
                    "Error en Abrir Remplazar Missing",JOptionPane.ERROR_MESSAGE);
        } else {
            if(datosEntrada.getColumnClass(colsel).getSimpleName().equals("Integer")) {  //************
                bdcolint = 1;
                
            } else if(datosEntrada.getColumnClass(colsel).getSimpleName().equals("Short")) {  //************
                bdcolint = 1;        //Considerar una para los Short
            } else  bdcolint = 0;
            
            cad = TxtRemCon.getText();
            for(int y = 0; y < cad.length(); y++) {
                uc = cad.charAt(y);
                if(uc>47 && uc<58) x++;
            }
            if(x==cad.length()) bdcadint = 1;
            else bdcadint = 0;
            
            if(bdcadint==bdcolint && bdcadint==1) {
                remcon = Integer.parseInt(TxtRemCon.getText());
                BtnCerrar.setEnabled(true);
            } else if(bdcadint==bdcolint && bdcadint==0) {
                remcon = TxtRemCon.getText();
                BtnCerrar.setEnabled(true);
            } else {
                TxtRemCon.setText("");
                JOptionPane.showMessageDialog(this, "Los tipos de datos son diferentes",
                        "Error en Abrir Remplazar Missing.",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnAplicarActionPerformed
    
    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        //System.exit( 0 );
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed
    
    private void BtnAplicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAplicarMouseClicked
        
    }//GEN-LAST:event_BtnAplicarMouseClicked
    
    public int getColSelec() {
        return colsel;
    }
    
    public Object getValRem() {
        return remcon;
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAplicar;
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnReset;
    private javax.swing.JComboBox CmbAtributos;
    private javax.swing.JTextField TxtRemCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}