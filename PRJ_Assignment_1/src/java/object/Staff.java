/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Staff extends User{
    private String StaffID;

    public Staff() {
    }

    public Staff(User User, String StaffID) {
        super(User);
        this.StaffID = StaffID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public Staff(String StaffID, String userID) {
        super(userID);
        this.StaffID = StaffID;
    }
    
    
}
