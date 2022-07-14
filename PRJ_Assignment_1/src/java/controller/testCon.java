/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import object.Group;
import object.Lecturer;
import object.Session;
import object.Slot;
import object.Student;
import object.User;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class testCon {

    public static void main(String[] args) {
//        try {
            SessionDBContext sessionDBC = new SessionDBContext();
            LecturerDBContext lecturerDBC = new LecturerDBContext();
            ArrayList<Session> sessionList;

            Date date = Date.valueOf("2022-05-01");
            Session[][] sessionTable = new Session[8][7];
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);

                        User user = new User("1000000000011", "");

            Lecturer lecturer = lecturerDBC.get(user);
            sessionList = sessionDBC.listSessionOfLecturerByWeek(lecturer,
                    new Date(calendar.getTimeInMillis()));

            calendar.setFirstDayOfWeek(2);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date mon = new Date(calendar.getTimeInMillis());        //Monday
            System.out.println(sessionList);

            for (Session session : sessionList) {
                long timeMinus = Math.abs(session.getDate().getTime() - mon.getTime());
                long daysMinus = TimeUnit.DAYS.convert(timeMinus, TimeUnit.MILLISECONDS);

                sessionTable[session.getSlot().getSlotNo() - 1][(int) daysMinus - 1] = session;
            }

            for (int i = 0; i < 8; i++) {
                System.out.print("Slot " + (i + 1) + "   ");
                for (int j = 0; j < 7; j++) {
                    if (sessionTable[i][j] == null) {
                        System.out.print("      ");
                    } else {
                        System.out.printf("%6s", sessionTable[i][j].getSessionID());
                    }
                }
                System.out.println("");
            }

//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    }
}
