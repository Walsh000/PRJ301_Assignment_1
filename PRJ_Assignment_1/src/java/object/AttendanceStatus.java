/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AttendanceStatus {
    private Student student;
    private Group group;
    private int tookPlace;
    private int attend;

    public AttendanceStatus() {
    }

    public AttendanceStatus(Student student, Group group, int tookPlace, int attend) {
        this.student = student;
        this.group = group;
        this.tookPlace = tookPlace;
        this.attend = attend;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getTookPlace() {
        return tookPlace;
    }

    public void setTookPlace(int tookPlace) {
        this.tookPlace = tookPlace;
    }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }
    
    public int getAbsent() {
        return tookPlace - attend;
    }

    @Override
    public String toString() {
        return student + " | " + group.getGroupID() + " | " + tookPlace + " | " + attend + "\n";
    }
    
}
