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
    
    public Student get(User user) {
        Student lecturer = null;
        try {
            String sql = "SELECT [StudentID] FROM Student s"
                    + " INNER JOIN [User] u ON u.UserID = s.UserID"
                    + " WHERE u.UserID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserID());
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                lecturer = new Student(user, results.getString("StudentID"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lecturer;
    }

    public ArrayList<Student> list(Group group) {
        try {
            String groupID = group.getGroupID();
            group.setStudentList(new ArrayList<>());
            String sql = "select u.UserID, s.StudentID, Username, g.GroupID, u.imageURL\n"
                    + "from Student s \n"
                    + "inner join [User] u on s.userID = u.UserID \n"
                    + "inner join Enroll e on e.StudentID = s.StudentID\n"
                    + "inner join [Group] g on g.GroupID = e.GroupID\n"
                    + "WHERE g.GroupID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, groupID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("StudentID"), resultSet.getString("UserID"));
                std.setUsername(resultSet.getString("Username"));
                std.setImageURL(resultSet.getString("imageURL"));
                group.getStudentList().add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group.getStudentList();
    }

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
