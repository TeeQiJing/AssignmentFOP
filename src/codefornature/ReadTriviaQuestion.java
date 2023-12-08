/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package codefornature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
        try {
            // Establish a database connection
            Connection conn = JConnection.Conn();
            
            
            String deleteSql = "DELETE FROM trivia";
            PreparedStatement statement = conn.prepareStatement(deleteSql);
            statement.executeUpdate();
            
            // Read the file using BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\TriviaSample.txt"));
            String line;

            // Prepare SQL statement for insertion
            String sql = "INSERT INTO trivia (question, optionA, optionB, optionC, optionD, answer) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Loop through all lines till the end of file
            while ((line = br.readLine()) != null) {
                // do not select empty line(between 2 question sets)
                if (!line.trim().isEmpty()) {
                    // Parse the lines and set values in the prepared statement
                    preparedStatement.setString(1, line.trim()); // QuestionTopic
                    String[] options = br.readLine().split(",");
                    for (int i = 0; i < 4; i++) {
                        preparedStatement.setString(i + 2, options[i].trim()); // OptionA, OptionB, OptionC, OptionD
                    }
                    preparedStatement.setString(6, br.readLine().trim()); // Answer

                    // Execute the insertion
                    preparedStatement.executeUpdate();
                }
            }

            // Close resources
            br.close();
            preparedStatement.close();
            conn.close();

            System.out.println("Data insertion successful.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
