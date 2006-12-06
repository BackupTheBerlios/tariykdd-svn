/*
 * SelectorTable.java
 *
 * Created on 30 de abril de 2006, 01:19 PM
 */

package gui.Icons.DBConnection;

import Utils.DataSet;
import gui.Icons.Filters.TariyTableModel;
import gui.KnowledgeFlow.Chooser;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

/**
 *
 * @author  and
 */
public class SelectorTable extends javax.swing.JFrame
        implements TableColumnModelListener{
    MyCanvasTable canvas;
    DBConnectionIcon myIcon;
    Connection connection = null;
    ScrollableTableModel tableModel = null;
    DataSet dataset;
    boolean isMarketBasket = false;
    int x = 0;
    
    private String table;
    
    int y = 0;
    /** Creates new form SelectorTable */
    public SelectorTable(DBConnectionIcon icon) {
        myIcon = icon;
        initComponents();
        this.setName("Frame");
        canvas = new MyCanvasTable(this);
        scrollTable.add(canvas);
        this.connection = icon.connection;
        cbxTable.setModel(new DefaultComboBoxModel(this.getTables()));
        //tblPreview.setColumnModel(new myTableColumnModel());
        tblPreview.getColumnModel().addColumnModelListener(this);
        dataset = new DataSet("");
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        seeRelacion = new javax.swing.JRadioButton();
        cbxTable = new javax.swing.JComboBox();
        btnExecute = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPreview = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        marketBasket = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        scrollTable = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtQuery2 = new JEditorPane("text/html", "<html>In case you thought that...</html>");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attribute Selector");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        seeRelacion.setText("View Relations");
        seeRelacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        seeRelacion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        seeRelacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seeRelacionItemStateChanged(evt);
            }
        });

        cbxTable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a Table..." }));
        cbxTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTableActionPerformed(evt);
            }
        });

        btnExecute.setText("Execute...");
        btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteActionPerformed(evt);
            }
        });

        tblPreview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPreview.setDragEnabled(true);
        jScrollPane2.setViewportView(tblPreview);

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        buttonGroup1.add(marketBasket);
        marketBasket.setText("Market Basket");
        marketBasket.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        marketBasket.setMargin(new java.awt.Insets(0, 0, 0, 0));
        marketBasket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                marketBasketItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("MultiValued");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        scrollTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attribute Selector", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Courier", 1, 12), javax.swing.UIManager.getDefaults().getColor("Checkbox.select")));

        txtQuery2.setFont(new java.awt.Font("Courier New", 0, 10));
        jScrollPane3.setViewportView(txtQuery2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(scrollTable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(cbxTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(seeRelacion)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(marketBasket)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton1))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnExecute)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAccept)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbxTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(seeRelacion)
                    .add(marketBasket)
                    .add(jRadioButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrollTable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btnAccept)
                        .add(btnExecute))
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getScrollTable() {
        return scrollTable;
    }

    private void marketBasketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_marketBasketItemStateChanged
// TODO add your handling code here:
        if(evt.getStateChange() == evt.SELECTED){
            isMarketBasket = true;
        } else{
            isMarketBasket = false;
        }
        this.setQuery(canvas.selectToString());
    }//GEN-LAST:event_marketBasketItemStateChanged
    
    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
