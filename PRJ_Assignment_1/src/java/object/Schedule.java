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
public class Schedule {
    private final String ScheduleID;
    private ArrayList<Session> SessionList;

    public Schedule(String ScheduleID, ArrayList<Session> SessionList) {
        this.ScheduleID = ScheduleID;
        this.SessionList = SessionList;
    }

    public String getScheduleID() {
        return ScheduleID;
    }

    public ArrayList<Session> getSessionList() {
        return SessionList;
    }

    public void setSessionList(ArrayList<Session> SessionList) {
        this.SessionList = SessionList;
    }
    
}
