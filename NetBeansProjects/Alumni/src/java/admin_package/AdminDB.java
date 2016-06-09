/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_package;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author HTA13NAU
 */
@WebServlet(name = "AdminDB", urlPatterns = {"/AdminDB"})
public class AdminDB extends HttpServlet {

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

    public static Connection getConnection()throws ClassNotFoundException, SQLException{
      try{
          
        Class.forName("org.postgresql.Driver");
       // String jdbcUrl = "jdbc:postgresql:studentdb";
        //String user= "dbuser";
        //String password= "dbpassword";
        
        //catch(Exception e){
    }
      catch(Exception e){  
          throw new ClassNotFoundException("connection failed", e);
      }
      //return(DriverManager.getConnection(jdbcUrl, user, password)); 
      return( DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", ""));
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
        
            /* TODO output your page here. You may use following sample code. */
          //  String user =request.getParameter("Auser");
           // String password=request.getParameter("Apass");
            
            String type = request.getParameter("type");
            
            if(type.equals("add"))
            {
                String schoolName = request.getParameter("schoolName");
                String schoolId =  request.getParameter("schoolID");
                String website = request.getParameter("website");
                String schoolInfo= request.getParameter("schoolInfo");
                School school = new School(schoolName, schoolId, website, schoolInfo);
                school.addSchool();
                request.setAttribute("aSchool", school);
                request.getRequestDispatcher("AdminAdd.jsp").forward(request, response);
            } 
             if (type.equals("list")){
                 
                ArrayList sch =SchoolList.returnSchool();
                ArrayList numSch =Attendance.returnAttendance();
                ArrayList countUser =Student.countUser();
                ArrayList countSchool =SchoolCount.countSchool();
            
                request.setAttribute("schoolList", sch);
                request.setAttribute("arry", numSch);
                request.setAttribute("countUser", countUser);
                request.setAttribute("countSchool", countSchool);
            
                request.getRequestDispatcher("AdminschoolList.jsp").forward(request, response);
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
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
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
