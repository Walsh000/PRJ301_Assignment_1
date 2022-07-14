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

    @Override
    public String toString() {
        return student + " | " + group.getGroupID() + " | " + tookPlace + " | " + attend + "\n";
    }
    
}
