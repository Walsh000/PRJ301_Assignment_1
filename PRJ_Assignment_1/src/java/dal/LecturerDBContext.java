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
import object.Lecturer;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class LecturerDBContext extends DBContext<Lecturer>{

    @Override
    public ArrayList<Lecturer> list() {
            ArrayList<Lecturer> lecturerList = new ArrayList<>();
        try {
            String sql = "SELECT [UserID], [LecturerID] FROM Lecturer";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Lecturer lecturer = new Lecturer(results.getString("LecturerID"), results.getString("UserID"));
                lecturerList.add(lecturer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            return lecturerList;
    }

    @Override
    public Lecturer get(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Lecturer entity) {
        try{
            String sql = "INSERT INTO Lecturer\n"
                    + "           ([UserID]\n"
                    + "           ,[LecturerID])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserID());
            statement.setString(2, entity.getLecturerID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void generateData() {
        try {
            String sql = "Select userID, RoleID from [User] where RoleID = 2";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count ++;
                Lecturer lecturer = new Lecturer("LT" + String.format("%06d", count), resultSet.getString("UserID"));
                insert(lecturer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
