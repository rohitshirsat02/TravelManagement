
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusrname, lblname, labelname;
    JComboBox comboid;
    JTextField tfNumber, tfCountry, tfAddress, tfemail,tfphnno, tfid, tfgender;
    JRadioButton rmale, rfemale, rother;
    JButton back, updatebtn;
    UpdateCustomer(String username){
        setBounds(450, 200, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahome", Font.BOLD, 20));
        add(text);
        
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(30, 50, 150, 25);
        add(lb1username);
        
        labelusrname = new JLabel();
        labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        
        JLabel lbid = new JLabel("id");
        lbid.setBounds(30, 90, 150, 25);
        add(lbid);
        
       //
        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid); 
        
        JLabel idNumber = new JLabel(" Id No.");
        idNumber.setBounds(30, 130, 150, 25);
        add(idNumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);
        
        
        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);
        
        ButtonGroup btngrp = new ButtonGroup();
        btngrp.add(rmale);
        btngrp.add(rfemale);
        btngrp.add(rother);
        
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(220, 250, 150, 25);
        add(tfCountry);
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25);
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);
        
        JLabel lblphnno = new JLabel("Phone no");
        lblphnno.setBounds(30, 330, 150, 25);
        add(lblphnno);
        
        tfphnno = new JTextField();
        tfphnno.setBounds(220, 330, 150, 25);
        add(tfphnno);
        
        updatebtn = new JButton("Update");
        updatebtn.setBounds(70, 430 , 100, 25);
        updatebtn.setBackground(Color.BLACK);
        updatebtn.setForeground(Color.white);
        updatebtn.addActionListener(this);
        add(updatebtn);
        
        back = new JButton("Back");
        back.setBounds(220, 430 , 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance( 400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);
        
        try{
            
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select *from PersonalDetails where username ='"+username+"'");
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfCountry.setText(rs.getString("country"));
                tfAddress.setText(rs.getString("address"));
                tfphnno.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
                
            
        } catch(Exception e){
           e.printStackTrace();
        }
        

        
        
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updatebtn){
            String username = labelusrname.getText();
            String id = tfid.getText();
            String number = tfNumber.getText();
           String name = labelname.getText();
           String gender = tfgender.getText();
           String Country = tfCountry.getText();
           String Address = tfAddress.getText();
           String Email = tfemail.getText();
           String Phone = tfphnno.getText();
           
           
           // for update the personal details of the user in the dataabase...........
           
           try{
               Connectivity c = new Connectivity();
               String query = "update  PersonalDetails set username = '"+username+"', id = '"+id+"', number =  '"+number+"', name =  '"+name+"', gender = '"+gender+"', country = '"+Country+"', address = '"+Address+"', phone = '"+Phone+"', email = '"+Email+"'";
               c.s.executeUpdate(query);
               
               JOptionPane.showInternalMessageDialog(null, "Customer Details Updated Successfull");
               setVisible(true);
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
        } else{
            setVisible(false);
        }
        
       
    }
    public static void main(String[] args){
        new UpdateCustomer("rohit");
        
    }
    
}
