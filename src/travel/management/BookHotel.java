
package travel.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotels,cAc, cfood;
    JTextField tfperson, tfdays;
    String username;
    JLabel  labelname,Labelid, Labelnumber, Labelphone, Labeltotalprice,lb1Person; 
    JButton Checkprice, BookHotel, Back;
    
    BookHotel(String username){
        this.username = username;
        setBounds(350, 200, 1100, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("BOOK Hotel");
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
        
        
        JLabel lb1select = new JLabel("Select Hotel");
        lb1select.setBounds(40, 110, 150, 22);
        lb1select.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1select); 
        
        // create a Dropdown for selecting the package..
        
        
        chotels = new Choice();
        chotels.setBounds(250, 110, 200, 20);
        add(chotels);
        
        try {
            
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select *from HotelDetails");
            while(rs.next()){
                chotels.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         // Label for adding the NUmaber of the persons  in the trip...
        
        
        lb1Person = new JLabel("Tota Persons");
        lb1Person.setBounds(40, 150, 150, 25);
        lb1Person.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1Person);
        
        // create textfield for adding the person in trip
        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);
        
        
        JLabel lb1days = new JLabel("No. of Days");
        lb1days.setBounds(40, 190, 150, 25);
        lb1days.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1days);
        
        // create textfield for adding the person in trip
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lb1ac = new JLabel("Ac / NonAc");
        lb1ac.setBounds(40, 230, 150, 25);
        lb1ac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1ac);
        
        cAc = new Choice();
        cAc.add("Ac");
        cAc.add("Non Ac");
        cAc.setBounds(250, 230, 200, 20);
        add(cAc);
        
        
        // label for adding the food choice box.....
        
        JLabel lb1food = new JLabel("Food Included");
        lb1food.setBounds(40, 270, 150, 25);
        lb1food.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lb1food);
        
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        // Label for adding the id of the user in the field 
        
        JLabel lb1id = new JLabel("Id");
        lb1id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1id.setBounds(40, 310, 150, 20);
        add(lb1id);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelid = new JLabel();
        Labelid.setBounds(250, 310, 200, 25);
        add(Labelid);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1Number = new JLabel("Id Number");
        lb1Number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1Number.setBounds(40, 350, 150, 25);
        add(lb1Number);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelnumber = new JLabel();
        Labelnumber.setBounds(250, 350, 150, 25);
        add(Labelnumber);
        
        
        
        // add the label on the right side of the screen for the ramaing fields..
        
        
        // Label for adding the name of Country given by the user in the field from the backend...
        
        JLabel lb1Phone = new JLabel("Phone NO");
        lb1Phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1Phone.setBounds(40, 390, 150, 20);
        add(lb1Phone);
        
        // Label for adding the Country given of the user in the countyr field from the  database...
        
        Labelphone = new JLabel();
        Labelphone.setBounds(250, 390, 200, 25);
        add(Labelphone);
        
        // Label for adding the name of Address given by the user in the field from the backend...
        
        JLabel lb1totalprice = new JLabel("Total Price");
        lb1totalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1totalprice.setBounds(40, 430, 150, 20);
        add(lb1totalprice);
        
        // Label for adding the address given of the user in the address field from the  database...
        
        Labeltotalprice = new JLabel();
        Labeltotalprice.setBounds(250, 430, 200, 25);
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
        Checkprice.setBounds(60, 490, 120, 25);
        Checkprice.setBackground(Color.BLACK);
        Checkprice.setForeground(Color.white);
        Checkprice.addActionListener(this);
        add(Checkprice);
        
        
        BookHotel  = new JButton("Book Hotel");
        BookHotel.setBounds(200, 490, 120, 25);
        BookHotel.setBackground(Color.BLACK);
        BookHotel.setForeground(Color.white);
        BookHotel.addActionListener(this);
        add(BookHotel);
        
        
        Back  = new JButton("Back");
        Back.setBounds(340, 490, 120, 25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);
        
        // add image on the screen 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 600, 400);
        add(l12);
        
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Checkprice){
            try {
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select *from HotelDetails where name = '"+chotels.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int costac = Integer.parseInt(rs.getString("acroom"));
                int costfood = Integer.parseInt(rs.getString("foodincluded"));
                
                int totalperson = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acSelected = cAc.getSelectedItem();
                String foodSelected = cfood.getSelectedItem();
                
                if(totalperson * days >0){
                    int totalCost = 0;
                    totalCost += acSelected.equals("Ac") ? costac : 0;
                    totalCost += foodSelected.equals("Yes") ? costfood : 0;
                    totalCost += cost ;
                    totalCost = totalCost * totalperson *days;
                    Labeltotalprice.setText("Rs "+totalCost);
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                }
            }
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == BookHotel){
            // for saving the details of bookpackage in the database..
            
            try{
                Connectivity conn = new Connectivity();
                conn.s.executeUpdate("insert into BookingDetails values('"+labelname.getText()+"','"+chotels.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cAc.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+Labelid.getText()+"','"+Labelnumber.getText()+"','"+Labelphone.getText()+"','"+Labeltotalprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotels Booked Successfully.. ");
                setVisible(false);
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            
           setVisible(false); 
        }
        
    }
    
    
 public static void main(String[] args){
     new BookHotel("Av1401");
 } 
}
