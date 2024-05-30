
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewCustomer(String username){
        setBounds(450,180, 870, 625);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(30, 50, 150, 25);
        add(lb1username);
        
        // Label for adding the name of the user in the name field from the backend...
        
        JLabel name = new JLabel();
        name.setBounds(220, 50, 150, 25);
        add(name);
        
     // Label for adding the id of the user in the field from the backend...
        
        
        JLabel lb1id = new JLabel("id");
        lb1id.setBounds(30, 110, 150, 25);
        add(lb1id);
        
        // Label for adding the id given of the user in the id field from the  database...
        
        JLabel Labelid = new JLabel();
        Labelid.setBounds(220, 110, 150, 25);
        add(Labelid);
        
        
         // Label for adding the NUmaber of the user in the field from the backend...
        
        
        JLabel lb1Number = new JLabel("Number");
        lb1Number.setBounds(30, 170, 150, 25);
        add(lb1Number);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        JLabel LabelNumber = new JLabel();
        LabelNumber.setBounds(220, 170, 150, 25);
        add(LabelNumber);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(30, 230, 150, 25);
        add(lb1name);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        JLabel Labelname = new JLabel();
        Labelname.setBounds(220, 230, 150, 25);
        add(Labelname);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1gender = new JLabel("Gender");
        lb1gender.setBounds(30, 290, 150, 25);
        add(lb1gender);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        JLabel Labelgender = new JLabel();
        Labelgender.setBounds(220, 290, 150, 25);
        add(Labelgender);
        
        
        
        // add the label on the right side of the screen for the ramaing fields..
        
        
        // Label for adding the name of Country given by the user in the field from the backend...
        
        JLabel lb1country = new JLabel("Country");
        lb1country.setBounds(500, 50, 150, 25);
        add(lb1country);
        
        // Label for adding the Country given of the user in the countyr field from the  database...
        
        JLabel LabelCountry = new JLabel();
        LabelCountry.setBounds(690, 50, 150, 25);
        add(LabelCountry);
        
        // Label for adding the name of Address given by the user in the field from the backend...
        
        JLabel lb1address = new JLabel("Address");
        lb1address.setBounds(500, 110, 150, 25);
        add(lb1address);
        
        // Label for adding the address given of the user in the address field from the  database...
        
        JLabel LabelAddress = new JLabel();
        LabelAddress.setBounds(690, 110, 150, 25);
        add(LabelAddress);
        
        
        //add label for the email field
        
         JLabel lb1email = new JLabel("Email");
        lb1email.setBounds(500, 170, 150, 25);
        add(lb1email);
        
        // Label for adding the email given of the user in the email field from the  database...
        
        JLabel LabelEmail = new JLabel();
        LabelEmail.setBounds(690, 170, 150, 25);
        add(LabelEmail);
        
         //add label for the phone field
        
         JLabel lb1Phone = new JLabel("Phone");
        lb1Phone.setBounds(500, 230, 150, 25);
        add(lb1Phone);
        
        // Label for adding the email given of the user in the email field from the  database...
        
        JLabel LabelPhone = new JLabel();
        LabelPhone.setBounds(690, 230, 150, 25);
        add(LabelPhone);
        
        // add back button for the action 
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // adding the image on the screen...
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);
        
        
        //ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
       // Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        //ImageIcon i6 = new ImageIcon(i5);
       // JLabel image2 = new JLabel(i6);
        //image.setBounds(600,400,600,200);
        //add(image2);
        
        
        try{
            Connectivity conn = new Connectivity();
            String query = "Select *from PersonalDetails where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("username"));
                Labelid.setText(rs.getString("id"));
                LabelNumber.setText(rs.getString("number"));
                Labelname.setText(rs.getString("name"));
                Labelgender.setText(rs.getString("gender"));
                LabelCountry.setText(rs.getString("country"));
                LabelAddress.setText(rs.getString("address"));
                LabelEmail.setText(rs.getString("email"));
                LabelPhone.setText(rs.getString("phone"));
                
                
                
            }
                
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    
    public static void main(String args[]){
        new ViewCustomer("Rohit");
    }
}
