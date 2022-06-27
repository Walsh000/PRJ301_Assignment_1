/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import object.Attendance;
import object.Group;
import object.Session;
import object.Slot;
import object.Student;

/**
 *
 * @author Silver_000
 */
public class AttendanceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SessionDBContext sessionDBC = new SessionDBContext();
//        StudentDBContext studentDBC = new StudentDBContext();

        Session session = new Session();
        session.setGroup(new Group(request.getParameter("groupID")));
        session.setDate(Date.valueOf(request.getParameter("date")));
        session.setSlot(new Slot(Integer.parseInt(request.getParameter("slotNo"))));
        session = sessionDBC.get(session);

        String rawIndex = request.getParameter("index");
        if (rawIndex == null || rawIndex.compareTo("1") < 0) {
            rawIndex = "1";
        }
        int index = Integer.parseInt(rawIndex);
        Student student = sessionDBC.listStudent(session).get(index);

        request.setAttribute("lecturer", session.getLecturer());
        request.setAttribute("student", student);
        request.setAttribute("index", index);
        request.setAttribute("course", session.getGroup().getCourse());
        request.setAttribute("date", session.getDate());
        request.setAttribute("slot", session.getSlot().getSlotNo());
        request.setAttribute("session", session);
        request.getRequestDispatcher("../view/lecturer/attendance.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDBContext studentDBC = new StudentDBContext();
        SessionDBContext sessionDBC = new SessionDBContext();
        AttendanceDBContext attendanceDBC = new AttendanceDBContext();

        Session session = new Session();
        session.setGroup(new Group(request.getParameter("groupID")));
        session.setDate(Date.valueOf(request.getParameter("date")));
        session.setSlot(new Slot(Integer.parseInt(request.getParameter("slotNo"))));
        session = sessionDBC.get(session);

        boolean isAttend = request.getParameter("isAttend") != null;

        int index;
        String rawIndex = request.getParameter("index");
        index = Integer.parseInt(rawIndex);

        ArrayList<Student> studentList = sessionDBC.listStudent(session);
        Student student = studentList.get(index);
        Attendance attend = new Attendance(session, student, isAttend);
        attendanceDBC.update(attend);

//        Student student = studentDBC.pagging(index, session.getGroup().getGroupID());
        index++;
        if (index == studentList.size()) {
            request.getRequestDispatcher("../view/lecturer/Home.jsp").forward(request, response);
        } else {
            student = studentList.get(index);

            request.setAttribute("lecturer", session.getLecturer());
            request.setAttribute("student", student);
            request.setAttribute("index", index);
            request.setAttribute("course", session.getGroup().getCourse());
            request.setAttribute("date", session.getDate());
            request.setAttribute("slot", session.getSlot().getSlotNo());
            request.setAttribute("session", session);
            request.getRequestDispatcher("../view/lecturer/attendance.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
