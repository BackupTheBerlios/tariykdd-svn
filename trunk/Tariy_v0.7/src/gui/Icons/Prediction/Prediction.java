/*
 * Prediction.java
 *
 * Created on 17 de mayo de 2006, 06:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Prediction;

import algorithm.classification.Value;
import algorithm.classification.c45_1.Attribute;
import algorithm.classification.compareValues;
//import algorithm.classification.
import gui.Icons.Filters.TariyTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class Prediction extends AbstractTableModel{
    AbstractTableModel datosEntrada;
    final Object[][] datos;
    final String[] nomcol;
    int columns, rows;
    int colnode;
    String cad,atri;
    Attribute ax;
        
    public Prediction(AbstractTableModel dataIn){
        datosEntrada = dataIn;
        columns = dataIn.getColumnCount();
        rows = dataIn.getRowCount();
        datos = new Object[rows][columns + 1];
        nomcol = new String[columns + 1];
        
                // Para isertar los datos
        for(int fi = 0; fi < rows; fi++ ){
            for(int c = 0; c < columns; c++ ){
              datos[fi][c] = datosEntrada.getValueAt(fi,c);
            }
        }
        // Para insertar el nombre de las columnas
        for(int i = 0; i < columns; i++ ){
            nomcol[i] = datosEntrada.getColumnName(i);
        }
        
    }
    
    public void PredictionColTarget(Attribute auxiliar){
        ax = auxiliar.son; // el ultimo .brother es provicional por que en este arbol se esta duplicando el 1 nodo
        nameColTarget(ax);
        NewTable(ax);
    }
    
    public void NewTable(Attribute auxiliar){
        int f = 0;
        
        while(f < rows){ 
            
            StringTokenizer token = new StringTokenizer(auxiliar.name,"=");
            cad = token.nextToken().trim();
           
            if(auxiliar.son!=null){
              colnode = getColNode(cad);   
            }   
            else colnode = 0; 
            
            if(colnode != -1){
                cad = token.nextToken().trim();
                atri = datos[f][colnode].toString().trim();

                if(auxiliar.son == null){
                   datos[f][columns] =  cad;
                   f++;
                   auxiliar = ax;
                }
                else if(auxiliar.son != null && cad.equalsIgnoreCase(atri)){
                    auxiliar = auxiliar.son;
                }
                else if(auxiliar.brother != null){
                    auxiliar = auxiliar.brother;
                }
                else { // por probar
                    // aqui asigno el mejor parcializado para este nodo con el metodo de Andres
                    int vlrv = 0;
                    String cadv = "";
                    ArrayList values = auxiliar.getValuesClass();
                    Collections.sort(values, new compareValues());
                    for(int v=0; v < values.size(); v++){  // busca el valor parcializado con mayor frecuencia ejm si ono con mas apaariciones
                       Value value = (Value)values.get(v);
                       if(value.getFrecuence()>vlrv){
                          vlrv =  value.getFrecuence();
                          cadv = value.getName();
                       } 
                    }
                   datos[f][columns] = cadv; 
                   f++;
                   auxiliar = ax;
                }
            }
            else f = rows;
        }
    }
    
    public void nameColTarget(Attribute aux){
        String cadtarget;
        while(aux.son != null){
            aux = aux.son;
        }       
        StringTokenizer token = new StringTokenizer(aux.name,"=");
        cadtarget = token.nextToken().trim();
        nomcol[columns] = cadtarget;
    }
       
    public int getColNode(String colt){
        int numcol = 0;
        boolean compatibilidad = false;
        
        for(int i = 0; i < columns; i++ ){
            if(colt.equalsIgnoreCase(nomcol[i])){
               numcol = i; 
               compatibilidad = true;
               break;
            }
        }
        if(!compatibilidad){
            for(int f = 0; f < rows; f++ ){             
                  datos[f][columns] = "x";       
            }
           JOptionPane.showMessageDialog(null, "Tablas Incompatibles","Error en Prediction.",JOptionPane.ERROR_MESSAGE);
           return -1;
           // de alguna forma debo salir para que no siga ejecutando esto
           // y devolver una tabla vacia y no permitir que se ejecute el view
           // con los que clasifique de esta forma se puede saber el porcentaje de certeza
        }
        else return numcol;
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
