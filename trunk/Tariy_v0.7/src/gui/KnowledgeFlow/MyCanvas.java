/*
 * Canvas.java
 *
 * Created on 20 de abril de 2006, 06:41 PM
 */

package gui.KnowledgeFlow;

import Utils.DataSet;
import gui.Icons.Association.AssociationIcon;
import gui.Icons.Clasification.ClasificationIcon;
import gui.Icons.DBConnection.DBConnectionIcon;
import gui.Icons.File.FileIcon;
import gui.Icons.Filters.FilterIcon;
import gui.Icons.Prediction.PredictionIcon;
import gui.Icons.Rules.RulesIcon;
import gui.Icons.Tree.HierarchicalTreeIcon;
import gui.Icons.Tree.TextTreeIcon;
import gui.Icons.Tree.WekaTreeIcon;
import gui.KnowledgeFlow.Conexion;
import gui.KnowledgeFlow.Conexion;
import gui.KnowledgeFlow.Conexion;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author  and
 */


public class MyCanvas extends javax.swing.JPanel {
    Icon seleccionado = null;
    Conector conectorPresionado = null;
    ArrayList conexiones = new ArrayList();  //Arreglo de conectores tipo Conexion()
    int ix, iy, fx, fy;
    
    Image offscreen;
    Dimension offscreensize;
    Graphics offgraphics;
    final Color colorEdge = new Color(124, 136, 135);
    final Color colorLine = new Color(148,167,179);                    //229,192,255
    private Component oldTipToolText;
    private Point oldPoint;
    
    /** Creates new form Canvas */
    public MyCanvas() {
        initComponents();
        this.setToolTipText("");
        oldTipToolText = this;
    }
    
    public void addIcono(Icon icono){
        add(icono);
        icono.setBounds(icono.getLocation().x, icono.getLocation().y,
                icono.getPreferredSize().width,
                icono.getPreferredSize().height);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);

