
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;

public class Loadingpage  extends JFrame implements Runnable{
    
    String username;
    Thread t;
    JProgressBar bar;
    
    public void run(){
        try {
            for(int i=1; i<=101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                    
                } else {
                    setVisible(false);
                    // new class object
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
    
    Loadingpage(String username){
        this.username = username;
         t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel And Tourism Management..");
        text.setBounds(40, 20 ,600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 30));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 100, 350, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading. Please wait...");
        loading.setBounds(230, 130 ,250, 40);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);
        
        JLabel lb1username = new JLabel("Welcome  "  + username);
        lb1username.setBounds(20, 310 ,400, 40);
        lb1username.setForeground(Color.red);
        lb1username.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lb1username);
        t.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new Loadingpage("");
    }
}
