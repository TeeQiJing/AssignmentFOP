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

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class LoginController implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label siguUpBtn;
    @FXML
    private PasswordField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String hoverStyle = "-fx-base: #565656;"; // You can customize the color.

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
                loginBtn.setStyle("-fx-base: rgb(0, 102, 102);");
            }
        });
    }    

    @FXML
    private void loginHover(MouseEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void signUpHover(MouseEvent event) {
    }

    @FXML
    private void signUp(MouseEvent event) {
    }
//    loginBtn.setOnMouseEntered(event -> button.setStyle(hoverStyle));
    
}
