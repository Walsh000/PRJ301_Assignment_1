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
    private String groupID;
    private Course course;
    private Semester semester;
    private ArrayList<Student> studentList;

    public Group() {
    }

    public Group(String GroupID) {
        this.groupID = GroupID;
    }
    
    public Group(String GroupID, ArrayList<Student> StudentList) {
        this.groupID = GroupID;
        this.studentList = StudentList;
    }

    public Group(String groupID, Course course, Semester semester) {
        this.groupID = groupID;
        this.course = course;
        this.semester = semester;
    }

    public Group(String groupID, Course course) {
        this.groupID = groupID;
        this.course = course;
    }

    public String getGroupID() {
        return groupID;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.studentList = StudentList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return groupID + "\n" + course.getCourseID() + "\n" + course.getCourseName() + "\n" + semester + "\n\n";
    }
    
}