// TODO add your handling code here:
        int rows = tableModel.getRowCount();
        int columns = tableModel.getColumnCount();
        Object[][] data = new Object[rows][columns];
        String[] columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                data[j][i] = tableModel.getValueAt(j ,i);
            }
            columnsName[i] = tableModel.getColumnName(i);
        }
        myIcon.connectionTableModel = new TariyTableModel(data, columnsName);
        myIcon.info = canvas.selectToString();
        myIcon.getMnuLoad().setEnabled(true);
        Chooser.setStatus("Load SQL: " + canvas.selectToString());
        this.dispose();
    }//GEN-LAST:event_btnAcceptActionPerformed
    
    public DataSet loadMultiValuedDataSet(){
        int ncolumns = tableModel.getColumnCount();
        Statement stm = null;
        ResultSet rs = null;
        ArrayList elementsDictionary = new ArrayList();
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String queryFrom = txtQuery2.getToolTipText();
            String column;
            int posFrom, posOrderBy;
            for(int i = 0; i < ncolumns; i++){
                column = (String)canvas.getSelect().elementAt(i);
                posFrom = queryFrom.indexOf("\nFROM ");
                posOrderBy= queryFrom.indexOf("\nORDER BY ");
                String query = "SELECT distinct " + column + queryFrom.substring(posFrom, posOrderBy) +
                        " ORDER BY " + column;
                rs = stm.executeQuery(query);
                column = column.substring(column.indexOf(".") + 1);
                while(rs.next()){
                    Object obj = rs.getObject(1);
                    if(!rs.wasNull()){
                        elementsDictionary.add(column + "=" + obj.toString());
                    }
                }
            }
            dataset.buildMultiValuedDictionary(elementsDictionary);
            for(int i = 0; i < tableModel.getRowCount(); i++){
                for(int j = 0; j < tableModel.getColumnCount(); j++){
                    if(tableModel.getValueAt(i, j) != null){
                        String item = tableModel.getColumnName(j) + "=" +
                                tableModel.getValueAt(i, j).toString();
                        int id = (j == tableModel.getColumnCount() - 1) ? -1 : j;
                        dataset.buildNTree(dataset.codeAttribute(item), id);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Chooser.status.setText("Exception: " + ex.getSQLState());
        } finally{
            return dataset;
        }
    }
    
    public DataSet loadDataSet(){
        Statement stm;
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String column2 = (String)canvas.getSelect().elementAt(1);
            String queryFrom = txtQuery2.getToolTipText();
            int posFrom = queryFrom.indexOf("\nFROM ");
            int posOrderBy= queryFrom.indexOf("\nORDER BY ");
            String query = "SELECT distinct " + column2 + queryFrom.substring(posFrom, posOrderBy) +
                    " ORDER BY " + column2;
            ResultSet rs = stm.executeQuery(query);
            dataset.buildDictionary(rs);
        } catch (SQLException ex) {
            Chooser.setStatus(ex.getMessage() + " Error in build dictionary");
        }
        boolean inicio, fin;
        int nfilas = tableModel.getRowCount() - 1;
        Integer aux = (Integer)(tableModel.getValueAt(0, 0));
        String item;
        Short itemShort;
        Integer itemInteger;
        int id = 1;
        inicio = true;
        fin = false;
        for(int i = 0; i < nfilas; i++){
            id = 1;
            if(aux.compareTo((Integer)(tableModel.getValueAt(i + 1, 0))) != 0){
                fin = true;
                aux = (Integer)(tableModel.getValueAt(i + 1, 0));
            }
            item = (String)(tableModel.getValueAt(i, 1).toString());
            if(inicio) {
                id = 0;
                inicio = false;
            }
            if(fin) {
                if(id == 0 && fin) id = -2;
                else id = -1;
                fin = false;
                inicio = true;
            }
            dataset.buildNTree(dataset.codeAttribute(item), id);
        }
        if(inicio) {
            id = -2;
            inicio = false;
        } else {
            id = -1;
        }
        item = (String)(tableModel.getValueAt(nfilas, 1).toString());
        dataset.buildNTree(dataset.codeAttribute(item), id);
        System.gc();
        Chooser.status.setText("Free Memory: " + Runtime.getRuntime().freeMemory()
                                            + " bits");
        try {
            dataset.setName(connection.getCatalog());
        } catch (SQLException ex) {
            Chooser.setStatus(ex.getMessage());
        }
        return dataset;
    }
    
    public DataSet getDataset() {
        return dataset;
    }
    
    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
// TODO add your handling code here:
        tableModel = new ScrollableTableModel(connection,
                txtQuery2.getToolTipText());
        tblPreview.setModel(tableModel);
    }//GEN-LAST:event_btnExecuteActionPerformed
    
    private void cbxTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTableActionPerformed
// TODO add your handling code here:
        String table = cbxTable.getSelectedItem().toString();
        ArrayList columns = this.getColumns(table);
        Table t = new Table(table, columns.size());
        Vector primaryKeys = this.getPrimaryKeys(table);
        Vector foreingKeys = this.getForeingKeys(table);
        Iterator it = columns.iterator();
        while(it.hasNext()){
            String name = (String)it.next();
            int key = 0;
            if(primaryKeys.contains(name) && foreingKeys.contains(name)){
                key = 3;
            } else if(foreingKeys.contains(name)){
                key = 2;
            } else if(primaryKeys.contains(name)){
                key = 1;
            }
            t.addColumn(name, key, false);
        }
        canvas.addTable(t);
        Component[] tables = canvas.getComponents();
        int nComponents = canvas.getComponentCount() - 1; //Sin contar la tabla que se acabo de adicionar
        Vector references = new Vector(1, 1);
        String otherTable;
        for(int i = 0; i < nComponents ; i++){
            otherTable = ((Table)tables[i]).getName();
            references = this.getCrossReference(otherTable, table);
            if(references.size() > 0){
                Chooser.status.setText(references.toString());
                Conector2 c1 = ((Table)tables[i]).getConector((String)references.elementAt(0));
                Conector2 c2 = t.getConector((String)references.elementAt(1));
                canvas.edges.add(new Edge(c1, c2));
            }
            references = this.getCrossReference(table, otherTable);
            if(references.size() > 0){
                Chooser.status.setText(references.toString());
                Conector2 c1 = ((Table)tables[i]).getConector((String)references.elementAt(0));
                Conector2 c2 = t.getConector((String)references.elementAt(1));
                canvas.edges.add(new Edge(c1, c2));
            }
        }
    }//GEN-LAST:event_cbxTableActionPerformed
    
    private void seeRelacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_seeRelacionItemStateChanged
