package Utils.GraphDistribution;
import algorithm.classification.Value;
import java.awt.geom.*;
import java.text.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.print.*;

public class Arcos extends JPanel {
    private double ini;
    private Color color;
    ArrayList values;
    DecimalFormat df = new DecimalFormat();
    public ArrayList text;
    double total;
    int n;
    
    public Arcos(ArrayList values) {
        setBackground(Color.WHITE);
        df.setMaximumFractionDigits(2);
        this.values = values;
        text = new ArrayList(values.size());
        total = 0;
        n = values.size();
        for(int i = 0; i < n; i++){
            int value = ((Value)values.get(i)).getFrecuence();
            total += value;
        }
        for(int i = 0; i < n; i++){
            Value value = (Value)values.get(i);
            text.add(value.getName() + ": " + df.format(value.getFrecuence()*100/total) + "% ["
                    + value.getFrecuence() + "/" + total + "]");
        }
    }
    
    public void porValores(Graphics2D g2) {
        double grados;
        int ancho = 185;
        int alto = 105;
        int x = 10;
        int y = 50;
        ini = 90.0;
        
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < n; j++){
                int value = ((Value)values.get(j)).getFrecuence();
                grados = value * 360 / total;
                color = this.getColor(j);
                g2.setPaint(color);
                g2.fill(new Arc2D.Double(x, y - i, ancho, alto, ini, grados, 2));
                ini += grados;
            }
        }
        color = new Color(245,245,245);
        color.brighter();
        g2.setPaint(color);
        g2.drawArc(x, y - 24, ancho, alto, 180, 180);
    }
    
    public static Color getColor(int n){
        switch(n){
            case 0:
                return Color.BLUE;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.RED;
            case 3:
                return Color.YELLOW.darker();
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.MAGENTA;
            case 6:
                return Color.PINK;
            case 7:
                return Color.LIGHT_GRAY;
            case 8:
                return Color.GRAY;
            case 9:
                return Color.DARK_GRAY;
        }
        return Color.BLACK;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        porValores(g2);
    }
}
