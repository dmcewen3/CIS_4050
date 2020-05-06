package business;


import java.util.List;

public class Tutor {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String[] subjects;
    
    //default constructor
    public Tutor() {
        
    }
    
    //constructor
    public Tutor(int employeeID, String firstName, String lastName, String [] subjects){
        
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
        
        
    }

    

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    
}