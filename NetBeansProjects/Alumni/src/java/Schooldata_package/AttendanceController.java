/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Schooldata_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hta13nau
 */
@WebServlet(name = "AttendanceController", urlPatterns = {"/AttendanceController"})
public class AttendanceController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String details = request.getParameter("school");
        String schoolName = null;
        String schoolID = null;
        String website = null;
        String schoolInfo= null;



        Class.forName("org.postgresql.Driver");

        ArrayList DBstudents = new ArrayList();
        Connection con = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");

        Statement statement2 = con.createStatement();
        String findSchooldetails = "SELECT * FROM attendance WHERE schoolName ='" + details + "'";
        ResultSet rs2 = statement2.executeQuery(findSchooldetails);
        while (rs2.next()) {
            String name = rs2.getString("name");
            details = rs2.getString("schoolName");
            String dateStart = rs2.getString("dateStart");
            String dateEnd = rs2.getString("dateEnd");
            Attendance attendance = new Attendance(name, details, dateStart, dateEnd);
            DBstudents.add(attendance);
        }

        Statement statement = con.createStatement();
        // ArrayList collection = new ArrayList();
        String schoolSelect = "SELECT * FROM school where schoolName='" + details + "'";
        ResultSet rs3 = statement.executeQuery(schoolSelect);
        while (rs3.next()) {
            schoolName = rs3.getString("schoolName");
            schoolID = rs3.getString("schoolId");
            website = rs3.getString("website");
            schoolInfo=rs3.getString("schoolInfo");

        }
        SchoolData thisSchool = new SchoolData(schoolName, schoolID, website, schoolInfo);

            session.setAttribute("DBstudents", DBstudents);
            request.setAttribute("thisSchool", thisSchool);
            request.getRequestDispatcher("DetailsPage.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
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
