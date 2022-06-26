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

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class CourseDBContext extends DBContext<Course> {

    @Override
    public ArrayList<Course> list() {
            ArrayList<Course> courseList = new ArrayList<>();
        try {
            String sql = "SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "  FROM [Course]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Course course = new Course(results.getString("CourseID"), results.getString("CourseName"));
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
                    + "  FROM [Course] WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getCourseID());
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                entity.setCourseName(result.getString("CourseName"));
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