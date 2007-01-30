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

package gui.Icons.Filters.Selection;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author  Tariy
 */
public class AbrirSeleccion extends javax.swing.JFrame {
    AbstractTableModel tipoVariables;
    int colsel[];
    int colObj = 0, pc = 0;
    /**
     * Creates new form AbrirSeleccion
     */
    public AbrirSeleccion(AbstractTableModel dataIn) {
        tipoVariables = new TipodVariablesSel(dataIn);
        colsel = new int[tipoVariables.getRowCount()];
        initComponents();
        
        TableColumn column = null;
        column = TableTVariables.getColumnModel().getColumn(0);
        column.setPreferredWidth(150);
        column = TableTVariables.getColumnModel().getColumn(2);
        column.setPreferredWidth(50);
        column = TableTVariables.getColumnModel().getColumn(3);
        column.setPreferredWidth(30);
        
        TableColumn sportColumn = TableTVariables.getColumnModel().getColumn(3);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Atributo");
        comboBox.addItem("Objetivo");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableTVariables = new javax.swing.JTable();
        BtnAplicar = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configure Filter");
        setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBackground(new java.awt.Color(81, 81, 133));
        TableTVariables.setModel(tipoVariables);
        jScrollPane3.setViewportView(TableTVariables);

        jTabbedPane1.addTab("Variables", jScrollPane3);

        BtnAplicar.setText("Play");
        BtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAplicarActionPerformed(evt);
            }
        });

        BtnCerrar.setText("Close");
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
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .add(94, 94, 94)
                .add(BtnAplicar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 199, Short.MAX_VALUE)
                .add(BtnCerrar)
                .add(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BtnAplicar)
                    .add(BtnCerrar))
                .add(24, 24, 24))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        dispose();
        //System.exit( 0 );
    }//GEN-LAST:event_BtnCerrarActionPerformed
    
    private void BtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAplicarActionPerformed
        int cob = 0, bdat = 0, bdob = 0;
        pc = 0;
        //________________________________
        
        for(int f = 0; f < tipoVariables.getRowCount(); f++ ){
            if(tipoVariables.getValueAt(f,2).toString().equals("true")) {
                colsel[pc] = f; // colsel son los atributos seleccionados
                pc++;
            }
        }
        if (pc==0) bdat = 1;
        
        
        for(int f = 0; f < tipoVariables.getRowCount(); f++ ){
            if(tipoVariables.getValueAt(f,3).toString().equals("Objetivo")) {
                colObj = f; // colObj es la columna Objetivo
                cob++;
            }
        }
        if(cob == 0 || cob > 1) bdob = 1;
        
        if(bdat == 1 && bdob == 1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un Atributo y '1' Objetivo",
                    "Error en Abrir Seleccin",JOptionPane.ERROR_MESSAGE);
        } else if(bdat == 1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un Atributo",
                    "Error en Abrir Seleccin.",JOptionPane.ERROR_MESSAGE);
        } else if(bdob == 1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar '1' Objetivo",
                    "Error en Abrir Seleccin.",JOptionPane.ERROR_MESSAGE);
        } else if(bdat ==0 && bdob == 0) {
            BtnCerrar.setEnabled(true);
            for(int i = 0; i < pc; i++ ){
                if(colsel[i] == colObj) {
                    for(int j = i; j < pc-1; j++ ){
                        colsel[j] = colsel[j+1];
                    }
                    colsel[pc-1] = '\0';
                    i = pc;
                    pc = pc-1;
                }
            }
        }
    }//GEN-LAST:event_BtnAplicarActionPerformed
    
    public int[] getColsSel() {
        return colsel;
    }
    
    public int getColObj() {
        return colObj;
    }
    
    public int getNumColsSel() {
        return pc;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAplicar;
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JTable TableTVariables;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    
}
