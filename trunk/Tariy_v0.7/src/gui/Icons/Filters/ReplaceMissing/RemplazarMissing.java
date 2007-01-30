/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package gui.Icons.Filters.ReplaceMissing;

import gui.Icons.DBConnection.ScrollableTableModel;
import gui.Icons.Filters.TariyTableModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class RemplazarMissing extends AbstractTableModel{
    
    public AbstractTableModel dataIn;
    public AbstractTableModel dataOut;
    int colRem, conm = 0;
    Object valRem;
    
    
//    final Object[][] datos = new Object[datosEntrada.getRowCount()][datosEntrada.getColumnCount()];
//    final String[] nomcol = new String[datosEntrada.getColumnCount()];
    
    public RemplazarMissing(){
        //nuevaTabla();
    }
    
    public void setDatosEntrada(AbstractTableModel di) {
        this.dataIn = di;
        int rows = dataIn.getRowCount();
        int columns = dataIn.getColumnCount();

        Object[][] data = new Object[rows][columns];
        String[] columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                data[j][i] = dataIn.getValueAt(j ,i);
            }
            columnsName[i] = dataIn.getColumnName(i);
        }
        dataOut = new TariyTableModel(data, columnsName);
    }
    
    public void setValRem(Object valRem) {
        this.valRem = valRem;
    }
    
    public void setColRem(int colRem) {
        this.colRem = colRem;
    }
    
    
    
    public void nuevaTabla() {
        //dataOut = datosEntrada.
        // Para isertar los datos
        //colRem = 3; //AbrirRemMissing. getColSelec();
        //valRem = "JC"; //AbrirRemMissing.getValRem();
        for(int f = 0; f < dataOut.getRowCount(); f++ ){
            if(dataOut.getValueAt(f,colRem) == null) {
                dataOut.setValueAt(valRem,f,colRem);
                conm++;
            }
        }
    }
    
    
    
    public int getColumnCount() {
        return dataOut.getColumnCount();
    }
    
    public int getRowCount() {
        return dataOut.getRowCount();
    }
    
    public String getColumnName(int col) {
        return dataOut.getColumnName(col);
    }
    
    public Object getValueAt(int row, int col) {
        return dataOut.getValueAt(row, col);
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
        dataOut.setValueAt(value, row, col);
    }
    
    public int getNMissing() {
        return conm;
    }
    
}
