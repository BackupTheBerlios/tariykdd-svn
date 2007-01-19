/*
 * FileIcon.java
 *
 * Created on 8 de junio de 2006, 21:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.File;

import Utils.DataSet;
import Utils.FileManager;
import gui.Icons.Association.AssociationIcon;
import gui.KnowledgeFlow.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class FileIcon extends Icon {
    private JMenuItem mnuOpen;
    private JMenuItem mnuLoad;
    public String filePath;
    public DataSet dataset;
    public boolean xcon;
    public boolean isMarketBasket;
    private OpenFile of; 
    public FileTableModel fileTable;
    
    /** Creates a new instance of FileIcon */
    public FileIcon(JLabel s, int x, int y) {
        super(s, x, y);
        
        super.constrainsTo = new ArrayList();
        super.constrainsTo.add("FilterIcon");
        super.constrainsTo.add("AssociationIcon");
//        super.constrainsTo.add("ClasificationIcon");
        
        filePath = "";
        dataset = null;
        xcon = false;
        isMarketBasket= false;
        
        mnuOpen = new JMenuItem();
        mnuOpen.setText("Open...");
        mnuOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuOpen);
        
        mnuLoad = new JMenuItem();
        mnuLoad.setText("Load...");
        mnuLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnuLoadActionPerformed(evt);
            } 
        });
        super.pupMenu.add(mnuLoad);
        
        of = new OpenFile(this);
        of.setVisible(false);
    }
    
    private void mnuOpenActionPerformed(ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                of.setVisible(true);
            }
        });
    }
    
    private void mnuLoadActionPerformed(ActionEvent evt) {
        final FileManager fm = new FileManager(filePath);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Iterator it = tos.iterator();
                while (it.hasNext()) {
                    Icon icon = (Icon) it.next();
                    if(icon instanceof AssociationIcon) {
                        System.out.println("assoc");
                        if (isMarketBasket) {
                            System.out.println("market");
                            dataset = fm.buildUnivaluedDataSet();
                            ((AssociationIcon) icon).dataset = dataset;
                            dataset.showNTree();
                        } else {
                            dataset = fm.buildMultivaluedDataset();
                            ((AssociationIcon) icon).dataset = dataset;
                        }
                        xcon = true;
                        
                    }
                    // Construir TableModel cuando un filtro esta conectado con
                    // un archivo plano.
                    /*else if (icon instanceof FiltersIcon) {
                       ((FiltersIcon) icon).matrix = fm.buildDataMatrix();
                        xcon = true;
                    }*/
                }
                // Si nadie esta conectado con el archivo plano crear dataset
                // por defecto.
                if (!xcon) {
                    if (isMarketBasket) {
                        dataset = fm.buildUnivaluedDataSet();
                        dataset.showNTree();
                    } else {
                        dataset = fm.buildMultivaluedDataset();
                        dataset.showNTree();
                    }
                }
            }
        });
        fileTable = of.getTableModel();
    }    
//     public FileTableModel getTableModel(){
//        FileTableModel fileTable = new FileTableModel(filePath);
//        return fileTable;
//    } 
}
