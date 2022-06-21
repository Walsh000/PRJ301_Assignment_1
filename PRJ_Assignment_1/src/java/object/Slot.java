/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.sql.Time;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Slot {
    private int SlotNo;
    private Time StartTime;
    private Time EndTime;

    public Slot() {
    }

    public Slot(int SlotNo, Time StartTime, Time EndTime) {
        this.SlotNo = SlotNo;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
    }

    public Slot(int SlotNo) {
        this.SlotNo = SlotNo;
    }

    public int getSlotNo() {
        return SlotNo;
    }

    public void setSlotNo(int SlotNo) {
        this.SlotNo = SlotNo;
    }

    public Time getStartTime() {
        return StartTime;
    }

    public void setStartTime(Time StartTime) {
        this.StartTime = StartTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public void setEndTime(Time EndTime) {
        this.EndTime = EndTime;
    }
    
    
}
