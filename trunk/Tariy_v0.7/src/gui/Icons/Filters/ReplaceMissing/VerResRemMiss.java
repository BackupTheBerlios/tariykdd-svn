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
package gui.Icons.Filters.ReplaceMissing;

import gui.Icons.DBConnection.ScrollableTableModel;
import gui.Icons.Filters.TipodVariables;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class VerResRemMiss extends javax.swing.JFrame {
    AbstractTableModel datosEntrada;
    AbstractTableModel tipoVariables;
    /*RemplazarMissing*/AbstractTableModel datosFiltros;
    /** Creates new form VerResElimMiss */
    public VerResRemMiss(AbstractTableModel dataIn, AbstractTableModel dataOut) {
        datosEntrada = dataIn;
        tipoVariables = new TipodVariables(dataIn);
        datosFiltros = ((RemplazarMissing)dataOut).dataOut;
        initComponents();
        LblRegAct.setText(Integer.toString(datosFiltros.getRowCount()));
        LblRegElim.setText(Integer.toString(/*datosFiltros*/((RemplazarMissing)dataOut).getNMissing()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDatosEntrada = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDatosFiltro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LblRegAct = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LblRegElim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Results ");
        setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBackground(new java.awt.Color(81, 81, 133));
        TableTVariables.setModel(tipoVariables);
        jScrollPane3.setViewportView(TableTVariables);

        jTabbedPane1.addTab("Variables", jScrollPane3);

        TableDatosEntrada.setModel(datosEntrada);
        jScrollPane1.setViewportView(TableDatosEntrada);

        jTabbedPane1.addTab("Input Data", jScrollPane1);

        TableDatosFiltro.setModel(datosFiltros);
        jScrollPane2.setViewportView(TableDatosFiltro);

        jTabbedPane1.addTab("Filtered Data", jScrollPane2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Current Records : ");

        LblRegAct.setFont(new java.awt.Font("Tahoma", 0, 18));
        LblRegAct.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Missing Data Remplaced : ");

        LblRegElim.setFont(new java.awt.Font("Tahoma", 0, 18));
        LblRegElim.setForeground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(LblRegElim)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 328, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(LblRegAct)
                        .add(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LblRegElim)
                    .add(LblRegAct)
                    .add(jLabel1)
                    .add(jLabel3))
                .add(28, 28, 28))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VerResRemMiss().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblRegAct;
    private javax.swing.JLabel LblRegElim;
    private javax.swing.JTable TableDatosEntrada;
    private javax.swing.JTable TableDatosFiltro;
    private javax.swing.JTable TableTVariables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    
}
