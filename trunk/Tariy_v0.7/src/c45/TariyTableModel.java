/*
 * TariyTableModel.java
 *
 * Created on 17 de mayo de 2006, 05:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package c45;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tariy
 */
public class TariyTableModel extends AbstractTableModel {
    
//  __________________________________________ 
// PERSONA
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
// ADMINISTRAR FARMACO    
   final Object[][] datos = {     
   { "Alta","Alto","Alto","No","No","Si" },
   { "Alta","Alto","Alto","Si","No","Si" },
   { "Baja","Alto","Bajo","No","No","Si" },
   { "Media","Alto","Alto","No","Si","No" },
   { "Media","Bajo","Alto","Si","Si","No" },
   { "Baja","Bajo","Alto","Si","Si","Si" },
   { "Alta","Bajo","Alto","Si","No","Si" },
   { "Alta","Bajo","Bajo","No","Si","Si" },
   { "Alta","Alto","Bajo","Si","Si","No" },
   { "Baja","Bajo","Alto","Si","Si","Si" },
   { "Media","Bajo","Bajo","Si","Si","Si" },
   { "Alta","Bajo","Alto","Si","Si","No" },
   { "Baja","Alto","Alto","Si","Si","Si" },
   { "Baja","Alto","Bajo","No","No","Si" },
 };
   
   final String[] nomcol = {
    "PRESION_ARTERIAL", 
    "AZUCAR_SANGRE",
    "INDICE_COLESTEROL",
    "ALERGIA_ANTIBIOTICO",
    "OTRAS_ALERGIAS",
    "ADMINISTRAR_FARMACO_F"
     };
   
//______________________________________________________   
// // GRIPA 2   
//   Object [][] datos = {
//                        {"no","si","alta","si"},
//                        {"si","no","alta","si"},
//                        {"si","si","media","no"},
//                        {"no","si","normal","si"},
//                        {"si","no","media","no"},
//                        {"no","no","normal","no"},
//                        {"si","no","normal","no"},
//                        {"si","si","alta","si"}
//                   };
//String[] nomcol = {
//                        "d_cabeza",
//                        "d_muscular",
//                        "temperatura",
//                        "gripa"
//                       };

 //____________________________________________________
 //CLIMA    
// Object [][] datos = {
//    { "Soleado","Caliente","Alta","Debil","no" },
//    { "Soleado","Caliente","Alta","Fuerte","no" },
//    { "Nublado","Caliente","Alta","Debil","si" },
//    { "Lluvioso","Templado","Alta","Debil","si" },
//    { "Lluvioso","Fresco","Normal","Debil","si" },
//    { "Lluvioso","Fresco","Normal","Fuerte","no" },
//    { "Nublado","Fresco","Normal","Fuerte","si" },
//    { "Soleado","Templado","Alta","Debil","no" },
//    { "Soleado","Fresco","Normal","Debil","si" },
//    { "Lluvioso","Templado","Normal","Debil","si" },
//    { "Soleado","Templado","Normal","Fuerte","si" },
//    { "Nublado","Templado","Alta","Fuerte","si" }, 
//    { "Nublado","Caliente","Normal","Debil","si" },
//    { "Lluvioso","Templado","Alta","Fuerte","no" },           
//  };  
//    
//String[] nomcol = {
//                    "ESTADO",
//                    "TEMPER",
//                    "HUMEDAD",
//                    "VIENTO",
//                    "JTENNIS"    
//                   };   
    
//_______________________________________________
// //GRIPA 1
//    Object [][] datos = {
//    { "D_CABEZA","D_MUSCULAR","TEMPERATURA","GRIPA"},              
//    { "no","si","alta","si" },
//    { "si","no","alta","si" },
//    { "si","si","media","no" },
//    { "no","si","normal","si" },
//    { "no","no","media","no" },
//    { "si","no","normal","no" },
//    { "no","no","normal","no" },
//    { "no","si","alta","si" },
//  };
//    
//   String[] nomcol = {
//                    "D_CABEZA",
//                    "D_MUSCULAR",
//                    "TEMPERATURA",
//                    "GRIPA"  
//                   };    
// =============================================
    
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

