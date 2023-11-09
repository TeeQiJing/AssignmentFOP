/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package codefornature;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author GIGA
 */
public class MainMenu extends Application {
    double x,y = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader  = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        root.setOnMousePressed(event->{
            x = event.getSceneX();
            y = event.getSceneY();
        });
        
        root.setOnMouseDragged(event->{
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        }); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
