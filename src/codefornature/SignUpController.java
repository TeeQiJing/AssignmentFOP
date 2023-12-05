/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class SignUpController implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    
    private double x=0, y=0;

    
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button signUpBtn;
    @FXML
    private Label loginBtn;
    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView closeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166);"; 
        String textStyle = "-fx-text-fill:#ff6666;"; 
        

        // Add the hover effect when the mouse enters the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle("-fx-background-color: rgb(0, 102, 102);");
            }
        });
        
        // Add the hover effect when the mouse enters the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle(textStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle("-fx-text-fill: red;");
            }
        });
    }    


    @FXML
    private void signUp(MouseEvent event) {
        try{
            Connection conn = JConnection.Conn();
            if(emailTextField.getText().isEmpty() || usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Please fill in all field!", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else{
                String email = emailTextField.getText();
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                
                
                String regex = "[0-9a-zA-Z._-]+@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);

                boolean validEmail = matcher.matches();

                String checkSql = "SELECT count(*) AS count FROM user WHERE email='"+email+"'"; 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(checkSql);
                boolean emailIsExist = true;
                while(resultSet.next()){
                    if(resultSet.getInt("count") == 0){
                        emailIsExist = false;
                        break;
                    }
                }
                if(!validEmail){
                    JOptionPane.showMessageDialog(new JFrame(), "This email is not a valid email. Please register again!", "Dialog", JOptionPane.ERROR_MESSAGE);
                }else if(emailIsExist){
                    JOptionPane.showMessageDialog(new JFrame(), "This email has already registered. Please Log In!", "Dialog", JOptionPane.ERROR_MESSAGE);
                    login(event);
                }
                else {
                    Date date = new Date();  
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                    String registration_date = formatter.format(date);  

                    String sql = "INSERT INTO user(email, username, password, registration_date, current_points) VALUES(?,?,?,?,0)";   

                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);
                    stmt.setString(2, username);
                    stmt.setString(3, password);
                    stmt.setString(4, registration_date);


                    // stmt.executeUpdate() returns the number of rows inserted, for this case is 1               
                    int count = stmt.executeUpdate();

                    if(count == 1){
                        JOptionPane.showMessageDialog(new JFrame(), "Registered Successfully! Please Login now!", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                        login(event);
                    }else
                        JOptionPane.showMessageDialog(new JFrame(), "Registration Failed!", "Dialog", JOptionPane.ERROR_MESSAGE);
                }
            }
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        emailTextField.setText("");
        usernameTextField.setText("");
        passwordTextField.setText("");
    }

    @FXML
    private void login(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    private void closeBtnClicked(MouseEvent event) {
        stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void anchorpane_dragged(MouseEvent event) {
        stage = (Stage) ap.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void anchorpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();    
    }


    
}
