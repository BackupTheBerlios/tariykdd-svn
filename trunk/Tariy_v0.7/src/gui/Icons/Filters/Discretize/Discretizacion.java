// falta corregir lo del vaciado a data lo que hacia ANDRES

/*
 * EliminarMissing.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters.Discretize;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Discretizacion extends AbstractTableModel{
    
    AbstractTableModel datosEntrada;
    int colSel, rbtnsel;
    
    private int rows;
    private int columns;
    int val;
    
    Object[][] data;
    String[] columnsName;
    
    public Discretizacion(AbstractTableModel dataIn, int cs, int v, int r){
        datosEntrada = dataIn;
        rows = dataIn.getRowCount();
        columns = dataIn.getColumnCount();
        data = new Object[rows][columns];
        columnsName = new String[columns];
        colSel = cs;
        val = v;
        rbtnsel = r;
        nuevaTabla();
    }
    
    public void nuevaTabla() {
        int min, max;
        float aux, incre;
        float rangos[];
        String rangString = "";
        
//        // Para isertar los datos
//        colSel = 5; //AbrirDiscretizacion.getColSelec();
//        val = 2; //AbrirDiscretizacion.getValor();
//        rbtnsel = 1; //AbrirDiscretizacion.getSelRbtn();
//
        
        min = (Integer)datosEntrada.getValueAt(0,colSel);
        max = (Integer)datosEntrada.getValueAt(0,colSel);
        for(int c = 0; c < columns; c++){
            for(int f = 0; f < rows; f++ ){
                if(c == colSel){
                    if((Integer)datosEntrada.getValueAt(f,colSel) < min) {
                        min = (Integer)datosEntrada.getValueAt(f,colSel);
                    }
                    if((Integer)datosEntrada.getValueAt(f,colSel) > max) {
                        max = (Integer)datosEntrada.getValueAt(f,colSel);
                    }
                }
                data[f][c] = datosEntrada.getValueAt(f, c);
            }
            columnsName[c] = datosEntrada.getColumnName(c);
        }
        
        if(rbtnsel == 0) {
            rangos =  new float[val - 1];
            //val = val - 2;
            
            aux = max - min;
            aux = aux / val;
            incre = min + aux;
            
            int con = 0;
            while( con < rangos.length) {
                rangos[con] = incre;
                incre = incre + aux;
                con ++;
            }
            //rangos[con] = max - 1;
            
            for(int f = 0; f < rows; f++ ){
                for(int i = 0; i < val; i++ ){
                    if((Integer)datosEntrada.getValueAt(f,colSel) <= (rangos[0])) {
                        rangString = "(- Infinity : " + rangos[0] + " ]";
                        data[f][colSel] = rangString;
                        break;
                    }else if((Integer)datosEntrada.getValueAt(f,colSel) > (rangos[rangos.length - 1])) {
                        rangString = "( " + rangos[rangos.length - 1] + " : + Infinity )";
                        data[f][colSel] = rangString;
                        break;
                    }else if((Integer)datosEntrada.getValueAt(f,colSel) > rangos[i] && (Integer)datosEntrada.getValueAt(f,colSel) <= rangos[i + 1]) {
                        rangString = "( " + rangos[i] + " : " + rangos[i + 1] + " ]";
                        data[f][colSel] = rangString;
                        break;
                    }
                }
            }
        } else if(rbtnsel == 1) {
            int r = ((max - min) / val) + 1;
            rangos = new float[r + 2];
            int pr = 0;
            incre = min;
            while(incre < max){
                rangos[pr] = incre;
                incre = incre + val;
                pr ++;
            }
            rangos[pr] = max - 1;
            
            for(int f = 0; f < rows; f++ ){
                for(int i = 0; i < pr; i++ ){
                    if((Integer)datosEntrada.getValueAt(f,colSel) <= (rangos[0])) {
                        rangString = "(- Infinity : " + rangos[0] + " ]";
                        data[f][colSel] = rangString;
                        break;
                    }else if((Integer)datosEntrada.getValueAt(f,colSel) > (rangos[pr])) {
                        rangString = "( " + rangos[pr] + " : + Infinity )";
                        data[f][colSel] = rangString;
                        break;
                    }else if((Integer)datosEntrada.getValueAt(f,colSel) > rangos[i] && (Integer)datosEntrada.getValueAt(f,colSel) <= rangos[i + 1]) {
                        rangString = "( " + rangos[i] + " : " + rangos[i + 1] + " ]";
                        data[f][colSel] = rangString;
                        break;
                    }
                }
            }
            
        }
    }
    
    public int getColumnCount() {
        return columns;
    }
    
    public int getRowCount() {
        return rows;
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
}
