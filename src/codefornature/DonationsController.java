package codefornature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javafx.scene.layout.BorderPane;
import java.sql.SQLException;

public class DonationsController implements Initializable {
    @FXML
    private ComboBox<String> ngoComboBox;
    @FXML
    private TextField amountDonateTextField;
    @FXML
    private Button donateBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PointShopController obj = new PointShopController();
        obj.setFocusedStyle(amountDonateTextField);
        obj.setFocusedStyle(ngoComboBox);
        ngoComboBox.getItems().addAll("World Wildlife Fund", "World Agroforestry Centre", "Greenpeace", "Earth Justice", "Nature Conservancy");
        obj.setHoverStyle(donateBtn);
        obj.setNumericalFilter(amountDonateTextField);
    }    

    @FXML
    private void donate(ActionEvent event) {
        if(ngoComboBox.getValue() == null || amountDonateTextField.getText().isEmpty() || Integer.parseInt(amountDonateTextField.getText())==0)
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields! Donation amount must be at least $1", "Dialog", JOptionPane.ERROR_MESSAGE);
        else{
            String ngo = ngoComboBox.getValue();
            int amount = Integer.parseInt(amountDonateTextField.getText());
            double donationAmount = 0.9 * amount;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedAmount = decimalFormat.format(donationAmount);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Donations.txt"), true))) {
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