        setName("miCanvas");
        setPreferredSize(new java.awt.Dimension(800, 500));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
// TODO add your handling code here:
        Component press = this.findComponentAt(evt.getPoint());
        System.out.println(press.getName());
        if(press instanceof MyIcon){
            seleccionado = (Icon)press.getParent();
            if(evt.getButton() == evt.BUTTON2 || evt.getButton() == evt.BUTTON3){
                seleccionado.getPupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
            }
            seleccionado = null;
        } else if(press instanceof Conector){
            Conector conectorPress = (Conector)press;
            if(conectorPress.seleccionado){
                this.removeConector(conectorPress);
            }
        }
    }//GEN-LAST:event_formMouseClicked
    
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
// TODO add your handling code here:
        Component presionado = this.findComponentAt(evt.getPoint());
        try{
            if(presionado instanceof Conector && conectorPresionado != null){
                Conector nuevoPresionado = (Conector)presionado;
                if(!conectorPresionado.getParent().equals(nuevoPresionado.getParent())){
                    Icon from = ((Icon)conectorPresionado.getParent());
                    Icon to = ((Icon)nuevoPresionado.getParent());
                    System.out.println(to.getIconType());
                    if(from.constrainsTo.contains(to.getIconType())){
                        to.froms.add(from);
                        from.tos.add(to);
                        if(from instanceof DBConnectionIcon &&
                                to instanceof AssociationIcon){
                            if(((DBConnectionIcon)from).dataset == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((AssociationIcon)to).dataset = ((DBConnectionIcon)from).dataset;
                                ((AssociationIcon)to).getMnuRun().setEnabled(true);
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof FilterIcon &&
                                to instanceof AssociationIcon){
                            if(((FilterIcon)from).dataOut == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((AssociationIcon)to).dataset = ((FilterIcon)from).buildDataSet();
                                ((AssociationIcon)to).getMnuRun().setEnabled(true);
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof AssociationIcon &&
                                to instanceof RulesIcon){
                            if(((AssociationIcon)from).trees == null || ((AssociationIcon)from).dataset == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((RulesIcon)to).trees = ((AssociationIcon)from).trees;
                                ((RulesIcon)to).dataset = ((AssociationIcon)from).dataset;
                                ((RulesIcon)to).support = ((AssociationIcon)from).support;
                                ((RulesIcon)to).title = ((AssociationIcon)from).icono.getText();
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof DBConnectionIcon &&
                                to instanceof ClasificationIcon){
                            if(((DBConnectionIcon)from).connectionTableModel == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((ClasificationIcon)to).dataIn = ((DBConnectionIcon)from).connectionTableModel;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof DBConnectionIcon &&
                                to instanceof FilterIcon){
                            if(((DBConnectionIcon)from).connectionTableModel == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((FilterIcon)to).dataIn = ((DBConnectionIcon)from).connectionTableModel;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof FilterIcon &&
                                to instanceof FilterIcon){
                            if(((FilterIcon)from).dataOut == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((FilterIcon)to).dataIn = ((FilterIcon)from).dataOut;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof FilterIcon &&
                                to instanceof ClasificationIcon){
                            if(((FilterIcon)from).dataOut == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((ClasificationIcon)to).dataIn = ((FilterIcon)from).dataOut;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if (from instanceof FileIcon &&
                                to instanceof AssociationIcon) {
                            if(((FileIcon)from).dataset == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((AssociationIcon)to).dataset = ((FileIcon)from).dataset;
                                ((AssociationIcon)to).getMnuRun().setEnabled(true);
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if (from instanceof FileIcon &&
                                to instanceof FilterIcon) {
                            if(((FileIcon)from).fileTable == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((FilterIcon)to).dataIn = ((FileIcon)from).fileTable;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        }  else if (from instanceof FileIcon &&
                                to instanceof PredictionIcon) {
                            if(((FileIcon)from).fileTable == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((PredictionIcon)to).dataIn = ((FileIcon)from).fileTable;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof ClasificationIcon &&
                                to instanceof HierarchicalTreeIcon){
                            if(((ClasificationIcon)from).root == null ||
                                    ((ClasificationIcon)from).dataOut2 == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((HierarchicalTreeIcon) to).root = ((ClasificationIcon)from).root;
                                ((HierarchicalTreeIcon) to).dataTest = ((ClasificationIcon)from).dataOut2;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof ClasificationIcon &&
                                to instanceof WekaTreeIcon){
                            if(((ClasificationIcon)from).root == null ||
                                    ((ClasificationIcon)from).dataOut2 == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((WekaTreeIcon) to).root = ((ClasificationIcon)from).root;
                                ((WekaTreeIcon) to).dataTest = ((ClasificationIcon)from).dataOut2;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof ClasificationIcon &&
                                to instanceof TextTreeIcon){
                            if(((ClasificationIcon)from).root == null ||
                                    ((ClasificationIcon)from).dataOut2 == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((TextTreeIcon) to).root = ((ClasificationIcon)from).root;
                                ((TextTreeIcon) to).dataTest = ((ClasificationIcon)from).dataOut2;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof ClasificationIcon &&
                                to instanceof PredictionIcon){
                            if(((ClasificationIcon)from).root == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((PredictionIcon)to).root = ((ClasificationIcon)from).root;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        } else if(from instanceof DBConnectionIcon &&
                                to instanceof PredictionIcon){
                            if(((DBConnectionIcon)from).connectionTableModel == null){
                                Chooser.setStatus("There are not loaded data in " + from.getIconType() + "...");
                            } else {
                                ((PredictionIcon)to).dataIn = ((DBConnectionIcon)from).connectionTableModel;
                                nuevoPresionado.seleccionado = true;
                                conexiones.add(new Conexion(conectorPresionado, nuevoPresionado));
                                conectorPresionado = null;
                            }
                        }
                    } else {
                        Chooser.setStatus("Cannot connect a " + from.getIconType() + " to a " + to.getIconType());
                    }
                }
            }
            if(conectorPresionado != null){
                conectorPresionado.seleccionado = false;
                conectorPresionado = null;
            }
            seleccionado = null;
            repaint();
        } catch(NullPointerException npe){
        }
    }//GEN-LAST:event_formMouseReleased
    
    private void setConnection(){
    }
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
// TODO add your handling code here:
        Component press = this.findComponentAt(evt.getPoint());
        if(press instanceof MyIcon || press instanceof JackAnimation || press instanceof AnimationLabel){
            System.out.println(press.getClass().getSimpleName());
            seleccionado = (Icon)(press.getParent());
        } else if(press instanceof Conector){
            System.out.println(press.getClass().getSimpleName() + " - "
                    + press.getParent().getName());
            conectorPresionado = (Conector)press;
            if(conectorPresionado.seleccionado){
                if(conectorPresionado.conections >= 1){// Mas de una conexion asociada
                    this.moveConector(conectorPresionado);
                } else {
                    conectorPresionado = null;
                }
            } else {
                conectorPresionado.seleccionado = true;
                fx = ix = conectorPresionado.get_X();
                fy = iy = conectorPresionado.get_Y();
            }
        }
        repaint();
    }//GEN-LAST:event_formMousePressed
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
// TODO add your handling code here:
        if(seleccionado != null){
            int x = evt.getX();
            int y = evt.getY();
            if(x < seleccionado.getWidth()/2)
                x = seleccionado.getWidth()/2;
            if(x > this.getWidth() - seleccionado.getWidth()/2)
                x = this.getWidth() - seleccionado.getWidth()/2;
            if(y < seleccionado.getHeight()/2)
                y = seleccionado.getHeight()/2;
            if(y > this.getHeight() - seleccionado.getHeight())
                y = this.getHeight() - seleccionado.getHeight();
            
            seleccionado.setLocation(x - seleccionado.getWidth() / 2,
                    y - seleccionado.getHeight() / 2);
        } else if(conectorPresionado != null){
            fx = evt.getX();
            fy = evt.getY();
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged
    
    public synchronized void paint(Graphics g){
        int xd, yd, xh, yh;
        Dimension d = getSize();
        if ((offscreen == null) || (d.width != offscreensize.width) || (d.height != offscreensize.height)) {
            offscreen = createImage(d.width, d.height);
            offscreensize = d;
            if (offgraphics != null) {
                offgraphics.dispose();
            }
            offgraphics = offscreen.getGraphics();
        }
        Iterator it = conexiones.iterator();
        
        super.paint(offgraphics);
        while(it.hasNext()){
            Conexion aux = (Conexion)(it.next());
            xd = aux.de.get_X();
            yd = aux.de.get_Y();
            xh = aux.hacia.get_X();
            yh = aux.hacia.get_Y();
            offgraphics.setColor(colorEdge);
            offgraphics.drawLine(xd, yd, xh, yh);
        }
        if(conectorPresionado != null && 0 < fx && fx < this.getWidth()
        && 0 < fy && fy < this.getHeight()){
            offgraphics.setColor(colorLine);
            offgraphics.drawLine(ix, iy, fx, fy);
        }
        g.drawImage(offscreen, 0, 0, null);
    }
    
    public String getToolTipText(MouseEvent event){
        Component press = findComponentAt(event.getPoint());
        if(press.getParent() instanceof Icon){
            Icon iconPress = (Icon)press.getParent();
            return this.setIconInfo("<strong>" + iconPress.getName() + "</strong><br>" +
                    iconPress.getInfo());
        } else {
            return null;
        }
    }
    
//    public Point getToolTipLocation(MouseEvent event) {
//        Component press = findComponentAt(event.getPoint());
//        Point point;
//        if(press.getParent() instanceof Icon){
//            Icon iconPress = (Icon)press.getParent();
//            this.setIconInfo("<strong>" + iconPress.getName() + "</strong><br>" +
//                    iconPress.getInfo());
//            oldTipToolText = press;
//            point = new Point(press.getParent().getLocation().x +
//                    press.getParent().getWidth(),
//                    press.getParent().getLocation().y);
//            oldPoint = point;
//            return point;
//        } else {
//            return null;
//        }
//
//    }
    
    private String setIconInfo(String str){
        str = str.replaceAll("\n", "<p>");
        str = "<html>".concat(str).concat("</html>");
        return str;
    }
    
    private void moveConector(Conector conector) {
        Iterator it = conexiones.iterator();
        boolean bfrom, bto;
        while(it.hasNext()){
            Conexion e = (Conexion)it.next();
            bfrom = e.de.equals(conector);
            bto = e.hacia.equals(conector);
            if( bfrom || bto ){
                if(bfrom){
                    if(e.de.conections == 1){
                        e.de.seleccionado = false;
                    }
                    ix = e.hacia.get_X();
                    iy = e.hacia.get_Y();
                    fx = e.de.get_X();
                    fy = e.de.get_Y();
                } else {
                    if(e.hacia.conections == 1){
                        e.hacia.seleccionado = false;
                    }
                    ix = e.de.get_X();
                    iy = e.de.get_Y();
                    fx = e.hacia.get_X();
                    fy = e.hacia.get_Y();
                }
                conectorPresionado = (Conector)this.findComponentAt(ix, iy);
                e.de.decreaseConection();
                e.hacia.decreaseConection();
                it.remove();
                break;
            }
        }
    }
    
    private void removeConector(Conector conector) {
        Iterator it = conexiones.iterator();
        while(it.hasNext()){
            Conexion e = (Conexion)it.next();
            if( e.de.equals(conector) ||
                    e.hacia.equals(conector) ){
                if(e.de.conections == 1){
                    e.de.seleccionado = false;
                }
                e.de.decreaseConection();
                if(e.hacia.conections == 1){
                    e.hacia.seleccionado = false;
                }
                e.hacia.decreaseConection();
                it.remove();
                break;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
