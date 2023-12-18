/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class PlantTreeController implements Initializable {

    @FXML
    private TextField treeNameTextField;
    @FXML
    private Button plantBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void initializePage(){
        PointShopController obj = new PointShopController();
        obj.setFocusedStyle(treeNameTextField);
        obj.setHoverStyle(plantBtn);
    }

    @FXML
    private void plant(ActionEvent event) {
        if(treeNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in Tree Name fields!", "Dialog", JOptionPane.ERROR_MESSAGE);
        }else{
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("TreePlantOrder.txt"), true))) {
               // Append donation entry
                    writer.write(SessionManager.getCurrentUser().getUsername() + " plants a tree with the name \""+treeNameTextField.getText()+"\"");
                    writer.newLine(); 
                    
                    JOptionPane.showMessageDialog(new JFrame(), "Thanks for planting a tree to save the earth!", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        treeNameTextField.setText("");
    }
    
}