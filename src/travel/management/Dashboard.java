
package travel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
     
    String username;
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,CheckPackages, Bookpackages,viewpackages,CheckHotels, Destinations, bookhotels,viewbookhotels;
    JButton payments, calculator,notepad, About,deletePersonalDetails;
    Dashboard(String username){
        this.username = username;
    //setBounds(0, 0, 1500, 1080);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    //getContentPane().setBackground(Color.BLUE);
    
    
    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(new Color(0, 0, 102));
    p1.setBounds(0, 0, 1600, 65);
    add(p1);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dashboard.png"));
    Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon I3 = new ImageIcon(i2);
    JLabel icon = new JLabel(I3);
    icon.setBounds(5 , 0, 70, 70);
    p1.add(icon);
    
    JLabel heading = new JLabel("Dashboard");
    heading.setBounds(80, 10, 300, 40);
    heading.setForeground( Color.white);
    heading.setFont(new Font("Tahoma", Font.BOLD, 30));
    p1.add(heading);
    
    
    // panel no.2 for the buttons..
    
    JPanel p2 = new JPanel();
    p2.setLayout(null);
    p2.setBackground(new Color(0, 0, 102));
    p2.setBounds(0, 65, 300, 900);
    add(p2);
    
    
    // add buttons on panel no.2
    // // add button no. 1 for personal details on the panel no 2..
    addPersonalDetails = new JButton("Add Personal Details");
    addPersonalDetails.setBounds(0, 0, 300, 50);
    addPersonalDetails.setBackground(new Color(0, 0, 102));
    addPersonalDetails.setForeground(Color.WHITE);
    addPersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 16));
    addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
    addPersonalDetails.addActionListener(this);
    
    p2.add(addPersonalDetails);
    
    // add button no. 2 for update details on the panel no 2...
    updatePersonalDetails = new JButton("Update Personal Details");
    updatePersonalDetails.setBounds(0, 40, 300, 50);
    updatePersonalDetails.setBackground(new Color(0, 0, 102));
    updatePersonalDetails.setForeground(Color.WHITE);
    updatePersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 16));
    updatePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
    updatePersonalDetails.addActionListener(this);
    
    p2.add(updatePersonalDetails);
    
    //// add button no. 3 for view details on the panel no 2...
    
     viewPersonalDetails = new JButton("View Details");
    viewPersonalDetails.setBounds(0, 80, 300, 50);
    viewPersonalDetails.setBackground(new Color(0, 0, 102));
    viewPersonalDetails.setForeground(Color.WHITE);
    viewPersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 16));
    viewPersonalDetails.addActionListener(this);
    viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
    
    p2.add(viewPersonalDetails);
    
    //// add button no. 4 for delete details on the panel no 2...
    
    deletePersonalDetails = new JButton("Delete Personal Details");
    deletePersonalDetails.setBounds(0, 120, 300, 50);
    deletePersonalDetails.setBackground(new Color(0, 0, 102));
    deletePersonalDetails.setForeground(Color.WHITE);
    deletePersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 16));
    deletePersonalDetails.setMargin(new Insets(0, 0, 0, 45));
    deletePersonalDetails.addActionListener(this);
    p2.add(deletePersonalDetails);
    
    // add button no. 5 for check packages on the panel no 2...
    
    CheckPackages = new JButton("Check Packages");
    CheckPackages.setBounds(0, 160, 300, 50);
    CheckPackages.setBackground(new Color(0, 0, 102));
    CheckPackages.setForeground(Color.WHITE);
    CheckPackages.setFont(new Font("Raleway", Font.PLAIN, 16));
    CheckPackages.setMargin(new Insets(0, 0, 0, 100));
    CheckPackages.addActionListener(this);
    p2.add(CheckPackages);
    
    
    // add button no. 6 for book packages on the panel no 2...
    
    Bookpackages = new JButton("Book Packages");
    Bookpackages.setBounds(0, 200, 300, 50);
    Bookpackages.setBackground(new Color(0, 0, 102));
    Bookpackages.setForeground(Color.WHITE);
    Bookpackages.setFont(new Font("Raleway", Font.PLAIN, 16));
    Bookpackages.setMargin(new Insets(0, 0, 0, 110));
    Bookpackages.addActionListener(this);
    p2.add(Bookpackages);
    
    
    // add button no. 7 for view packages on the panel no 2...
    
    viewpackages = new JButton("View Packages");
    viewpackages.setBounds(0, 240, 300, 50);
    viewpackages.setBackground(new Color(0, 0, 102));
    viewpackages.setForeground(Color.WHITE);
    viewpackages.setFont(new Font("Raleway", Font.PLAIN, 16));
    viewpackages.setMargin(new Insets(0, 0, 0, 110));
    viewpackages.addActionListener(this);
    p2.add(viewpackages);
    
    // add button no. 8 for view hotels on the panel no 2...
    
    CheckHotels = new JButton("View hotels");
    CheckHotels.setBounds(0, 280, 300, 50);
    CheckHotels.setBackground(new Color(0, 0, 102));
    CheckHotels.setForeground(Color.WHITE);
    CheckHotels.setFont(new Font("Raleway", Font.PLAIN, 16));
    CheckHotels.setMargin(new Insets(0, 0, 0, 130));
    CheckHotels.addActionListener(this);
    p2.add(CheckHotels);
    
    
    // add button no. 9 for bookhotels on the panel no 2...
    
    bookhotels = new JButton("Book hotels");
    bookhotels.setBounds(0, 320, 300, 50);
    bookhotels.setBackground(new Color(0, 0, 102));
    bookhotels.setForeground(Color.WHITE);
    bookhotels.setFont(new Font("Raleway", Font.PLAIN, 16));
    bookhotels.setMargin(new Insets(0, 0, 0, 130));
    bookhotels.addActionListener(this);
    p2.add(bookhotels);
    
    
    // add button no. 10 for view bookhotels on the panel no 2...
    
    viewbookhotels = new JButton(" View book hotels");
    viewbookhotels.setBounds(0, 360, 300, 50);
    viewbookhotels.setBackground(new Color(0, 0, 102));
    viewbookhotels.setForeground(Color.WHITE);
    viewbookhotels.setFont(new Font("Raleway", Font.PLAIN, 16));
    viewbookhotels.setMargin(new Insets(0, 0, 0, 100));
    viewbookhotels.addActionListener(this);
    p2.add(viewbookhotels);
    
    // add button no. 11 for view bookhotels on the panel no 2...
    
    Destinations = new JButton(" Destinations");
    Destinations.setBounds(0, 400, 300, 50);
    Destinations.setBackground(new Color(0, 0, 102));
    Destinations.setForeground(Color.WHITE);
    Destinations.setFont(new Font("Raleway", Font.PLAIN, 16));
    Destinations.setMargin(new Insets(0, 0, 0, 130));
    Destinations.addActionListener(this);
    p2.add(Destinations);
    
    
    // add button no. 12 for payments on the panel no 2...
    
    payments = new JButton(" Payments");
    payments.setBounds(0, 440, 300, 50);
    payments.setBackground(new Color(0, 0, 102));
    payments.setForeground(Color.WHITE);
    payments.setFont(new Font("Raleway", Font.PLAIN, 16));
    payments.setMargin(new Insets(0, 0, 0, 150));
    payments.addActionListener(this);
    p2.add(payments);
    
    
    // add button no. 13 for calculator on the panel no 2...
    
    calculator = new JButton(" Calculator");
    calculator.setBounds(0, 480, 300, 50);
    calculator.setBackground(new Color(0, 0, 102));
    calculator.setForeground(Color.WHITE);
    calculator.setFont(new Font("Raleway", Font.PLAIN, 16));
    calculator.setMargin(new Insets(0, 0, 0, 150));
    calculator.addActionListener(this);
    p2.add(calculator);
    
    // add button no. 14 for notes on the panel no 2...
    
    notepad = new JButton(" Notepad");
    notepad.setBounds(0, 520, 300, 50);
    notepad.setBackground(new Color(0, 0, 102));
    notepad.setForeground(Color.WHITE);
    notepad.setFont(new Font("Raleway", Font.PLAIN, 16));
    notepad.setMargin(new Insets(0, 0, 0, 165));
    notepad.addActionListener(this);
    p2.add(notepad);
   
    
        // add button no. 15 for About on the panel no 2...
    
    About = new JButton(" About");
    About.setBounds(0, 560, 300, 50);
    About.setBackground(new Color(0, 0, 102));
    About.setForeground(Color.WHITE);
    About.setFont(new Font("Raleway", Font.PLAIN, 16));
    About.setMargin(new Insets(0, 0, 0, 165));
    About.addActionListener(this);
    p2.add(About);
    
    
    // add image on ramaining screen for the home page...
    
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
    Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
    ImageIcon I6 = new ImageIcon(i5);
    JLabel image = new JLabel(I6);
    image.setBounds(0, 0, 1650, 1000);
    add(image);

    JLabel texthome = new JLabel("Travel Management System"); 
    texthome.setBounds(400, 70, 1200, 70);
    texthome.setFont(new Font("Raleway", Font.PLAIN, 40));
    texthome.setForeground(Color.white);
    image.add(texthome);
    
    
    
    
    
    
    
    setVisible(true); 
    
    
    
    setVisible(true); 
    
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addPersonalDetails){
           new addCustomer(username);
        } else if(ae.getSource()== viewPersonalDetails){
           new ViewCustomer(username);
        } else if(ae.getSource()== updatePersonalDetails){
           new UpdateCustomer(username);
        }else if(ae.getSource()== CheckPackages){
           new CheckPackages();
        }else if(ae.getSource()== Bookpackages){
           new BookPackage(username);
        }else if(ae.getSource()== viewpackages){
           new ViewPackage(username);
        }else if(ae.getSource()== CheckHotels){
           new CheckHotels();
        }else if(ae.getSource()== Destinations){
           new Destinations();
        }else if(ae.getSource()== bookhotels ){
            new  BookHotel(username);
        } else if(ae.getSource()==viewbookhotels){
            new ViewBookedHotel(username);
        } else if(ae.getSource() == payments){
            new Payment();
        } else if(ae.getSource() ==calculator ){
            try{
                
                Runtime.getRuntime().exec("calc.exe");
                
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == notepad){
            try{
                
                Runtime.getRuntime().exec("notepad.exe");
                
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == About){
            new About();
        } else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }

        
        
    }
    public static void main(String[] args){
        new Dashboard("");
    }
    
}
