// signup page for the user to get the data from the user........
package travel.management;
import javax.swing.*;
import java.awt.Color;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
    
    JButton createbtn, backbtn;
    JTextField usertext,Nametext, passwordtext, anstext ;
    JLabel lb1username,lb1name,lb1password,lb1secq,lb1answer,image ; 
    Choice secq;
    SignUp() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 235));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        //================================================================//
        //label for username from the user
        lb1username = new JLabel("Username");
        lb1username.setFont(new Font("TAHOMA", Font.BOLD, 18));
        lb1username.setBounds(50, 20, 125, 25);
        p1.add(lb1username);
        
         usertext = new JTextField();
         usertext.setBounds(190, 20, 180, 25);
         p1.add(usertext);
         usertext.setBorder(BorderFactory.createEmptyBorder());
        
         // Label for to get the user name
         lb1name = new JLabel("Name");
        lb1name.setFont(new Font("TAHOMA", Font.BOLD, 18));
        lb1name.setBounds(50, 60, 125, 25);
        p1.add(lb1name);
        
         Nametext = new JTextField();
         Nametext.setBounds(190, 60, 180, 25);
         p1.add(Nametext);
         Nametext.setBorder(BorderFactory.createEmptyBorder());
        
         // Label gor to get the passwrd from the user
         
          lb1password = new JLabel("Password");
        lb1password.setFont(new Font("TAHOMA", Font.BOLD, 18));
        lb1password.setBounds(50, 100, 125, 25);
        p1.add(lb1password);
        
         passwordtext = new JTextField();
         passwordtext.setBounds(190, 100, 180, 25);
         p1.add(passwordtext);
         passwordtext.setBorder(BorderFactory.createEmptyBorder());
        
         // laabel for security question 
         
         lb1secq = new JLabel("Security question");
        lb1secq.setFont(new Font("TAHOMA", Font.BOLD, 10));
        lb1secq.setBounds(50, 140, 125, 25);
        p1.add(lb1secq);
        
        secq = new Choice();
        secq.add("Fav game");
        secq.add("what is your pet name");
        secq.add("best person for you");
        secq.add("what is you lucky number");
        secq.setBounds(190, 140, 180, 25);
        p1.add(secq);
        
        // take the answer from the usr for this security question
        lb1answer = new JLabel("Answer");
        lb1answer.setFont(new Font("TAHOMA", Font.BOLD, 18));
        lb1answer.setBounds(50, 180, 125, 25);
        p1.add(lb1answer);
        
         anstext = new JTextField();
         anstext.setBounds(190, 180, 180, 25);
         p1.add(anstext);
         anstext.setBorder(BorderFactory.createEmptyBorder());
         
         // button for the creation....
         
         createbtn = new JButton("Create");
         createbtn.setBounds(80, 250, 130, 30);
         p1.add(createbtn);
         createbtn.setBackground(Color.WHITE);
         createbtn.setForeground(new Color(133, 193, 233));
         //createbtn.setBorder(new LineBorder(new Color(131, 193, 235)));
         createbtn.setFont(new Font("Tahoma",Font.BOLD, 10));
         createbtn.addActionListener(this);
        
         // button for privious page....
         
         backbtn = new JButton("Back");
         backbtn.setBounds(250, 250, 130, 30);
         p1.add(backbtn);
         backbtn.setBackground(Color.white);
         backbtn.setForeground(new Color(133, 193, 233));
         //createbtn.setBorder(new LineBorder(new Color(131, 193, 235)));
         backbtn.setFont(new Font("Tahoma",Font.BOLD, 10));
         backbtn.addActionListener(this);
         
        //add image for the right side of the panel....
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/signup.png"));
         Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         image = new JLabel(i3);
         image.setBounds(580, 50, 250, 250);
         add(image);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == createbtn){
             String username = usertext.getText();
             String name =  Nametext.getText();
             String password = passwordtext.getText();
             String question = secq.getSelectedItem();
             String answer =  anstext.getText();
             
             //String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
             String query = "insert into account (username, name, password, question, answer) values ('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";

              try{ 
                  
                  Connectivity c = new Connectivity();
                  c.s.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Account Created Successfully");
                  setVisible(false);
                  new Loginpage();
                  
              } 
            
              catch(Exception e){
                      e.printStackTrace();
                      }
         }
                  
            else if (ae.getSource() == backbtn ){
                setVisible(false);
                new Loginpage();
                
            }
                   
        
    }
    
    public static void main(String[] args){
       new SignUp(); 
    }
}
