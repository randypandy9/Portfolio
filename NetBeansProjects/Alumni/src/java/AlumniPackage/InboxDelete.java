/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(name = "InboxDelete", urlPatterns = {"/InboxDelete"})
public class InboxDelete extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
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
                
                
                    Class.forName("org.postgresql.Driver");
                    Connection msgupdate = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");               
                    String delmsg = "DELETE FROM message WHERE msgid='"+msg.getMessageeID()+"';";
                    PreparedStatement msgdelete = msgupdate.prepareStatement(delmsg);
                    msgdelete.executeUpdate();
                    
                    
                    ArrayList<Message> messages = new ArrayList();
        
                    int msgid = 0;
                    Connection msgcon = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
                    Statement friendstatement = msgcon.createStatement();
                    String myInbox = "SELECT * FROM message WHERE reciever='"+myID+"';";
                    ResultSet inboxResults = friendstatement.executeQuery(myInbox);
                    while(inboxResults.next())
                    {
                        msgid = inboxResults.getInt("msgid");
                        String sender = inboxResults.getString("sender");
                        String reciever = inboxResults.getString("reciever");
                        String themsg = inboxResults.getString("msg");
                        String status = inboxResults.getString("status");

                        Message amsg = new Message(msgid, sender, reciever, themsg, status);
                        messages.add(amsg);
                    }
                    session.setAttribute("myInbox", messages);
                    request.getRequestDispatcher("myInbox.jsp").forward(request, response); 
//                  response.sendRedirect("myInbox.jsp");                 
//                  request.getRequestDispatcher("myInbox.jsp").forward(request, response);
                
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InboxDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InboxDelete.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InboxDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InboxDelete.class.getName()).log(Level.SEVERE, null, ex);
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
