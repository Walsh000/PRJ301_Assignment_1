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
public class Session {
    private String SessionID;
    private Lecturer lecturer;
    private Slot Slot;
    private Group group;
    private Date Date;
    private Room Room;
    private boolean attendanceChecked;

    public Session() {
    }

    public Session(String SessionID, Lecturer lecturer, Slot Slot, Group Group, Date Date, Room Room) {
        this.SessionID = SessionID;
        this.lecturer = lecturer;
        this.Slot = Slot;
        this.group = Group;
        this.Date = Date;
        this.Room = Room;
    }

    public Session(String SessionID) {
        this.SessionID = SessionID;
    }
    
    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }

    public Slot getSlot() {
        return Slot;
    }

    public void setSlot(Slot Slot) {
        this.Slot = Slot;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group Group) {
        this.group = Group;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Room getRoom() {
        return Room;
    }

    public void setRoom(Room Room) {
        this.Room = Room;
    }
    
    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public boolean isAttendanceChecked() {
        return attendanceChecked;
    }

    public void setAttendanceChecked(boolean attendanceChecked) {
        this.attendanceChecked = attendanceChecked;
    }

    @Override
    public String toString() { 
        return "ID: " +SessionID + "\nLect: " + lecturer.getLecturerID() + "\nDate: " + Date + "\n\n";
    }
    
}
