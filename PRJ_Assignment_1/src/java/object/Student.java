/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Student extends User {

    private String studentID;
    private ArrayList<Group> groupList;

    public Student() {
    }

    public Student(User user, String StudentID) {
        super(user);
        this.studentID = StudentID;
    }

    public Student(String StudentID, ArrayList<Group> groupList, String userID, String userGmail, String userPassword, String username, boolean gender, Date dateOfBirth, Role userRole) {
        super(userID, userGmail, userPassword, username, gender, dateOfBirth, userRole);
        this.studentID = StudentID;
        this.groupList = groupList;
    }

    public Student(String StudentID, String userID) {
        super(userID);
        this.studentID = StudentID;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public void setStudentID(String StudentID) {
        this.studentID = StudentID;
    }

    @Override
    public String toString() {
        return studentID + "\n" + super.getUsername() + "\n\n";
    }

}
