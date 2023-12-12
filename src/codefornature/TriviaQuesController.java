/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TriviaQuesController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private GridPane gp;

    private PreparedStatement preparedStatement;
    private String sql;
    private ResultSet resultSet;
    private static Connection conn;
    private static int quesNum;
    private static List<String> optionList;
    private static String answer;
    
    
    public void initializeQues(){
//        question.setText("Question "+quesNum);
        
        try{
            conn = JConnection.Conn();
            sql = "SELECT *, count(*) AS count FROM user_trivia WHERE id = ? AND email = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, quesNum);
            preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());
            resultSet = preparedStatement.executeQuery();
            int attempts = 0;
            while(resultSet.next()) { 
                if(resultSet.getInt("count") == 1){
                    attempts = resultSet.getInt("attempts");
                }
            }

            sql = "SELECT *, count(*) AS count FROM trivia WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, quesNum);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) { 
                if(resultSet.getInt("count") == 1){
                    question.setText(resultSet.getString("question"));
                    int count = 0;
                    Button option;
                    answer = resultSet.getString("answer");
                    for (Node node : gp.getChildren()) {
                        if (node instanceof Button && node.getStyleClass().contains("option")) {
                            option = (Button) node;      
                            option.setText(resultSet.getString(optionList.get(count)));
                            
                            if(attempts >= 2){
                                option.setDisable(true);
                                option.setOpacity(1.0);
                                option.setStyle("-fx-background-color: #dddddd;");
                                if(option.getText().equals(answer)){
                                    option.setStyle("-fx-background-color: green; ");
                                }
                            }else if(attempts == 1){
                                final Button optionBtn = option;
                                optionBtn.setOnMouseClicked(e -> {
                                    int point = 0;
                                    optionBtn.setStyle("-fx-background-color: #dddddd;");
                                    if(optionBtn.getText().equals(answer)){
                                        JOptionPane.showMessageDialog(new JFrame(), "Congratulations! You answered it correctly. You have been awarded 1 point !", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                                        point = 1;     
//                                        SessionManager.getCurrentUser().setCurrentPoint(SessionManager.getCurrentUser().getCurrentPoint() + 1);
                                    }else {
                                        JOptionPane.showMessageDialog(new JFrame(), "Your answer is still incorrect, the correct answer will be revealed", "Dialog", JOptionPane.ERROR_MESSAGE);
                                        point = 0;
                                    }
                                    try{
                                        sql = "UPDATE user_trivia SET attempts = ? WHERE email = ? AND id = ?";
                                        preparedStatement = conn.prepareStatement(sql);
                                        preparedStatement.setInt(1, 2);
                                        preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());
                                        preparedStatement.setInt(3, quesNum);
                                        int rowsAffected = preparedStatement.executeUpdate();
                                        
                                        sql = "UPDATE user SET current_points = (current_points + ?) WHERE email = ?";
                                        preparedStatement = conn.prepareStatement(sql);
                                        preparedStatement.setInt(1, point);
                                        preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());
                                        rowsAffected = preparedStatement.executeUpdate();
                                    }catch(Exception ex){
                                        ex.printStackTrace();
                                    }
                                    initializeQues();
                                });
                            }else if(attempts == 0){
                                final Button optionBtn = option;
                                
                                optionBtn.setOnMouseClicked(ev -> {
                                    int point = 0;
                                    int attemptsNow = 1;
                                    
                                    if(optionBtn.getText().equals(answer)){
                                        JOptionPane.showMessageDialog(new JFrame(), "Congratulations! You answered it correctly. You have been awarded 2 point !", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                                        point = 2;  
                                        attemptsNow = 2;
//                                        SessionManager.getCurrentUser().setCurrentPoint(SessionManager.getCurrentUser().getCurrentPoint() + point);
                                        initializeQues();
                                        
                                    }else {
                                        attemptsNow = 1;
                                        point = 0;
                                        JOptionPane.showMessageDialog(new JFrame(), "Whoops, that doesn’t look right, try again!", "Dialog", JOptionPane.ERROR_MESSAGE);
                                        setQuesNum(quesNum);
                                    }
                                    try{
                                        sql = "INSERT INTO user_trivia(attempts, email, id) VALUES(?, ?, ?)";
                                        preparedStatement = conn.prepareStatement(sql);
                                        preparedStatement.setInt(1, attemptsNow);
                                        preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());
                                        preparedStatement.setInt(3, quesNum);
                                        int rowsAffected = preparedStatement.executeUpdate();
                                        
                                        
                                        sql = "UPDATE user SET current_points = (current_points + ?) WHERE email = ?";
                                        preparedStatement = conn.prepareStatement(sql);
                                        preparedStatement.setInt(1, point);
                                        preparedStatement.setString(2, SessionManager.getCurrentUser().getEmail());
                                        rowsAffected = preparedStatement.executeUpdate();
                                        
                                        TriviaController triviaController = new TriviaController();
                                        triviaController.toQuestion(optionBtn, quesNum);       
                                    }catch(Exception ex){
                                        ex.printStackTrace();
                                    }
                                });     
                            }
                        }
                        count++;
                    }  
                }else {
                    System.out.println("Question not found");
                }
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Connection conn = JConnection.Conn();
            
            String sql = "SELECT *, count(*) AS count FROM user WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, SessionManager.getCurrentUser().getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            BorderPane bp1 = (BorderPane)question.getScene().getRoot();
            
           
            int point = 0;
            while(resultSet.next()) { 
                if(resultSet.getInt("count") == 1){
                    point = resultSet.getInt("current_points");
                    ((Text)bp1.lookup("#pointsText")).setText("Points: " + point);
                    
                }
            }
            
            System.out.println("Current Points : " + point);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
    public void setQuesNum(int dayNum){  
        
        optionList = new ArrayList<>();
        optionList.clear();
        optionList.add("optionA");
        optionList.add("optionB");
        optionList.add("optionC");
        optionList.add("optionD");
        Collections.shuffle(optionList);
        
//        String answer = "";
        this.quesNum = dayNum;
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        question.setText("Question " + quesNum);
    }    
}
