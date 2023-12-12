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
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javafx.scene.layout.BorderPane;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class DonationsController implements Initializable {

    @FXML
    private ComboBox<String> ngoComboBox;
    @FXML
    private TextField amountDonateTextField;
    @FXML
    private Button donateBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        amountDonateTextField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
        ngoComboBox.setStyle("-fx-font-size: 20px; -fx-background-color: transparent; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: rgb(0,102,102);");
        
        ngoComboBox.getItems().addAll(
                "World Wildlife Fund", 
                "World Agroforestry Centre",
                "Greenpeace",
                "Earth Justice",
                "Nature Conservancy");
//        ngoComboBox.setStyle("-fx-font-size: 20px; -fx-border-width:0px 0px 1px 0px; -fx-border-color: rgb(0,102,102); -fx-background-color: white;");
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166); -fx-background-radius: 50px;"; 
        donateBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                donateBtn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        donateBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                donateBtn.setStyle("-fx-background-color: rgb(0, 102, 102); -fx-background-radius: 50px;");
            }
        });
        
        amountDonateTextField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume(); // Consume the event to prevent the character from being entered
            }
        });
        
    }    

    @FXML
    private void donate(ActionEvent event) {
        

        if(ngoComboBox.getValue() == null || amountDonateTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields! Donation amount must be at least $1", "Dialog", JOptionPane.ERROR_MESSAGE);
            
        }else{
            String ngo = ngoComboBox.getValue();
            int amount = Integer.parseInt(amountDonateTextField.getText());
            double donationAmount = 0.9 * amount;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedAmount = decimalFormat.format(donationAmount);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Donations.txt"), true))) {
               // Append donation entry
                writer.write(SessionManager.getCurrentUser().getUsername() + " has donated $" + formattedAmount + " to " + ngo);
                writer.newLine(); 

                int pointGet = amount * 10;

                JOptionPane.showMessageDialog(new JFrame(), "You have successfully donate $" + amount + ", " + pointGet + " points are rewarded.", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);

                Connection conn = JConnection.Conn();
                String sql = "UPDATE user SET current_points = (current_points + ?) WHERE email = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, pointGet);
                preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());

                int rowsAffected = preparedStatement.executeUpdate();

                sql = "SELECT *, count(*) AS count FROM user WHERE email = ?";
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, SessionManager.getCurrentUser().getEmail());
                ResultSet resultSet = preparedStatement.executeQuery();

                BorderPane bp1 = (BorderPane)ngoComboBox.getScene().getRoot();


                int point = 0;
                while(resultSet.next()) { 
                    if(resultSet.getInt("count") == 1){
                        point = resultSet.getInt("current_points");
                        ((Text)bp1.lookup("#pointsText")).setText("Points: " + point);

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        ngoComboBox.getSelectionModel().clearSelection();
        amountDonateTextField.setText("");
    }

    
}
