
package travel.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
   
public class ViewPackage extends JFrame implements ActionListener{
    
    JButton back;
     JLabel Labelname, Labelpackage, LabelPerson,Labelid, Labelnumber,Labelphone,LabelTprice;
    
    ViewPackage(String username){
        setBounds(450,200, 900, 450);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel text = new JLabel("View Package Details..");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0, 300, 30);
        add(text);
        
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(30, 50, 150, 25);
        add(lb1username);
        
        // Label for adding the name of the user in the name field from the backend...
        
        Labelname = new JLabel();
        Labelname.setBounds(220, 50, 150, 25);
        add(Labelname);
        
     // Label for adding the id of the user in the field from the backend...
        
        
        JLabel lb1Package = new JLabel("Package");
        lb1Package.setBounds(30, 90, 150, 25);
        add(lb1Package);
        
        // Label for adding the id given of the user in the id field from the  database...
        
        Labelpackage = new JLabel();
        Labelpackage.setBounds(220, 90, 150, 25);
        add(Labelpackage);
        
        
         // Label for adding the NUmaber of the user in the field from the backend...
        
        
        JLabel lb1Person = new JLabel("Total Persons");
        lb1Person.setBounds(30, 130, 150, 25);
        add(lb1Person);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        LabelPerson = new JLabel();
        LabelPerson.setBounds(220, 130, 150, 25);
        add(LabelPerson);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1id = new JLabel("Id");
        lb1id.setBounds(30, 170, 150, 25);
        add(lb1id);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelid = new JLabel();
        Labelid.setBounds(220, 170, 150, 25);
        add(Labelid);
        
        
        // Label for adding the id of the user in the field from the backend...
        
        JLabel lb1number = new JLabel("Id Number");
        lb1number.setBounds(30, 210, 150, 25);
        add(lb1number);
        
        // Label for adding the id no given of the user in the id field from the  database...
        
         Labelnumber = new JLabel();
        Labelnumber.setBounds(220, 210, 150, 25);
        add(Labelnumber);
        
        

        
        
        // Label for adding the phone NO of the user in the field from the backend...
        
        JLabel lblphone = new JLabel("phone");
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);
        
        // Label for adding the Country given of the user in the countyr field from the  database...
        
        Labelphone = new JLabel();
        Labelphone.setBounds(220, 250, 150, 25);
        add(Labelphone);
        
        // Label for adding the name of Address given by the user in the field from the backend...
        
        JLabel lblTprice = new JLabel("Total Price");
        lblTprice.setBounds(30, 290, 150, 25);
        add(lblTprice);
        
        // Label for adding the address given of the user in the address field from the  database...
        
        LabelTprice = new JLabel();
        LabelTprice.setBounds(220, 290, 150, 25);
        add(LabelTprice);
        
        
       
        
        // add back button for the action 
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // adding the image on the screen...
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        
   
        
        try{
            Connectivity conn = new Connectivity();
            String query = "Select *from PackageDetails where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                Labelname.setText(rs.getString("username"));
                Labelpackage.setText(rs.getString("package"));
                LabelPerson.setText(rs.getString("totalPerson"));
                Labelid.setText(rs.getString("id"));
                Labelnumber.setText(rs.getString("Idnumber"));
                LabelTprice.setText(rs.getString("totalPrice"));
                Labelphone.setText(rs.getString("phone"));
                
                
                
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
        new ViewPackage("Av1401");
    }
}

   
