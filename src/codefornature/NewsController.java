/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NewsController implements Initializable {
    @FXML
    private GridPane gp;
    private static Connection conn;
    private String sql;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private int j=1;
    private int i=1;
    private int countValue=0;
    private ArrayList<String> titleList = new ArrayList<>();
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<String> urlList = new ArrayList<>();
    

    @FXML
    private Label news1;
    @FXML
    private Label news2;
    @FXML
    private Label news3;
    @FXML
    private Label news4;
    @FXML
    private Label news5;
    @FXML
    private Label news6;
    @FXML
    private Label news7;
    @FXML
    private Label news8;
    @FXML
    private Label news9;
    @FXML
    private Label news10;
    @FXML
    private Label news11;
    @FXML
    private Label news12;
    @FXML
    private Label news13;
    @FXML
    private Label news14;
    @FXML
    private Label news15;
    @FXML
    private Label news16;
    @FXML
    private Label news17;
    @FXML
    private Label news18;
    @FXML
    private Label news19;
    @FXML
    private Label news20;
    @FXML
    private Hyperlink link1;
    @FXML
    private Hyperlink link2;
    @FXML
    private Hyperlink link3;
    @FXML
    private Hyperlink link4;
    @FXML
    private Hyperlink link5;
    @FXML
    private Hyperlink link6;
    @FXML
    private Hyperlink link7;
    @FXML
    private Hyperlink link8;
    @FXML
    private Hyperlink link9;
    @FXML
    private Hyperlink link10;
    @FXML
    private Hyperlink link11;
    @FXML
    private Hyperlink link12;
    @FXML
    private Hyperlink link13;
    @FXML
    private Hyperlink link14;
    @FXML
    private Hyperlink link15;
    @FXML
    private Hyperlink link16;
    @FXML
    private Hyperlink link17;
    @FXML
    private Hyperlink link18;
    @FXML
    private Hyperlink link19;
    @FXML
    private Hyperlink link20;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showNews(j);
    }    

    @FXML
    private void nextBtn(ActionEvent event) {
        if(j<=countValue-20){
            j+=20;
            showNews(j);
        }
    }
    
    @FXML
    private void previousBtn(ActionEvent event) {
        if(j>20 ){
            j-=20;
            showNews(j);
        }  
    }
    
    public void showNews(int j){
        ArrayList<Label> newsArr = new ArrayList<>();
        newsArr.add(news1);
        newsArr.add(news2);
        newsArr.add(news3);
        newsArr.add(news4);
        newsArr.add(news5);
        newsArr.add(news6);
        newsArr.add(news7);
        newsArr.add(news8);
        newsArr.add(news9);
        newsArr.add(news10);
        newsArr.add(news11);
        newsArr.add(news12);
        newsArr.add(news13);
        newsArr.add(news14);
        newsArr.add(news15);
        newsArr.add(news16);
        newsArr.add(news17);
        newsArr.add(news18);
        newsArr.add(news19);
        newsArr.add(news20);
        
        ArrayList<Hyperlink> urlArr = new ArrayList<>();
        urlArr.add(link1);
        urlArr.add(link2);
        urlArr.add(link3);
        urlArr.add(link4);
        urlArr.add(link5);
        urlArr.add(link6);
        urlArr.add(link7);
        urlArr.add(link8);
        urlArr.add(link9);
        urlArr.add(link10);
        urlArr.add(link11);
        urlArr.add(link12);
        urlArr.add(link13);
        urlArr.add(link14);
        urlArr.add(link15);
        urlArr.add(link16);
        urlArr.add(link17);
        urlArr.add(link18);
        urlArr.add(link19);
        urlArr.add(link20);
        
        try{
            conn = JConnection.Conn();
            sql = "SELECT count(*) as count FROM news";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                 countValue= resultSet.getInt("count"); 
            }
            
            sql = "SELECT * FROM news";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String title = resultSet.getString("title");
                titleList.add(title);
                String date = resultSet.getString("date");
                dateList.add(date);
                String url = resultSet.getString("url");
                urlList.add(url);
                
                
            }
            
            String[] titleArr = titleList.toArray(new String[0]);
            String[] dateArr = dateList.toArray(new String[0]);
            String [] urlArray = urlList.toArray(new String[0]);
            int x=j+20;
            
            for(;j<x && j<=countValue;j++){
                StringBuilder strDate = new StringBuilder();
                if(j>countValue){
                    break;
                }
                else if(j<=20){
                    i=j;
                }
                else if(j>20 && j%20!=0){
                    i=j%20;
                }
                else{
                    i=20;
                }
                    
                strDate.append(titleArr[j-1]).append("\n").append("\n").append(dateArr[j-1]);
                String titleDate = strDate.toString();
                Label label = newsArr.get(i-1);                                                                
                label.setText(titleDate);  
                
                
                Hyperlink hyperlink = urlArr.get(i-1);
                hyperlink.setText(urlArray[j-1]);
//                final String []  urlStringArr = urlArray;
                final int z = j;
                hyperlink.setOnAction(e -> {
                    openLink(urlArray[z-1]);
                });
                System.out.println("i is : "+i);
                System.out.println("j is : "+j);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
        private void openLink(String url) {
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
}
      


    
    

    
    


