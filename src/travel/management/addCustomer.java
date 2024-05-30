
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class addCustomer extends JFrame implements ActionListener{
    
    JLabel labelusrname, lblname, labelname;
    JComboBox comboid;
    JTextField tfNumber, tfCountry, tfAddress, tfemail,tfphnno;
    JRadioButton rmale, rfemale, rother;
    JButton back, addbtn;
    addCustomer(String username){
        setBounds(450, 200, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(30, 50, 150, 25);
        add(lb1username);
        
        labelusrname = new JLabel();
        labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        
        JLabel lbid = new JLabel("id");
        lbid.setBounds(30, 90, 150, 25);
        add(lbid);
        
        comboid = new JComboBox(new String[]{"Passport", "Aadhar card", "Driving Licence", "Pan Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.white);  
        add(comboid);
        
        JLabel idNumber = new JLabel("Number");
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        
        rother = new JRadioButton("Other");
        rother.setBounds(380, 210, 700, 25);
        rother.setBackground(Color.white);
        add(rother);
        
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
        
        addbtn = new JButton("Add");
        addbtn.setBounds(70, 430 , 100, 25);
        addbtn.setBackground(Color.BLACK);
        addbtn.setForeground(Color.white);
        addbtn.addActionListener(this);
        add(addbtn);
        
        back = new JButton("Back");
        back.setBounds(220, 430 , 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance( 400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try{
            
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select *from account where username ='"+username+"' ");
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
                
            
        } catch(Exception e){
           e.printStackTrace();
        }
        

        
        
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addbtn){
            String username = labelusrname.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfNumber.getText();
           String name = labelname.getText();
           String gender = null;
           if(rmale.isSelected()){
               gender = "male";
               
           }
           else if(rfemale.isSelected()){
               gender = "female";
           }
           else{
               gender = "other";
           }
           String Country = tfCountry.getText();
           String Address = tfAddress.getText();
           String Email = tfemail.getText();
           String Phone = tfphnno.getText();
           
           
           // for stroe the personal details of the user in the dataabase...........
           
           try{
               Connectivity c = new Connectivity();
               String query = "Insert into  PersonalDetails values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+Country+"', '"+Address+"', '"+Phone+"', '"+Email+"')";
               c.s.executeUpdate(query);
               
               JOptionPane.showInternalMessageDialog(null, "Customer Details Added Successfull");
               setVisible(true);
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
        } else{
            setVisible(false);
        }
        
       
    }
    public static void main(String[] args){
        new addCustomer("");
        
    }
    
}
