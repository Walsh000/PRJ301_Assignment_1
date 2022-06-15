/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.RandomNameGenerator;
import object.Role;
import object.User;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class UserDBContext extends DBContext<User> {

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(User entity) {
        try {
            String sql = "INSERT INTO [dbo].[User]\n"
                    + "           ([Gmail]\n"
                    + "           ,[Password]\n"
                    + "           ,[Username]\n"
                    + "           ,[RoleID]\n"
                    + "           ,[Gender]\n"
                    + "           ,[DateOfBirth])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserGmail());
            statement.setString(2, entity.getUserPassword());
            statement.setString(3, entity.getUsername());
            statement.setInt(4, entity.getUserRole().getRoleID());
            statement.setBoolean(5, entity.isGender());
            statement.setDate(6, entity.getDateOfBirth());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    void generateData() {
//        int[] roleSlots = {5, 15, 80, 500};
//        User newUser;
//        for (int i = 1; i <= 500; i++) {
//            String mail = "EduMail_";
//            int roleID;
//
//            genRole:
//            while (true) {
//                roleID = (int) (Math.random() * 4);
//                if (roleSlots[roleID] == 0) {
//                    continue;
//                }
//                switch (roleID) {
//                    case 0:
//                        mail += "Admin_AD" + String.format("%04d", 5 - roleSlots[0] + 1);
//                        roleSlots[0]--;
//                        break genRole;
//                    case 1:
//                        mail += "Staff_ST" + String.format("%06d", 15 - roleSlots[1] + 1);
//                        roleSlots[1]--;
//                        break genRole;
//                    case 2:
//                        mail += "Lecturer_LT" + String.format("%06d", 80 - roleSlots[2] + 1);
//                        roleSlots[2]--;
//                        break genRole;
//                    case 3:
//                        mail += "Student_ST" + String.format("%06d", 500 - roleSlots[3] + 1);
//                        roleSlots[3]--;
//                        break genRole;
//                }
//            }
//            mail += "@assign.edu.com";
//
//            String Password = "";
//            //Loop until captcha have 5 character
//            while (Password.length() != 10) {
//                int CharacterGroup = (int) (Math.random() * 3);
//                //If group is 0, get a digit
//                if (CharacterGroup == 0) {
//                    char AsciiCharacter = (char) (Math.random() * 10 + 48);
//                    Password += Character.toString(AsciiCharacter);
//                } //If group is 1, get a upcase letter
//                else if (CharacterGroup == 1) {
//                    char AsciiCharacter = (char) (Math.random() * 24 + 65);
//                    Password += Character.toString(AsciiCharacter);
//                } //If group is 2, get a lowcase letter
//                else {
//                    char AsciiCharacter = (char) (Math.random() * 24 + 97);
//                    Password += Character.toString(AsciiCharacter);
//                }
//            }
//
//            String username = "";
//            RandomNameGenerator nameGen = new RandomNameGenerator();
//            int firstNameIndex = (int) (Math.random() * nameGen.getFirstName().size());
//            int lastNameIndex = (int) (Math.random() * nameGen.getLastName().size());
//            username += nameGen.getFirstName().get(firstNameIndex) + " "
//                    + nameGen.getLastName().get(lastNameIndex);
//            boolean gender = (int) (Math.random() * 2) == 0;
//            
//            //Starting year of specified random date (including)
//            int startYear = 1960;
//            int endYear = 2004;
//            long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
//            long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
//            //The qualified number of 13-bit milliseconds is obtained.
//            long ms = (long) ((end - start) * Math.random() + start);
//            Date dob = new Date(ms);
//            
//            newUser = new User(mail, Password, username, gender, dob, new Role(roleID));
//            insert(newUser);
//        }
//
//    }

}
