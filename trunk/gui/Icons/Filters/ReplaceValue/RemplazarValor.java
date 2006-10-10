/*
 * EliminarMissing.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.ReplaceValue;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class RemplazarValor extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    Object[][] data;
    String[] columnsName;
    int ColSel;
    int numatri;
    int filen;
    ArrayList atrisel;
    String remcon;
    public int replaceCount; 
    //-----------------
    
    public RemplazarValor(AbstractTableModel dataIn, int colsel,
            ArrayList atri, String rem){
        datosEntrada = dataIn;
        ColSel = colsel;
        atrisel = atri;
        numatri = atri.size();
        remcon = rem;
        replaceCount = 0;
        
        //dataOut = new TariyTableModel(data, columnsName);
        
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        //int ColSel; // AbrirRemVal.getColSel();
        //String atrisel[] = new String[datosEntrada.getRowCount()]; //AbrirRemVal.getAtriSel(); //-----
        //String remcon; // AbrirRemVal.getRemCon();
        //int numatri; // AbrirRemVal.getNumAtri()
        //int filen;
        //___________
        
//        ColSel = 0;
//        numatri = 2;
//        atrisel[0] = "Alta";
//        atrisel[1] = "Baja";
//        remcon = "JC";
        
        int rows = datosEntrada.getRowCount();
        int columns = datosEntrada.getColumnCount();
        
        data = new Object[rows][columns];
        columnsName = new String[columns];
        for(int i = 0; i < columns; i++){
            if(i != ColSel){
                for(int j = 0; j < rows; j++){
                    data[j][i] = datosEntrada.getValueAt(j ,i);
                }
            } else{
                for(int j = 0; j < rows; j++){
                    if(atrisel.contains(datosEntrada.getValueAt(j,ColSel))){
                        data[j][ColSel] = remcon;
                        replaceCount++;
                    } else {
                        data[j][ColSel] = datosEntrada.getValueAt(j ,ColSel);
                    }
                }
            }
            columnsName[i] = datosEntrada.getColumnName(i);
        }
        
        
//        for(int f = 0; f < datosEntrada.getRowCount(); f++) {
//            filen = 0;
//            for(int i = 0; i < numatri; i++) {
//                if(datosEntrada.getValueAt(f,ColSel).equals(atrisel.get(i))) {
//                    filen ++;
//                    //break;
//                }
//            }
//            if(filen != 0) {
//                data[f][ColSel] = remcon;
//            }
//        }
    }
    
    public int getColumnCount() {
        return columnsName.length;
    }
    
    public int getRowCount() {
        return data.length;
    }
    
    public String getColumnName(int col) {
        return columnsName[col];
    }
    
    public Object getValueAt(int row, int col) {
        return data[row][col];
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
//
//    public void setValueAt(Object value, int row, int col) {
//        datosEntrada.setValueAt(value, row, col);
//    }
}
