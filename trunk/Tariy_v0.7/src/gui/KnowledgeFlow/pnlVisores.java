/*
 * pnlPreprocesamiento.java
 *
 * Created on 24 de abril de 2006, 06:02 PM
 */

package gui.KnowledgeFlow;

import java.awt.Component;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
/**
 *
 * @author  and
 */
public class pnlVisores extends javax.swing.JPanel implements DragSourceListener, DragGestureListener {
    private DragSource dragSource;
    private Contenedor container;
    
    /** Creates new form pnlPreprocesamiento */
    public pnlVisores(Contenedor container) {
        this.container = container;
        initComponents();
        // Step 1: Create a DragSource instance
        dragSource = new DragSource();
        // Step 2 and 3: Ask the DragSource to watch this JList
        //(first this) and to
        // notify this class when a drag gesture is recognized (second this)
        dragSource.createDefaultDragGestureRecognizer( this,
                DnDConstants.ACTION_COPY, this);
        
    }
    
    public String getToolTipText(MouseEvent event){
        Component press = findComponentAt(event.getPoint());
        if(press instanceof JLabel){
            JLabel iconPress = (JLabel)press;
            String name = iconPress.getText();
            String tooltip = "<strong>" + name + "</strong><br>";
            if(name.trim().equals("Generator")){
                tooltip += "Association rules generator.";
            } else if(name.trim().equals("Hierarchical Tree")){
                tooltip += "Dinamic decision tree.";
            } else if(name.trim().equals("Weka Tree")){
                tooltip += "Most dinamic decision tree.";
            } else if(name.trim().equals("Text Tree")){
                tooltip += "Decision tree in text format";
            } else if(name.trim().equals("Prediction")){
                tooltip += "To predict new records.";
            }
            return this.setIconInfo(tooltip);
        } else {
            return null;
        }
    }
    
    private String setIconInfo(String str){
        str = str.replaceAll("\n", "<p>");
        str = "<html>".concat(str).concat("</html>");
        return str;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("por ver");
        setName("otro");
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Visores/Arbol")));
        jLabel11.setText("Hierarchical Tree");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setName("Hierarchical_Tree");
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Visores/Generador")));
        jLabel12.setText("Generator");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setName("Generador");
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Visores/Prediction")));
        jLabel13.setText("Prediction");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setName("Prediction");
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Visores/tree.png")));
        jLabel14.setText(" Weka Tree ");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setName("Weka_Tree");
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Visores/tree2.png")));
        jLabel15.setText("Text Tree");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setName("Text_Tree");
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .add(jLabel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .add(jLabel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel12)
                .add(14, 14, 14)
                .add(jLabel11)
                .add(16, 16, 16)
                .add(jLabel14)
                .add(22, 22, 22)
                .add(jLabel15)
                .add(14, 14, 14)
                .add(jLabel13)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Step 6: Listen to all notifications when our object is dragged
    // over a drop target
    public void dragEnter(DragSourceDragEvent dsde) {
        System.out.println( "DS: dragEnter" );
    }
    public void dragOver(DragSourceDragEvent dsde) {
        System.out.println( "DS: dragOver" );
    }
    public void dropActionChanged(DragSourceDragEvent dsde) {
        System.out.println( "DS: dropActionChanged" );
    }
    public void dragExit(DragSourceEvent dse) {
        System.out.println( "DS: dragExit" );
    }
    
    // Step 7: Handle the drop
    public void dragDropEnd(DragSourceDropEvent dsde) {
        System.out.println( "DS: dragDropEnd" );
        if( dsde.getDropSuccess() ) {
            System.out.println( "Object successfully dropped" );
        } else {
            System.out.println( "Object not successfully dropped" );
        }
    }
    
    public void dragGestureRecognized(DragGestureEvent dge) {
        Component press = findComponentAt(dge.getDragOrigin());
        
        //Object selected = getSelectedValue();
        if( press instanceof  JLabel ) {
            JLabel icon = (JLabel)press;
            // Step 4: StringSelection implements Transferable
            // Build a StringSelection object that the Drag Source
            // can use to transport a string to the Drop Target
            StringSelection text = new StringSelection(
                    icon.getText());
            JLabel pressed = new JLabel(icon.getText(), icon.getIcon(), JLabel.CENTER);
            pressed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pressed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            pressed.setName(icon.getName());
            pressed.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            
            //Transferable dataIcon = new ImageSelection(icon);
            container.setDragged(pressed);
            // Step 5: As the DragSource to start the drag of our text
            dragSource.startDrag( dge, DragSource.DefaultMoveDrop,
                    text, this );
        } else {
            System.out.println( "nothing was selected");
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    // End of variables declaration//GEN-END:variables
    
}
