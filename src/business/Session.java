/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author David
 */
public class Session {
    private int SessionID;
    private String StartTime;
    private String EndTime;
    private String Topic;
    private int TutorID;
    private int CRN;
    
    public Session(){
        
    }
    
    public Session(int SessionID, String StartTime, String EndTime, String Topic, int TutorID, int CRN){
        this.SessionID = SessionID;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Topic = Topic;
        this.TutorID = TutorID;
    }

    /**
     * @return the SessionID
     */
    public int getSessionID() {
        return SessionID;
    }

    /**
     * @param SessionID the SessionID to set
     */
    public void setSessionID(int SessionID) {
        this.SessionID = SessionID;
    }

    /**
     * @return the StartTime
     */
    public String getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the EndTime
     */
    public String getEndTime() {
        return EndTime;
    }

    /**
     * @param EndTime the EndTime to set
     */
    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    /**
     * @return the Topic
     */
    public String getTopic() {
        return Topic;
    }

    /**
     * @param Topic the Topic to set
     */
    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    /**
     * @return the TutorID
     */
    public int getTutorID() {
        return TutorID;
    }

    /**
     * @param TutorID the TutorID to set
     */
    public void setTutorID(int TutorID) {
        this.TutorID = TutorID;
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
    
    
}
