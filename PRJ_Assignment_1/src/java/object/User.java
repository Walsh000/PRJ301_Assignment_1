/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.sql.Date;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class User {

    private String userID;
    private String userGmail;
    private String userPassword;
    private String username;
    private boolean gender;
    private Date dateOfBirth;
    private Role userRole;

    public User() {
    }

    public User(String userID) {
        this.userID = userID;
    }

    public User(User user) {
        this.userID = user.getUserID();
        this.userGmail = user.getUserGmail();
        this.userPassword = user.getUserPassword();
        this.username = user.getUsername();
        this.gender = user.isGender();
        this.dateOfBirth = user.getDateOfBirth();
        this.userRole = user.getUserRole();
    }

    public User(String userID, String userGmail, String userPassword, String username, boolean gender, Date dateOfBirth, Role userRole) {
        this.userID = userID;
        this.userGmail = userGmail;
        this.userPassword = userPassword;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userRole = userRole;
    }

    public User(String userGmail, String userPassword, String username, boolean gender, Date dateOfBirth, Role userRole) {
        this.userGmail = userGmail;
        this.userPassword = userPassword;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userRole = userRole;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserGmail() {
        return userGmail;
    }

    public void setUserGmail(String userGmail) {
        this.userGmail = userGmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
