/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe.method_romjanali01673;

/**
 *
 * @author romja
 */
public class notificationStore {
    private int student_id;
    private int employee_id;
    private String subject;
    private java.sql.Time T_time;
    private java.sql.Date T_date;
    private String message; 
    private String description;

    // Constructor
    public notificationStore(){
        
    }
    
    public notificationStore(int student_id, int employee_id, String subject, java.sql.Time T_time, java.sql.Date T_date, String message, String description){
        this.student_id=student_id;
        this.employee_id=employee_id;
        this.subject=subject;
        this.T_time=T_time;
        this.T_date=T_date;
        this.message=message;
        this.description=description;
    }
    //get data
    public int get_student__id(){
        return student_id;
    }
    public int get_employee__id(){
        return employee_id;
    }
    public String get_subject(){
        return subject;
    }
    public java.sql.Time get_time(){
        return T_time;
    }
    public java.sql.Date get_date(){
        return T_date;
    }
    public String get_message(){
        return message;
    }
    public String get_description(){
        return description;
    }
    //set data
    public void set_student__id(int student_id){
        this.student_id=student_id;
    }
    public void set_employee__id(int employee_id){
        this. employee_id=employee_id;
    }
    public void set_subject(String subject){
        this. subject=subject;
    }
    public void set_time(java.sql.Time T_time){
        this.T_time=T_time;
    }
    public void set_date(java.sql.Date T_date){
        this. T_date=T_date;
    }
    public void set_message(String message){
        this.message=message;
    }
    public void set_description(String description){
        this.description=description;
    }
    
}
