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
import object.Course;
import object.Group;
import object.Semester;
import object.Student;
import object.User;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Group> list(Student student) {
        try {
            student.setGroupList(new ArrayList<>());
            String sql = "select u.UserID, s.StudentID, Username, g.GroupID, g.CourseID, g.SemesterID\n"
                    + "from Student s \n"
                    + "inner join [User] u on s.userID = u.UserID \n"
                    + "inner join Enroll e on e.StudentID = s.StudentID\n"
                    + "inner join [Group] g on g.GroupID = e.GroupID\n"
                    + "WHERE s.StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getStudentID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("StudentID"), resultSet.getString("UserID"));
                std.setUsername(resultSet.getString("Username"));
                student.getGroupList().add(new Group(resultSet.getString("GroupID"),
                        new Course(resultSet.getString("CourseID")),
                        new Semester(resultSet.getString("SemesterID"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student.getGroupList();
    }
//
//    public Student pagging(int index, String GroupID) {
//        Student student = null;
//        try {
//            String sql = "SELECT distinct u.UserID, s.StudentID, Username, ImageURL \n"
//                    + "FROM Student s \n"
//                    + "inner join [User] u on s.UserID = u.UserID \n"
//                    + "inner join Enroll e  on e.StudentID = s.StudentID\n"
//                    + "inner join [Session] ss on ss.GroupID = e.GroupID\n"
//                    + "WHERE ss.GroupID = ?\n"
//                    + "ORDER BY UserID ASC \n"
//                    + "OFFSET ? ROWS\n"
//                    + "FETCH NEXT 1 ROWS ONLY";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, GroupID);
//            statement.setInt(2, index);
//            ResultSet results = statement.executeQuery();
//            if (results.next()) {
//                student = new Student(new User(results.getString("UserID"),
//                        results.getString("Username")), results.getString("StudentID"));
//                student.setImageURL(results.getString("ImageURL"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return student;
//    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            String sql = "SELECT s.[UserID]\n"
                    + "      ,[StudentID]\n"
                    + "      ,[Username]\n"
                    + "  FROM [Student] s inner join [User] u on s.UserID = u.UserID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Student student = new Student(new User(results.getString("UserID"), results.getString("UserID")), results.getString("StudentID"));
                studentList.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }

    @Override
    public Student get(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student entity) {

        try {
            String sql = "INSERT INTO Student\n"
                    + "           ([UserID]\n"
                    + "           ,[StudentID])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserID());
            statement.setString(2, entity.getStudentID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void generateData() {
        try {
            String sql = "Select userID, RoleID from [User] where RoleID = 3";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
                Student student = new Student("ST" + String.format("%06d", count), resultSet.getString("UserID"));
                insert(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
