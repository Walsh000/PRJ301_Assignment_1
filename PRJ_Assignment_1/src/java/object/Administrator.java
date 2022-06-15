/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Administrator extends User {
    private String AdministratorID;

    public Administrator(String AdministratorID, User user) {
        super(user);
        this.AdministratorID = AdministratorID;
    }

    public Administrator() {
    }

    public Administrator(String AdministratorID, String userID) {
        super(userID);
        this.AdministratorID = AdministratorID;
    }

    public String getAdministratorID() {
        return AdministratorID;
    }
    
}
