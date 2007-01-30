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

package gui.Icons.Filters.RemoveMissing;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class EliminarMissing extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    final Object[][] datos;
    final String[] nomcol;
    public int fv = 0;
    //-----------------
    
    public EliminarMissing(AbstractTableModel dataIn){
        datosEntrada = dataIn;
        datos = new Object[datosEntrada.getRowCount()][datosEntrada.getColumnCount()];
        nomcol = new String[datosEntrada.getColumnCount()];
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        // Para isertar los datos
        int bfv = 0;
        for(int f = 0; f < datosEntrada.getRowCount(); f++ ){
            bfv = 0;
            for(int c = 0; c < datosEntrada.getColumnCount(); c++ ){
                if(datosEntrada.getValueAt(f,c) != null) { 
                    datos[fv][c] = datosEntrada.getValueAt(f,c);   // fv = fila verificada solo incrementa cuando todos los atributos estuvieron llenos
                } else {
                    if(f == datosEntrada.getRowCount()-1) {
                        for(int i=0; i < c; i++) {
                            datos[fv][i] = null;
                        }
                    }
                    c = datosEntrada.getColumnCount();  bfv=1;  // bfv = bandera de fila verificada si es 1 es porque tuvo algun atributo vacio
                }
            }
            if(bfv!=1) fv++;
        }
        // Para insertar el nombre de las columnas
        for(int i = 0; i < datosEntrada.getColumnCount(); i++ ){
            nomcol[i] = datosEntrada.getColumnName(i);
        }
    }
    
    public int getColumnCount() {
        return nomcol.length;
    }
    
    public int getRowCount() {
        return fv;
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
