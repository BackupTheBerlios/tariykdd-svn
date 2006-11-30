/*
 * AssociationIcon.java
 *
 * Created on 26 de mayo de 2006, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.Icons.Association;

import Utils.AvlTree;
import algorithm.association.Apriori.Apriori;
import algorithm.association.EquipAsso.EquipAsso;
import algorithm.association.FPGrowth.FPGrowth;
import Utils.DataSet;
import gui.Icons.DBConnection.DBConnectionIcon;
import gui.Icons.Rules.RulesIcon;
import gui.KnowledgeFlow.Chooser;
import gui.KnowledgeFlow.Icon;
import gui.KnowledgeFlow.JackAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author ivan
 */
public class AssociationIcon extends Icon{
    private JMenuItem mnuConfigure;
    private JMenuItem mnuRun;
    public String algorithm;
    public configureSupport cs;
    public DataSet dataset;
    public double  support;
    public Vector trees;
    
    /** Creates a new instance of DBConnectionIcon */
    public AssociationIcon(JLabel s, int x, int y) {
        super(s, x, y);
        super.constrainsTo = new ArrayList(1);
        super.constrainsTo.add("RulesIcon");
        algorithm = s.getText();
        
        if(super.froms.size() > 0){
            dataset = ((DBConnectionIcon)super.froms.get(0)).dataset;
        }
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
        final AssociationIcon ai = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cs = new configureSupport(ai);
                cs.setVisible(true);
            }
        });
    }
    
    private void mnuRunActionPerformed(java.awt.event.ActionEvent evt) {
        short s = (short) ( (support * dataset.getNtransactions()) / 100 );
        System.out.println("Support " + s + " for " + algorithm);
        JackAnimation jack = new JackAnimation();
        this.add(jack);
        this.setComponentZOrder(jack, 0);
        jack.setBounds(this.animation.getX(), this.animation.getY(), 36, 36);
        this.setAnimation(jack);
        AvlTree frequentsOne = new AvlTree();
        dataset.pruneCandidatesOne(s, frequentsOne);
        if(frequentsOne.howMany() > 0){
            if(algorithm.equals("Apriori")){
                Apriori apriori = new Apriori(dataset, s);
                this.startAnimation();
                apriori.setAnimation(jack);
                apriori.start();
                trees = apriori.getFrequents();
            } else if(algorithm.equals("FPGrowth")){
                FPGrowth fpgrowth = new FPGrowth(dataset, s);
                this.startAnimation();
                fpgrowth.setAnimation(this.animation);
                fpgrowth.start();
                trees = fpgrowth.getFrequents();
            } else if(algorithm.equals("EquipAsso")){
                EquipAsso equipasso = new EquipAsso(dataset, s);
                this.startAnimation();
                equipasso.setAnimation(this.animation);
                equipasso.start();
                trees = equipasso.getFrequents();
            }
            Iterator it = tos.iterator();
            while(it.hasNext()){
                Icon icon = (Icon)it.next();
                if(icon instanceof RulesIcon){
                    ((RulesIcon)icon).trees = trees;
                    ((RulesIcon)icon).dataset = dataset;
                    ((RulesIcon)icon).support = s;
                    ((RulesIcon)icon).title = algorithm;
                }
            }
        } else {
            Chooser.setStatus("Not Found larges itemsets");
        }
    }
}
