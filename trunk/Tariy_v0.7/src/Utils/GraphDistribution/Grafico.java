/*
 * Grafico.java
 *
 * Created on 6 de marzo de 2005, 06:49 PM
 */

package Utils.GraphDistribution;
import algorithm.classification.c45_1.Attribute;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
/**
 *
 * @author  Flia Calder�n Romero
 */
public class Grafico extends javax.swing.JFrame {
    Arcos sp;
    
    /** Creates new form Grafico */
    public Grafico() {
        initComponents();
        ArrayList values = new ArrayList();
        values.add(60);
        values.add(140);
        values.add(225);
        values.add(22);
        values.add(5);
        sp = new Arcos(values);
        Collections.sort(values);
        run();
    }
    
    public Grafico(Attribute node) {
        initComponents();
        sp = new Arcos(node.getValuesClass());
        sp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, node.name, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10), Color.BLACK));
        scrollGraph.setViewportView(sp);
        run();
        this.setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        scrollGraph = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frm_graficos");
        setResizable(false);
        jScrollPane2.setViewportView(jList1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, scrollGraph, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(scrollGraph, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-240)/2, (screenSize.height-299)/2, 240, 299);
    }// </editor-fold>//GEN-END:initComponents
    
    public void run(){
        
        //getContentPane().add(sp);
        //sp.setBounds(10, 10, 200, 190);
        final ArrayList t = sp.text;
        jList1.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return t.size(); }
            public Object getElementAt(int i) {
                return (String)t.get(i);
            }
        });
        jList1.setCellRenderer(new CompanyLogoListCellRenderer());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafico().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane scrollGraph;
    // End of variables declaration//GEN-END:variables
    class CompanyLogoListCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            Component retValue = super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus
                    );
            setForeground(Arcos.getColor(index));
            return retValue;
        }
    }
}
