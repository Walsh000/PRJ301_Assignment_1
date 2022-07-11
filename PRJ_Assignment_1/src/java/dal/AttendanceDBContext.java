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
import object.Attendance;
import object.Session;
import object.Student;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AttendanceDBContext extends DBContext<Attendance> {
    
    public void clear(Session session) {
        try {
            String sql = "UPDATE [Attendance]\n"
                    + "   SET [Attendance] = 0\n"
                    + " WHERE [SessionID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, session.getSessionID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isAttend(Student student, Session session) {
        try {
            String sql = "SELECT [StudentID]\n"
                    + "      ,[SessionID]\n"
                    + "      ,[Attendance]\n"
                    + "  FROM [Attendance]\n"
                    + "  WHERE [StudentID]=?\n"
                    + "  AND SessionID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getStudentID());
            statement.setString(2, session.getSessionID());
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                return result.getBoolean("Attendance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance entity) {
        try {
            String sql = "UPDATE [Attendance]\n"
                    + "   SET [Attendance] = ?\n"
                    + " WHERE [SessionID] = ?\n"
                    + " AND [StudentID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, entity.isIsAttend());
            statement.setString(2, entity.getSession().getSessionID());
            statement.setString(3, entity.getStudent().getStudentID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
