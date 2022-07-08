/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import object.Lecturer;
import object.Session;
import object.User;

/**
 *
 * @author Silver_000
 */
public class ScheduleController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScheduleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScheduleController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        LecturerDBContext lecturerDBC = new LecturerDBContext();
        ArrayList<Session> sessionList;
        
        Session[][] sessionTable = new Session[7][8];
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        
        calendar.setFirstDayOfWeek(2);
        calendar.set(Calendar.DATE, Calendar.MONDAY);
        Date mon = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date tue = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date wed = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date thu = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date fri = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date sat = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Date sun = new Date(calendar.getTimeInMillis());

        User user = (User) request.getSession().getAttribute("user");
        Lecturer lecturer = lecturerDBC.get(user);
        
        sessionList = sessionDBC.listSessionOfLecturerByWeek(lecturer, 
                        new Date(calendar.getTimeInMillis()));
        request.getRequestDispatcher("view/Home.jsp").forward(request, response);
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
        String choosenDate = request.getParameter("date");
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
