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
import object.Staff;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class StaffDBContext extends DBContext<Staff>{

    @Override
    public Staff get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Staff> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Staff get(Staff entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Staff entity) {
        try {
            String sql = "INSERT INTO Staff\n"
                    + "           ([UserID]\n"
                    + "           ,[StaffID])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserID());
            statement.setString(2, entity.getStaffID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Staff entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Staff entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void generateData() {
        try {
            String sql = "Select userID, RoleID from [User] where RoleID = 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count ++;
                Staff admin = new Staff("ST" + String.format("%06d", count), resultSet.getString("UserID"));
                insert(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
