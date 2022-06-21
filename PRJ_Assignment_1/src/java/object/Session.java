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
    private Group Group;
    private Date Date;
    private Room Room;
    private SessionContent sessionContent;

    public Session() {
    }

    public Session(String SessionID, Lecturer lecturer, Slot Slot, Group Group, Date Date, Room Room, SessionContent sessionContent) {
        this.SessionID = SessionID;
        this.lecturer = lecturer;
        this.Slot = Slot;
        this.Group = Group;
        this.Date = Date;
        this.Room = Room;
        this.sessionContent = sessionContent;
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
        return Group;
    }

    public void setGroup(Group Group) {
        this.Group = Group;
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

    public SessionContent getSessionContent() {
        return sessionContent;
    }

    public void setSessionContent(SessionContent sessionContent) {
        this.sessionContent = sessionContent;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() { 
        return "ID: " +SessionID + "\nLect: " + lecturer.getLecturerID() + "\nDate: " + Date + "\n\n";
    }
    
}
