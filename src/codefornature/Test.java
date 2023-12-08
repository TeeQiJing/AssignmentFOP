/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package codefornature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author GIGA
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        try{
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            String firstInput = "23 01 1997";
            String secondInput = "24 01 1997";
            final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
            final LocalDate secondDate = LocalDate.parse(secondInput, formatter);
            final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
            System.out.println("Days between: " + days);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
