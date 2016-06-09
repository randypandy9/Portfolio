/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

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
 * @author ysj13kxu
 */
@WebServlet(name = "profileController", urlPatterns = {"/profileController"})
public class profileController extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            HttpSession session = request.getSession();      
            Student student = (Student) session.getAttribute("Studentdetails");
                         
            int id = student.getStudentID();
            String newname = request.getParameter("newname");
            String newemail = request.getParameter("newemail");
            String newinfo = request.getParameter("newinfo");
            String newschool = request.getParameter("newschool");
            
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
            String updatestudentdetails = "UPDATE student SET name='"+newname+"', email='"+newemail+"', info='"+newinfo+"', schoolname='"+newschool+"' WHERE studentID='"+id+"';";
            PreparedStatement updatenewdetails = connection.prepareStatement(updatestudentdetails);
            updatenewdetails.executeUpdate();
            String updatelogindetails = "UPDATE login SET email='"+newemail+"' WHERE ID='"+id+"';";
            PreparedStatement updatenewlogin = connection.prepareStatement(updatelogindetails);
            updatenewlogin.executeUpdate();
            String updateattendancedetails = "UPDATE attendance SET name='"+newname+"', schoolname='"+newschool+"' WHERE attendanceID='"+id+"';";
            PreparedStatement updatenewattendance = connection.prepareStatement(updateattendancedetails);
            updatenewattendance.executeUpdate();
            student.setName(newname);
            student.setEmail(newemail);
            student.setInfo(newinfo);
            student.setSchool(newschool);
            session.setAttribute("Studentdetails", student);
            request.getRequestDispatcher("profilepage.jsp").forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(profileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(profileController.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
