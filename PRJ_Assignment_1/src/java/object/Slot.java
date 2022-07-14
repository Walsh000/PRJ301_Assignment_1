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
    private int slotNo;
    private Time startTime;
    private Time endTime;

    public Slot() {
    }

    public Slot(int SlotNo, Time StartTime, Time EndTime) {
        this.slotNo = SlotNo;
        this.startTime = StartTime;
        this.endTime = EndTime;
    }

    public Slot(int SlotNo) {
        this.slotNo = SlotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int SlotNo) {
        this.slotNo = SlotNo;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time StartTime) {
        this.startTime = StartTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time EndTime) {
        this.endTime = EndTime;
    }
    
    
}
