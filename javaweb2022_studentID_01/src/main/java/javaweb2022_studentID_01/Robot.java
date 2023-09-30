/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaweb2022_studentID_01;

/**
 *
 * @author C7
 */
public class Robot {
    
    public String response(String question){
        String str="";
        
        switch (question){
            case "who are you":
                str="I am a student.";
                break;
            case "where is your hometown":
                str="Hsin-chu";
                break;                
        }
        return str;
    }
    
}
