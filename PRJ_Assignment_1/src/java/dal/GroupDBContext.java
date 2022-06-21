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

    void generateData() {

    }

}
