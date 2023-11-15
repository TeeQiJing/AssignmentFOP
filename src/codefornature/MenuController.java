/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

//import com.sun.javafx.logging.Logger;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.util.logging.*;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class MenuController implements Initializable {



    
    
    public static String email;
    public static String username;
    public static int current_points;
    
    @FXML
    private Text usernameText;
    @FXML
    private Text pointsText;
    @FXML
    private Button homeBtn;
    @FXML
    private Button triviaBtn;
    @FXML
    private Button newsBtn;
    @FXML
    private Button pointShopBtn;
    @FXML
    private Button donationBtn;
    @FXML
    private Button logOutBtn;
    
    String hoverStyle = "-fx-background-color: rgb(13, 163, 166);";
    @FXML
    private BorderPane bp1;
    @FXML
    private BorderPane bp2;
    
    private Scene scene;
    private Stage stage;
    private Parent root;
    

    public void setInfo(String username, String email, int current_points){
        this.username = username;
        this.email = email;
        this.current_points = current_points;
        
        usernameText.setText(this.username);
        pointsText.setText("Points: " + Integer.toString(this.current_points));
        
    }
    /**
     * Initializes the controller class.
     */
    
    private void hoverEffect(Button btn){
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle(hoverStyle);
//                homeBtn.setStyle("-fx-border-color: white;");
//                homeBtn.setStyle("-fx-border-width: 0px 0px 2px 0px;");
                
            }
        });

        
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle("-fx-background-color: transparent;");
//                homeBtn.setStyle("-fx-border-color: white;");
//                homeBtn.setStyle("-fx-border-width: 0px 0px 2px 0px;");
            }
        });
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hoverEffect(homeBtn);
        hoverEffect(triviaBtn);
        hoverEffect(newsBtn);
        hoverEffect(pointShopBtn);
        hoverEffect(donationBtn);
        hoverEffect(logOutBtn);

        
        
    }    

    @FXML
    private void homePage(MouseEvent event) {
        bp1.setCenter(bp2);
        
    }

    @FXML
    private void triviaPage(MouseEvent event) {
        loadPage("Trivia");       
    }

    @FXML
    private void newsPage(MouseEvent event) {
        loadPage("News");
    }

    @FXML
    private void donationPage(MouseEvent event) {
        loadPage("Donations");
    }
 
    @FXML
    private void pointShopPage(MouseEvent event) {
        loadPage("PointShop");
    }
    
    @FXML
    private void logOutPage(MouseEvent event) throws Exception{
        email = null;
        username = null;
        current_points = 0;
        
        JOptionPane.showMessageDialog(new JFrame(), "You have successfully logged out!", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
    
    private void loadPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        }catch(IOException e){
            e.printStackTrace();
        }
        bp1.setCenter(root);     
    }
//    hoverEffect(homeBtn);
    
    
//    private void hoverEffect(Button btn){
    // Add the hover effect when the mouse enters the button.
        
//    }

    
}
