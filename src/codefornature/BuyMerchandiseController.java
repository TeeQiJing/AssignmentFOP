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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class BuyMerchandiseController implements Initializable {

    @FXML
    private Button buyBtn;
    @FXML
    private ComboBox<String> merchandiseComboBox;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField addressTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initializePage(){
        quantityTextField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
        addressTextField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
        merchandiseComboBox.setStyle("-fx-font-size: 20px; -fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
        
        merchandiseComboBox.getItems().addAll(
                "merch-1", 
                "merch-2",
                "merch-3",
                "merch-4",
                "merch-5");
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166); -fx-background-radius: 50px;"; 
        
        buyBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buyBtn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        buyBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buyBtn.setStyle("-fx-background-color: rgb(0, 102, 102); -fx-background-radius: 50px;");
            }
        });
        
        quantityTextField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume(); // Consume the event to prevent the character from being entered
            }
        });
    
    }

    @FXML
    private void buy(ActionEvent event) {
        if(merchandiseComboBox.getValue() == null || quantityTextField.getText().isEmpty() || addressTextField.getText().isEmpty() || Integer.parseInt(quantityTextField.getText()) == 0){
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields! Quantity must be at least 1", "Dialog", JOptionPane.ERROR_MESSAGE);
            
        }else{
            String merchandise = merchandiseComboBox.getValue();
            int quantity = Integer.parseInt(quantityTextField.getText());
            String address = addressTextField.getText();

            int pricePerQuantity = Integer.parseInt(merchandise.split("-")[1]);
            int deductedPoints = pricePerQuantity * quantity;
            int current_point = 0; 
            BorderPane bp1 = (BorderPane)merchandiseComboBox.getScene().getRoot();

            try{
                Connection conn = JConnection.Conn();
                String sql = "SELECT *, count(*) AS count FROM user WHERE email = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, SessionManager.getCurrentUser().getEmail());
                ResultSet resultSet = preparedStatement.executeQuery();

                
                while(resultSet.next()) { 
                    if(resultSet.getInt("count") == 1){
                        current_point = resultSet.getInt("current_points");
    //                        ((Text)bp1.lookup("#pointsText")).setText("Points: " + current_point);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }


            if(deductedPoints <= current_point){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("MerchandiseOrder.txt"), true))) {
               // Append donation entry
                    writer.write(SessionManager.getCurrentUser().getUsername() + " orders " + quantity + " " + merchandise +" to " + address);
                    writer.newLine(); 


                    Connection conn = JConnection.Conn();
                    String sql = "UPDATE user SET current_points = (current_points - ?) WHERE email = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, deductedPoints);
                    preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());

                    int rowsAffected = preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(new JFrame(), "Your order has been placed " + deductedPoints + " points are deducted.", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    sql = "SELECT *, count(*) AS count FROM user WHERE email = ?";
                    preparedStatement = conn.prepareStatement(sql);

                    preparedStatement.setString(1, SessionManager.getCurrentUser().getEmail());
                    ResultSet resultSet = preparedStatement.executeQuery();


                    while(resultSet.next()) { 
                        if(resultSet.getInt("count") == 1){
                            current_point = resultSet.getInt("current_points");
                                ((Text)bp1.lookup("#pointsText")).setText("Points: " + current_point);
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "You have no sufficient points! You need at least " + deductedPoints +" points!" , "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
            }    
        }
        merchandiseComboBox.getSelectionModel().clearSelection();
        quantityTextField.setText("");
        addressTextField.setText("");
    }
    
}
