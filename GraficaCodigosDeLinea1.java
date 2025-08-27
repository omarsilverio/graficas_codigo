import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GraficaCodigosDeLinea1 extends JFrame  implements WindowListener, TextListener, AdjustmentListener, ActionListener{

  private JLabel mensaje, str, desde, hasta, cuantos, con, cod;
  private JTextPane Convert;
  private JScrollPane sc1;
  private JButton convertir,limpiar;
  private TextField caja,rango1,rango2,cuantosnum;
  private JTextArea areaescritura;//Llamar un jTextArea para introducirle el texto
  private AreaGrafica2 graf;
  private Scrollbar barra;
  private Panel panel;
  private String ca="";
  
    /**
     *
     * @param args
     */
    public static void main(String[] args){
    GraficaCodigosDeLinea1 obj = new GraficaCodigosDeLinea1();
  }

  public GraficaCodigosDeLinea1(){
    setVisible(true);
    setTitle("Graficando codigos de linea");
    setSize(750,480);
    setLocation(20,20);
    setResizable(false);
    setBackground(Color.blue);
    addWindowListener(this);
    Panel panel = new Panel();
    panel.setLayout(new FlowLayout());
    add(panel,BorderLayout.NORTH);
    
    str = new JLabel("Ingrese el rango de numeros:");
    panel.add(str);
    str.setBackground(Color.white);
    
    desde = new JLabel("Desde:");
    panel.add(desde);
    desde.setBackground(Color.white);
    
    rango1 = new TextField(5);
    rango1.addTextListener(this);
    panel.add(rango1);
    rango1.setBackground(Color.white);
    
    hasta = new JLabel("Hasta:");
    panel.add(hasta);
    hasta.setBackground(Color.white);
    
    rango2 = new TextField(5);
    rango2.addTextListener(this);
    panel.add(rango2);
    rango2.setBackground(Color.white);
    
    cuantos = new JLabel("¿Cuantos valores?:");
    panel.add(cuantos);
    cuantos.setBackground(Color.white);
    
    cuantosnum = new TextField(5);
    cuantosnum.addTextListener(this);
    panel.add(cuantosnum);
    cuantosnum.setBackground(Color.white);
    
    convertir = new JButton("Convertir");
    panel.add(convertir);
    convertir.addActionListener(this);
    convertir.setBackground(Color.white);
    
    /*str = new Label("O ingrese el numero en binario: ");
    panel.add(str);
    str.setBackground(Color.white);*/
    
    caja = new TextField(57);
    caja.addTextListener(this);
    panel.add(caja);
    caja.setBackground(Color.white);
    
    graf = new AreaGrafica2();    
    add(graf,BorderLayout.CENTER);
    
    barra = new Scrollbar(0, 1, 1, 1, 1);
    barra.addAdjustmentListener(this);
    add(barra,BorderLayout.SOUTH);
    
    areaescritura = new JTextArea();//agregar un area de texto con borderLayout solo lo puedes agreagr en la izquierda o derecha por que ya ocupaste south North center
    areaescritura.setText("Texto");
    this.add(areaescritura,BorderLayout.EAST);
    
    validate();
  }
  
  public void cuantificar(){
        String ran1 = rango1.getText();
        String ran2 = rango2.getText();
        String cnum = cuantosnum.getText();
        int r1 = Integer.parseInt(ran1);
        int r2 = Integer.parseInt(ran2);
        int cuantosn = Integer.parseInt(cnum);
        String bin;
        String imp="";
        String bins="";
        for (int i=0; i<cuantosn; i++){
            int num = (int)(Math.random()*(r2-r1+1)+r1);
            bin = Integer.toBinaryString(Math.abs(num));
            if(bin.length()<2 && num>=0){
                imp+= num+"  =        "+"0000000"+bin+"\n";
            }else
            if(bin.length()<2 && num<0){
                imp+= num+"  =        "+"1000000"+bin+"\n";
            }else
            if(bin.length()<3 && num>=0){
                imp+= num+"  =        "+"000000"+bin+"\n";
            }else
            if(bin.length()<3 && num<0){
                imp+= num+"  =        "+"100000"+bin+"\n";
            }else
            if(bin.length()<4 && num>=0){
                imp+= num+"  =        "+"00000"+bin+"\n";
            }else
            if(bin.length()<4 && num<0){
                imp+= num+"  =        "+"10000"+bin+"\n";
            }else
            if(bin.length()<5 && num>=0){
                imp+= num+"  =        "+"0000"+bin+"\n";
            }else
            if(bin.length()<5 && num<0){
                imp+= num+"  =        "+"1000"+bin+"\n";
            }else
            if(bin.length()<6 && num>=0){
                imp+= num+"  =        "+"000"+bin+"\n";
            }else
            if(bin.length()<6 && num<0){
                imp+= num+"  =        "+"100"+bin+"\n";
            }else
            if(bin.length()<7 && num>=0){
                imp+= num+"  =        "+"00"+bin+"\n";
            }else
            if(bin.length()<7 && num<0){
                imp+= num+"  =        "+"10"+bin+"\n";
            }else
            if(bin.length()<8 && num>=0){  
                imp+= num+"  =        "+"0"+bin+"\n";
            }else
            if(bin.length()<8 && num<0){
                imp+= num+"  =        "+"1"+bin+"\n";
            }else{
                imp+= num+"  =        "+bin+"\n";
            }

            if(bin.length()<2 && num>=0){
                bins+= "0000000"+bin;
            }else
            if(bin.length()<2 && num<0){
                bins+= "1000000"+bin;
            }else
            if(bin.length()<3 && num>=0){
                bins+= "000000"+bin;
            }else
            if(bin.length()<3 && num<0){
                bins+= "100000"+bin;
            }else
            if(bin.length()<4 && num>=0){
                bins+= "00000"+bin;
            }else
            if(bin.length()<4 && num<0){
                bins+= "10000"+bin;
            }else
            if(bin.length()<5 && num>=0){
                bins+= "0000"+bin;
            }else
            if(bin.length()<5 && num<0){
                bins+= "1000"+bin;
            }else
            if(bin.length()<6 && num>=0){
                bins+= "000"+bin;
            }else
            if(bin.length()<6 && num<0){
                bins+= "100"+bin;
            }else
            if(bin.length()<7 && num>=0){
                bins+= "00"+bin;
            }else
            if(bin.length()<7 && num<0){
                bins+= "10"+bin;
            }else
            if(bin.length()<8 && num>=0){  
                bins+= "0"+bin;
            }else
            if(bin.length()<8 && num<0){
                bins+= "1"+bin;
            }else
                bins+= bin;

        }
        caja.setText(bins);
        ca+=(imp+"\n"+bins);
        System.out.println(imp+"\n"+bins);
    }

  public void windowClosing(WindowEvent ev){
    System.exit(0);
  }
  public void windowClosed(WindowEvent ev){}
  public void windowOpened(WindowEvent ev){}
  public void windowActivated(WindowEvent ev){}
  public void windowDeactivated(WindowEvent ev){}
  public void windowIconified(WindowEvent ev){}
  public void windowDeiconified(WindowEvent ev){}

  public void textValueChanged(TextEvent e){
    if(vale(caja.getText())){
      if((caja.getText().length()-29)>0)
        barra.setMaximum(caja.getText().length()-29);
      else
        barra.setMaximum(1);
      barra.setValue(-1);
      validate();
      graf.graficar(caja.getText(),ca);
      //caja.setBackground(Color.white);
    }
    else{
      graf.graficar("","");
      //caja.setBackground(Color.red);
    }
  }

  private boolean vale(String a){
    for(int i=0;i<a.length();i++)
      if(a.charAt(i)!='0' && a.charAt(i)!='1')
        return false;
    return true;
  }

  public void adjustmentValueChanged(AdjustmentEvent e){
    String subCad = caja.getText().substring(barra.getValue(),caja.getText().length());
    graf.graficar(subCad,ca);
  }
  
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton=(JButton) ae.getSource();
        if (boton == convertir){//Ejecuta el metodo suma
            cuantificar();
            
        }
        if (boton == limpiar){//Limpia todos los campos
            rango1.setText("");
            rango2.setText("");
            cuantosnum.setText("");
        }
    }
}
