/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.util.ArrayList;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Lecturer extends User {
    
    private String lecturerID;
    private ArrayList<Group> groupList;

    public Lecturer() {
    }

    public Lecturer(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    
    public Lecturer(String LecturerID, User user) {
        super(user);
        this.lecturerID = LecturerID;
    }

    public Lecturer(String LecturerID, ArrayList<Group> groupList, User user) {
        super(user);
        this.lecturerID = LecturerID;
        this.groupList = groupList;
    }

    public Lecturer(String LecturerID, String userID) {
        super(userID);
        this.lecturerID = LecturerID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String LecturerID) {
        this.lecturerID = LecturerID;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }
    
}
