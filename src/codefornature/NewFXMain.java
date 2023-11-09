/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package codefornature;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author GIGA
 */
public class NewFXMain extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
        
//        Scene scene = new Scene(root, 300, 250);
        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
//        FXMLLoader loader = new FXMLLoader(System.getProperty("user.dir") + "\\src\\codefornature\\Login.fxml");
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Log In Page");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
