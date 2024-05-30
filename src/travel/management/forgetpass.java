
package travel.management;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

 public class forgetpass extends JFrame implements ActionListener{
    JTextField usrtext, name,  secqus, secans, tfpassword ;
    JButton searchbtn, retrivebtn , backbtn ;  
    JLabel lb1secq, lb1name, lb1username , lb1secans, lb1password ;    
    forgetpass(){
        
        // create a one screen of this length
        setBounds(340, 200, 850, 350 );
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        
        //create a panel that visualise screenn  divides with two parts
       JPanel p1 = new JPanel();
      //p1.setBackground(new Color(131, 193, 235));
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);
        
        // for add the image on the panel ....
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/forgotpassword.jpg"));
         Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(580, 70, 200, 200);
         add(image);
         
         // create a label for the username...
         
          lb1username = new JLabel("username");
        lb1username.setFont(new Font("TAHOMA", Font.BOLD, 15));
        lb1username.setBounds(40, 20, 105, 25);
        p1.add(lb1username);
        
        // add textfield for that taking the input from the user...
         usrtext = new JTextField();
         usrtext.setBounds(220, 20, 150, 25);
        
         usrtext.setBorder(BorderFactory.createEmptyBorder());
          p1.add(usrtext);
          
          // create a search button that get the details from the username for the user
          
           searchbtn = new JButton("search");
         searchbtn.setBounds(380, 20, 100, 25);
         p1.add(searchbtn);
         searchbtn.setBackground(Color.WHITE);
         searchbtn.setForeground(new Color(133, 193, 233));
        searchbtn.setBorder(new LineBorder(new Color(131, 193, 235)));
         searchbtn.setFont(new Font("Tahoma",Font.BOLD, 10));
         searchbtn.addActionListener(this);
         
         // create a label for gettig name of the user for validation...
         
         
        lb1name = new JLabel("Name");
        lb1name.setFont(new Font("TAHOMA", Font.BOLD, 13));
        lb1name.setBounds(40, 60, 100, 25);
        p1.add(lb1name);
        
        // add textfield for that taking the input from the user...
          name  = new JTextField();
         name.setBounds(220, 60, 150, 25);
        
        name.setBorder(BorderFactory.createEmptyBorder());
          p1.add(name);
         // creat a label that take the sec question from the user for validation..
        lb1secq = new JLabel("Your Security Question");
        lb1secq.setFont(new Font("TAHOMA", Font.BOLD, 13));
        lb1secq.setBounds(40, 100, 160, 25);
        p1.add(lb1secq);
          
        // creat a label that take the sec question from the user for validation..
        lb1secq = new JLabel("Your Security Question");
        lb1secq.setFont(new Font("TAHOMA", Font.BOLD, 13));
        lb1secq.setBounds(40, 100, 160, 25);
        p1.add(lb1secq);
        
        // add textfield for that taking the input from the user...
         secqus = new JTextField();
         secqus.setBounds(220, 100, 150, 25);
        
         secqus.setBorder(BorderFactory.createEmptyBorder());
          p1.add(secqus);
          
        // creat a label that take the answer of sec question from the user for validation..
        lb1secans= new JLabel("Answer");
        lb1secans.setFont(new Font("TAHOMA", Font.BOLD, 13));
        lb1secans.setBounds(40, 140, 160, 25);
        p1.add(lb1secans);
        
        // add textfield for that taking the input from the user...
         secans = new JTextField();
         secans.setBounds(220, 140, 150, 25);
        
         secans.setBorder(BorderFactory.createEmptyBorder());
          p1.add(secans);
          
          // create button for retrive the ans of the sec question
        
         retrivebtn = new JButton("Retrive");
         retrivebtn.setBounds(380, 140, 100, 25);
         p1.add(retrivebtn);
         retrivebtn.setBackground(Color.WHITE);
         retrivebtn.setForeground(new Color(133, 193, 233));
        retrivebtn.setBorder(new LineBorder(new Color(131, 193, 235)));
        retrivebtn.setFont(new Font("Tahoma",Font.BOLD, 10));
        retrivebtn.addActionListener(this);
        
       //**********************************************************************************//
        
        // creat a label that take the answer of sec question from the user for validation..
        lb1password= new JLabel("Password");
        lb1password.setFont(new Font("TAHOMA", Font.BOLD, 13));
        lb1password.setBounds(40, 180, 160, 25);
        p1.add(lb1password);
        
        // add textfield for that taking the input from the user...
         tfpassword = new JTextField();
         tfpassword.setBounds(220, 180, 150, 25);
        
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
          p1.add(tfpassword);
          
          // create button for retrive the ans of the sec question
        
         backbtn = new JButton("back");
         backbtn.setBounds(150, 230, 100, 25);
         p1.add(backbtn);
         backbtn.setBackground(Color.WHITE);
         backbtn.setForeground(new Color(133, 193, 233));
        backbtn.setBorder(new LineBorder(new Color(131, 193, 235)));
        backbtn.setFont(new Font("Tahoma",Font.BOLD, 10));
        backbtn.addActionListener(this);

        setVisible(true);
        
        
    }
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == searchbtn){  // for geting the  answer of name and security textfield after take the input from the user in the  
                try{
                    
                    String query = "select *from account where username = '"+usrtext.getText()+"'";  // username textfield (complete the above sentecnce
                    Connectivity c = new Connectivity();
                   ResultSet rs =  c.s.executeQuery(query);
                   
                   while(rs.next()){
                      name.setText(rs.getString("name"));
                       secqus.setText(rs.getString("question"));
                   }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if (ae.getSource() == retrivebtn ){
                
                 try{
                    
                    String query = "select *from account where answer = '"+secans.getText()+"' AND username = '"+usrtext.getText()+"'";  
// username textfield (complete the above sentecnce
                    Connectivity c = new Connectivity();
                   ResultSet rs =  c.s.executeQuery(query);
                   
                   while(rs.next()){
                      tfpassword.setText(rs.getString("password"));
                       
                   }
                } catch(Exception e){
                    e.printStackTrace();
                }

                
            }
            else{
                setVisible(false);
                new Loginpage();
            }
                
            
        }
        

        
    
    public static void main(String[] args ){
        new forgetpass();
    }
}
