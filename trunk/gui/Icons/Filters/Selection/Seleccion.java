/*
 * Seleccion.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.Selection;

import gui.Icons.Filters.TariyTableModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Seleccion extends AbstractTableModel{
    AbstractTableModel datosEntrada;
    final Object[][] datos;
    final String[] nomcol;
    int columns, rows;
    int colObje;
    int colsel[];
    int numcols;
    
    
    public Seleccion(AbstractTableModel dataIn, int nc, int[] cs, int o){
        datosEntrada = dataIn;
        numcols = nc + 1;
        colsel = cs;
        colObje = o;
        columns = dataIn.getColumnCount();
        rows = dataIn.getRowCount();
        datos = new Object[rows][numcols];
        nomcol = new String[numcols];
        nuevaTabla();
    }
    
    public void nuevaTabla() {
//        int colObje = 0;
//        colsel[0] = 1; //AbrirSeleccion.getColsSel();
//        colsel[1] = 3;
//        colObje = 5; //AbrirSeleccion.getColObj();
//        
        // Para isertar los datos
        for(int f = 0; f < rows; f++ ){
            for(int c = 0; c < numcols; c++ ){
                if(c == numcols-1) datos[f][c] = datosEntrada.getValueAt(f,colObje);
                else datos[f][c] = datosEntrada.getValueAt(f,colsel[c]);
            }
        }
        // Para insertar el nombre de las columnas
        for(int i = 0; i < numcols; i++ ){
            if(i == numcols-1) nomcol[i] = datosEntrada.getColumnName(colObje);
            else nomcol[i] = datosEntrada.getColumnName(colsel[i]);
        }
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
