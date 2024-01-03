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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class LoginController implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private double x=0, y=0;
    
    @FXML
    private TextField emailTextField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label signUpBtn;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView closeBtn;
    @FXML
    private AnchorPane loadingAP;
    @FXML
    private ProgressIndicator progressIndicator;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HomeController.firstTry=false;
        loadingAP.setVisible(false);
        loadingAP.managedProperty().bind(loadingAP.visibleProperty());
        
        String hoverStyle = "-fx-background-color: rgb(13, 163, 166);"; 
        String textStyle = "-fx-text-fill:#ff6666;"; 

        // Add the hover effect when the mouse enters the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle(hoverStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        loginBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginBtn.setStyle("-fx-background-color: rgb(0, 102, 102);");
            }
        });
        
        // Add the hover effect when the mouse enters the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle(textStyle);
            }
        });

        // Remove the hover effect when the mouse exits the button.
        signUpBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                signUpBtn.setStyle("-fx-text-fill: red;");
            }
        });
    }    

    @FXML
    private void login(ActionEvent event) {
        try{
            Connection conn = JConnection.Conn();
            if(emailTextField.getText().isEmpty() || passwordTextField.getText().isEmpty())
                JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields!", "Dialog", JOptionPane.ERROR_MESSAGE);
            else{
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                String sql = "SELECT *, count(*) AS count FROM user WHERE email='"+email+"' AND password='"+password+"'";

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    if(resultSet.getInt("count") == 1){
//                        System.out.println("Animation finished");
                        String userEmail = resultSet.getString("email");
                        String username = resultSet.getString("username");
                        String registration_date = resultSet.getString("registration_date");
                        String userPassword = resultSet.getString("password");
                        int current_points = resultSet.getInt("current_points");                

                        User user = new User(userEmail, username, userPassword, registration_date, current_points);
                        SessionManager.setCurrentUser(user);
                        
                        loadingAP.setVisible(true);
                        loadingAP.managedProperty().bind(loadingAP.visibleProperty());
                        
                        // Create a Task that update the News
                        Task<Void> backgroundTask = new Task<>() {
                            @Override
                            protected Void call() throws Exception {
                                BBCNews.UpdateNews();
                                return null;
                            }
                        };
                        
                        // Bind the ProgressBar's progress property to the progress property of the background task
                        progressIndicator.progressProperty().bind(backgroundTask.progressProperty());
                        
                        Timeline timeline = new Timeline(
                                new KeyFrame(Duration.ZERO, e -> {
                                    // Toggle the indeterminate property
                                    progressIndicator.setProgress(progressIndicator.getProgress() == ProgressIndicator.INDETERMINATE_PROGRESS ? 0.0 : ProgressIndicator.INDETERMINATE_PROGRESS);
                                }),
                                new KeyFrame(Duration.seconds(1))
                        );

                        // Set the timeline to execute only once
                        timeline.setCycleCount(1);

                        // Start the timeline
                        timeline.play();
                        
                        // Start the background task
                        new Thread(backgroundTask).start();
                        
                        // Add an event handler to detect when the animation is finished
                        timeline.setOnFinished(e -> {
                            try{   
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                                Parent root = loader.load();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            }catch(Exception ep){
                                ep.printStackTrace();
                            }  
                        });             
                    }else
                        JOptionPane.showMessageDialog(new JFrame(), "Login Failed! Invalid email or password!", "Dialog", JOptionPane.ERROR_MESSAGE);
                    
                }         
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        emailTextField.setText("");
        passwordTextField.setText("");   
    }

    @FXML
    private void signUp(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void anchorpane_dragged(MouseEvent event) {
        stage = (Stage) ap.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void anchorpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void closeBtnClicked(MouseEvent event) {
        stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    } 
}
