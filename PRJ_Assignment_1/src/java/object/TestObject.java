/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class TestObject {
    public static void main(String[] args) {
        User user = new User("11111111111", "gmail@gmail.coom", "pass", "name", true, Date.valueOf(LocalDate.MAX), new Role(0));
//        Student student = new Student(user, "HE163997", new Schedule("000", new ArrayList<>()));
//        System.out.println(student);
    }
}
