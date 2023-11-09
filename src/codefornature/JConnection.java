/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;

/**
 *
 * @author GIGA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
//import java.sql.Statement;
import javax.swing.JOptionPane;
public class JConnection {
    public static Connection Conn() throws Exception{
        String url = "jdbc:mysql://localhost:3306/codefornature";
        String username = "root";
        String password = "";
        
        try{
            // Call the system class loader to load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Please Start XAMPP Control Panel!", "Dialog", JOptionPane.ERROR_MESSAGE);
            return null;
        }
  
    }

}
