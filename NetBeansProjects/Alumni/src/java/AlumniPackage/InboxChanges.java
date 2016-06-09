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
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "InboxChanges", urlPatterns = {"/InboxChanges"})
public class InboxChanges extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        Student student = (Student) session.getAttribute("Studentdetails");
        int myID = student.getStudentID();

        List msgs = (List) session.getAttribute("myInbox");
        
        int msgID = Integer.parseInt(request.getParameter("msgID"));
        
        Iterator msgit = msgs.iterator();
        while (msgit.hasNext()) 
        {
            Message msg = (Message) msgit.next();
            
            if (msg.getMessageeID() == msgID) 
            {               
                
                if (msg.getStatus().equals("Unread"))
                {
                    Class.forName("org.postgresql.Driver");
                    Connection msgupdate = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");               
                    String myInbox = "UPDATE message SET status='Read' WHERE msgid='"+msg.getMessageeID()+"';";
                    PreparedStatement msgupdatestatement = msgupdate.prepareStatement(myInbox);
                    msgupdatestatement.executeUpdate();
                    msg.setStatus("Read");
                    request.getRequestDispatcher("myInbox.jsp").forward(request, response);
                }
                else if (msg.getStatus().equals("Read"))
                {
                    Class.forName("org.postgresql.Driver");
                    Connection msgupdate = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");               
                    String myInbox = "UPDATE message SET status='Unread' WHERE msgid='"+msg.getMessageeID()+"';";
                    PreparedStatement msgupdatestatement = msgupdate.prepareStatement(myInbox);
                    msgupdatestatement.executeUpdate();
                    msg.setStatus("Unread");
                    request.getRequestDispatcher("myInbox.jsp").forward(request, response);
                }
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(InboxChanges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InboxChanges.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InboxChanges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InboxChanges.class.getName()).log(Level.SEVERE, null, ex);
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
