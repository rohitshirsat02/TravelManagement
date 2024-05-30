
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Loginpage extends JFrame implements ActionListener{
    JTextField usertext, passtext;
    JButton login, signup, frgetp;
      Loginpage(){
          setSize(900,400);
          setLocation(350,200);
          setLayout(null);   
          
         getContentPane().setBackground(Color.WHITE);
          
          JPanel p1 = new JPanel();
          p1.setBackground(new Color(131, 193, 235));
          p1.setBounds(0,    0, 400, 400);
         // p1.setLayout(null);
          add(p1);
          
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
         Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(100, 120, 200, 200);
         p1.add(image);
          
         
         JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBounds(400, 30,450,300);
         add(p2);
         JLabel lb1username = new JLabel("Username");
         lb1username.setBounds(60, 20, 100, 25);
         lb1username.setFont(new Font("SAN_SARIF", Font.PLAIN, 18));
         p2.add(lb1username);
         usertext = new JTextField();
         usertext.setBounds(60, 60, 300, 30);
         p2.add(usertext);
         usertext.setBorder(BorderFactory.createEmptyBorder());
         
         /*=============================================================================*/
         JLabel lb1password = new JLabel("Password");
         lb1password.setBounds(60, 110, 100, 25);
         lb1password.setFont(new Font("SAN_SARIF", Font.PLAIN, 18));
         p2.add(lb1password);
         passtext = new JTextField();
         passtext.setBounds(60, 150, 300, 30);
         p2.add(passtext);
         passtext.setBorder(BorderFactory.createEmptyBorder());
         
      /*=============================================================================*/
      
         login = new JButton("Login");
         login.setBounds(60, 200, 130, 30);
         p2.add(login);
         login.setBackground(new Color(131, 193, 235));
         login.setForeground(Color.white);
         login.setBorder(new LineBorder(new Color(131, 193, 235)));
         login.addActionListener(this);
         
         signup = new JButton("SignUp");
         signup.setBounds(230, 200, 130, 30);
         p2.add(signup);
         signup.setBackground(new Color(131, 193, 235));
         signup.setForeground(Color.white);
         signup.setBorder(new LineBorder(new Color(131, 193, 235)));
         signup.addActionListener(this);
         
         frgetp = new JButton("Forget Password");
         frgetp.setBounds(130, 250, 150, 30);
         p2.add(frgetp);
         frgetp.setBackground(new Color(131, 193, 235));
         frgetp.setForeground(Color.white);
         frgetp.setBorder(new LineBorder(new Color(131, 193, 235)));
         frgetp.addActionListener(this);
         
       /*=============================================================================*/
         
         JLabel text = new JLabel("Trouble in Login....");
         text.setBounds(300, 250, 150, 20);
         p2.add(text);
         text.setForeground(Color.red);
         

          setVisible(true);
      }
       public void actionPerformed(ActionEvent ae)
       {
        if(ae.getSource()==login){
            
            try{
                String username = usertext.getText();
                String password = passtext.getText();
                
                String query = "select *from account where username = '"+usertext.getText()+"' AND password = '"+passtext.getText()+"'";
                
                Connectivity c = new Connectivity();
               ResultSet rs =  c.s.executeQuery(query);
               
               if(rs.next()){
                   setVisible(false);
                   new Loadingpage(username);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
               }
                
                
            } catch(Exception e){
                e.printStackTrace();
            }
          
            
       } else if(ae.getSource()== signup){
           setVisible(false);
           new SignUp();
           
       } else{
           setVisible(false);
           new forgetpass();
       }
           
       }
      
    public static void main(String[] args){
         new Loginpage();   //  created annynoms object 
  } 
}
