/*
 * AssociationIcon.java
 *
 * Created on 26 de mayo de 2006, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Clasification;


import c45.TariyTableModel;
import c45.c45;
import gui.Icons.Filters.Selection.Seleccion;
import gui.KnowledgeFlow.Icon;
import gui.KnowledgeFlow.JackAnimation;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class ClasificationIcon extends Icon{
    private JMenuItem mnuConfigure;
    private JMenuItem mnuRun;
    private String algorithm;
    public AbstractTableModel dataIn;
    
    
    /** Creates a new instance of DBConnectionIcon */
    public ClasificationIcon(JLabel s, int x, int y) {
        super(s, x, y);
        super.constrainsTo = new ArrayList(1);
        super.constrainsTo.add("");//Restricciones de conexion (a que iconos se puede conectar un icono de clasificacion)
        algorithm = s.getText();
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
    }
    
    private void mnuConfigureActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    private void mnuRunActionPerformed(java.awt.event.ActionEvent evt) {
        JackAnimation jack = new JackAnimation();
        this.add(jack);
        this.setComponentZOrder(jack, 0);
        jack.setBounds(this.animation.getX(), this.animation.getY(), 36, 36);
        this.setAnimation(jack);
        System.out.println(algorithm);
        if(algorithm.equals("C45")){
            this.startAnimation();
            
            final JFrame frame = new JFrame( "Arbol C 4.5" );
            frame.addWindowListener( new WindowAdapter() {
                public void windowClosing( WindowEvent evt ) {
                    frame.dispose();
                    //System.exit( 0 );
                }
            });
            //c45 c = new c45(dataIn);
            frame.getContentPane().add( new c45(dataIn),BorderLayout.CENTER );
            frame.setSize( 300,500 );
            frame.setVisible( true );
            
            
            
            this.stopAnimation();
        } else if(algorithm.equals("Mate")){
            //this.startAnimation();
            
        }
    }
}
