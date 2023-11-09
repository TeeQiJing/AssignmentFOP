/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package codefornature;

/**
 *
 * @author GIGA
 */
public class User {

    /**
     * @param args the command line arguments
     */
    private String email;
    private String username;
    private String password;
    private String registrationDate;
    private int currentPoint;
   
    public User(String email, String username, String password, String registrationDate, int currentPoint){
        this.email = email;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
        this.currentPoint = currentPoint;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    
    public String getRegistrationDate(){
        return this.registrationDate;
    }
    public void setRegistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
    }
    
    
    public int getCurrentPoint(){
        return this.currentPoint;
    }
    public void setCurrentPoint(int currentPoint){
        this.currentPoint = currentPoint;
    }
}