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
public class Group {
    private String GroupID;
    private ArrayList<Student> StudentList;

    public Group() {
    }

    public Group(String GroupID, ArrayList<Student> StudentList) {
        this.GroupID = GroupID;
        this.StudentList = StudentList;
    }

    public String getGroupID() {
        return GroupID;
    }

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }
    
    
}
