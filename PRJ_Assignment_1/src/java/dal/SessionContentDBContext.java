/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class SessionContentDBContext {
    private String sessionContentID;
    private String courseID;
    private int sessionNo;
    private String description;

    public SessionContentDBContext(String sessionContentID, String courseID, int sessionNo) {
        this.sessionContentID = sessionContentID;
        this.courseID = courseID;
        this.sessionNo = sessionNo;
    }

    public SessionContentDBContext(String sessionContentID, String courseID, int sessionNo, String description) {
        this.sessionContentID = sessionContentID;
        this.courseID = courseID;
        this.sessionNo = sessionNo;
        this.description = description;
    }

    public SessionContentDBContext() {
    }

    public String getSessionContentID() {
        return sessionContentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getSessionNo() {
        return sessionNo;
    }

    public String getDescription() {
        return description;
    }

    public void setSessionContentID(String sessionContentID) {
        this.sessionContentID = sessionContentID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setSessionNo(int sessionNo) {
        this.sessionNo = sessionNo;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
