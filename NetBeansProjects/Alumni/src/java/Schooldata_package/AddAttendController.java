/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Schooldata_package;

import AlumniPackage.Student;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(name = "AddAttendController", urlPatterns = {"/AddAttendController"})
public class AddAttendController extends HttpServlet {

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
        
        Student student = (Student) session.getAttribute("Studentdetails");
        String alumnitoadd = student.getName();
        String schName = request.getParameter("School");
        String dateStarter = request.getParameter("dateStart");
        String dateEnder = request.getParameter("dateEnd");




        if (!alumnitoadd.isEmpty() || !schName.isEmpty() || !dateStarter.isEmpty() || !dateEnder.isEmpty()) {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
            
            
            PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO attendance (name, schoolName, dateStart, dateEnd) values(?,?,?,?)");            
            insertQuery.setString(1, alumnitoadd);
            insertQuery.setString(2, schName);
            insertQuery.setString(3, dateStarter);
            insertQuery.setString(4, dateEnder);
            insertQuery.executeUpdate();
            
            Attendance newAttendance = new Attendance(alumnitoadd, schName, dateStarter, dateEnder);
            request.setAttribute("newAttendance", newAttendance);
            request.getRequestDispatcher("SchoolAdd.jsp").forward(request, response);
            connection.close();
        } else {
            response.sendRedirect("SchoolDataList.jsp");
        }
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
            Logger.getLogger(AddAttendController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddAttendController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendController.class.getName()).log(Level.SEVERE, null, ex);
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
