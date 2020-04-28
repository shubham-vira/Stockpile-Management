
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public class MySqlConnect {
    /*
    @author Shubham
    Description:
    This is a static method whic
    */
    public static Connection connectDB(){
        /*
        We want to to establish connection with mysql
        Connection String for MYSQL 
        
        jdbc:mysql://servername:portno/database_name
        
        getConnectionString(String connectionString, String userName, String password);
        */
                
                
        try {
            //Class.forName.("com.mysql.jdbc.Driver")
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","shubham_vira","ShubhamVira");
            //JOptionPane.showMessageDialog(null, "Connection Successfull!", "Connection",JOptionPane.INFORMATION_MESSAGE);
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Connection Unsuccessfull : " + e, "Connection",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Unusual Error Occured : " + e, "Connection",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}