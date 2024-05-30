package travel.management;

import javax.swing.*;
import java.awt.*;
public class Spalsh  extends JFrame implements Runnable{
    Thread thread;
    
     Spalsh(){
         
         //setSize(1100, 600);
         //setLocation(200,100);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bora.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1250, 600, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         add(image);
         
         setVisible(true);
         thread = new Thread(this);
         thread.start();
         
     }
      public void run() {
             try {
                 Thread.sleep(4000);
                  new Loginpage();
                 setVisible(false);
             } catch (Exception e){}
         }
         
    
    
    public static void main(String args[]){
        
     Spalsh frame = new Spalsh();
     int x = 1;
     for(int i=1; i<=500; x+=6, i+=5){
        frame.setLocation(450-(x+i)/4, 200-(i/8));
        frame.setSize(x+(i/2), i+2);
        
        try{
            Thread.sleep(6);
           //
        } catch (Exception e){ }
        
        
        
    }
     
     
  }
}
