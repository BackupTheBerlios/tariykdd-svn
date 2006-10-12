/*
 * FiltroStandard.java
 *
 * Created on 18 de mayo de 2006, 03:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.Selection;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class TipodVariablesSel extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    final Object[][] datos;
    final String[] nomcol;
    int columns, rows;
    
    public TipodVariablesSel(AbstractTableModel dataIn){
        datosEntrada = dataIn;
        columns = dataIn.getColumnCount();
        rows = dataIn.getRowCount();
        datos = new Object[columns][4];
        nomcol  = new String[4];
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        // Para isertar los datos
        for(int c = 0; c < columns; c++ ){
            datos[c][0] = datosEntrada.getColumnName(c);
            datos[c][1] = datosEntrada.getColumnClass(c).getSimpleName();
            datos[c][2] = Boolean.TRUE;
            datos[c][3] = "Atributo";  // tiene que ser un radio buton
        }
        // Para insertar el nombre de las columnas
        nomcol[0] = "ATRIBUTO";
        nomcol[1] = "TIPO";
        nomcol[2] = "SELECCION";
        nomcol[3] = "OBJETIVO";
    }
    
    public int getColumnCount() {
        return nomcol.length;
    }
    
    public int getRowCount() {
        return datos.length;
    }
    
    public String getColumnName(int col) {
        return nomcol[col];
    }
    
    public Object getValueAt(int row, int col) {
        return datos[row][col];
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setValueAt(Object value, int row, int col) {
        datos[row][col] = value;
    }
    
}
