/*
 * EliminarMissing.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.Reduction;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Reduccion extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    ArrayList data;
    String[] columnsName;
    int columns, rows;
    int selRbtn, rManRem;
    int filIni, filFin;
    int numfil;
    int seal, menores, colsel, numatrisel;
    ArrayList valsAtr;
    
    //-----------------
    
    public Reduccion(AbstractTableModel dataIn, int s, int r, int fi, int ff,
            int se, int men, int cs, ArrayList va){
        datosEntrada = dataIn;
        columns = dataIn.getColumnCount();
        rows = dataIn.getRowCount();
        columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            columnsName[i] = dataIn.getColumnName(i);
        }
        selRbtn = s;
        rManRem = r;
        filIni = fi - 1;
        filFin = ff - 1;
        seal = se;
        menores = men;
        colsel = cs;
        valsAtr = va;
        
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        if(selRbtn == 0) { // por rango
            if(rManRem == 0) { // mantener
                numfil = (filFin - filIni) + 1;
                data = new ArrayList(numfil);
                for(int f = filIni; f <= filFin; f++) {
                    Object[] row = new Object[columns];
                    for(int c = 0; c < columns; c++) {
                        row[c] = datosEntrada.getValueAt(f,c);
                    }
                    data.add(row);
                }
            } else if(rManRem == 1) { // remover
                numfil = rows - ((filFin - filIni) + 1);// quitamos un +1
                data = new ArrayList(numfil);
                for(int f = 0; f < rows; f++) {
                    if(f < filIni || f > filFin){
                        Object[] row = new Object[columns];
                        for(int c = 0; c < columns; c++) {
                            row[c] = datosEntrada.getValueAt(f,c);
                        }
                        data.add(row);
                    }
                }
            }
        } else if(selRbtn == 1) { // por valor
            //String valsAtri[] = new String[numatrisel];
            data = new ArrayList();
            if(seal == 0) {  // es porque el combo box fue Integer
                numfil = 0;
                for(int f = 0; f < rows; f++) {
                    if(rManRem == 0) { // para mantenerlos
                        if((Integer)datosEntrada.getValueAt(f,colsel) < menores) {
                            Object[] row = new Object[columns];
                            for(int c = 0; c < columns; c++) {
                                row[c] = datosEntrada.getValueAt(f,c);
                            }
                            data.add(row);
                            numfil ++;
                        }
                    } else if(rManRem == 1) { // para removerlos
                        if((Integer)datosEntrada.getValueAt(f,colsel) >= menores) {
                            Object[] row = new Object[columns];
                            for(int c = 0; c < columns; c++) {
                                row[c] = datosEntrada.getValueAt(f,c);
                            }
                            data.add(row);
                            numfil ++;
                        }
                    }
                }
            } else if(seal == 1) { // es porque el combo box fue String
                numfil = 0;
                //________________
                if(rManRem == 0) { // para mantenerlos
                    for(int f = 0; f < rows; f++) {
                        if(valsAtr.contains(datosEntrada.getValueAt(f,colsel))){
                            Object[] row = new Object[columns];
                            for(int c = 0; c < columns; c++) {
                                row[c] = datosEntrada.getValueAt(f,c);
                            }
                            data.add(row);
                            numfil++;
                        }
                    }
                } else if(rManRem == 1) { // para removerlos
                    for(int f = 0; f < rows; f++) {
                        if(!valsAtr.contains(datosEntrada.getValueAt(f,colsel))){
                            Object[] row = new Object[columns];
                            for(int c = 0; c < columns; c++) {
                                row[c] = datosEntrada.getValueAt(f,c);
                            }
                            data.add(row);
                            numfil++;
                        }
                    }
                }
            }
        }
    }
    
    public int getColumnCount() {
        return columns;
    }
    
    public int getRowCount() {
        return numfil;
    }
    
    public String getColumnName(int col) {
        return columnsName[col];
    }
    
    public Object getValueAt(int row, int col) {
        Object[] r = (Object[])data.get(row);
        return r[col];
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
