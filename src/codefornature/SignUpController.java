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
public class SignUpController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String hoverStyle = "-fx-base: rgb(6, 186, 186);"; // You can customize the color.

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
                signUpBtn.setStyle("-fx-base: rgb(0, 102, 102);");
            }
        });
    }    

    @FXML
    private void loginHover(MouseEvent event) {
    }

    @FXML
    private void signUpHover(MouseEvent event) {
    }

    @FXML
    private void signUp(ActionEvent event) {
    }

    @FXML
    private void login(MouseEvent event) {
    }
    
}
