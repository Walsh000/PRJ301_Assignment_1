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
                        + "WHERE ss.GroupID = ? "
                        + "AND ss.Date = ? "
                        + "AND ss.SlotNo = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, entity.getGroup().getGroupID());
                statement.setDate(2, entity.getDate());
                statement.setInt(3, entity.getSlot().getSlotNo());

            } else {
                String sql = "select u.UserID, s.StudentID, Username, e.GroupID, u.ImageURL\n"
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
                std.setImageURL(resultSet.getString("ImageURL"));
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
                    + "      ,[attendanceChecked]\n"
                    + "FROM Lecturer l "
                    + "inner join [Session] s on l.LecturerID = s.LecturerID"
                    + " WHERE l.LecturerID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lecturer.getLecturerID());
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Session session = new Session(results.getString("SessionID"),
                        lecturer, new Slot(results.getInt("SlotNo")),
                        new Group(results.getString("GroupID")),
                        results.getDate("Date"),
                        new Room(results.getString("RoomID")));
                session.setAttendanceChecked(results.getBoolean("attendanceChecked"));
                sessionList.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessionList;
    }

    public ArrayList<Session> listSessionOfStudentByWeek(Student student, Date date) {
        ArrayList<Session> sessionList = new ArrayList<>();
        try {
            String sql = "  select SessionID, LecturerID, g.GroupID, [Date], SlotNo, RoomID, attendanceChecked \n"
                    + "  from [Session] s \n"
                    + "  inner join [Group] g on s.GroupID = g.GroupID\n"
                    + "  inner join [Enroll] e on e.GroupID = g.GroupID\n"
                    + "  where StudentID = ?\n"
                    + "  and DATEPART(wk, [Date]) = DATEPART(wk, ?)\n"
                    + "  AND DATEPART(yy, [Date]) = DATEPART(yy, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getStudentID());
            statement.setDate(2, date);
            statement.setDate(3, date);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Session session = new Session(resultSet.getString("SessionID"),
                        new Lecturer(resultSet.getString("LecturerID")),
                        new Slot(resultSet.getInt("SlotNo")),
                        new Group(resultSet.getString("GroupID")),
                        resultSet.getDate("Date"),
                        new Room(resultSet.getString("RoomID")));
                session.setAttendanceChecked(resultSet.getBoolean("attendanceChecked"));
                sessionList.add(session);
            }

            return sessionList;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Session> listSessionOfLecturerByWeek(Lecturer lecturer, Date date) {
        ArrayList<Session> sessionList = new ArrayList<>();
        try {
            String sql = "select SessionID, LecturerID, g.GroupID, [Date], SlotNo, RoomID, attendanceChecked "
                    + "from [Session] s inner join [Group] g on s.GroupID = g.GroupID\n"
                    + "where LecturerID = ?\n"
                    + "and DATEPART(wk, [Date]) = DATEPART(wk, ?)\n"
                    + "AND DATEPART(yy, [Date]) = DATEPART(yy, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lecturer.getLecturerID());
            statement.setDate(2, date);
            statement.setDate(3, date);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Session session = new Session(resultSet.getString("SessionID"),
                        lecturer,
                        new Slot(resultSet.getInt("SlotNo")),
                        new Group(resultSet.getString("GroupID")),
                        resultSet.getDate("Date"),
                        new Room(resultSet.getString("RoomID")));
                session.setAttendanceChecked(resultSet.getBoolean("attendanceChecked"));
                sessionList.add(session);
            }

            return sessionList;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(Session entity) {
        try {
            PreparedStatement statement;
            if (entity.getSessionID() != null && !entity.getSessionID().equals("")) {
                String sql = "SELECT [SessionID]\n"
                        + "      ,l.[LecturerID]\n"
                        + "      ,UserName\n"
                        + "      ,g.[GroupID]\n"
                        + "      ,c.[CourseID]\n"
                        + "      ,c.[CourseName]\n"
                        + "      ,[Date]\n"
                        + "      ,[SlotNo]\n"
                        + "      ,[RoomID]\n"
                        + "      ,[attendanceChecked]\n"
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
                        + "      ,[attendanceChecked]\n"
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
//                entity.getLecturer().setImageURL(resultSet.getString("ImageURL"));
                entity.getLecturer().setImageURL(resultSet.getString("ImageURL"));
                entity.setGroup(new Group(resultSet.getString("GroupID"),
                        new Course(resultSet.getString("CourseID"),
                                resultSet.getString("CourseName"))));
                entity.setDate(resultSet.getDate("Date"));
                entity.setSlot(new Slot(resultSet.getInt("SlotNo")));
//                entity.setSlot(new Slot(resultSet.getInt("SlotNo")));
                entity.setRoom(new Room(resultSet.getString("RoomID")));
                entity.setAttendanceChecked(resultSet.getBoolean("attendanceChecked"));
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
        try {
            String sql = "UPDATE [dbo].[Session]\n"
                    + "   SET [attendanceChecked] = 1\n"
                    + " WHERE SessionID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getSessionID());
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public void generateData(String groupID, int slot, Date startDate, String roomID) {
    //        Date currentDate = startDate;
//        String sql = "INSERT INTO [Session] "
//                + "(GroupID, "
//                + "Date, "
//                + "SlotNo, "
//                + "RoomID) "
//                + "VALUES "
//                + "(?, ?, ?, ?)";
//        for (int count = 1; count <= 10; count++) {
//            try {
//                PreparedStatement statement = connection.prepareStatement(sql);
//                statement.setString(1, groupID);
//                statement.setDate(2, currentDate);
//                statement.setInt(3, slot);
//                statement.setString(4, roomID);
//                statement.executeUpdate();
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            currentDate = addDays(currentDate, 7);
//        }
//}
//    public void generateData() {
//        try {
//            String getGroupSQL = "SELECT GroupID, LecturerID FROM [GROUP]";
//            String updateLectSession = "UPDATE [Session] SET LecturerID = ? "
//                    + "WHERE GroupID = ?";
//            PreparedStatement setGroupStatement = connection.prepareStatement(getGroupSQL);
//            ResultSet resultSet = setGroupStatement.executeQuery();
//            while (resultSet.next()) {
//                PreparedStatement updateStatement = connection.prepareStatement(updateLectSession);
//                updateStatement.setString(1, resultSet.getString("LecturerID"));
//                updateStatement.setString(2, resultSet.getString("GroupID"));
//                updateStatement.executeUpdate();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public static Date addDays(Date date, int days) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.add(Calendar.DATE, days);
//        return new Date(c.getTimeInMillis());
//    }
}
