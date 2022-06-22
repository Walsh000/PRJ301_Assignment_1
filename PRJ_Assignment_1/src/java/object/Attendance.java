/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Attendance {
    private Session session;
    private Student student;
    private boolean isAttend;

    public Attendance() {
    }

    public Attendance(Session session, Student student, boolean isAttend) {
        this.session = session;
        this.student = student;
        this.isAttend = isAttend;
    }

    public Attendance(Session session, Student student) {
        this.session = session;
        this.student = student;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isIsAttend() {
        return isAttend;
    }

    public void setIsAttend(boolean isAttend) {
        this.isAttend = isAttend;
    }
    
    
}
