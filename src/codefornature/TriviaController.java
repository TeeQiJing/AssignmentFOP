/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package codefornature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class TriviaController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    public void readTriviaQues() throws IOException{
        FileReader in = new FileReader("../TriviaSample.txt");
        BufferedReader br = new BufferedReader(in);

        while (br.readLine() != null) {
            System.out.println(br.readLine());
        }
        in.close();
    }  
}
