/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.util.ArrayList;
import object.Feature;
import object.Group;
import object.Lecturer;
import object.Role;
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
        RoleDBContext roleDBC = new RoleDBContext();
        AttendanceDBContext attendanceDBC = new AttendanceDBContext();
//        Group group = new Group("CEA201SU2201");
//        System.out.println(attendanceDBC.getAttendanceStatus(group));
        
//        attendanceDBC.generateData();
//        System.out.println(roleDBC.list());

        ArrayList<Session> sessionList;
//        sessionList = sessionDBC.listSessionOfLecturerByWeek(new Lecturer("LT000001"), Date.valueOf("2022-07-11"));
        sessionList = sessionDBC.listSessionOfStudentByWeek(new Student("ST000021"), Date.valueOf("2022-06-20"));
        System.out.println(sessionList);
//        Feature feature = new Feature();
//        feature.setUrl("/lecturer/attendance");
//        ArrayList<Role> roleList = roleDBC.list(feature);
//        System.out.println(roleList.get(0));

//                Feature feature = new Feature();
//                feature.setUrl("/attendance");
//                System.out.println(feature.getUrl());
//                System.out.println(roleDBC.list(feature).size());

//        sessionDBC.generateData();
//        sessionDBC.generateData("CEA201SU2201", 1, Date.valueOf("2022-05-02"), "AL301");
//        sessionDBC.generateData("CEA201SU2201", 1, Date.valueOf("2022-05-04"), "AL301");
//        sessionDBC.generateData("CEA201SU2201", 1, Date.valueOf("2022-05-06"), "AL301");
//
//        sessionDBC.generateData("CEA201SU2202", 1, Date.valueOf("2022-05-02"), "AL302");
//        sessionDBC.generateData("CEA201SU2202", 1, Date.valueOf("2022-05-04"), "AL302");
//        sessionDBC.generateData("CEA201SU2202", 1, Date.valueOf("2022-05-06"), "AL302");
//
//        sessionDBC.generateData("CEA201SU2203", 1, Date.valueOf("2022-05-03"), "AL201");
//        sessionDBC.generateData("CEA201SU2203", 2, Date.valueOf("2022-05-03"), "AL201");
//        sessionDBC.generateData("CEA201SU2203", 1, Date.valueOf("2022-05-05"), "AL201");
//
//        sessionDBC.generateData("CEA201SU2204", 1, Date.valueOf("2022-05-03"), "AL205");
//        sessionDBC.generateData("CEA201SU2204", 2, Date.valueOf("2022-05-03"), "AL205");
//        sessionDBC.generateData("CEA201SU2204", 1, Date.valueOf("2022-05-05"), "AL205");
//
//        sessionDBC.generateData("CEA201SU2205", 1, Date.valueOf("2022-05-03"), "AL303");
//        sessionDBC.generateData("CEA201SU2205", 2, Date.valueOf("2022-05-03"), "AL303");
//        sessionDBC.generateData("CEA201SU2205", 1, Date.valueOf("2022-05-05"), "AL303");
//
//        sessionDBC.generateData("IOT102SU2201", 5, Date.valueOf("2022-05-02"), "BE202");
//        sessionDBC.generateData("IOT102SU2201", 5, Date.valueOf("2022-05-04"), "BE202");
//        sessionDBC.generateData("IOT102SU2201", 5, Date.valueOf("2022-05-06"), "BE202");
//
//        sessionDBC.generateData("IOT102SU2202", 4, Date.valueOf("2022-05-03"), "BE201");
//        sessionDBC.generateData("IOT102SU2202", 5, Date.valueOf("2022-05-03"), "BE201");
//        sessionDBC.generateData("IOT102SU2202", 4, Date.valueOf("2022-05-05"), "BE201");
//
//        sessionDBC.generateData("IOT102SU2203", 4, Date.valueOf("2022-05-03"), "BE203");
//        sessionDBC.generateData("IOT102SU2203", 5, Date.valueOf("2022-05-03"), "BE203");
//        sessionDBC.generateData("IOT102SU2203", 4, Date.valueOf("2022-05-05"), "BE203");
//
//        sessionDBC.generateData("IOT102SU2204", 1, Date.valueOf("2022-05-02"), "BE202");
//        sessionDBC.generateData("IOT102SU2204", 1, Date.valueOf("2022-05-04"), "BE202");
//        sessionDBC.generateData("IOT102SU2204", 1, Date.valueOf("2022-05-06"), "BE202");
//
//        sessionDBC.generateData("IOT102SU2205", 1, Date.valueOf("2022-05-02"), "BE205");
//        sessionDBC.generateData("IOT102SU2205", 1, Date.valueOf("2022-05-04"), "BE205");
//        sessionDBC.generateData("IOT102SU2205", 1, Date.valueOf("2022-05-06"), "BE205");
//
//        sessionDBC.generateData("DGT301SU2201", 1, Date.valueOf("2022-05-02"), "DE101");
//        sessionDBC.generateData("DGT301SU2201", 1, Date.valueOf("2022-05-04"), "DE101");
//        sessionDBC.generateData("DGT301SU2201", 1, Date.valueOf("2022-05-06"), "DE101");
//        
//        sessionDBC.generateData("DGT301SU2202", 1, Date.valueOf("2022-05-02"), "DE103");
//        sessionDBC.generateData("DGT301SU2202", 1, Date.valueOf("2022-05-04"), "DE103");
//        sessionDBC.generateData("DGT301SU2202", 1, Date.valueOf("2022-05-06"), "DE103");
//        
//        sessionDBC.generateData("DGT301SU2203", 6, Date.valueOf("2022-05-03"), "DE301");
//        sessionDBC.generateData("DGT301SU2203", 5, Date.valueOf("2022-05-05"), "DE301");
//        sessionDBC.generateData("DGT301SU2203", 6, Date.valueOf("2022-05-05"), "DE301");
//        
//        sessionDBC.generateData("ITE302SU2201", 2, Date.valueOf("2022-05-03"), "DE301");
//        sessionDBC.generateData("ITE302SU2201", 3, Date.valueOf("2022-05-03"), "DE301");
//        sessionDBC.generateData("ITE302SU2201", 3, Date.valueOf("2022-05-05"), "DE301");
//        
//        sessionDBC.generateData("ITE302SU2202", 1, Date.valueOf("2022-05-03"), "DE301");
//        sessionDBC.generateData("ITE302SU2202", 1, Date.valueOf("2022-05-05"), "DE301");
//        sessionDBC.generateData("ITE302SU2202", 2, Date.valueOf("2022-05-05"), "DE301");
//        
//        sessionDBC.generateData("ITE302SU2203", 5, Date.valueOf("2022-05-02"), "DE201");
//        sessionDBC.generateData("ITE302SU2203", 5, Date.valueOf("2022-05-04"), "DE201");
//        sessionDBC.generateData("ITE302SU2203", 5, Date.valueOf("2022-05-06"), "DE201");
//        
//        sessionDBC.generateData("ITE302SU2204", 5, Date.valueOf("2022-05-02"), "DE203");
//        sessionDBC.generateData("ITE302SU2204", 5, Date.valueOf("2022-05-04"), "DE203");
//        sessionDBC.generateData("ITE302SU2204", 5, Date.valueOf("2022-05-06"), "DE203");
//        
//        sessionDBC.generateData("LAB211SU2201", 1, Date.valueOf("2022-05-03"), "AL204");
//        sessionDBC.generateData("LAB211SU2201", 2, Date.valueOf("2022-05-03"), "AL204");
//        sessionDBC.generateData("LAB211SU2201", 1, Date.valueOf("2022-05-05"), "AL204");
//        
//        sessionDBC.generateData("LAB211SU2202", 2, Date.valueOf("2022-05-02"), "AL202");
//        sessionDBC.generateData("LAB211SU2202", 2, Date.valueOf("2022-05-04"), "AL202");
//        sessionDBC.generateData("LAB211SU2202", 2, Date.valueOf("2022-05-06"), "AL202");
//        
//        sessionDBC.generateData("PMG201SU2201", 2, Date.valueOf("2022-05-02"), "BE104");
//        sessionDBC.generateData("PMG201SU2201", 2, Date.valueOf("2022-05-04"), "BE104");
//        sessionDBC.generateData("PMG201SU2201", 2, Date.valueOf("2022-05-06"), "BE104");
//        
//        sessionDBC.generateData("PMG201SU2202", 6, Date.valueOf("2022-05-03"), "BE105");
//        sessionDBC.generateData("PMG201SU2202", 5, Date.valueOf("2022-05-05"), "BE105");
//        sessionDBC.generateData("PMG201SU2202", 6, Date.valueOf("2022-05-05"), "BE105");
//        
//        sessionDBC.generateData("PMG201SU2203", 5, Date.valueOf("2022-05-02"), "BE106");
//        sessionDBC.generateData("PMG201SU2203", 5, Date.valueOf("2022-05-04"), "BE106");
//        sessionDBC.generateData("PMG201SU2203", 5, Date.valueOf("2022-05-06"), "BE106");
//        
//        sessionDBC.generateData("PRC391SU2201", 5, Date.valueOf("2022-05-02"), "DE202");
//        sessionDBC.generateData("PRC391SU2201", 5, Date.valueOf("2022-05-04"), "DE202");
//        sessionDBC.generateData("PRC391SU2201", 5, Date.valueOf("2022-05-06"), "DE202");
//        
//        sessionDBC.generateData("PRC391SU2202", 6, Date.valueOf("2022-05-02"), "DE202");
//        sessionDBC.generateData("PRC391SU2202", 6, Date.valueOf("2022-05-04"), "DE202");
//        sessionDBC.generateData("PRC391SU2202", 6, Date.valueOf("2022-05-06"), "DE202");
//        
//        sessionDBC.generateData("SWP391SU2201", 4, Date.valueOf("2022-05-02"), "BE201");
//        sessionDBC.generateData("SWP391SU2201", 4, Date.valueOf("2022-05-04"), "BE201");
//        sessionDBC.generateData("SWP391SU2201", 4, Date.valueOf("2022-05-06"), "BE201");
//       
//        sessionDBC.generateData("SWP391SU2202", 4, Date.valueOf("2022-05-02"), "BE202");
//        sessionDBC.generateData("SWP391SU2202", 4, Date.valueOf("2022-05-04"), "BE202");
//        sessionDBC.generateData("SWP391SU2202", 4, Date.valueOf("2022-05-06"), "BE202");
//        
//        sessionDBC.generateData("SWP391SU2203", 4, Date.valueOf("2022-05-02"), "BE203");
//        sessionDBC.generateData("SWP391SU2203", 4, Date.valueOf("2022-05-04"), "BE203");
//        sessionDBC.generateData("SWP391SU2203", 4, Date.valueOf("2022-05-06"), "BE203");
//        
//        sessionDBC.generateData("SWP391SU2204", 3, Date.valueOf("2022-05-03"), "BE204");
//        sessionDBC.generateData("SWP391SU2204", 2, Date.valueOf("2022-05-05"), "BE204");
//        sessionDBC.generateData("SWP391SU2204", 3, Date.valueOf("2022-05-05"), "BE204");
//        
//        sessionDBC.generateData("SWP391SU2205", 3, Date.valueOf("2022-05-03"), "BE205");
//        sessionDBC.generateData("SWP391SU2205", 2, Date.valueOf("2022-05-05"), "BE205");
//        sessionDBC.generateData("SWP391SU2205", 3, Date.valueOf("2022-05-05"), "BE205");
//        
//        sessionDBC.generateData("SWP391SU2206", 3, Date.valueOf("2022-05-03"), "BE206");
//        sessionDBC.generateData("SWP391SU2206", 2, Date.valueOf("2022-05-05"), "BE206");
//        sessionDBC.generateData("SWP391SU2206", 3, Date.valueOf("2022-05-05"), "BE206");
//        
//        sessionDBC.generateData("SWT301SU2201", 3, Date.valueOf("2022-05-03"), "AL304");
//        sessionDBC.generateData("SWT301SU2201", 2, Date.valueOf("2022-05-05"), "AL304");
//        sessionDBC.generateData("SWT301SU2201", 3, Date.valueOf("2022-05-05"), "AL304");
//        groupDBC.generateData();
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
//        Student s = studentDBC.pagging(1, "CEA201SU2201");
//        System.out.println(s);
    }
}
