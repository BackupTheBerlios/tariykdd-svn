/*
 * TariyTableModel.java
 *
 * Created on 17 de mayo de 2006, 04:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters;

import Utils.DataSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class TariyTableModel extends AbstractTableModel {
    /*
//  __________________________________________  
//    final Object[][] datos = {
//    {"Mary", "Campione","Snowboarding", new Integer(5), new Boolean(false)},
//    {"Alison", "Huml","Rowing", new Integer(3), new Boolean(true)},
//    {"Kathy", "Walrath","Chasing toddlers", new Integer(2), new Boolean(false)},
//    {"Mark", "Andrews","Speed reading", new Integer(20), new Boolean(true)},
//    {"Angela", "Lih","Teaching high school", new Integer(4), new Boolean(false)}
//};
//    final String[] nomcol = {
//    "First Name", 
//    "Last Name",
//    "Sport",
//    "# of Years",
//    "Vegetarian"
//    }; 
//  =============================================

//_______________________________________________ 
// Normales
//   final Object[][] datos = { 
//   { "Alta","Alto","Alto","No","No","Si" },
//   { "Alta","Alto","Alto","Si","No","Si" },
//   { "Baja","Alto","Bajo","No","No","Si" },
//   { "Media","Alto","Alto","No","Si","No" },
//   { "Media","Bajo","Alto","Si","Si","No" },
//   { "Baja","Bajo","Alto","Si","Si","Si" },
//   { "Alta","Bajo","Alto","Si","No","Si" },
//   { "Alta","Bajo","Bajo","No","Si","Si" },
//   { "Alta","Alto","Bajo","Si","Si","No" },
//   { "Baja","Bajo","Alto","Si","Si","Si" },
//   { "Media","Bajo","Bajo","Si","Si","Si" },
//   { "Alta","Bajo","Alto","Si","Si","No" },
//   { "Baja","Alto","Alto","Si","Si","Si" },
//   { "Baja","Alto","Bajo","No","No","Si" },  
//   };
//___________________________________________
 // con vacios    
//    final Object[][] datos = { 
//   { "Alta","Alto","Alto","No","No","No"},
//   { "Alta","Alto","","Si","No",""},
//   { "Baja","Alto","Bajo","No","Si","No"},
//   { "","Alto","","No","",""},
//   { "Media","Bajo","Alto","Si","Si","Si"},
//   { "Baja","Bajo","Alto","Si","Si",""},
//   { "Alta","Bajo","Alto","","No",""},
//   { "Alta","Bajo","Bajo","","Si","No"},
//   { "Alta","Alto","Bajo","Si","","Si"},
//   { "Baja","Bajo","Alto","Si","",""},
//   { "Media","Bajo","Bajo","","Si","No"},
//   { "Alta","","Alto","","Si","Si"},
//   { "Baja","Alto","Alto","Si","Si","No"},
//   { "Baja","Alto","","No","No","Si"},
// };
//  
//____________________________________________
 // con numericos   
//   final Object[][] datos = { 
//   { "Alta","Alto","Alto","No","No",1 },
//   { "Alta","Alto","Alto","Si","No",4 },
//   { "Baja","Alto","Bajo","No","No",9 },
//   { "Media","Alto","Alto","No","Si",6 },
//   { "Media","Bajo","Alto","Si","Si",3 },
//   { "Baja","Bajo","Alto","Si","Si",8 },
//   { "Alta","Bajo","Alto","Si","No",2 },
//   { "Alta","Bajo","Bajo","No","Si",5 },
//   { "Alta","Alto","Bajo","Si","Si",7 },
//   { "Baja","Bajo","Alto","Si","Si",8 },
//   { "Media","Bajo","Bajo","Si","Si",3 },
//   { "Alta","Bajo","Alto","Si","Si",7 },
//   { "Baja","Alto","Alto","Si","Si",1 },
//   { "Baja","Alto","Bajo","No","No",7 },  
//   }; 
//    
//   final String[] nomcol = {
//    "PRESION_ARTERIAL", 
//    "AZUCAR_SANGRE",
//    "INDICE_COLESTEROL",
//    "ALERGIA_ANTIBIOTICO",
//    "OTRAS_ALERGIAS",
//    "ADMINISTRAR_FARMACO_F"};
   //  =============================================*/
    
   private Object[][] data;
   private String[] columnName;
   
   public TariyTableModel(Object[][] d, String [] cn){
       this.setData(d, cn);
   }
   
   public void setData(Object[][] d, String [] cn){
       data = d;
       columnName = cn;
   }
   
    public int getColumnCount() {
        return columnName.length;
    }
    
    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnName[col];
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

    public void setValueAt(Object value, int row, int col) {       
        data[row][col] = value;    
    }    
    
//    public DataSet loadDataSet(){
//        
//    }
}
