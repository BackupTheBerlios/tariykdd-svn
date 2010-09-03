/*
 * MyCanvasTable.java
 *
 * Created on 30 de abril de 2006, 03:42 PM
 */
package gui.Icons.DBConnection;

import gui.KnowledgeFlow.Chooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author  and
 */



public class MyCanvasTable extends JPanel {
    /** Creates new form MyCanvasTable */
    int x, y;
    int deltax = 5;
    Table tableSelected;
    Vector select;
    Image offscreen;
    Dimension offscreensize;
    Graphics offgraphics;
    ArrayList edges;
    int cx, cy, fx, fy;
    Conector2 conectorFixed = null;
    boolean campofixed = false;
    Vector Ys = new Vector(1,1);
    boolean stress = false;
    final Color colorConector = new Color(29,113,255);
    final Color colorSeleccionado = new Color(210, 116, 226);
    public SelectorTable mySelectorTable;
    
    public int ntables;
    
    public int nrelations;
    final Color colorTag = new Color(210, 27, 226);
    final Color colorBg = new Color(238, 238, 238);
    
    public MyCanvasTable(SelectorTable st) {
        initComponents();
        select = new Vector(5,1);
        edges = new ArrayList();
        setName("CanvasTable");
        tableSelected = null;
        mySelectorTable = st;
    }
    /** Añade una tabla en el Attribute Selector */
    public void addTable(Table table){
        this.add(table);
        table.setBounds(table.getLocation().x, table.getLocation().y, table.getPreferredSize().width,
                table.getPreferredSize().height);
        int n = getComponents().length;
        int x = 15 + (n - 1) * table.getPreferredSize().width;
        int y = 15 + (n - 1) * 24;
        table.setLocation(x, y);
        if(x + table.getPreferredSize().width > this.getWidth()){
            this.setPreferredSize(new Dimension(x + table.getPreferredSize().width,
                    this.getHeight()));
            mySelectorTable.getScrollTable().setViewportView(this);
        }
        if(y + table.getPreferredSize().height > this.getHeight()){
            this.setPreferredSize(new Dimension(this.getWidth(),
                    y + table.getPreferredSize().height));
            mySelectorTable.getScrollTable().setViewportView(this);
        }
        validate();
        repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);

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
        if(press.getName().equals("Table")){
            tableSelected = (Table)press.getParent();
            if(evt.getButton() == evt.BUTTON2 || evt.getButton() == evt.BUTTON3){
                //Chooser.status.setText(t.getPopupMenu());
                tableSelected.getPopupMenu().show(evt.getComponent(),
                        evt.getX(), evt.getY());
            }
        } else if(press.getName().equals("Campo")){
            Campo campo = (Campo)press;
            if(evt.getButton() == evt.BUTTON1){
                if(campo.seleccionado){
                    campo.seleccionado = false;
                    campo.setIcon(null);
                    select.removeElement(new String( ((Table)campo.getParent().getParent()).getName()
                    + "." + campo.getText()));
                    
                } else {
                    campo.seleccionado = true;
                    campo.setIcon(campo.imageSelectorON);
                    select.addElement(new String( ((Table)campo.getParent().getParent()).getName()
                    + "." + campo.getText()));
                }
                Chooser.status.setText(selectToString());
                mySelectorTable.setQuery(selectToString());
            }
        } else if(press.getName().equals("Conector")){
            Conector2 conectorPress = (Conector2)press;
            if(conectorPress.selected){
                this.removeConector(conectorPress);
            }
        }
    }//GEN-LAST:event_formMouseClicked
    
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
// TODO add your handling code here:
        if( (0 > evt.getX() || evt.getX() > this.getWidth()) ||
                (0 > evt.getY() || evt.getY() > this.getHeight()) ){
            if(conectorFixed != null && conectorFixed.conections == 0){
                conectorFixed.selected = false;
            }
            repaint();
            return;
        }
        Component presionado = this.findComponentAt(evt.getPoint());
        if(presionado.getName().equals("Conector") && conectorFixed != null){
            Conector2 conectorFix = (Conector2)presionado;
            if(!conectorFix.getTable().equals(conectorFixed.getTable())){
                Edge newEdge = new Edge(conectorFixed, conectorFix, false);
                if(!edges.contains(newEdge)){
                    conectorFix.selected = true;
                    edges.add(newEdge);
                    Chooser.status.setText(selectToString());
                    mySelectorTable.setQuery(selectToString());
                }
            } else {
                conectorFixed.selected = false;
            }
        } else {
            if(conectorFixed != null && conectorFixed.conections == 0){
                conectorFixed.selected = false;
            }
        }
        tableSelected = null;
        conectorFixed = null;
        repaint();
    }//GEN-LAST:event_formMouseReleased
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
// TODO add your handling code here:
        Component presionado = this.findComponentAt(evt.getPoint());
        if(presionado.getName().equals("Table")){
            tableSelected = (Table)presionado.getParent();
        } else if(presionado.getName().equals("Conector")){
            conectorFixed = (Conector2)presionado;
            if(conectorFixed.selected){
                if(conectorFixed.conections >= 1){// Mas de una conexion asociada
                    this.moveConector(conectorFixed);
                } else {
                    conectorFixed = null;
                }
            } else {
                conectorFixed.selected = true;
                fx = cx = conectorFixed.get_X();
                fy = cy = conectorFixed.get_Y();
            }
        }
    }//GEN-LAST:event_formMousePressed
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
// TODO add your handling code here:
        if(tableSelected != null){
            int delay = 3;
            x = evt.getX();
            y = evt.getY();
            if(x < tableSelected.getWidth()/2 + tableSelected.n * deltax + delay)
                x = tableSelected.getWidth()/2 + tableSelected.n * deltax + delay;
            if(x > this.getWidth() - tableSelected.getWidth()/2 - delay)
                x = this.getWidth() - tableSelected.getWidth()/2 - delay;
            if(y < tableSelected.jLabel1.getHeight()/2 + delay)
                y = tableSelected.jLabel1.getHeight()/2 + delay;
            if(y > this.getHeight() - tableSelected.getHeight() - delay)
                y = this.getHeight() - tableSelected.getHeight() - delay;
            tableSelected.setLocation(x - tableSelected.getWidth()/2,
                    y - tableSelected.jLabel1.getHeight()/2);
        } else if(conectorFixed != null){
            fx = evt.getX();
            fy = evt.getY();
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged
    
    public synchronized void update(Graphics g){
        paint(g);
    }
    
    public synchronized void paint(Graphics g) {
        Dimension d = getSize();
        if ((offscreen == null) || (d.width != offscreensize.width) || (d.height != offscreensize.height)) {
            offscreen = createImage(d.width, d.height);
            offscreensize = d;
            if (offgraphics != null) {
                offgraphics.dispose();
            }
            offgraphics = offscreen.getGraphics();
        }
        offgraphics.setColor(colorBg);
        offgraphics.fillRect(0, 0, d.width, d.height);
        Ys.clear();
        int nedges = edges.size();
        for (int i = 0 ; i < nedges ; i++) {
            Edge e = (Edge)edges.get(i);
            int x1 = e.from.get_X();
            int y1 = e.from.get_Y();
            int x2 = e.to.get_X();
            int y2 = e.to.get_Y();
            offgraphics.setColor(colorSeleccionado) ;
            this.conectarNodos(offgraphics, x1, y1, x2, y2,
                    stress ? e.from.getCampo() + " = " + e.to.getCampo() : "", i);
        }
        paintChildren(offgraphics);
        if(conectorFixed != null && 0 < fx && fx < this.getWidth()
        && 0 < fy && fy < this.getHeight()){
            offgraphics.setColor(colorConector);
            offgraphics.drawLine(cx, cy, fx, fy);
        }
        g.drawImage(offscreen, 0, 0, null);
        paintBorder(g);
    }
    
    private void conectarNodos(Graphics g, int x1, int y1, int x2, int y2, String etiqueta, int i){
        int[] ax = new int[10];
        int nax = 0;
        int[] ay = new int[10];
        int nay = 0;
        int delta = 20;
        int d = 5;
        int aux_x2;
        
        if(x1 > x2){
            int aux;
            aux = x1;
            x1 = x2;
            x2 = aux;
            aux = y1;
            y1 = y2;
            y2 = aux;
        }
        aux_x2 = x2;
        ax[nax++] = x1;
        ay[nay++] = y1;
        x1 -= delta + i * d;
        ax[nax++] = x1;
        ay[nay++] = y1;
        boolean fup, fdown;
        for(int yup = y1, ydown = y1; ydown < this.getHeight() || yup > 5; yup += 24, ydown -=24){
            if( (fup = this.linea_de_VisionX(x1, yup, x2 - delta) && !Ys.contains(yup)) ||
                    (fdown = this.linea_de_VisionX(x1, ydown, x2 - delta) && !Ys.contains(ydown)) ){
                int y = fup ? yup : ydown;
                ax[nax++] = x1;
                Ys.add(y);
                ay[nay++] = y;
                if(stress){
                    g.setColor(colorTag);
                    g.drawString(etiqueta, x1 + (x2-x1-delta)/2, y + 11);
                    g.setColor(colorSeleccionado);
                }
                ax[nax++] = x2 - (delta + i * d);
                ay[nay++] = y;
                break;
            }
        }
        ax[nax++] = x2 - (delta + i * d);
        ay[nay++] = y2;
        ax[nax++] = x2;
        ay[nay++] = y2;
        g.drawPolyline(ax, ay, nax);
    }
    
    private boolean linea_de_VisionX(int x1, int y, int x2){
        try{
            for(int i = x1; i <= x2; i += 5){
                if(!this.getComponentAt(i,y).getName().equals("CanvasTable")){
                    return false;
                }
            }
            return true;
        } catch(NullPointerException npe){
            return false;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    
    private void moveConector(Conector2 conector) {
        Iterator it = edges.iterator();
        while(it.hasNext()){
            Edge e = (Edge)it.next();
            if(e.isDefault()){
                fx = cx = conectorFixed.get_X();
                fy = cy = conectorFixed.get_Y();
                continue;
            }
            if(e.from.equals(conector)){
                if(e.from.conections == 1){
                    e.from.selected = false;
                }
                cx = e.to.get_X();
                cy = e.to.get_Y();
                fx = e.from.get_X();
                fy = e.from.get_Y();
                conectorFixed = (Conector2)this.findComponentAt(cx, cy);
                e.from.decreaseConection();
                e.to.decreaseConection();
                it.remove();
                Chooser.setStatus(selectToString());
                mySelectorTable.setQuery(selectToString());
                break;
            }
            if(e.to.equals(conector)){
                if(e.to.conections == 1){
                    e.to.selected = false;
                }
                cx = e.from.get_X();
                cy = e.from.get_Y();
                fx = e.to.get_X();
                fy = e.to.get_Y();
                conectorFixed = (Conector2)this.findComponentAt(cx, cy);
                e.from.decreaseConection();
                e.to.decreaseConection();
                it.remove();
                Chooser.setStatus(selectToString());
                mySelectorTable.setQuery(selectToString());
                break;
            }
        }
    }
    
    private void removeConector(Conector2 conector) {
        Iterator it = edges.iterator();
        while(it.hasNext()){
            Edge e = (Edge)it.next();
            if(e.isDefault()){
                continue;
            }
            if( e.from.equals(conector) ||
                    e.to.equals(conector) ){
                if(e.from.conections == 1){
                    e.from.selected = false;
                }
                e.from.decreaseConection();
                if(e.to.conections == 1){
                    e.to.selected = false;
                }
                e.to.decreaseConection();
                it.remove();
                Chooser.setStatus(selectToString());
                mySelectorTable.setQuery(selectToString());
                break;
            }
        }
    }
    
    public Vector getSelect() {
        return select;
    }
    
    public void setSelect(Vector select) {
        this.select = select;
    }
    
    public String selectToString(){
        int length = select.size();
        if(length == 0){
            mySelectorTable.getBtnAccept().setEnabled(false);
            return "No Select Found...";
        }
        StringTokenizer st;
        StringBuffer str = new StringBuffer();
        String columns;
        String tables = "";
        String relation = "";
        StringBuffer relations = new StringBuffer();
        String aux;
        ntables = 0;
        for(int i = 0; i < length; i++){
            columns = (String)select.elementAt(i);
            if(i < length - 1){
                str.append(columns + ", ");
            } else {
                str.append(columns);
            }
            st = new StringTokenizer(columns, ".");
            aux = st.nextToken();
            if(!tables.contains(aux)){
                tables += aux + ", ";
                ntables++;
            }
        }
        length = edges.size();
        Edge edge;
        nrelations = 0;
        for(int i = 0; i < length; i++){
            edge = (Edge)edges.get(i);
            if(tables.contains(edge.from.getTableName()) &&
                    tables.contains(edge.to.getTableName()) ){
                relation = edge.getRelation();
                relations.append(relation + " AND ");
                nrelations++;
            }
        }
        
        String orderby = "";
        if(select.size() > 1){
            if(mySelectorTable.isMarketBasket){
                orderby = "\nORDER BY " + (String) select.firstElement() + "," +
                        (String) select.elementAt(1);
            } else {
                //orderby = "\nORDER BY " + (String) select.lastElement();
                orderby = "";
            }
        }
        mySelectorTable.getBtnAccept().setEnabled(false);
        return "SELECT " +
                (mySelectorTable.isMarketBasket ? "DISTINCT " : "")
                + str.toString() + " \nFROM "
                + tables.substring(0, tables.length() - 2)
                + (relations.length() == 0 ? "": " \nWHERE "
                + relations.toString().substring(0, relations.length() - 4))
                + orderby;
    }
}
