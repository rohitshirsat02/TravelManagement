
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;


public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
       JLabel lbl = new JLabel("About");
       lbl.setBounds(200, 10, 100, 40);
       lbl.setForeground(Color.red);
       lbl.setFont(new Font("Tahoma", Font.BOLD, 25));
       add(lbl);
       
       String s = "About Project   \n" +
       "\n" +
       "The objective of the travel management system project to develop a system that automates the process and activities of a travel and the purpose is to design a system using which one can perform all operation related to travelling \n" +
        "\n" +
        "This application will help in accessing the information related to the travel to the perticular destination with great ease. The user can track the information related to their tours with great ease through this application. The travel agency information can also be obtained through this application \n" +
         "\n" +
          "Advantages Of Project : \n" +
          " Gives accurate information. \n"+
          " Simplifies the manual work\n" +
         " It modified the documentation related work.\n"+
         "Provides up to date information \n"+
         "Friendly Environment by providing warning Massage.\n"+
         "Traverls details can be provided\n"+
         "Booking conformation notification" ;
          
       TextArea tArea = new TextArea(s, 10 , 40, Scrollbar.VERTICAL);
       tArea.setEditable(false);
       tArea.setBounds(20, 100, 450, 300);
       add(tArea);
       
        back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    
    
  public static  void main(String[] args){
      new About();
      
  }  
}
