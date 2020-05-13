/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoringApp.ui;
import database.*;
import business.*;
import java.util.List;

/**
 *
 * 
 */
public class FrameUtil {
        public static Object[][] getAllStudents(){
        List<Student> students = null;
        try{
            students = database.getAllStudents();
        }
        catch(DBException e){
            System.out.println("Unable to display Students.");
            e.getMessage();
        }
        
        if (students == null){
            System.out.println("Unable to get Students.");
        }
        
        //populates an array with the data needed for the table
        Object[][] allStudents = new Object[students.size()][5];
        int i = 0;
        for(Student s : students){
            allStudents[i][0] = s.getStudentID();
            allStudents[i][1] = s.getFirstName();
            allStudents[i][2] = s.getLastName();
            allStudents[i][3] = s.getYear();
            i++;
        }
        allStudents[0][4] = "2:15";
        allStudents[1][4] = "10:30";
        allStudents[2][4] = "1:30";
        
        return allStudents;
    }
    
    public static Object[][] getAllAppointments(){
        List<Appointment> students = null;
        try{
            students = database.getAllAppointments();
        }
        catch(DBException e){
            System.out.println("Unable to display Students.");
            e.getMessage();
        }
        
        if (students == null){
            System.out.println("Unable to get Students.");
        }
        
        //populates an array with the data needed for the table
        Object[][] allStudents = new Object[students.size()][4];
        int i = 0;
        for(Appointment s : students){
            allStudents[i][0] = s.getScheduleID();
            allStudents[i][1] = s.getSlotID();
            allStudents[i][2] = s.getCRN();
            allStudents[i][3] = s.getStudentID();
            i++;
        }
        
        return allStudents;
    }
    
    public static Object[][] getAllApoointments(){
        List<Appointment> students = null;
        try{
            students = database.getAllAppointments();
        }
        catch(DBException e){
            System.out.println("Unable to display Students.");
            e.getMessage();
        }
        
        if (students == null){
            System.out.println("Unable to get Students.");
        }
        
        //populates an array with the data needed for the table
        Object[][] allStudents = new Object[students.size()][4];
        int i = 0;
            allStudents[0][0] = 1;
            allStudents[0][1] = "Aaron";
            allStudents[0][2] = "CIS 3300";
            allStudents[0][3] = "11:00";
            allStudents[1][0] = 2;
            allStudents[1][1] = "Sam";
            allStudents[1][2] = "ACC 2020";
            allStudents[1][3] = "12:30";
            i++;
        
        return allStudents;
    }
    
    public static Object[][] getAllSessions(){
        List<Session> sessions = null;
        try{
            sessions = database.getAllSessions();
        }
        catch(DBException e){
            System.out.println("Unable to display Students.");
            e.getMessage();
        }
        
        if (sessions == null){
            System.out.println("Unable to get Students.");
        }
        
        //populates an array with the data needed for the table
        Object[][] allStudents = new Object[sessions.size()][6];
        int i = 0;
        for(Session s : sessions){
            allStudents[i][0] = s.getSessionID();
            allStudents[i][1] = s.getStartTime();
            allStudents[i][2] = s.getEndTime();
            allStudents[i][3] = s.getTopic();
            i++;
        }
        allStudents[0][4] = "Aaron";
        allStudents[0][5] = "CIS 3300";
        allStudents[1][4] = "Sam";
        allStudents[1][5] = "ACC 2020";
        
        return allStudents;
    }
}
