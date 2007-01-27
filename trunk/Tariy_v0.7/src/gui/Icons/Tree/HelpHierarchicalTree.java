/*
 * frmCredits.java
 *
 * Created on 12 de octubre de 2006, 20:58
 */

package gui.Icons.Tree;

/**
 *
 * @author  and
 */
public class HelpHierarchicalTree extends javax.swing.JFrame {
    
    /** Creates new form frmCredits */
    public HelpHierarchicalTree() {
        initComponents();
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
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit2.png")));
        jButton1.setMnemonic('c');
        jButton1.setText("Close Help...");
        jButton1.setToolTipText("Return Aplication");
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
        jTextArea9.setText("Este tipo de visor, permite generar un arbol jerarquico de desicion\napartir de un proceso minero de Clasificacion. \nEs muy util para visualizar el arbol por secciones.\n\nla conexion con otros componentes drag and drop, es similar \nen todos los visores, y se realiza como se muestra a continuacion. ");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tariy11")));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/interrogacion.jpg")));
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/mnuHierarchical.png")));
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jTextArea10.setText("Al liberar el icono en el area de trabajo. es posible conectar los iconos\npor medio de un hilo.\n\nAl hacer click derecho sobre el icono aparece un menu emergente, \nel cual consta de las siguientes opciones:\n\nLa opci\u00f2n Delete, borra el visor del area de trabajo. \n\nLa opcion Run ejecuta la aplicacin del visor.\n\nLa opcion View despliega la ventana que permite visualizar tanto \nel \u00e1rbol como  las reglas generadas. Sus detalles se explican \na continuaci\u00f3n.\n\n\nVisualizacion del arbol jerarquico colapsado:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/rulesView.png")));
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jTextArea11.setText("Las reglas generadas a partir del \u00e1rbol son mostradas.\nEsta lista puede ser ordenada de acuerdo a la columna. \nLa lista se ordena de mayor a menor o viceversa teniendo \ncomo criterio dicha columna.\n.\n");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel19.setText("Hierarchical Tree");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/HierarchicalExpandido.png")));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jTextArea12.setText("El anterior es el \u00e1rbol jer\u00e1rquico. Los campos de esta ventana son:\n\nA \u00e1rea del \u00e1rbol. \n\nB botones para expandir o colapsar el \u00e1rbol.\n\nC pesta\u00f1a para visualizar las reglas generadas a partir del \u00e1rbol.\n\nD porcentaje de error del \u00e1rbol.\n\n\n\nVisualizacion de las reglas a partir de dicho arbol.");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/HierarchicalColapsed.png")));
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                            .add(jTextArea10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel17)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jTextArea9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel20)
                            .add(jLabel21)
                            .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel18)
                            .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
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
                .add(20, 20, 20)
                .add(jLabel17)
                .add(21, 21, 21)
                .add(jTextArea10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(jLabel20)
                .add(14, 14, 14)
                .add(jLabel21)
                .add(17, 17, 17)
                .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel18)
                .add(21, 21, 21)
                .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jScrollPane2.setViewportView(jPanel3);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(118, 118, 118)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 363, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-627)/2, (screenSize.height-538)/2, 627, 538);
    }// </editor-fold>//GEN-END:initComponents

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
                new HelpHierarchicalTree().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea9;
    // End of variables declaration//GEN-END:variables
    
}
