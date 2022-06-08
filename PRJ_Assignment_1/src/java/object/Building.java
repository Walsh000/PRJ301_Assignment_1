/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Building {
    private String BuildingID, Name;

    public Building(String BuildingID, String Name) {
        this.BuildingID = BuildingID;
        this.Name = Name;
    }

    public Building() {
    }

    public String getBuildingID() {
        return BuildingID;
    }

    public void setBuildingID(String BuildingID) {
        this.BuildingID = BuildingID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
