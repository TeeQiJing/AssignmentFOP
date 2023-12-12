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
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
    }
    
}