// TODO add your handling code here:
        if(evt.getStateChange() == evt.SELECTED){
            this.canvas.stress = true;
        } else{
            this.canvas.stress = false;
        }
        repaint();
    }//GEN-LAST:event_seeRelacionItemStateChanged
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    
    public ArrayList getColumns(String table){
        ResultSet rs;
        ArrayList nombres = new ArrayList();
        try{
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getColumns("%", "%", table, null);
            while(rs.next()){
                nombres.add(rs.getString(4));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            nombres.trimToSize();
            return nombres;
        }
    }
    
    public Vector getTables(){
        ResultSet rs;
        Vector nombres = new Vector();
        try{
            DatabaseMetaData dbmd = connection.getMetaData();
            String[] types = { "TABLE" };
            rs = dbmd.getTables("%", "%", "%", types);
            while(rs.next()){
                nombres.addElement(rs.getString(3));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            return nombres;
        }
    }
    
    public Vector getPrimaryKeys(String table){
        ResultSet rs;
        Vector primaryKeys = new Vector(1);
        try{
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getPrimaryKeys("", "", table);
            while(rs.next()){
                primaryKeys.addElement(new String(rs.getString(4)));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            return primaryKeys;
        }
    }
    
    public Vector getForeingKeys(String table){
        ResultSet rs;
        Vector foreingKeys = new Vector(1);
        try{
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getImportedKeys("", "", table);
            while(rs.next()){
                foreingKeys.addElement(new String(rs.getString(8)));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            return foreingKeys;
        }
    }
    
    public Vector getCrossReference(String table1, String table2){
        ResultSet rs;
        Vector pairKeys = new Vector(2);
        try{
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getCrossReference("", "", table1, "", "", table2);
            while(rs.next()){
                pairKeys.addElement(rs.getString(4));
                pairKeys.addElement(rs.getString(8));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            return pairKeys;
        }
    }
    
    public void setQuery(String query){
        this.txtQuery2.setToolTipText(query);
        this.setQuery2(query);
    }
    
    public void setQuery2(String query){
        query = query.replaceFirst("SELECT", "<font color=blue>SELECT</font>");
        query = query.replaceFirst("DISTINCT", "<font color=blue>DISTINCT</font>");
        query = query.replaceFirst("FROM", "<font color=blue>FROM</font>");
        query = query.replaceFirst("WHERE", "<font color=blue>WHERE</font>");
        query = query.replaceFirst("ORDER BY", "<font color=blue>ORDER BY</font>");
        query = query.replaceAll("\n", "<br>");
        query = "<html><body face=\"Arial\" size=\"-1\">".concat(query).concat("</body></html>");
        this.txtQuery2.setText(query);
    }
    
    public void columnAdded(TableColumnModelEvent e) {
    }
    
    public void columnRemoved(TableColumnModelEvent e) {
    }
    
    public void columnMarginChanged(ChangeEvent e) {
    }
    
    public void columnSelectionChanged(ListSelectionEvent e) {
    }
    
    public void columnMoved(TableColumnModelEvent e) {
        if(e.getFromIndex() != e.getToIndex()){
            Vector select = canvas.getSelect();
            String from = (String)select.elementAt(e.getFromIndex());
            String to = (String)select.elementAt(e.getToIndex());
            select.setElementAt(from, e.getToIndex());
            select.setElementAt(to, e.getFromIndex());
            canvas.setSelect(select);
            setQuery(canvas.selectToString());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnExecute;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxTable;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton marketBasket;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JRadioButton seeRelacion;
    private javax.swing.JTable tblPreview;
    private javax.swing.JEditorPane txtQuery2;
    // End of variables declaration//GEN-END:variables
}
