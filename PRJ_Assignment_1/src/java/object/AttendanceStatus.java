/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.util.Formatter;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AttendanceStatus {
    private Student student;
    private Group group;
    private double progress;
    private double attendRate;
    private double absentRate;

    public AttendanceStatus() {
    }

    public AttendanceStatus(Student student, Group group, double progress, double attendRate, double absentRate) {
        this.student = student;
        this.group = group;
        this.progress = progress;
        this.attendRate = attendRate;
        this.absentRate = absentRate;
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

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getAttendRate() {
        return attendRate;
    }

    public void setAttendRate(double attendRate) {
        this.attendRate = attendRate;
    }

    public double getAbsentRate() {
        return absentRate;
    }

    public void setAbsentRate(double absentRate) {
        this.absentRate = absentRate;
    }

    @Override
    public String toString() {
        return student + " | " + group.getGroupID() + " | " + progress + " | " + attendRate + "\n";
    }
    
}
