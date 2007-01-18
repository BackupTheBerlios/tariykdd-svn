/*
 * Contenedor.java
 *
 * Created on 26 de abril de 2006, 06:09 AM
 */

package gui.KnowledgeFlow;

import gui.Icons.Association.AssociationIcon;
import gui.Icons.Clasification.ClasificationIcon;
import gui.Icons.DBConnection.DBConnectionIcon;
import gui.Icons.File.FileIcon;
import gui.Icons.Filters.FilterIcon;
import gui.Icons.Prediction.PredictionIcon;
import gui.Icons.Rules.RulesIcon;
import gui.Icons.Tree.HierarchicalTreeIcon;
import gui.Icons.Tree.WekaTreeIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author  and
 */
public class Contenedor extends JPanel {
    JPanel selector;
    MyCanvas canvas;
    Component presionado;
    /** Creates new form Contenedor */
    public Contenedor(JPanel s, MyCanvas c) {
        initComponents();
        selector = s;
        canvas = c;
        scrollPanel.setViewportView(canvas);
        contenedor.setLeftComponent(selector);
        contenedor.setRightComponent(scrollPanel);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        contenedor = new javax.swing.JSplitPane();
        scrollPanel = new javax.swing.JScrollPane();

        contenedor.setOneTouchExpandable(true);
        contenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contenedorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                contenedorMouseReleased(evt);
            }
        });

        contenedor.setRightComponent(scrollPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contenedor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contenedor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public JSplitPane getContenedor(){
        return contenedor;
    }
    
    public void cambiarPanel(JPanel p){
        contenedor.setLeftComponent(p);
    }
    
    private void contenedorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenedorMouseReleased
// TODO add your handling code here:
        System.out.println("Mouse Liberado");
        Point p = evt.getPoint();
        p.x -= (contenedor.getDividerLocation() + contenedor.getDividerSize());
        if(p.x < 0) p.x = 0;
        if(p.y < 0) p.y = 0;
        p.x += scrollPanel.getViewport().getViewPosition().x;
        p.y += scrollPanel.getViewport().getViewPosition().y;
        if(!presionado.getName().equals("otro")){
            String nameIcon = presionado.getName();
            Icon icon = null;
            if(nameIcon.equals("Conexion BD")){
                icon = new DBConnectionIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("EquipAsso")){
                icon = new AssociationIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("FPGrowth")){
                icon = new AssociationIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("Apriori")){
                icon = new AssociationIcon((JLabel)presionado, p.x, p.y);
            } else if (nameIcon.equals("plaintext")) {
                icon = new FileIcon((JLabel) presionado, p.x, p.y);
            } else if(nameIcon.equals("Generador")){
                icon = new RulesIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("updatem")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("codification")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("removem")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("muestra")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("remvalor")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("rangenum")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("discretize")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("reduction")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("selection")){
                icon = new FilterIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("c45")){
                icon = new ClasificationIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("mate")){
                icon = new ClasificationIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("Hierarchical_Tree")){
                icon = new HierarchicalTreeIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("Weka_tree")){
                icon = new WekaTreeIcon((JLabel)presionado, p.x, p.y);
            } else if(nameIcon.equals("Prediction")){
                icon = new PredictionIcon((JLabel)presionado, p.x, p.y);
            } else {
                icon = new Icon((JLabel)presionado, p.x, p.y);
            }
            if(p.x + icon.getPreferredSize().width > canvas.getWidth()){
                canvas.setPreferredSize(new Dimension(p.x + icon.getPreferredSize().width,
                        canvas.getHeight()));
                scrollPanel.setViewportView(canvas);
            }
            if(p.y + icon.getPreferredSize().height > canvas.getHeight()){
                canvas.setPreferredSize(new Dimension(canvas.getWidth(),
                        p.y + icon.getPreferredSize().height));
                scrollPanel.setViewportView(canvas);
            }
            canvas.addIcono(icon);
            icon.setBackground(new Color(0, 0, 0, 0)); //transparencia en el icono.
        }
        repaint();
    }//GEN-LAST:event_contenedorMouseReleased
    
    private void contenedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenedorMousePressed
// TODO add your handling code here:
        presionado = contenedor.findComponentAt(evt.getPoint());
        System.out.println(presionado.getName());
    }//GEN-LAST:event_contenedorMousePressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane contenedor;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
    
}
