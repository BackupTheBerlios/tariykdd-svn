
package c45;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.tree.*;

//@author endimeon

public class Entropia {
    
    double gain=0,entropiaS=0,entroini=0;
    double vecentro[];
    double vecS[];
    int cuantos[][];
    
    public Entropia(ArrayList cuantosg){
        int den = 0;
        int n = cuantosg.size();
        float aux;
        float nuecu[] = new float[n];
        ////////////////////////////
        
        for(int k=0; k < n; k++){
            den = den + Integer.parseInt(((Integer)cuantosg.get(k)).toString());
        }
        
        for(int k=0; k < n; k++){
            aux = Float.parseFloat(((Integer)cuantosg.get(k)).toString());
            nuecu[k]=aux/den;
        }
        
        for(int k=0; k < n; k++){
            entroini = entroini - (nuecu[k]*lg(nuecu[k]));
        }
    }
    
    public Entropia(int nrutas, TreeNode rutas[][],  int cuantosg[][], int nrtsbus, int nclsbus, String rtsbusqueda[][]) { 
        cuantos = cuantosg;
        vecentro = new double[nrtsbus];
        int bdrev=0,ccc=0;
        float pex[];
        float denex=0;
        float den=0;
        float denrsin[] = new float[cuantos.length];
        ////////////////////////////////

        int bdesta=0, pfb=0;           
        int filas[] = new int[30];
        
        for(int rtb=0; rtb < nrtsbus; rtb++){  
            denex = 0;
            pfb = 0;
            for(int nrt=0; nrt < nrutas; nrt++){ 
                for(int clam=0; clam < nclsbus; clam++){ 
                    if(rtsbusqueda[rtb][clam]==rutas[nrt][clam].toString()) {
                        bdesta++;
                    }
                }
                
                if(bdesta==nclsbus) {
                    den=0;
                    for(int n=0; n < cuantos[0].length; n++){
                        den = den + cuantos[nrt][n];
                    }
                    denrsin[pfb]=den; 
                    
                    denex = denex + denrsin[pfb]; 
                    
                    filas[pfb]=nrt;
                    
                    pfb++;
                    
                    bdesta=0; 
                    
                } else{
                    bdesta=0;
                }
            }
            vecS = new double[pfb];
            pex = new float[pfb];
            entropiaS = 0;
            for(int cp=0; cp < pfb; cp++){
                pex[cp] = denrsin[cp]/denex;  
                vecS[cp] = entro(denrsin[cp],filas[cp]); 
                entropiaS = entropiaS - (pex[cp]*vecS[cp]); 
            }
            vecentro[rtb]=entropiaS;
        }
        
    }
    
    public double entro(float din, int fl) {
        float pin[] = new float[cuantos[0].length];
        double entropia=0;
        int ccc=0;
        
        for(int n=0; n < cuantos[0].length; n++){
            pin[n] = cuantos[fl][n]/din;
        }
        
        for(int n=0; n < cuantos[0].length; n++){
            entropia = entropia + (pin[n]*lg(pin[n]));
        }
        return(entropia);
    }
    
    
    public double[] entroS() {
        return(vecentro);
    }
    
    public double entroIni() {
        return(entroini);
    }
    
    public double[] vecS() {
        return(vecS);
    }
    
    public double gain() {
        return(gain);
    }
    
    public double lg(float val) {
        if(val == 0.0) return 0.0;
        double log;
        log=Math.log(val)/Math.log(2);
        return(log);
    }
}
