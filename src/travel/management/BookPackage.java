
package travel.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel  labelname,Labelid, Labelnumber, Labelphone, Labeltotalprice,lb1Person; 
    JButton Checkprice, BookPackage, Back;
    
    BookPackage(String username){
        this.username = username;
        setBounds(350, 200, 1100, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 20);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(40, 70, 100, 20);
        lb1username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1username);
        
        // Label for adding the name of the user in the name field from the backend...
        
        labelname = new JLabel();
        labelname.setBounds(250, 70, 200, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelname);
        
     // Label for adding the id of the user in the field from the backend...
        
        
        JLabel lb1select = new JLabel("Select Package");
        lb1select.setBounds(40, 110, 150, 22);
        lb1select.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1select); 
        
        // create a Dropdown for selecting the package..
        
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);
        
        
         // Label for adding the NUmaber of the persons  in the trip...
        
        
        lb1Person = new JLabel("Tota Persons");
        lb1Person.setBounds(40, 150, 150, 25);
        lb1Person.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1Person);
        
        // create textfield for adding the person in trip
        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);
        
        
        
        // Label for adding the id of the user in the field 
        
        JLabel lb1id = new JLabel("Id");
        lb1id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1id.setBounds(40, 190, 150, 20);
        add(lb1id);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelid = new JLabel();
        Labelid.setBounds(250, 190, 200, 25);
        add(Labelid);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1Number = new JLabel("Id Number");
        lb1Number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1Number.setBounds(40, 230, 150, 25);
        add(lb1Number);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelnumber = new JLabel();
        Labelnumber.setBounds(250, 230, 150, 25);
        add(Labelnumber);
        
        
        
        // add the label on the right side of the screen for the ramaing fields..
        
        
        // Label for adding the name of Country given by the user in the field from the backend...
        
        JLabel lb1Phone = new JLabel("Phone NO");
        lb1Phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1Phone.setBounds(40, 270, 150, 20);
        add(lb1Phone);
        
        // Label for adding the Country given of the user in the countyr field from the  database...
        
        Labelphone = new JLabel();
        Labelphone.setBounds(250, 270, 200, 25);
        add(Labelphone);
        
        // Label for adding the name of Address given by the user in the field from the backend...
        
        JLabel lb1totalprice = new JLabel("Total Price");
        lb1totalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1totalprice.setBounds(40, 310, 150, 20);
        add(lb1totalprice);
        
        // Label for adding the address given of the user in the address field from the  database...
        
        Labeltotalprice = new JLabel();
        Labeltotalprice.setBounds(250, 310, 200, 25);
        add(Labeltotalprice);
        
        
        
        
         try{
            Connectivity conn = new Connectivity();
            String query = "Select *from PersonalDetails where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("username"));
                Labelid.setText(rs.getString("id"));
                Labelnumber.setText(rs.getString("number"));
                Labelphone.setText(rs.getString("phone"));
                Labeltotalprice.setText(rs.getString(""));
                
                
                
            }
                
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        Checkprice  = new JButton("CheckPrice");
        Checkprice.setBounds(60, 380, 120, 25);
        Checkprice.setBackground(Color.BLACK);
        Checkprice.setForeground(Color.white);
        Checkprice.addActionListener(this);
        add(Checkprice);
        
        
        BookPackage  = new JButton("BookPackage");
        BookPackage.setBounds(200, 380, 120, 25);
        BookPackage.setBackground(Color.BLACK);
        BookPackage.setForeground(Color.white);
        BookPackage.addActionListener(this);
        add(BookPackage);
        
        
        Back  = new JButton("Back");
        Back.setBounds(340, 380, 120, 25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);
        
        // add image on the screen 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);
        
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
                
            } else if(pack.equals("Silver Package")){
                cost += 32000;
         
        }
            else{
                cost += 24000;
            }
            
            // calculate the cost of persons those going to trip 
               
            int tpersons = Integer.parseInt(tfperson.getText());
            cost *= tpersons;
            Labeltotalprice.setText("Rs " +cost);
            
            
        } else if(ae.getSource() == BookPackage){
            // for saving the details of bookpackage in the database..
            
            try{
                Connectivity conn = new Connectivity();
                conn.s.executeUpdate("insert into PackageDetails values('"+labelname.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+Labelid.getText()+"','"+Labelnumber.getText()+"','"+Labelphone.getText()+"','"+Labeltotalprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully.. ");
                setVisible(false);
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == Back){
            new Dashboard(username);
            
        }
        
    }
    
    
 public static void main(String[] args){
     new BookPackage("Av1401");
 } 
}
