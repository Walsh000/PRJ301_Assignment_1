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
        ArrayList<Session> sessionList;
        SessionDBContext sessionDBC = new SessionDBContext();
        LecturerDBContext lecturerDBC = new LecturerDBContext();

        Session[][] sessionTable = new Session[8][7];
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        User user = new User("1000000000011", "");
        Lecturer lecturer = lecturerDBC.get(user);
        sessionList = sessionDBC.listSessionOfLecturerByWeek(lecturer,
                new Date(calendar.getTimeInMillis()));

        calendar.setFirstDayOfWeek(2);
        calendar.set(Calendar.DATE, Calendar.MONDAY);
        Date mon = new Date(calendar.getTimeInMillis());        //Monday

        for (Session session : sessionList) {
            long timeMinus = Math.abs(session.getDate().getTime() - mon.getTime());
            long daysMinus = TimeUnit.DAYS.convert(timeMinus, TimeUnit.MILLISECONDS);

            sessionTable[session.getSlot().getSlotNo() - 1][(int) daysMinus] = session;
        }

        for (int i = 0; i < 8; i++) {
            System.out.print("Slot " + (i+1) + "   ");
            for (int j = 0; j < 7; j++) {
                if (sessionTable[i][j] == null) {
                    System.out.print("      ");
                } else {
                    System.out.printf("%6s", sessionTable[i][j].getSessionID());
                }
            }
            System.out.println("");
        }
    }
}
