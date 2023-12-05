/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package codefornature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author GIGA
 */
public class ReadTriviaQuestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        readTriviaQues();
    }
    public static void readTriviaQues(){
        try{
            String triviaFile = System.getProperty("user.dir") + "\\TriviaSample.txt";
            FileReader in = new FileReader(triviaFile);
            BufferedReader br = new BufferedReader(in);
            
            ArrayList<String> question = new ArrayList();
            String lines = "", line;
            while ((line = br.readLine()) != null) {
                lines = lines +"\n" + line;
            }
            in.close();
            
//            System.out.println(lines);
                
            String [] quesArr = lines.split("\n");
            
            System.out.println(quesArr[0]);
            System.out.println(":::");
            System.out.println(quesArr[1]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
