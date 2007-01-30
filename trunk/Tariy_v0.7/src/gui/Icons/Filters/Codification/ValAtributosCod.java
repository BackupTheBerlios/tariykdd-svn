/*
 * FiltroStandard.java
 *
 * Created on 18 de mayo de 2006, 03:18 PM
 *
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class ValAtributosCod extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    
    public final ArrayList datos = new ArrayList();   //  el 30 hay que hacerlo dinamico ***---989898
    final String[] nomcol = new String[3];
    
    int catri = 1, limc = 0,  auxc = 0;
    
    public ValAtributosCod(AbstractTableModel dataIn){
        datosEntrada = dataIn;
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        Object[] valores = new Object[datosEntrada.getRowCount()];
        int con = 0, pv;
        
        for(int c = 0; c < datosEntrada.getColumnCount(); c++) {
            catri = 0;  //1
            for(int f = 0; f < datosEntrada.getRowCount(); f++) {
                con = 0;
                for(int i = 0; i < catri; i++) {
                    if(datosEntrada.getValueAt(f,c).equals(valores[i])){
                        con ++;
                        break;
                    }
                }
                if(con == 0) {
                    valores[catri] = datosEntrada.getValueAt(f,c);
                    catri++;
                }
            }
            pv = 0;
            limc = limc + catri;
            for(int i = auxc; i < limc; i++) {
                //ArrayList row = new ArrayList(3);
                //row.add(new Short((short)i));
                datos.add(datosEntrada.getColumnName(c) + "=" + valores[pv]);
                pv ++;
                //datos.add(row);
            }
            auxc = auxc + catri;
        }
        nomcol[0] = "INDICE";
        nomcol[1] = "ATRIBUTO";
        nomcol[2] = "VALOR";
        datos.trimToSize();
        Collections.sort(datos);
    }
    
    public int getColumnCount() {
        return nomcol.length;
    }
    
    public int getRowCount() {
        return auxc;
    }
    
    public String getColumnName(int col) {
        return nomcol[col];
    }
    
    public Object getValueAt(int row, int col) {
        StringTokenizer token = new StringTokenizer((String)datos.get(row), "=");
        if(col == 0){
            return new Short((short)row);
        } else if(col == 1){
            return token.nextToken();
        } else if(col == 2){
            token.nextToken();
            return token.nextToken();
        }
//        
//        
//        ArrayList fila = (ArrayList)datos.get(row);
//        return fila.get(col);
        return null;
    }
    
    public Class getColumnClass(int c) {
        if(c == 0){
            return Short.class;
        } else {
            return String.class;
        }
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
    
//    public void setValueAt(Object value, int row, int col) {
//        datos[row][col] = value;
//    }
    
}
