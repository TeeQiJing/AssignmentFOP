package codefornature;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
public class LogOutController implements Initializable {
    private double x=0, y=0;
    private Stage stage;
    @FXML
    private BorderPane bp;
    @FXML
    private Button yesBtn;
    @FXML
    private Button noBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void noLogOut(ActionEvent event) {    
        try{
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void yesLogOut(ActionEvent event) {
        try{
            List<Window> openWindows = Window.getWindows();
            for (Window window : openWindows) {
                if (window instanceof Stage) {
                    Stage stage = (Stage) window;
                    stage.close();
                }
            }
            if(SessionManager.isUserLoggedIn()){
                User currentUser = SessionManager.getCurrentUser();
                currentUser.setUsername(null);
                currentUser.setEmail(null);
                currentUser.setPassword(null);
                currentUser.setRegistrationDate(null);
                currentUser.setCurrentPoint(0);
            }
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
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
