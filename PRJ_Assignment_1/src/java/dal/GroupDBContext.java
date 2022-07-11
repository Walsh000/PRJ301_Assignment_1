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

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class GroupDBContext extends DBContext<Group> {
    
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

    @Override
    public ArrayList<Group> list() {
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            String sql = "SELECT GroupID, c.CourseID, CourseName, s.SemesterID, SemesterName "
                    + "FROM [Group] g "
                    + "INNER JOIN [Course] c on g.CourseID = c.CourseID "
                    + "INNER JOIN [Semester] s on g.SemesterID = s.SemesterID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Group group = new Group(result.getString("GroupID"),
                        new Course(result.getString("CourseID"), result.getString("CourseName")),
                        new Semester(result.getString("SemesterID"), result.getString("SemesterName")));
                groupList.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groupList;
    }

    @Override
    public Group get(Group entity) {
        try {
            String sql = "SELECT [GroupID]\n"
                    + "      ,[StudentID]\n"
                    + "  FROM [Enroll] WHERE GroupID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            entity.setStudentList(new ArrayList<>());
            while (result.next()) {
                Student student = new Student();
                student.setStudentID(result.getString("StudentID"));
                entity.getStudentList().add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @Override
    public void insert(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    void generateData() {
//        try {
//            StudentDBContext studentDBC = new StudentDBContext();
//            ArrayList<Student> studentList = studentDBC.list();
//            ArrayList<Group> groupList = list();
//            
//            for(Group group: groupList) {
//                ArrayList<Student> enroll = new ArrayList<>();
//                String groupByCourse = group.getGroupID().substring(0, 10);
//
//                enrollLoop:
//                while (enroll.size() < 25) {
//                    int randomIndex = (int) (Math.random() * studentList.size());
//                    Student selectedStudent = studentList.get(randomIndex);
//                    
//                    String enrollSearchSQL = "select StudentID, GroupID\n"
//                            + "from Enroll s \n"
//                            + "WHERE StudentID = ? and GroupID like ? + '%'";
//                    PreparedStatement searchStatement = connection.prepareStatement(enrollSearchSQL);
//                    searchStatement.setString(1, selectedStudent.getStudentID());
//                    searchStatement.setString(2, groupByCourse);
//                    ResultSet stdResult = searchStatement.executeQuery();
//                    
//                    if (stdResult.next()) {
//                        continue;
//                    }
//                    
//                    String enrollInsertSQL = "INSERT INTO Enroll (StudentID, GroupID) "
//                            + "VALUES (?, ?)";
//                    PreparedStatement addEnrollStatement = connection.prepareStatement(enrollInsertSQL);
//                    addEnrollStatement.setString(1, selectedStudent.getStudentID());
//                    addEnrollStatement.setString(2, group.getGroupID());
//                    addEnrollStatement.executeUpdate();
//                    enroll.add(selectedStudent);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    
    public void generateData() {
        try {
            String getListSQL = "Select SessionID, StudentID from [Session] "
                    + "inner join Enroll on Enroll.GroupID = [Session].GroupID";
            String insertSQL = "INSERT INTO [Attendance] (StudentID, SessionID, Attendance) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(getListSQL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setString(1, resultSet.getString("StudentID"));
                insertStatement.setString(2, resultSet.getString("SessionID"));
                insertStatement.setBoolean(3, false);
                insertStatement.executeUpdate();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
