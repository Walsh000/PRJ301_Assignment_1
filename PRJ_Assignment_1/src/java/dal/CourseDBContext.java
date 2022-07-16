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

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class CourseDBContext extends DBContext<Course> {
    
    public Course get(Group group) {
        try {
            String sql = "SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[NumberOfSession]\n"
                    + "  FROM [Course]"
                    + "  WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getCourse().getCourseID());
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                Course course = new Course(results.getString("CourseID"), results.getString("CourseName"));
                course.setNumberOfSession(results.getInt("NumberOfSession"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public ArrayList<Course> list() {
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            String sql = "SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[NumberOfSession]\n"
                    + "  FROM [Course]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Course course = new Course(results.getString("CourseID"), results.getString("CourseName"));
                course.setNumberOfSession(results.getInt("NumberOfSession"));
                courseList.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseList;
    }

    @Override
    public Course get(Course entity) {
        try {
            String sql = "SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[NumberOfSession]\n"
                    + "  FROM [Course] WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getCourseID());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                entity.setCourseName(result.getString("CourseName"));
                entity.setNumberOfSession(result.getInt("NumberOfSession"));
                return entity;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Course entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Course entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Course entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
