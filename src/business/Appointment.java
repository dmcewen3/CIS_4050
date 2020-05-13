/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * 
 */
public class Appointment {
    private int ScheduleID;
    private int SlotID;
    private int CRN;
    private int StudentID;
    
    public Appointment(){
    }
    
    public Appointment(int ScheduleID, int SlotID, int CRN, int StudentID){
        this.ScheduleID = ScheduleID;
        this.SlotID = SlotID;
        this.CRN = CRN;
        this.StudentID = StudentID;
    }

    /**
     * @return the ScheduleID
     */
    public int getScheduleID() {
        return ScheduleID;
    }

    /**
     * @param ScheduleID the ScheduleID to set
     */
    public void setScheduleID(int ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    /**
     * @return the SlotID
     */
    public int getSlotID() {
        return SlotID;
    }

    /**
     * @param SlotID the SlotID to set
     */
    public void setSlotID(int SlotID) {
        this.SlotID = SlotID;
    }

    /**
     * @return the CRN
     */
    public int getCRN() {
        return CRN;
    }

    /**
     * @param CRN the CRN to set
     */
    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    /**
     * @return the StudentID
     */
    public int getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }
    
    
}
