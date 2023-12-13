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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class PointShopController implements Initializable {

    @FXML
    private Button buyMerchandiseBtn;
    @FXML
    private Button plantTreeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buyMerchandise(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyMerchandise.fxml"));
            Parent buyMerchandiseNode = loader.load();
            BuyMerchandiseController buyMerchandiseController = loader.getController();
            
            BorderPane bp1 = (BorderPane)buyMerchandiseBtn.getScene().getRoot();
            
            bp1.setCenter(buyMerchandiseNode);    
            buyMerchandiseController.initializePage();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void plantTree(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlantTree.fxml"));
            Parent plantTreeNode = loader.load();
            PlantTreeController plantTreeController = loader.getController();
            
            BorderPane bp1 = (BorderPane)buyMerchandiseBtn.getScene().getRoot();
            
            bp1.setCenter(plantTreeNode);    
            plantTreeController.initializePage();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setFocusedStyle(Node node){
        if(node instanceof TextField){
            TextField textField = (TextField) node;
            textField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
            textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    textField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: rgb(0,102,102);");
                } else {
                    textField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
                }
            });
        }else if(node instanceof ComboBox){
            ComboBox comboBox = (ComboBox) node;
            comboBox.setStyle("-fx-font-size: 20px; -fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
            comboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    comboBox.setStyle("-fx-font-size: 20px; -fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: rgb(0,102,102);");
                } else {
                    comboBox.setStyle("-fx-font-size: 20px; -fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
                }
            });
        }
    }
    
    public void setHoverStyle(Button btn){
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166); -fx-background-radius: 50px;"; 
        
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle("-fx-background-color: rgb(0, 102, 102); -fx-background-radius: 50px;");
            }
        });
    }
    
    public void setNumericalFilter (TextField textfield){
        textfield.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume(); // Consume the event to prevent the character from being entered
            }
        });
    }
    
}
