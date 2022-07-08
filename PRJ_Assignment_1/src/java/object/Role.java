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
public class Role {

    private int roleID;
    private String roleName;
    private ArrayList<Feature> featureList;

    public Role(int roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Role(int roleID) {
        this.roleID = roleID;
    }

    public Role() {
    }

    public int getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public ArrayList<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(ArrayList<Feature> featureList) {
        this.featureList = featureList;
    }

}
