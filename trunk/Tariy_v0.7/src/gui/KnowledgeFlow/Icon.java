/*
 * Icon.java
 *
 * Created on 23 de abril de 2006, 05:16 AM
 */

package gui.KnowledgeFlow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author  and
 */

class Conexion implements Serializable{
    Conector de;
    Conector hacia;
    
    public Conexion(Conector de, Conector hacia){
        this.de = de;
        de.increaseConection();
        this.hacia = hacia;
        hacia.increaseConection();
    }
    
    public String toString(){
        return "De: " + de.getIcon().icono.getText() +
                " Hacia: " + hacia.getIcon().icono.getText() ;
    }
}

class Conector extends JComponent {
    boolean seleccionado = false;
    public int conections = 0;
    final int width = 7;
    final int height = 7;
    final Color colorSeleccionado = new Color(232, 232, 232);
    final Color colorNormal = new Color(0, 0, 232);
    final Color colorConector = new Color(126,142,152);
    
    
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
    public int get_X(){
        return this.getParent().getLocation().x + this.getLocation().x
                + width / 2;
    }
    
    public int get_Y(){
        return this.getParent().getLocation().y + this.getLocation().y
                + height / 2;
    }
    
    public synchronized void paint(Graphics g){
        g.setColor(colorConector);
        g.drawRect(0,0,getPreferredSize().width - 1,
                getPreferredSize().height - 1);
        if(seleccionado){
            g.fillRect(2, 2, 3, 3);
        }
    }
    
    public void increaseConection(){
        this.conections++;
    }
    
    public void decreaseConection(){
        this.conections--;
    }
    
    public Icon getIcon(){
        return (Icon)this.getParent();
    }
}

class MyIcon extends JLabel{
    final Color colorIcono = new Color(212, 212, 212);
    
    public MyIcon(JLabel s){
        super(s.getText());
        this.setName(s.getName());
        this.setHorizontalTextPosition(this.CENTER);
        this.setVerticalTextPosition(this.BOTTOM);
        this.setIcon(s.getIcon());
    }
    
    public synchronized void paint(Graphics g){
        super.paint(g);
        g.setColor(colorIcono);
        g.drawRect(0,0,getSize().width - 1,getSize().height - 1);
    }
}

public class Icon extends javax.swing.JPanel {
    Conector[] conectores = new Conector[8];
    int c = 7;
    public MyIcon icono;
    public AnimationLabel animation;
    //public Thread animationThread;
    public ArrayList constrainsTo = null;
    public ArrayList froms = new ArrayList(1);
    public ArrayList tos = new ArrayList(1);
    public String info;
    
    public Icon(JLabel s, int x, int y) {
        initComponents();
        setName(s.getText());
        setLocation(x, y);
        info = new String("[Not run]");
        icono = new MyIcon(s);
        animation = new AnimationLabel();
        animation.setVisible(false);
        //animationThread = null;
        addIcono(icono);
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getInfo() {
        return info;
    }
    
    public void addIcono(MyIcon icono){
        int w = this.getPreferredSize().width;
        int h = this.getPreferredSize().height;
        animation.addAnimation(this, w/2 - 18, c);
        add(icono);
        icono.setBounds(c, c, icono.getPreferredSize().width,
                icono.getPreferredSize().height);
        w -= c;
        h -= c;
        
        conectores[0] = new Conector();
        add(conectores[0]);
        conectores[0].setBounds(0,0, c, c);
        conectores[0].setName("0");
        
        conectores[1] = new Conector();
        add(conectores[1]);
        conectores[1].setBounds(w / 2, 0, c, c);
        conectores[1].setName("1");
        
        conectores[2] = new Conector();
        add(conectores[2]);
        conectores[2].setBounds(w, 0, c, c);
        conectores[1].setName("1");
        
        conectores[3] = new Conector();
        add(conectores[3]);
        conectores[3].setBounds(0, h / 2, c, c);
        conectores[3].setName("3");
        
        conectores[4] = new Conector();
        add(conectores[4]);
        conectores[4].setBounds(w, h / 2, c, c);
        conectores[4].setName("4");
        
        conectores[5] = new Conector();
        add(conectores[5]);
        conectores[5].setBounds(0, h, c, c);
        conectores[5].setName("5");
        
        conectores[6] = new Conector();
        add(conectores[6]);
        conectores[6].setBounds(w / 2, h, c, c);
        conectores[6].setName("6");
        
        conectores[7] = new Conector();
        add(conectores[7]);
        conectores[7].setBounds(w, h, c, c);
        conectores[7].setName("7");
    }
    
    public void setAnimation(AnimationLabel animation) {
        this.animation = animation;
    }
    
    public void startAnimation(){
        animation.run();
    }
    
    public AnimationLabel getAnimation() {
        return animation;
    }
    
    public void stopAnimation(){
        animation.stop();
    }
    
    public Dimension getPreferredSize() {
        int w = c + icono.getPreferredSize().width + c;
        int h = c + icono.getPreferredSize().height + c;
        
        return new Dimension(w, h);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        pupMenu = new javax.swing.JPopupMenu();
        mnuDelete = new javax.swing.JMenuItem();

        pupMenu.setInvoker(this);
        mnuDelete.setText("Delete");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });

        pupMenu.add(mnuDelete);

        setLayout(null);

        setComponentPopupMenu(pupMenu);
    }// </editor-fold>//GEN-END:initComponents
    
    public JPopupMenu getPupMenu() {
        return pupMenu;
    }
    
    public String getIconType(){
        return this.getClass().getSimpleName();
    }
    
    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
// TODO add your handling code here:
        MyCanvas parent = (MyCanvas)this.getParent();
        Iterator it = parent.conexiones.iterator();
        while(it.hasNext()){
            Conexion c = (Conexion)it.next();
            for(int i = 0; i < conectores.length; i++){
                if(conectores[i].equals(c.de)){
                    c.hacia.seleccionado = false;
                    c.hacia.decreaseConection();
                    parent.seleccionado = null;
                    it.remove();
                    break;
                } else if(conectores[i].equals(c.hacia)){
                    c.de.seleccionado = false;
                    c.de.decreaseConection();
                    parent.seleccionado = null;
                    it.remove();
                    break;
                }
            }
        }
        parent.remove(this);
        parent.repaint();
    }//GEN-LAST:event_mnuDeleteActionPerformed
            // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem mnuDelete;
    protected javax.swing.JPopupMenu pupMenu;
    // End of variables declaration//GEN-END:variables
}
