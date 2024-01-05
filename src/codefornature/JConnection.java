package codefornature;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class JConnection {
    public static Connection Conn(){
        String url = "jdbc:mysql://localhost:3306/codefornature";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Please Start XAMPP Control Panel!", "Dialog", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
