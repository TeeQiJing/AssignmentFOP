/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class LoginController implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    
    
    @FXML
    private TextField emailTextField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label signUpBtn;
    @FXML
    private PasswordField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166);"; 
        String textStyle = "-fx-text-fill:#ff6666;"; 
        

        // Add the hover effect when the mouse enters the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle("-fx-background-color: rgb(0, 102, 102);");
            }
        });
        
        // Add the hover effect when the mouse enters the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle(textStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle("-fx-text-fill: red;");
            }
        });
    }    



    @FXML
    private void login(ActionEvent event) {
        try{
            Connection conn = JConnection.Conn();
            if(emailTextField.getText().isEmpty() || passwordTextField.getText().isEmpty())
                JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields!", "Dialog", JOptionPane.ERROR_MESSAGE);
            else{
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                String sql = "SELECT email, username, current_points, count(*) AS count FROM user WHERE email='"+email+"' AND password='"+password+"'";

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    if(resultSet.getInt("count") == 1){
                        String userEmail = resultSet.getString("email");
                        String username = resultSet.getString("username");
                        int current_points = resultSet.getInt("current_points");
                        
                        
//                        JOptionPane.showMessageDialog(new JFrame(), "Login Successfully!", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root = loader.load();
                        
                        MenuController menuController = loader.getController();
                        menuController.setInfo(username, userEmail, current_points);
                        
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root, 800, 500);
                        stage.setScene(scene);
                        stage.setTitle("Home");
                        stage.show();

                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "Login Failed! Invalid email or password!", "Dialog", JOptionPane.ERROR_MESSAGE);
                    }
                }         
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        emailTextField.setText("");
        passwordTextField.setText("");   
    }



    @FXML
    private void signUp(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }
//    loginBtn.setOnMouseEntered(event -> button.setStyle(hoverStyle));
    
}
