/*
 * AnimationLabel.java
 *
 * Created on 28 de mayo de 2006, 09:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.KnowledgeFlow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionListener;

/**
 *
 * @author and
 */
public class AnimationLabel extends javax.swing.JLabel
        implements ActionListener{
    
    ImageIcon[] images = new ImageIcon[31];
    Timer timer = new Timer(100, this);
    int n = 0;
    /** Creates a new instance of AnimationLabel */
    public AnimationLabel() {
        for(int i = 0; i < 31; i++){
            images[i] = new ImageIcon(getClass().getResource(
                    "/images/animation/a" + (i + 1) + ".png"));
        }
        this.setName("MyIcon");
    }
    
    public void run() {
        if(!timer.isRunning()){
            this.setVisible(true);
            timer.start();
        }
    }
    
    public void stop(){
        this.setVisible(false);
        timer.stop();
        this.getParent().getParent().repaint();
    }
    
    public void addAnimation(Container container, int x, int y){
        container.add(this, 0);
        this.setBounds(x, y, 36, 36);
    }
    
    public void actionPerformed(ActionEvent e) {
        this.setIcon(images[n]);
        n++;
        if(n > 30) n = 0;
    }
    
}
