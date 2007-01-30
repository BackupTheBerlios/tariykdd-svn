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

package gui.Icons.Filters.Range;

import gui.Icons.Filters.TariyTableModel;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Muestra extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    AbstractTableModel dataOut;
    Object[][] data;
    String[] columnsName;
    int filmenos = 0;
    
    private int opcmues;
    
    private int valmues;
    //-----------------
    
    public Muestra(AbstractTableModel dataIn, int r, int o){
        datosEntrada = dataIn;
        
        int columns = dataIn.getColumnCount();
        columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            columnsName[i] = dataIn.getColumnName(i);
        }
        //dataOut = new TariyTableModel(data, columnsName);
        
        opcmues = o;
        valmues = r;
        //nuevaTabla();
    }
    
    public void nuevaTabla() {
        int /*opcmues = 0, valmues=0,*/filn = 0, fp = 0, cfila = 0;
        //_________________________
        //opcmues = 1; // AbrirMuestra.getSelRbtn();
        //valmues = 2; // AbrirMuestra.getValMues();
        
        if(opcmues==0) {      // Aleatorio
            //AbstractTableModel datosParaSem = datosEntrada;
            Random r = new Random();
            data = new Object[valmues][columnsName.length];
            for(int f = 0; f < valmues; f++) {
                cfila = r.nextInt(datosEntrada.getRowCount());
                for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
                    data[f][c] = datosEntrada.getValueAt(cfila,c);
                }
            }
            filmenos = valmues;
        }
        
        else if(opcmues==1){ //  1 en n
            filn = 0;
            int nrows = (int)(datosEntrada.getRowCount() / valmues) + 1;
            data = new Object[nrows][columnsName.length];
            int rows = datosEntrada.getRowCount();
            for(int f = 0; f < rows; f++) {
                if(f==filn) {
                    for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
                        data[fp][c] = datosEntrada.getValueAt(filn,c);
                    }
                    filn = filn + valmues;
                    fp++;
                }
            }
            filmenos = fp;
        }
        
        else if(opcmues==2){ // Primeros n
            data = new Object[valmues][columnsName.length];
            for(int f = 0; f < valmues; f++) {
                for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
                    data[f][c] = datosEntrada.getValueAt(f,c);
                }
            }
            filmenos = valmues;
        }
        dataOut = new TariyTableModel(data, columnsName);
    }
    
    public int getColumnCount() {
        return dataOut.getColumnCount();
    }
    
    public int getRowCount() {
        return filmenos;
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
}
