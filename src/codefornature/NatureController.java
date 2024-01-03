/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GIGA
 */
public class NatureController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static Connection conn;
    private String query;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private ArrayList<String> titleList = new ArrayList<>();
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<String> urlList = new ArrayList<>();
    private int i=0;
    private int j=0;
    @FXML
    private Label news2;
    @FXML
    private Label news3;
    @FXML
    private Label news5;
    @FXML
    private Label news4;
    @FXML
    private Label news1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;
    @FXML
    private Label date1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initNature();
        
        
    }    
    
    public void initNature(){
        ArrayList<Label> newsArr = new ArrayList<>();
        newsArr.add(news1);
        newsArr.add(news2);
        newsArr.add(news3);
        newsArr.add(news4);
        newsArr.add(news5);
       
        ArrayList<Label> datesArr = new ArrayList<>();
        datesArr.add(date1);
        datesArr.add(date2);
        datesArr.add(date3);
        datesArr.add(date4);
        datesArr.add(date5);

        try{
            conn = JConnection.Conn();
            String query = "SELECT * FROM news WHERE title LIKE '%nature%' LIMIT 5";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int count =0;
            while(resultSet.next()&& count<5){
                String title = resultSet.getString("title");
                titleList.add(title);
                String date = resultSet.getString("date");
                dateList.add(date);
                String url = resultSet.getString("url");
                urlList.add(url);
                
                count++;
            
            }
            String[] titleArr = titleList.toArray(new String[0]);
            String[] dateArr = dateList.toArray(new String[0]);
            String [] urlArray = urlList.toArray(new String[0]);
            
            for(;i<5;i++){
                Label news = newsArr.get(i);
                news.setText(titleArr[i]);
                Label date = datesArr.get(i);
                date.setText(dateArr[i]);
                
            
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        } 
    }    
    public void openLink() {
        try{
            conn = JConnection.Conn();
            String query = "SELECT URL FROM news WHERE title LIKE '%nature%' LIMIT 5";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int count =0;
            while(resultSet.next()&& count<5){
                
                String url = resultSet.getString("url");
                urlList.add(url);

                count++;

            }

           
            String [] urlArray = urlList.toArray(new String[0]);

            
                


             
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            try {
                
                    System.out.println(urlArray[j]);
                    desktop.browse(new java.net.URI(urlArray[j]));
                    System.out.println("j ="+j);
                
                
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        } 
            
            
        
        
    }

    @FXML
    private void news2Btn(MouseEvent event) {
        j=1;
        openLink();
        
    }

    @FXML
    private void news3Btn(MouseEvent event) {
        j=2;
        openLink();
    }

    @FXML
    private void nesw4Btn(MouseEvent event) {
        j=3;
        openLink();
    }

    @FXML
    private void news5Btn(MouseEvent event) {
        j=4;
        openLink();
    }

    @FXML
    private void new1Btn(MouseEvent event) {
        j=0;
        openLink();
    }
    
    
}
