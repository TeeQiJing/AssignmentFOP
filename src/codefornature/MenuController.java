/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

//import com.sun.javafx.logging.Logger;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class MenuController implements Initializable {

    private double x=0, y=0;
    private Scene scene;
    private Stage stage;
    private Parent root;
    String hoverStyle = "-fx-background-color: rgb(13, 163, 166);";
    
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
    @FXML
    private BorderPane bp1;
    @FXML
    private BorderPane bp2;
    @FXML
    private ImageView closeBtn;
    @FXML
    private ImageView maxBtn;
    @FXML
    private ImageView minBtn;
    @FXML
    private VBox menuVBox;
    @FXML
    private AnchorPane minMaxClosebar; 
    
    /**
     * Initializes the controller class.
     */
    
    private void hoverEffect(Button btn){
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle(hoverStyle); 
            }
        });

        btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle("-fx-background-color: transparent;");
            }
        });
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hoverEffect(homeBtn);
        hoverEffect(triviaBtn);
        hoverEffect(newsBtn);
        hoverEffect(pointShopBtn);
        hoverEffect(donationBtn);
        hoverEffect(logOutBtn);
        btnHover(closeBtn, "red");
        btnHover(minBtn, "yellow");
        btnHover(maxBtn, "green");
        
        if(SessionManager.isUserLoggedIn()){
            User currentUser = SessionManager.getCurrentUser();
            usernameText.setText(currentUser.getUsername());
            pointsText.setText("Points: " + Integer.toString(currentUser.getCurrentPoint()));
        }else{
            usernameText.setText("No User");
            pointsText.setText("No Points");
        }
    }    
    
    @FXML
    private void homePage(MouseEvent event) {
        loadPage("Home"); 
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
        if(SessionManager.isUserLoggedIn()){
            User currentUser = SessionManager.getCurrentUser();
            currentUser.setUsername(null);
            currentUser.setEmail(null);
            currentUser.setPassword(null);
            currentUser.setRegistrationDate(null);
            currentUser.setCurrentPoint(0);
        }

        try {
            // Load the pop-out logout FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LogOut.fxml"));
            Parent root = loader.load();

            // Create a new stage for the pop-out window
            Stage popupStage = new Stage();
            
            popupStage.setScene(new Scene(root));

            // Set the modality of the stage to APPLICATION_MODAL
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initStyle(StageStyle.UNDECORATED);
            
            // Show the pop-out window
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    private void loadPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        }catch(IOException e){
            e.printStackTrace();
        }
        bp2.setCenter(root);     
    }

    @FXML
    private void borderpane_dragged(MouseEvent event) {
        stage = (Stage) bp1.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void borderpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void closeBtnClicked(MouseEvent event) {
        stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void maxBtnClicked(MouseEvent event) {
        stage = (Stage) minBtn.getScene().getWindow();
        if(stage.isMaximized())
            stage.setMaximized(false);
        else
            stage.setMaximized(true);
    }

    @FXML
    private void minBtnClicked(MouseEvent event) {
        stage = (Stage) minBtn.getScene().getWindow();
        stage.setIconified(true);
    }
    
    private void btnHover(ImageView btn, String name){   
        File oldFile = new File("src/codefornature/images/"+name+".png");
        Image oldImage = new Image(oldFile.toURI().toString());
        
        File newFile = new File("src/codefornature/images/"+name+"_hover.png");
        Image newImage = new Image(newFile.toURI().toString());
        
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setImage(newImage);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setImage(oldImage);
            }
        });
    }
}
