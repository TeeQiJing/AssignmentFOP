/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class OkWindowController implements Initializable {

    @FXML
    private BorderPane bp;
    
    private double x=0, y=0;
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        try{
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Sign Up Successfully");
            stage.initStyle(StageStyle.UNDECORATED);
            
            stage.show();   
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void borderpane_dragged(MouseEvent event) {
        stage = (Stage) bp.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void borderpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    
}
