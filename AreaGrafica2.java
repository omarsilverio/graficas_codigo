import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class AreaGrafica2 extends Canvas{
    private JTextPane Convert;
    private String c;
    private String ca;

    public AreaGrafica2(){
        c="";
        ca="";
    }

    public void graficar(String cad,String cas){
        c=cad;
        ca=cas;
        repaint();
    }

    public void paint(Graphics g){
        
        int ab=20;
        int[] abAcum = new int[1];
        
        int aux_bip=266;
        g.setColor(Color.black);
        g.fillRect(23,230,699,80);
        for(int y=0;y<1;y++) abAcum[y]=115;

        g.setColor(Color.white);
        for(int j=114;j<=722;j+=11){
            g.drawLine(j,248+17,j+1,248+17);
            g.drawLine(j,248+37,j+1,248+37);
            g.drawLine(j,248+57,j+1,248+57);
        }
        g.setColor(Color.yellow);
        g.drawString("+v",98,248+17);
        g.drawString("0v",98,248+37);
        g.drawString("-v",98,248+57);

        g.drawString("Bipolar (AMI)",26,288);
        g.drawLine(113,230,113,310);
        // here i go
        for(int u=0;u<(c.length()<31?c.length():30);u++){
            g.setColor(Color.red);
            for(int q=230;q<=310;q+=10)
                g.drawLine(abAcum[0]+ab,q,abAcum[0]+ab,q+1);
            g.setColor(Color.green);
            g.drawString(""+c.charAt(u),abAcum[0]+6,250);
            int val=(int)(c.charAt(u))-48;

            if(val==1){

                g.drawLine(abAcum[0],aux_bip,abAcum[0],286); // vertical divisora pulso anterior y actual Bipolar
                g.drawLine(abAcum[0],aux_bip,(abAcum[0]+=ab),aux_bip); // medio pulso alto Bipolar
                g.drawLine(abAcum[0],aux_bip,abAcum[0],286); // vertical divisora medio pulso Bipolar
                aux_bip=(aux_bip==266?306:266); // cambiar valor pulso en alto para Bipolar
            }
            else{
                g.drawLine(abAcum[0],286,(abAcum[0]+=ab),286); // pulso bajo Bipolar  
            }
            
        }
        
    }    
}
