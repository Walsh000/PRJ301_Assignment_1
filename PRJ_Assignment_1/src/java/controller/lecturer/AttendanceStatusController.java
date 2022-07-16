/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import dal.AttendanceDBContext;
import dal.GroupDBContext;
import dal.LecturerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import object.AttendanceStatus;
import object.Group;
import object.Lecturer;
import object.User;

/**
 *
 * @author Silver_000
 */
public class AttendanceStatusController extends HttpServlet {

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

        LecturerDBContext lecturerDBC = new LecturerDBContext();
        GroupDBContext groupDBC = new GroupDBContext();
        User user = (User) request.getSession().getAttribute("user");
        Lecturer sessionLecturer = lecturerDBC.get(user);
//        groupDBC.list(sessionLecturer);
        ArrayList<Group> groupList = groupDBC.list(sessionLecturer);
        request.getSession().setAttribute("groupList", groupList);
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
        processRequest(request, response);
        request.setAttribute("isPost", false);
        request.getRequestDispatcher("view/lecturer/AttendanceStatus.jsp").forward(request, response);
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
        processRequest(request, response);
        AttendanceDBContext attendanceDBC = new AttendanceDBContext();
        String groupID = request.getParameter("groupID");
        ArrayList<AttendanceStatus> attendanceStatusList = attendanceDBC.getAttendanceStatus(new Group(groupID));
        request.setAttribute("attendanceStatusList", attendanceStatusList);
        request.setAttribute("isPost", true);
        request.getRequestDispatcher("view/lecturer/AttendanceStatus.jsp").forward(request, response);
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
