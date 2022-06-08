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
import model.Rectangle;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class RectDBContext extends DBContext<Rectangle> {

    @Override
    public ArrayList<Rectangle> list() {
        ArrayList<Rectangle> rectList = new ArrayList<>();
        try {
            String sql = "SELECT id,x,y,width,height FROM Rectangle";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Rectangle rect = new Rectangle();
                rect.setCoordiX(resultSet.getInt("x"));
                rect.setCoordiY(resultSet.getInt("y"));
                rect.setWidth(resultSet.getInt("width"));
                rect.setHeight(resultSet.getInt("height"));
                rectList.add(rect);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rectList;
    }

    @Override
    public Rectangle get(Rectangle entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Rectangle entity) {
//            String sql = "INSERT INTO Rectangle(x, y, width, height) values(?, ?, ?, ?)";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, entity.getCoordiX());
//            statement.setInt(2, entity.getCoordiY());
//            statement.setInt(3, entity.getWidth());
//            statement.setInt(4, entity.getHeight());
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(RectDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void update(Rectangle entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Rectangle entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resetDatabase() {
        try {
            String sql = "truncate table Rectangle";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Rectangle get(int id) {
        Rectangle rect = new Rectangle();
        try {
            String sql = "SELECT id,x,y,width,height FROM Rectangle where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                rect.setCoordiX(result.getInt("x"));
                rect.setCoordiY(result.getInt("y"));
                rect.setWidth(result.getInt("width"));
                rect.setHeight(result.getInt("height"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rect;
    }

}
