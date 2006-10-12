/*
 * VerResElimMiss.java
 *
 * Created on 19 de mayo de 2006, 08:19 PM
 */

package gui.Icons.Filters.Reduction;

import gui.Icons.Filters.TipodVariables;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author  Tariy
 */
public class VerReduccion extends javax.swing.JFrame {
    AbstractTableModel datosEntrada;
    AbstractTableModel tipoVariables;
    AbstractTableModel datosFiltros;
    
    /** Creates new form VerResElimMiss */
    public VerReduccion(AbstractTableModel dataIn, AbstractTableModel dataOut) {
        datosEntrada = dataIn;
        tipoVariables = new TipodVariables(dataIn);
        datosFiltros = dataOut;
        initComponents();
        LblRegAct.setText(Integer.toString(datosFiltros.getRowCount()));
        LblRegElim.setText(Integer.toString((datosEntrada.getRowCount()-datosFiltros.getRowCount())));
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
        setTitle("Ver Resultado de Muestra");
        setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBackground(new java.awt.Color(81, 81, 133));
        TableTVariables.setModel(tipoVariables);
        jScrollPane3.setViewportView(TableTVariables);

        jTabbedPane1.addTab("Variables", jScrollPane3);

        TableDatosEntrada.setModel(datosEntrada);
        jScrollPane1.setViewportView(TableDatosEntrada);

        jTabbedPane1.addTab("Datos de Entrada", jScrollPane1);

        TableDatosFiltro.setModel(datosFiltros);
        jScrollPane2.setViewportView(TableDatosFiltro);

        jTabbedPane1.addTab("Datos Filtrados", jScrollPane2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registros Actuales : ");

        LblRegAct.setFont(new java.awt.Font("Tahoma", 0, 18));
        LblRegAct.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registros Eliminados : ");

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
                        .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(LblRegElim)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 308, Short.MAX_VALUE)
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
                    .add(jLabel3)
                    .add(LblRegElim)
                    .add(LblRegAct)
                    .add(jLabel1))
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
