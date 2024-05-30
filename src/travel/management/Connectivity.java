// in this page we connect the front end with backennd using JDBC with mysql ;
package travel.management;
import java.sql.*;

public class Connectivity {
    
    Connection c ;
    Statement s;
    
    Connectivity(){
        try{
           // Class.forName("com.mysql.cj.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelManagementSystem","root","Rohit@123$");
            s = c.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
