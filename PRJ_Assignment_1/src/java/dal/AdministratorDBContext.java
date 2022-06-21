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
import object.Administrator;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AdministratorDBContext extends DBContext<Administrator> {

    @Override
    public ArrayList<Administrator> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrator get(Administrator entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Administrator entity) {
        try {
            String sql = "INSERT INTO Administrator\n"
                    + "           ([UserID]\n"
                    + "           ,[AdminID])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserID());
            statement.setString(2, entity.getAdministratorID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Administrator entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Administrator entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public void generateData() {
//        try {
//            String sql = "Select userID, RoleID from [User] where RoleID = 0";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//            int count = 0;
//            while (resultSet.next()) {
//                count ++;
//                Administrator admin = new Administrator("AD" + String.format("%04d", count), resultSet.getString("UserID"));
//                insert(admin);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
