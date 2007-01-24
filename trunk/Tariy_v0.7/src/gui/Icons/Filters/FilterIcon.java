/*
 * AssociationIcon.java
 *
 * Created on 26 de mayo de 2006, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Filters;

import Utils.DataSet;
import gui.Icons.DBConnection.DBConnectionIcon;
import gui.Icons.Filters.Codification.Codificacion;
import gui.Icons.Filters.Codification.VerCodificacion;
import gui.Icons.Filters.Discretize.AbrirDiscretizacion;
import gui.Icons.Filters.Discretize.Discretizacion;
import gui.Icons.Filters.Discretize.VerDiscretizacion;
import gui.Icons.Filters.RemoveMissing.EliminarMissing;
import gui.Icons.Filters.RemoveMissing.Help;
import gui.Icons.Filters.RemoveMissing.VerResElimMiss;
import gui.Icons.Filters.Range.AbrirMuestra;
import gui.Icons.Filters.Range.Muestra;
import gui.Icons.Filters.Range.VerMuestra;
import gui.Icons.Filters.NumericRange.AbrirRangNumer;
import gui.Icons.Filters.NumericRange.RangoNumerico;
import gui.Icons.Filters.NumericRange.VerRangoNumerico;
import gui.Icons.Filters.Reduction.AbrirReduccion;
import gui.Icons.Filters.Reduction.Reduccion;
import gui.Icons.Filters.Reduction.VerReduccion;
import gui.Icons.Filters.ReplaceMissing.AbrirRemMissing;
import gui.Icons.Filters.ReplaceMissing.RemplazarMissing;
import gui.Icons.Filters.ReplaceMissing.VerResRemMiss;
import gui.Icons.Filters.ReplaceValue.AbrirRemVal;
import gui.Icons.Filters.ReplaceValue.RemplazarValor;
import gui.Icons.Filters.ReplaceValue.VerRemVal;
import gui.Icons.Filters.Selection.AbrirSeleccion;
import gui.Icons.Filters.Selection.Seleccion;
import gui.Icons.Filters.Selection.VerSeleccion;
import gui.KnowledgeFlow.Chooser;
import gui.KnowledgeFlow.Icon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class FilterIcon extends Icon{
    private JMenuItem mnuConfigure;
    private JMenuItem mnuRun;
    private JMenuItem mnuView;
    private JMenuItem mnuHelp;
    public AbstractTableModel dataIn = null;
    public AbstractTableModel dataOut = null;
    public TipodVariables typeData;
    public String filterName;
    public JFrame Open;

    //
    int indexColumn; //indice de la columna para update missing
    Object replaceWith; //objeto con el que sera reemplazado en update missing
    int rangeValue; //Valora de la muestra en Muestras y numero de rangos en Discretizacion.
    int optionRange;//Opcion del rango selecciona en Muestras y opcion seleccionada en Discretizacion.
    int columnSelected; //columna escogida en reemplazarValor, rango numerico, Discretizacion y Reduccion.
    ArrayList valuesAttribute; //valores del atributo seleccionado en reemplazarValor y Reducciones.
    String replaceString; //valor a reemplazar en reemplazar valor.
    int attributeCount;//numero de atributos a reemplazar en reemplazar valor.
    int minValue;//minimo valor para Rango Numerico.
    int maxValue;//maximo valor para Rango Numerico.
    int selRbtn; //seleccion por valor o por rango en Reducciones.
    int rManRem; //seleccion para mantener o remover en Reducciones.
    int filIni, filFin; // fila inicial y fila final en Reducciones.
    int seal; // opcion para identificar tipo de columna(Integer o String) en Reducciones.
    int minor; // valor a comparar en Reducciones.
    int numberColumns; // numero de columnas de Seleccion.
    
    private DataSet dataset = null;
    int columnsSelected[]; //arreglo de las columnas seleccionadas en Seleccion.
    
    /** Creates a new instance of DBConnectionIcon */
    public FilterIcon(JLabel s, int x, int y) {
        super(s, x, y);
        super.constrainsTo = new ArrayList(3);
        super.constrainsTo.add("FilterIcon");
        super.constrainsTo.add("AssociationIcon");
        super.constrainsTo.add("ClasificationIcon");
        
        filterName = s.getName();
        mnuConfigure = new javax.swing.JMenuItem();
        mnuConfigure.setText("Configure...");
        mnuConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfigureActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuConfigure);
        
        mnuRun = new javax.swing.JMenuItem();
        mnuRun.setText("Run...");
        mnuRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuRun);
        
        mnuView = new javax.swing.JMenuItem();
        mnuView.setText("View...");
        mnuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuView);
        
        mnuHelp = new javax.swing.JMenuItem();
        mnuHelp.setText("Help...");
        mnuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHelpActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuHelp);
    }
    
    public void setDataIn(AbstractTableModel dataIn) {
        this.dataIn = dataIn;
    }
    
    private void mnuHelpActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Help ayuda =  new Help();
                ayuda.setVisible(true);
            }
        }); 
     }
    
    private void mnuConfigureActionPerformed(java.awt.event.ActionEvent evt) {
        final FilterIcon filter = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(filterName.equals("updatem")){
                    Open = new AbrirRemMissing(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("muestra")){
                    Open = new AbrirMuestra(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("remvalor")){
                    Open = new AbrirRemVal(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("rangenum")){
                    Open = new AbrirRangNumer(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("discretize")){
                    Open = new AbrirDiscretizacion(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("reduction")){
                    Open = new AbrirReduccion(dataIn);
                    Open.setVisible(true);
                } else if(filterName.equals("selection")){
                    Open = new AbrirSeleccion(dataIn);
                    Open.setVisible(true);
                }
            }
        });
    }
    
    private void mnuRunActionPerformed(java.awt.event.ActionEvent evt) {
        if(filterName.equals("updatem")){
            indexColumn = ((AbrirRemMissing)Open).getColSelec();
            replaceWith = ((AbrirRemMissing)Open).getValRem();
            RemplazarMissing replace = new RemplazarMissing();
            if(dataOut == null){
                replace.setDatosEntrada(dataIn);
            } else {
                replace.setDatosEntrada(dataOut);
            }
            replace.setColRem(indexColumn);
            replace.setValRem(replaceWith);
            replace.nuevaTabla();
            dataOut = replace;
            this.setInfo("Column for Remplace: " + (indexColumn+1) +
                    "\nValue for Remplace: " + replaceWith);
        } else if(filterName.equals("codification")){
            Codificacion codification = new Codificacion(dataIn);
            dataOut = codification;
            this.setInfo(dataIn.getRowCount() + " Records Loaded");
        } else if(filterName.equals("removem")){ // falta top desde aqui
            EliminarMissing remove = new EliminarMissing(dataIn);
            this.setInfo(dataIn.getRowCount() - remove.fv + " Records Deleted" +
                    "\n" + remove.fv + " Records Currents");
            dataOut = remove;
        } else if(filterName.equals("muestra")){
            rangeValue = ((AbrirMuestra)Open).getValMues();
            optionRange = ((AbrirMuestra)Open).getSelRbtn();
            Muestra range = new Muestra(dataIn, rangeValue, optionRange);
            range.nuevaTabla();
            dataOut = range;
            this.setInfo("Range Value: " + rangeValue +
                    "\nOption Range: " + (optionRange+1));
        } else if(filterName.equals("remvalor")){
            columnSelected = ((AbrirRemVal)Open).getColSel();
            valuesAttribute = ((AbrirRemVal)Open).getAtriSel();
            replaceString = ((AbrirRemVal)Open).getRemCon();
            attributeCount = ((AbrirRemVal)Open).getNumAtri();
            RemplazarValor replace = new RemplazarValor(dataIn, columnSelected,
                    valuesAttribute, replaceString);
            dataOut = replace;
            this.setInfo("Column Selected: " + (columnSelected+1) +
                    "\nValues Attribute: " + valuesAttribute +
                    "\nValue for Remplace: " + replaceString +
                    "\nNumbers of Atributes: " + attributeCount);
        } else if(filterName.equals("rangenum")){
            columnSelected = ((AbrirRangNumer)Open).getColSelec();
            minValue = ((AbrirRangNumer)Open).getMinVal();
            maxValue = ((AbrirRangNumer)Open).getMaxVal();
            
            RangoNumerico range = new RangoNumerico(dataIn, columnSelected,
                    minValue, maxValue);
            dataOut = range;
            this.setInfo("Column Selected: " + (columnSelected+1) +
                    "\nMin Value: " + minValue +
                    "\nMax Value: " + maxValue);
        } else if(filterName.equals("discretize")){
            columnSelected = ((AbrirDiscretizacion)Open).getColSelec();
            rangeValue = ((AbrirDiscretizacion)Open).getValor();
            optionRange = ((AbrirDiscretizacion)Open).getSelRbtn();
            
            Discretizacion discretize = new Discretizacion(dataIn, columnSelected,
                    rangeValue, optionRange);
            dataOut = discretize;
             this.setInfo("Column Selected: " + (columnSelected+1) +
                    "\nRange Value: " + rangeValue +
                    "\nOption Range: " + optionRange);
        } else if(filterName.equals("reduction")){
            selRbtn = ((AbrirReduccion)Open).getSelRbtn();
            rManRem = ((AbrirReduccion)Open).getRbtnManRem();
            filIni = ((AbrirReduccion)Open).getValFilIni();
            filFin = ((AbrirReduccion)Open).getValFilFin();
            seal = ((AbrirReduccion)Open).getSe();
            minor = ((AbrirReduccion)Open).getMenoresQue();
            columnSelected = ((AbrirReduccion)Open).getColSel();
            valuesAttribute = ((AbrirReduccion)Open).getAtriSel();
            
            Reduccion reduction = new Reduccion(dataIn, selRbtn, rManRem, filIni,
                    filFin, seal, minor, columnSelected, valuesAttribute);
            dataOut = reduction;
            this.setInfo("Option Selected: " + (selRbtn+1) +
            "\nFirst Row: " + filIni +
            "\nLast Row: " + filFin +
            "\nColumn Selected: " + (columnSelected+1) +
            "\nValues Attributes: " + valuesAttribute);
        } else if(filterName.equals("selection")){
            numberColumns = ((AbrirSeleccion)Open).getNumColsSel();
            columnsSelected = ((AbrirSeleccion)Open).getColsSel();
            columnSelected = ((AbrirSeleccion)Open).getColObj();
            
            Seleccion selection = new Seleccion(dataIn, numberColumns,
                    columnsSelected, columnSelected);
            dataOut = selection;
             this.setInfo("Number of Columns: " + (numberColumns+1) +
            "\nColumn Target: " + (columnSelected+1));
        }
        
        Chooser.setStatus("Filter " +filterName+ " loaded");
    }
    
    private void mnuViewActionPerformed(java.awt.event.ActionEvent evt) {
        final FilterIcon ai = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(filterName.equals("updatem")){
                    VerResRemMiss view = new VerResRemMiss(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("codification")){
                    VerCodificacion view = new VerCodificacion(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("removem")){
                    VerResElimMiss view = new VerResElimMiss(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("muestra")){
                    VerMuestra view = new VerMuestra(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("remvalor")){
                    VerRemVal view = new VerRemVal(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("rangenum")){
                    VerRangoNumerico view = new VerRangoNumerico(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("discretize")){
                    VerDiscretizacion view = new VerDiscretizacion(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("reduction")){
                    VerReduccion view = new VerReduccion(dataIn, dataOut);
                    view.setVisible(true);
                } else if(filterName.equals("selection")){
                    VerSeleccion view = new VerSeleccion(dataIn, dataOut);
                    view.setVisible(true);
                }
            }
        });
    }
    
    public DataSet buildDataSet(){
        dataset = new DataSet("");
        ArrayList dictionary;
        
        if(filterName.equals("codification")){
            dictionary = ((Codificacion)dataOut).valatricod.datos;
        } else {
            dictionary = this.getDictionaryFromTableModel();
        }
        dataset.buildMultiValuedDictionary(dictionary);
        
        for(int i = 0; i < dataOut.getRowCount(); i++){
            for(int j = 0; j < dataOut.getColumnCount(); j++){
                if(dataOut.getValueAt(i, j) != null){
                    String value = dataOut.getColumnName(j) + "=" + (String)dataOut.getValueAt(i, j);
                    short item = dataset.codeAttribute(value);
                    int id = (j == dataOut.getColumnCount() - 1) ? -1 : j;
                    dataset.buildNTree(item, id);
                }
            }
        }
        
        return dataset;
    }
    
    private ArrayList getDictionaryFromTableModel() {
        ArrayList dictionary = new ArrayList();
        int rows = dataOut.getRowCount();
        int columns = dataOut.getColumnCount();
        for(int column = 0; column < columns; column++){
            String columnName = dataOut.getColumnName(column);
            ArrayList attributes = this.getAttributes(rows, column);
            Iterator it = attributes.iterator();
            while(it.hasNext()){
                String attribute = (String)it.next();
                dictionary.add(columnName + "=" + attribute);
            }
        }
        
        return dictionary;
    }
    
    private ArrayList getAttributes(int rows, int column){
        ArrayList values = new ArrayList();
        for(int row = 0; row < rows; row++){
            String key = (String) dataOut.getValueAt(row, column);
            int index = Collections.binarySearch(values, key);
            if(index < 0){
                values.add((-(index) - 1), key);
            }
        }
        
        return values;
    }
}