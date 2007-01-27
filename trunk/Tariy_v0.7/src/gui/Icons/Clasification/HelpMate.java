/*
 * frmCredits.java
 *
 * Created on 12 de octubre de 2006, 20:58
 */

package gui.Icons.Clasification;

/**
 *
 * @author  and
 */
public class HelpMate extends javax.swing.JFrame {
    
    /** Creates new form frmCredits */
    public HelpMate() {
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
        jTextArea9.setText("Mate es un algoritmo de Clasificaci\u00f3n\nLa Clasificaci\u00f3n de datos es un proceso de dos pasos:\nEn el primero, se construye un modelo con basa en un c\nonjunto de datos  denominado conjunto de entrenamiento.\nEn el conjunto de entrenamiento, cada tupla se asume que \npertenece a una clase predefinida, determinada por un \natributo clase.\nPor esto, la clasificaci\u00f3n es un aprendizaje supervizado\nEl resto de atributos se denominan atributos condici\u00f3n.\nEn el segundo, el modelo inicialmente se prueba con otro \nconjunto de datos denominado conjunto de prueba\n\nMate  El operador Mate genera, por cada una de las tuplas de \nuna relaci\u00f3n, todas los posibles combinaciones formadas por \nlos valores no nulos de los atributos pertenecientes a una lista \nde atributos denominados Atributos Condici\u00f3n, y el valor no \nnulo del atributo denominado Atributo Clase.\n\nMate toma como entrada cada tupla de R y produce una nueva \nrelaci\u00f3n cuyo esquema esta formado por los atributos condici\u00f3n, \nlista atributos condici\u00f3n y el atributo clase, atributo clase con \ntuplas formadas por todas las posibles combinaciones de cada \nuno de los atributos condici\u00f3n con el atributo clase, los dem\u00e1s \nvalores de los atributos se hacen nulos.\n\nMate empareja en cada partici\u00f3n todos los atributos condici\u00f3n \ncon el atributo clase, lo que facilita el conteo y el posterior c\u00e1lculo de \nlas medidas de entrop\u00eda y la ganancia de informaci\u00f3n. \nEl operador Mate genera estas combinaciones, en una sola pasada \nsobre la tabla de entrenamiento (lo que redunda en la e\ufb01ciencia \ndel proceso de construcci\u00f3n del \u00e1rbol de decisi\u00f3n).\n\nLa exactitud del modelo se calcula de acuerdo al porcentaje de\nejemplos de prueba que son correctamente clasificados.\n\nla conexion con otros componentes drag and drop, es similar \nen todos los algoritmos, y se realiza como se muestra a continuacion. ");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tariy11")));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/interrogacion.jpg")));
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/conectClasification")));
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jTextArea10.setText("Al liberar el icono del arera A en el area de trabajo B. es posible conectar los iconos\npor medio de un hilo.\n\nAl hacer click derecho sobre el icono aparece un menu emergente, \nel cual consta de las siguientes opciones:\n\nLa opci\u00f2n Delete, borra el algoritmo del area de trabajo. \n\nLa opcion Configure, adapta los parametros del algoritmo a las necesidades \ndel analista\n\nLa opcion Run ejecuta la aplicacin del algoritmo.\n\n\nLa configuracion del algoritmo es similar en todos los algoritmos de \nClasificacion, se realiza de la siguiente manera:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/runApriori")));
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jTextArea11.setText("Al ejecutar el algoritmo, su icono cambiara por una animaci\u00f3n, \nas\u00ed como se muestra en B, lo cual indica que el proceso esta \nen ejecucion.\n\nEl tiempo de ejecucion, es proporcional al tam\u00f1o de la base de \ndatos y al numero y tipo de  procesos que dicho algoritmo involucre.\n");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel19.setText("Algorithm Mate");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help/ConfClasification.png")));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jTextArea12.setText("Al acceder a la opcion de configuracion, sobre el \u00e1rea de trabajo \naparece un menu contextual, el cual se divide en dos partes:\nuna para parametros de Pruning o poda y otra para Training Set\no conjunto de entrenamiento.\n\nEn pruning en analista tiene la posibilidad de configurar un minimo \nde registros por nodo y tambien debera suministrar un umbral que \npermitira detener la poda de un nodo determinado.\n\nEl analista debera tambien brindar el tam\u00f1o del conjunto de \nentrenamiento.\n\nTodos los parametros estan en terminos de porcentaje.\ndel algoritmo.\n\n\nLa ejecucion de todos los algoritmos es similar, \naccediendo a la opcion Run del menu contextual.");

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
                            .add(jTextArea9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel17)))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(44, 44, 44)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel18)
                            .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel21))))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .add(25, 25, 25)
                .add(jLabel17)
                .add(16, 16, 16)
                .add(jTextArea10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jLabel21)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextArea12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(jLabel18)
                .add(30, 30, 30)
                .add(jTextArea11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
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
                new HelpMate().setVisible(true);
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea9;
    // End of variables declaration//GEN-END:variables
    
}