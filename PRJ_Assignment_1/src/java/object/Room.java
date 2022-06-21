/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Room {
    private String RoomID;
    private Building Building;
    private int Floor;
    private int RoomNo;

    public Room(String RoomID, Building Building, int Floor, int RoomNo) {
        this.RoomID = RoomID;
        this.Building = Building;
        this.Floor = Floor;
        this.RoomNo = RoomNo;
    }

    public Room() {
    }

    public Room(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public Building getBuilding() {
        return Building;
    }

    public void setBuilding(Building Building) {
        this.Building = Building;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int Floor) {
        this.Floor = Floor;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int RoomNo) {
        this.RoomNo = RoomNo;
    }
    
}
