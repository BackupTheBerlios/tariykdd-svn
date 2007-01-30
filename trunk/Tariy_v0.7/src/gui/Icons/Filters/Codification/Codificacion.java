/*
 * FiltroStandard.java
 *
 * Created on 18 de mayo de 2006, 03:18 PM
 */

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

package gui.Icons.Filters.Codification;

import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Codificacion extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    public ValAtributosCod valatricod;
    
    final Object[][] datos;
    final String[] nomcol;
    
    public Codificacion(AbstractTableModel dataIn){
        datosEntrada = dataIn;
        valatricod = new ValAtributosCod(dataIn);
        datos = new Object[datosEntrada.getRowCount()][datosEntrada.getColumnCount()];
        nomcol = new String[datosEntrada.getColumnCount()];
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        for(int f = 0; f < datosEntrada.getRowCount(); f++) {
            for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
                String element = datosEntrada.getColumnName(c) + "=" +
                        datosEntrada.getValueAt(f,c);
                int index = Collections.binarySearch(valatricod.datos, element);
                datos[f][c] = new Short((short)index);
            }
        }
        for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
            nomcol[c] = datosEntrada.getColumnName(c);
        }
    }
    
    public int getColumnCount() {
        return nomcol.length;
    }
    
    public int getRowCount() {
        return datosEntrada.getRowCount();
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
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setValueAt(Object value, int row, int col) {
        datos[row][col] = value;
    }
    
}
