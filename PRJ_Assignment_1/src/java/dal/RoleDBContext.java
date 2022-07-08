/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Feature;
import object.Role;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class RoleDBContext extends DBContext<Role> {

    public ArrayList<Role> roleList(Feature feature) {
        ArrayList<Role> roleList = new ArrayList<>();
        try {
            String sql = "SELECT r.[RoleID]\n"
                    + "      ,[RoleName]\n"
                    + "  FROM [Role] r\n"
                    + "  INNER JOIN [Role_Feature] rf ON r.RoleID = rf.RoleID\n"
                    + "  INNER JOIN [Feature] f ON f.FeatureID = rf.FeatureID\n"
                    + "  WHERE f.FeatureURL = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, feature.getUrl());
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                roleList.add(new Role(results.getInt("RoleID"), 
                        results.getString("RoleName")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }

    @Override
    public ArrayList<Role> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Role get(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
