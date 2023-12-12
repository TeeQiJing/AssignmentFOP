/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TriviaController implements Initializable {

    @FXML
    private GridPane gp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int daysRegistered = daysRegistered();
        System.out.println(daysRegistered);
        setLockedDays(daysRegistered);
        
        
    }    
    
    private int daysRegistered() {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String registrationDate = SessionManager.getCurrentUser().getRegistrationDate();
            String todayDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            LocalDate firstDate = LocalDate.parse(registrationDate, formatter);
            LocalDate secondDate = LocalDate.parse(todayDate, formatter);
            int days = (int)ChronoUnit.DAYS.between(firstDate, secondDate);
            return days+1;    
        }catch(Exception e){
           return 0;
        }    
    }
    
    
    private void setLockedDays(int dayRegistered){
        for (Node node : gp.getChildren()) {
            if (node instanceof Button && node.getStyleClass().contains("dayBtn")) {
                Button dayButton = (Button) node;
                
                // Get the text of the button
                int dayNum = Integer.parseInt(dayButton.getText().split(" ")[1]);
                if(dayNum<=dayRegistered){
                    dayButton.setStyle("-fx-background-color: #dddddd;");
                    dayButton.setDisable(false);
                }
                else{
                    dayButton.setStyle("-fx-background-color: grey;");
                    dayButton.setDisable(true);
                }
                
                final int DayNum = dayNum;
                dayButton.setOnMouseClicked(ev -> {
                    toQuestion(dayButton, DayNum);
                });
            }
        }
    }
    
    public void toQuestion (Button dayButton, int dayNum){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TriviaQues.fxml"));
            Parent questionNode = loader.load();
            TriviaQuesController triviaQuesController = loader.getController();
            triviaQuesController.setQuesNum(dayNum);
            
            BorderPane bp1 = (BorderPane)dayButton.getScene().getRoot();
            
            bp1.setCenter(questionNode);    
            triviaQuesController.initializeQues();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    @FXML
    private void nextClicked(MouseEvent event) {
        
        for (Node node : gp.getChildren()) {
            if (node instanceof Button && node.getStyleClass().contains("dayBtn")) {
                Button dayButton = (Button) node;
                // Get the text of the button
                int dayNum = Integer.parseInt(dayButton.getText().split(" ")[1]);
                if(dayNum<=180){
                    dayNum = dayNum + 20;
                    dayButton.setText("Day " + dayNum);
                    setLockedDays(daysRegistered());
                }
                final int DayNum = dayNum;
                dayButton.setOnMouseClicked(ev -> {
                    toQuestion(dayButton, DayNum);
                });
            }
        }
    }

    @FXML
    private void previousClicked(MouseEvent event) {
        setLockedDays(daysRegistered());
        for (Node node : gp.getChildren()) {
            if (node instanceof Button && node.getStyleClass().contains("dayBtn")) {
                Button dayButton = (Button) node;
                // Get the text of the button
                int dayNum = Integer.parseInt(dayButton.getText().split(" ")[1]);
                if(dayNum>20){
                    dayNum = dayNum - 20;
                    dayButton.setText("Day " + dayNum);
                    setLockedDays(daysRegistered());
                }
                final int DayNum = dayNum;
                dayButton.setOnMouseClicked(ev -> {
                    toQuestion(dayButton, DayNum);
                });
            }
        }
    }
}
