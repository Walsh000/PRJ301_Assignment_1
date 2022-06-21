/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import object.Group;
import object.Lecturer;
import object.Session;
import object.Slot;
import object.Student;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class testDBC {

    public static void main(String[] args) {
        UserDBContext userDBC = new UserDBContext();
        AdministratorDBContext adminDBC = new AdministratorDBContext();
        LecturerDBContext lecturerDBC = new LecturerDBContext();
        StaffDBContext staffDBC = new StaffDBContext();
        StudentDBContext studentDBC = new StudentDBContext();
        CourseDBContext courseDBC = new CourseDBContext();
        SessionDBContext sessionDBC = new SessionDBContext();
        GroupDBContext groupDBC = new GroupDBContext();

//        lecturerDBC.generateData();
//        staffDBC.generateData();
//        adminDBC.generateData();
//        userDBC.generateData();
//        System.out.println(courseDBC.list());
//        System.out.println(studentDBC.list(new Group("CEA201SU2202")));
//        System.out.println(sessionDBC.list(new Lecturer("LT000001")));
//        Session s = new Session(null, new Lecturer("LT000001", ""), new Slot(1), new Group("CEA201SU2202"), Date.valueOf("2022-05-02"), null, null);
//        System.out.println(s);
//        System.out.println(sessionDBC.get(s));
        Student s = studentDBC.pagging(1, "CEA201SU2201");
        System.out.println(s);
    }
}
