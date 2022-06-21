/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public abstract class DBContext<T> {
    protected Connection connection;

    public DBContext() {
        try {
            String user = "M_Anh";
            String pass = "WhiteMoon";
            String url = "jdbc:sqlserver://DESKTOP-0JSC32A\\SILVER_000\\SILVER_000:1433;databaseName=PRJ_Assignment_1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract ArrayList<T> list();

    public abstract T get(T entity);

    public abstract void insert(T entity);

    public abstract void update(T entity);

    public abstract void delete(T entity);
    

}
