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
    
    private String LecturerID;
    private ArrayList<Group> groupList;

    public Lecturer() {
    }

    public Lecturer(String LecturerID, User user) {
        super(user);
        this.LecturerID = LecturerID;
    }

    public Lecturer(String LecturerID, ArrayList<Group> groupList, User user) {
        super(user);
        this.LecturerID = LecturerID;
        this.groupList = groupList;
    }

    public Lecturer(String LecturerID, String userID) {
        super(userID);
        this.LecturerID = LecturerID;
    }

    public String getLecturerID() {
        return LecturerID;
    }

    public void setLecturerID(String LecturerID) {
        this.LecturerID = LecturerID;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }
    
}
