/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;
import javafx.scene.control.Alert;
/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class HomeController implements Initializable {
    static String linkArray[]=new String[5];
    static boolean firstTry=false;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button triviaButton;
    @FXML
    private Label whatsUpText;
    @FXML
    private Label checkInText;
    @FXML
    private Button checkInBtn;
    @FXML
    private Label seeSee;
    @FXML
    private Label news1;
    @FXML
    private Label date1;
    @FXML
    private Label news2;
    @FXML
    private Label date2;
    @FXML
    private Label news3;
    @FXML
    private Label date3;
    @FXML
    private Label news4;
    @FXML
    private Label date4;
    @FXML
    private Label news5;
    @FXML
    private Label date5;
    @FXML
    private VBox VBox1;
    @FXML
    private VBox VBox2;
    @FXML
    private VBox VBox3;
    @FXML
    private VBox VBox4;
    @FXML
    private VBox Vbox5;
    @FXML
    private BorderPane bpChanging;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String time=time();
        String currentEmail="";
        Connection conn = JConnection.Conn();
        if(SessionManager.isUserLoggedIn()){
            User currentUser=SessionManager.getCurrentUser();
            currentEmail=SessionManager.getCurrentUser().getEmail();
            testUser(currentEmail);
            whatsUpText.setText("What\'s up! "+currentUser.getUsername());
        }
        else{
            whatsUpText.setText("What\'s up! ");
        }
        try{
            Statement statement=conn.createStatement();
            String sql= "UPDATE `home` SET `date` = '"+time+"' WHERE `email` = '" + currentEmail + "'" ;
            statement.executeUpdate(sql);
            String dataSql = "SELECT `date`,`checked` FROM `home` WHERE `email`= '"+currentEmail+"' "; 
            ResultSet resultSet=statement.executeQuery(dataSql);
            if(resultSet.next()){
                String date=resultSet.getString("date");
                String checked=resultSet.getString("checked");
                if(date.equals(checked)){
                    checkInBtn.setVisible(false);
                    checkInText.setText("Great to see you here! Welcome!");
                }
                else{
                    checkInBtn.setVisible(true);
                    checkInText.setText("Click to Sign Up and Grab Your Daily Point!");
                }
            }
            news();
            Task<Void> backgroundTask = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    start();
                    return null;
                }
            };
            new Thread(backgroundTask).start();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }    

    public void start() {
        // Set up a timeline to update the label text every 3 seconds
        if(!firstTry){
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                // Create and show the alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Auto-Close Dialog");
                alert.setHeaderText(null);
                alert.setContentText("You can\'t even see!");

                // Show the alert
                alert.show();

                // Set up a timeline to close the alert after 1 second
                Timeline closeTimeline = new Timeline(new KeyFrame(Duration.millis(0.1), e -> alert.close()));
                closeTimeline.setCycleCount(1);
                closeTimeline.play();
                news();
            }));
            timeline.setCycleCount(1);
            timeline.play();
            firstTry=true;
        }
    }
    
    public void news(){
        try{
            Connection conn = JConnection.Conn();
            Statement statement=conn.createStatement();
            ArrayList<Label>newsArray=new ArrayList<>();
            newsArray.add(news1);
            newsArray.add(news2);
            newsArray.add(news3);
            newsArray.add(news4);
            newsArray.add(news5);

            ArrayList<Label>dateArray=new ArrayList<>();
            dateArray.add(date1);
            dateArray.add(date2);
            dateArray.add(date3);
            dateArray.add(date4);
            dateArray.add(date5);
            String newsSql="SELECT `title`, `url`, `date` FROM `news` ";
            ResultSet newsResult=statement.executeQuery(newsSql);
            for(int i=0;i<5&&newsResult.next();i++){
                String link=newsResult.getString("url");
                String title=newsResult.getString("title");
                String date=newsResult.getString("date");
                linkArray[i]=link;
                Label label1=newsArray.get(i);
                Label label2=dateArray.get(i);
                label1.setText(title);
                label2.setText(date);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void checkIn(ActionEvent event){
        System.out.println("You have succesfully checked in! yay!");
        JOptionPane.showMessageDialog(new JFrame(), "You have succesfully checked in! yay!", "Checked in!", JOptionPane.PLAIN_MESSAGE);
        String time=time();
        try{
            Connection conn=JConnection.Conn();
            String updateHomeSql="UPDATE `home` SET `checked` = ? WHERE `email` = ?" ;
            try(PreparedStatement preparedStatementHome=conn.prepareStatement(updateHomeSql)){
                preparedStatementHome.setString(1,time);
                preparedStatementHome.setString(2,SessionManager.getCurrentUser().getEmail());
                preparedStatementHome.executeUpdate();
            }
            String updateUserSql="UPDATE user SET current_points = (current_points + ?) WHERE email = ?";
            try(PreparedStatement preparedStatementUser=conn.prepareStatement(updateUserSql)){
                preparedStatementUser.setInt(1, 1);
                preparedStatementUser.setString(2,SessionManager.getCurrentUser().getEmail());
                preparedStatementUser.executeUpdate();
            }
            checkInBtn.setVisible(false);
            checkInText.setText("Great to see you here! Welcome!");
            Statement statement=conn.createStatement();
            String check="SELECT * FROM `user` WHERE `email`='"+SessionManager.getCurrentUser().getEmail()+"'";
            ResultSet resultSet=statement.executeQuery(check);
            if(resultSet.next()){
                int point=resultSet.getInt("current_points");
                BorderPane b1 = (BorderPane)seeSee.getScene().getRoot();
                ((Text)b1.lookup("#pointsText")).setText("Points: " + point);
            }
            news();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void testUser(String currentEmail) {
        System.out.println(currentEmail);
        try {
            Connection conn = JConnection.Conn();
            String selectSql = "SELECT *, count(*) AS count FROM home WHERE email= '"+currentEmail+"'";
            String insertSql = "INSERT INTO `home`(`email`, `checked`, `date`) VALUES ('"+currentEmail+"','0','0')";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()) {
                if(resultSet.getInt("count")!=1){
                    System.out.println("ansIs"+resultSet.getInt("count"));
                    System.out.println("hey"+insertSql);
                    statement.executeUpdate(insertSql);
                    System.out.println("hey"+insertSql);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static String time(){
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted=localDateTime.format(format);
        return formatted;
    }
    public static void openLink(String url) {
    // Implement the logic to open the link, e.g., using java.awt.Desktop
    // You can also use HostServices to open the link in the default web browser
    // Note: In a full application, you should handle exceptions appropriately
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            desktop.browse(new java.net.URI(url));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void VBox1Btn(MouseEvent event) {
        openLink(linkArray[0]);
        loadPage("News");
    }

    @FXML
    private void VBox2Btn(MouseEvent event) {
        openLink(linkArray[1]);
        loadPage("News");
    }

    @FXML
    private void VBox3Btn(MouseEvent event) {
        openLink(linkArray[2]);
        loadPage("News");
    }

    @FXML
    private void VBox4Btn(MouseEvent event) {
        openLink(linkArray[3]);
        loadPage("News");
    }

    @FXML
    private void VBox5Btn(MouseEvent event) {
        openLink(linkArray[4]);
        loadPage("News");
    }

    @FXML
    private void triviaDirect(ActionEvent event) {
        loadPage("Trivia");
    }
    public void loadPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        }catch(IOException e){
            e.printStackTrace();
        }
        bpChanging.setCenter(root);     
    }
}
