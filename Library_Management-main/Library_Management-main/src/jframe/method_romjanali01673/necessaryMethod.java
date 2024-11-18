
package jframe.method_romjanali01673;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class necessaryMethod extends JFrame{
    
//this.setState(this.ICONIFIED); 
//System.exit(0); 
    
    
    
    
    
    public String remove_white_space(String str){
        // Remove leading whitespaces
        int start = 0;
        while (start < str.length() && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        // Remove trailing whitespaces
        int end = str.length() - 1;
        while (end >= 0 && Character.isWhitespace(str.charAt(end))) {
            end--;
        }
        String sub_string = str.substring(start, end+1);
        // Return the substring without leading and trailing whitespaces
        return sub_string;
    }
    public java.sql.Date getTodayDate(){
        LocalDate today = LocalDate.now();
        
        // Convert LocalDate to java.sql.Date
        java.sql.Date sqlDate = java.sql.Date.valueOf(today);
        return sqlDate;
    }
    public java.sql.Time getNowTime(){
        LocalTime now_time = LocalTime.now();
        java.sql.Time time = java.sql.Time.valueOf(now_time);
        return time;
    }
    public  String genarateOtp(){
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        String pin = String.format("%06d", randomNumber);
        return pin;
    }
    public int stringToint(String str){
        int i = 0;
        try{
            i = Integer.parseInt(remove_white_space(str));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Enter Valid Input!");
        }
        return i;
    }
    public java.sql.Time stringToTime(String dateString){
        // Define the format of the input date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

        try {
            // Parse the date string into a java.util.Date object
            java.util.Date parsedUtilDate = dateFormat.parse(remove_white_space(dateString));

            // Convert the java.util.Date object to a java.sql.Date object
            java.sql.Time sqlTime = new java.sql.Time(parsedUtilDate.getTime());

            // Print the java.sql.Date object
            System.out.println("Converted java.sql.Date: " + sqlTime);
            return sqlTime;
        } catch (ParseException e) {
            // Handle parsing errors
            e.printStackTrace();
        }
        return null;
    }
    public long stringToLong(String string){
        long l=0l;
        try{
            l=Long.valueOf(remove_white_space(string));
        }catch(Exception e){
            e.printStackTrace();
        }
    return l;
    }
    public java.sql.Date stringToDate(String YYYY_MM_DD){
        // Define the format of the input date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parse the date string into a java.util.Date object
            java.util.Date parsedUtilDate = dateFormat.parse(remove_white_space(YYYY_MM_DD));

            // Convert the java.util.Date object to a java.sql.Date object
            java.sql.Date sqlDate = new java.sql.Date(parsedUtilDate.getTime());

            // Print the java.sql.Date object
            System.out.println("Converted java.sql.Date: " + sqlDate);
            return sqlDate;
        } catch (ParseException e) {
            // Handle parsing errors
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
}
