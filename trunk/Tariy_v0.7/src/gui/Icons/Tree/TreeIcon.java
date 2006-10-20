/*
 * RulesIcon.java
 *
 * Created on 26 de mayo de 2006, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Tree;

import gui.KnowledgeFlow.Icon;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author ivan
 */
public class TreeIcon extends Icon{
    private JMenuItem mnuView;
    public JPanel TreePanel;
    public ArrayList RulesText;
    
    /** Creates a new instance of DBConnectionIcon */
    public TreeIcon(JLabel s, int x, int y) {
        super(s, x, y);
        super.constrainsTo = new ArrayList(0);
        
        mnuView = new javax.swing.JMenuItem();
        mnuView.setText("Run...");
        mnuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewActionPerformed(evt);
            }
        });
        super.pupMenu.add(mnuView);
    }
    
    private void mnuViewActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewerClasification(TreePanel, RulesText).setVisible(true);
            }
        });
    }
    
    /** Creates a new instance of AssociationIcon */
    
}
