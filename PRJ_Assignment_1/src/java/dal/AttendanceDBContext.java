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
import object.AttendanceStatus;
import object.Group;
import object.Lecturer;
import object.Session;
import object.Student;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<AttendanceStatus> getAttendanceStatus(Group group) {
        try {
            ArrayList<AttendanceStatus> attendanceStatusList = new ArrayList<>();
            String attSQL = "select StudentID, s.GroupID, sum(case [Attendance] when 1 then 1 else 0 end) as countAttendance, count(s.SessionID) as countSession \n"
                    + "from Attendance a\n"
                    + "inner join [Session] s on s.SessionID = a.SessionID\n"
                    + "inner join [Group] g on g.GroupID = s.GroupID\n"
                    + "where s.GroupID = ?\n"
                    + "and s.Date < '2022-06-20'\n"
                    + "group by StudentID, s.GroupID";
            PreparedStatement statement = connection.prepareStatement(attSQL);
            statement.setString(1, group.getGroupID());
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                AttendanceStatus attendanceStatus = 
                        new AttendanceStatus(
                                new Student(results.getString("StudentID")), 
                                group, 
                                results.getInt("countSession"), 
                                results.getInt("countAttendance"));
                attendanceStatusList.add(attendanceStatus);
            }
            return attendanceStatusList;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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
            if (result.next()) {
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

//    void generateData() {
//        try {
//            String getSessionSQL = "SELECT [SessionID]\n"
//                    + "      ,[LecturerID]\n"
//                    + "      ,[GroupID]\n"
//                    + "      ,[Date]\n"
//                    + "      ,[SlotNo]\n"
//                    + "      ,[RoomID]\n"
//                    + "      ,[SessionContentID]\n"
//                    + "  FROM [Session]\n"
//                    + "  where date < '2022-06-20'";
//            PreparedStatement statement = connection.prepareStatement(getSessionSQL);
//            ResultSet results = statement.executeQuery();
//            while (results.next()) {
//                String getAttendances = "SELECT [StudentID]\n"
//                        + "      ,[SessionID]\n"
//                        + "      ,[Attendance]\n"
//                        + "  FROM [Attendance]"
//                        + "  WHERE [SessionID] = ?";
//                PreparedStatement attStatement = connection.prepareStatement(getAttendances);
//                attStatement.setInt(1, results.getInt("SessionID"));
//                ResultSet attResults = attStatement.executeQuery();
//                while (attResults.next()) {
//                    Attendance attendance = new Attendance(
//                            new Session(attResults.getString("SessionID")),
//                            new Student(attResults.getString("StudentID")),
//                            ((int) (Math.random() * 10)) < 9);
//                    update(attendance);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
}
