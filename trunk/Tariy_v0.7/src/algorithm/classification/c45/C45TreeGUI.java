/*
 * TariyNTreeGUI.java
 *
 * Created on April 12, 2006, 2:42 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package algorithm.classification.c45;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author Tariy
 */

/*Interfaz grafica que muestra el contenido de Tree usa dos botones, un panel y
 *el JTree que extendimos
 */ 
public class C45TreeGUI extends JPanel {
    Tree tree;
    /** Creates a new instance of TariyNTreeGUI */
    public C45TreeGUI(Tree tree) {
        super(new BorderLayout());
        
        // Construct the button panel and the buttons.
        JPanel panel = new JPanel();
        JButton btnExpand = new JButton("Expand All");
        JButton btnCollapse = new JButton("Collapse All");
        panel.add(btnExpand);
        panel.add(btnCollapse);
        
        // Construct the tree.
        this.tree = tree;
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        
        // Add everything to this panel.
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Control the buttons events.
        btnExpand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C45TreeGUI.this.expandRows();
            }
        });
        
        btnCollapse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C45TreeGUI.this.collapseRows();
            }
        });
    }
    
    private void expandRows() {
        int row = 0;
        while(row < tree.getRowCount()) {
            tree.expandRow(row);
            row++;
        }
    }
    
    private void collapseRows() {
        int row = tree.getRowCount();
        while(row > 0) {
            tree.collapseRow(row);
            row--;
        }
    }
    
   public static JPanel createAndShowGUI(Tree tree) {
        // Make sure we have nice window decorations.
        //JFrame.setDefaultLookAndFeelDecorated(true);
        
        // Create and set up the window.
        //JFrame frame = new JFrame("Show C4.5 Tree");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and set up the content pane.
        C45TreeGUI contentPane = new C45TreeGUI(tree);
        contentPane.setOpaque(true); // Content pane must be opaque.
        return contentPane;
        //frame.setContentPane(contentPane);
        
        // Display the window.
        //frame.pack();
        //frame.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(new Tree(new Node("Funciona!!!")));
            }
        });
    }
}
