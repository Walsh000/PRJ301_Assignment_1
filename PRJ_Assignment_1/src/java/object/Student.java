/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.sql.Date;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Student extends User {
    private String StudentID;
    private Schedule Schedule;

    public Student() {
    }

    public Student(String StudentID, Schedule Schedule, String userID, String userGmail, String userPassword, String username, boolean gender, Date dateOfBirth, Role userRole) {
        super(userID, userGmail, userPassword, username, gender, dateOfBirth, userRole);
        this.StudentID = StudentID;
        this.Schedule = Schedule;
    }
    
    public Student(User user, String StudentID, Schedule Schedule) {
        super(user);
        this.StudentID = StudentID;
        this.Schedule = Schedule;
    }

    public void setSchedule(Schedule Schedule) {
        this.Schedule = Schedule;
    }
    
    public String getStudentID() {
        return StudentID;
    }

    public Schedule getSchedule() {
        return Schedule;
    }
    
//    @Override
//    public String toString() {
//        return "UserID: " + getUserID() +"\n";
//    }

    
}
