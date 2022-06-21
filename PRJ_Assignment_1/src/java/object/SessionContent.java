/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class SessionContent {
    private String SessionContentID;
    private Course Course;
    private int SessionNo;
    private String Content;

    public SessionContent(String SessionContentID, Course Course, int SessionNo, String Content) {
        this.SessionContentID = SessionContentID;
        this.Course = Course;
        this.SessionNo = SessionNo;
        this.Content = Content;
    }

    public SessionContent(String SessionContentID) {
        this.SessionContentID = SessionContentID;
    }

    public SessionContent() {
    }

    public String getSessionContentID() {
        return SessionContentID;
    }

    public Course getCourse() {
        return Course;
    }

    public int getSessionNo() {
        return SessionNo;
    }

    public String getContent() {
        return Content;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public void setSessionNo(int SessionNo) {
        this.SessionNo = SessionNo;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
}
