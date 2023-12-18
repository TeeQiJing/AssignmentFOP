package codefornature;

import java.io.File;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MenuController implements Initializable {

    private double x=0, y=0;
    private Scene scene;
    private Stage stage;
    private Parent root;
    String hoverStyle = "-fx-background-color: rgb(13, 163, 166);";
    
    @FXML
    private Text usernameText;
    @FXML
    public Text pointsText;
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
    private ImageView closeBtn;
    @FXML
    private ImageView maxBtn;
    @FXML
    private ImageView minBtn;
    @FXML
    private VBox menuVBox;
    @FXML
    private AnchorPane minMaxClosebar; 

    
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
        loadPage("Home");
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
            updatePoints();
        }else{
            usernameText.setText("No User");
            pointsText.setText("No Points");
        }
    }  
    public void updatePoints(){
        try{
            Connection conn = JConnection.Conn();
            
            String sql = "SELECT *, count(*) AS count FROM user WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, SessionManager.getCurrentUser().getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) { 
                if(resultSet.getInt("count") == 1){
                    int point = resultSet.getInt("current_points");
                    pointsText.setText("Points: " + point);
                }
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
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
//    public BorderPane getBp2() {
//        return bp2;
//    }
    public void loadPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        }catch(IOException e){
            e.printStackTrace();
        }
        bp1.setCenter(root);     
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
