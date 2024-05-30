
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
   
public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JButton back;
     JLabel Labelname, Labelpackage, LabelPerson,Labelid, Labelnumber,Labelphone,LabelTprice,LabelTotalday,LabelAc,Labelfood,Labelhotelname;
    
    ViewBookedHotel(String username){
        setBounds(400,200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel text = new JLabel("View BookedHotel Details..");
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
        
        
        JLabel lb1Package = new JLabel("Hotel Name");
        lb1Package.setBounds(30, 90, 150, 25);
        add(lb1Package);
        
        // Label for adding the id given of the user in the id field from the  database...
        
        Labelhotelname = new JLabel();
        Labelhotelname.setBounds(220, 90, 150, 25);
        add(Labelhotelname);
        
        
         // Label for adding the NUmaber of the user in the field from the backend...
        
        
        JLabel lb1Person = new JLabel("Total Persons");
        lb1Person.setBounds(30, 130, 150, 25);
        add(lb1Person);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        LabelPerson = new JLabel();
        LabelPerson.setBounds(220, 130, 150, 25);
        add(LabelPerson);
        
        
           
        JLabel lb1totalDay= new JLabel("Total Days");
        lb1totalDay.setBounds(30, 170, 150, 25);
        add(lb1totalDay);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        LabelTotalday = new JLabel();
        LabelTotalday.setBounds(220, 170, 150, 25);
        add(LabelTotalday);
        
           
        JLabel lb1ac = new JLabel("Ac / Non ac");
        lb1ac.setBounds(30, 210, 150, 25);
        add(lb1ac);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        LabelAc = new JLabel();
        LabelAc.setBounds(220, 210, 150, 25);
        add(LabelAc);
        
           
        JLabel lb1food = new JLabel("Food Included?");
        lb1food.setBounds(30, 250, 150, 25);
        add(lb1food);
        
        // Label for adding the number given of the user in the number field from the  database...
        
        Labelfood = new JLabel();
        Labelfood.setBounds(220, 250, 150, 25);
        add(Labelfood);
        
        
        // Label for adding the name of the user in the field from the backend...
        
        JLabel lb1id = new JLabel("Id");
        lb1id.setBounds(30, 290, 150, 25);
        add(lb1id);
        
        // Label for adding the name given of the user in the name field from the  database...
        
        Labelid = new JLabel();
        Labelid.setBounds(220, 290, 150, 25);
        add(Labelid);
        
        
        // Label for adding the id of the user in the field from the backend...
        
        JLabel lb1number = new JLabel("Id Number");
        lb1number.setBounds(30, 330, 150, 25);
        add(lb1number);
        
        // Label for adding the id no given of the user in the id field from the  database...
        
         Labelnumber = new JLabel();
        Labelnumber.setBounds(220, 330, 150, 25);
        add(Labelnumber);
        
        

        
        
        // Label for adding the phone NO of the user in the field from the backend...
        
        JLabel lblphone = new JLabel("phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);
        
        // Label for adding the Country given of the user in the countyr field from the  database...
        
        Labelphone = new JLabel();
        Labelphone.setBounds(220, 370, 150, 25);
        add(Labelphone);
        
        // Label for adding the name of Address given by the user in the field from the backend...
        
        JLabel lblTprice = new JLabel("Total Cost");
        lblTprice.setBounds(30, 410, 150, 25);
        add(lblTprice);
        
        // Label for adding the address given of the user in the address field from the  database...
        
        LabelTprice = new JLabel();
        LabelTprice.setBounds(220, 410, 150, 25);
        add(LabelTprice);
        
        
       
        
        // add back button for the action 
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 460, 100, 25);
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
            String query = "Select *from BookingDetails where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                Labelname.setText(rs.getString("username"));
                Labelhotelname.setText(rs.getString("hotelName"));
                LabelPerson.setText(rs.getString("Persons"));
                Labelid.setText(rs.getString("id"));
                Labelnumber.setText(rs.getString("IdNumber"));
                LabelTprice.setText(rs.getString("totalPrice"));
                Labelphone.setText(rs.getString("phone"));
                Labelfood.setText(rs.getString("food"));
                LabelAc.setText(rs.getString("ac"));
                LabelTotalday.setText(rs.getString("days"));
                
                
                
                
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
        new ViewBookedHotel("Av1401");
    }
}

   
