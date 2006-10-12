/*
 * EliminarMissing.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.NumericRange;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class RangoNumerico extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    ArrayList data;
    String[] columnsName;
    int colSel, min, max;
    String valRem;
    
//    final Object[][] datos = new Object[datosEntrada.getRowCount()][datosEntrada.getColumnCount()];
//    final String[] nomcol = new String[datosEntrada.getColumnCount()];
    
    public RangoNumerico(AbstractTableModel dataIn, int cs, int mn, int mx){
        datosEntrada = dataIn;
        int columns = dataIn.getColumnCount();
        columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            columnsName[i] = dataIn.getColumnName(i);
        }
        data = new ArrayList();
        colSel = cs;
        
        min = mn;
        max = mx;
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        for(int f = 0; f < datosEntrada.getRowCount(); f++ ){
            if((Integer)datosEntrada.getValueAt(f,colSel) >= min && (Integer)datosEntrada.getValueAt(f,colSel) <= max) {
                Object[] row = new Object[columnsName.length];
                for(int i = 0; i < row.length; i++){
                    row[i] = datosEntrada.getValueAt(f, i);
                }
                data.add(row);
                //datosEntrada.setValueAt("",f,colSel);  // si en ves de "" le pongo null se da�a por que?  ********
                //conm ++;
            }
        }
    }
    
    public int getColumnCount() {
        return columnsName.length;
    }
    
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col) {
        return columnsName[col];
    }
    
    public Object getValueAt(int row, int col) {
        Object[] rows = (Object[])data.get(row);
        return rows[col];
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
   
}
