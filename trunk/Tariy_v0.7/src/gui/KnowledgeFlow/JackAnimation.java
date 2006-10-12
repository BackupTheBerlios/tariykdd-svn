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
public class JackAnimation extends AnimationLabel{
    
    ImageIcon[] images = new ImageIcon[7];
    Timer timer = new Timer(50, this);
    int n = 0;
    /** Creates a new instance of AnimationLabel */
    public JackAnimation() {
        for(int i = 0; i < 7; i++){
            images[i] = new ImageIcon(getClass().getResource(
                    "/images/animation/j" + (i + 1) + ".png"));
        }
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
        container.add(this);
        this.setBounds(x, y, 36, 36);
    }
    
    public void actionPerformed(ActionEvent e) {
        this.setIcon(images[n]);
        n++;
        if(n > 6) n = 0;
    }
}
