/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Course;
import object.Group;
import object.Lecturer;
import object.Room;
import object.Semester;
import object.Session;
import object.SessionContent;
import object.Slot;
import object.Student;
import object.User;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Student> listStudent(Session entity) {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement;
            if (entity.getSessionID() == null) {
                String sql = "select u.UserID, s.StudentID, Username, e.GroupID, ss.Date\n"
                        + "from Student s \n"
                        + "inner join [User] u on s.userID = u.UserID \n"
                        + "inner join Enroll e on e.StudentID = s.StudentID\n"
                        + "inner join [Session] ss on ss.GroupID = e.GroupID\n"
                        + "WHERE ss.GroupID = ?"
                        + "AND ss.Date = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, entity.getGroup().getGroupID());
                statement.setDate(2, entity.getDate());

            } else {
                String sql = "select u.UserID, s.StudentID, Username, e.GroupID, ss.Date\n"
                        + "from Student s \n"
                        + "inner join [User] u on s.userID = u.UserID \n"
                        + "inner join Enroll e on e.StudentID = s.StudentID\n"
                        + "inner join [Session] ss on ss.GroupID = e.GroupID\n"
                        + "WHERE ss.SessionID = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, entity.getSessionID());

            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("StudentID"), resultSet.getString("UserID"));
                std.setUsername(resultSet.getString("Username"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;

    }

    public ArrayList<Session> list(Lecturer lecturer) {
        ArrayList<Session> sessionList = new ArrayList<>();
        try {
            String sql = "SELECT [SessionID]\n"
                    + "      ,l.[LecturerID]\n"
                    + "      ,[GroupID]\n"
                    + "      ,[Date]\n"
                    + "      ,[SlotNo]\n"
                    + "      ,[RoomID]\n"
                    + "      ,[SessionContentID]\n"
                    + "FROM Lecturer l "
                    + "inner join [Session] s on l.LecturerID = s.LecturerID"
                    + " WHERE l.LecturerID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lecturer.getLecturerID());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Session session = new Session(result.getString("SessionID"),
                        lecturer, new Slot(result.getInt("SlotNo")),
                        new Group(result.getString("GroupID")),
                        result.getDate("Date"),
                        new Room(result.getString("RoomID")),
                        new SessionContent(result.getString("SessionContentID")));
                sessionList.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessionList;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(Session entity) {
        try {
            PreparedStatement statement;
            if (entity.getSessionID() != null && entity.getSessionID() != "") {
                String sql = "SELECT [SessionID]\n"
                        + "      ,l.[LecturerID]\n"
                        + "      ,UserName\n"
                        + "      ,g.[GroupID]\n"
                        + "      ,c.[CourseID]\n"
                        + "      ,c.[CourseName]\n"
                        + "      ,[Date]\n"
                        + "      ,[SlotNo]\n"
                        + "      ,[RoomID]\n"
                        + "      ,[SessionContentID]\n"
                        + "  FROM [Session] s "
                        + "INNER JOIN [Group] g on s.GroupID = g.GroupID "
                        + "INNER JOIN [Lecturer] l on s.LecturerID = l.LecturerID "
                        + "INNER JOIN [User] u on u.UserID = l.UserID "
                        + "INNER JOIN [Course] c on c.CourseID = g.CourseID "
                        + "WHERE SessionID = ?";

                statement = connection.prepareStatement(sql);
                statement.setString(1, entity.getSessionID());

            } else {
                String sql = "SELECT [SessionID]\n"
                        + "      ,l.[LecturerID]\n"
                        + "      ,l.[UserID]\n"
                        + "      ,UserName\n"
                        + "      ,ImageURL\n"
                        + "      ,g.[GroupID]\n"
                        + "      ,c.[CourseID]\n"
                        + "      ,c.[CourseName]\n"
                        + "      ,[Date]\n"
                        + "      ,[SlotNo]\n"
                        + "      ,[RoomID]\n"
                        + "      ,[SessionContentID]\n"
                        + "  FROM [Session] s "
                        + "INNER JOIN [Group] g on s.GroupID = g.GroupID "
                        + "INNER JOIN [Lecturer] l on s.LecturerID = l.LecturerID "
                        + "INNER JOIN [User] u on u.UserID = l.UserID "
                        + "INNER JOIN [Course] c on c.CourseID = g.CourseID "
                        + "WHERE s.Date = ? AND s.[GroupID] = ? AND SlotNo = ?";

                statement = connection.prepareStatement(sql);
                statement.setDate(1, entity.getDate());
                statement.setString(2, entity.getGroup().getGroupID());
                statement.setInt(3, entity.getSlot().getSlotNo());

            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                entity.setSessionID(resultSet.getString("SessionID"));
                entity.setLecturer(new Lecturer(resultSet.getString("LecturerID"),
                        new User(resultSet.getString("UserID"), resultSet.getString("Username"))));
                entity.getLecturer().setImageURL(resultSet.getString("ImageURL"));
                entity.setGroup(new Group(resultSet.getString("GroupID"),
                        new Course(resultSet.getString("CourseID"),
                                resultSet.getString("CourseName"))));
                entity.setDate(resultSet.getDate("Date"));
//                entity.setSlot(new Slot(resultSet.getInt("SlotNo")));
                entity.setRoom(new Room(resultSet.getString("RoomID")));
                return entity;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void generateData(String groupID, int slot, Date startDate, String roomID) {
        Date currentDate = startDate;
        String sql = "INSERT INTO [Session] "
                + "(GroupID, "
                + "Date, "
                + "SlotNo, "
                + "RoomID) "
                + "VALUES "
                + "(?, ?, ?, ?)";
        for (int count = 1; count <= 10; count++) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, groupID);
                statement.setDate(2, currentDate);
                statement.setInt(3, slot);
                statement.setString(4, roomID);
                statement.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            currentDate = addDays(currentDate, 7);
        }
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

}
