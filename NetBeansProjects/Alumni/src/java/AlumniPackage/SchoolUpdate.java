/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hta13nau
 */
@WebServlet(name = "SchoolUpdate", urlPatterns = {"/SchoolUpdate"})
public class SchoolUpdate extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        int id=0;       
        String email = request.getParameter("email");
        String schoolAdd = request.getParameter("schoolAdd");
        String dateStart = request.getParameter("dateStart");
        String dateEnd  = request.getParameter("dateEnd");
        Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
        PreparedStatement studentQuery =connection.prepareStatement("Select studentid from student where email='"+email+"'");
        ResultSet studentResult = studentQuery.executeQuery();
        while(studentResult.next()){
             id = studentResult.getInt("studentid");
        }
        String updateStudentSql = "UPDATE student SET schoolName='"+schoolAdd+"' WHERE studentid='"+ id +"'";
        PreparedStatement updateStatement1 = connection.prepareStatement(updateStudentSql); 
        updateStatement1.executeUpdate();
        String updateAttendanceSql = "UPDATE attendance SET schoolName='"+schoolAdd+"', dateStart='"+dateStart+"', dateEnd='"+dateEnd+"' WHERE attendanceid='"+ id +"'";
        PreparedStatement updateStatement2 = connection.prepareStatement(updateAttendanceSql);
        updateStatement2.executeUpdate();
      
        response.sendRedirect("profileCreated.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(SchoolUpdate.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(SchoolUpdate.class.getName()).log(Level.SEVERE, null, ex);
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
