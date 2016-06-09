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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 *
 * @author ysj13kxu
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        
        int id = 0;
        //getting logging in details
        String loginusername = request.getParameter("loginusername");
        String loginpassword = request.getParameter("loginpassword");

        //getting signing up details
        String signname = request.getParameter("signfullname");
        String signusername = request.getParameter("signusername");
        String signpassword = request.getParameter("signpassword");
        String signemail = request.getParameter("signemail");
        String signemailcheck = request.getParameter("signemailconfirm");
        String signdatestart = request.getParameter("dateStart");
        String signdateend = request.getParameter("dateEnd");
        String signSchool = request.getParameter("signschool");
        
        
        String defaultinfo = signname + ", you haven't set any information about yourself!";
        //default info
        
        ArrayList<Attendance> friendList = new ArrayList();
        ArrayList<Attendance> allfriendList = new ArrayList();
        //array to keep users relavant friends
        //checks if sign up fields were used
        if (signname != null || signusername != null || signpassword != null || signemail != null || signemailcheck != null) {
            Account account = new Account(signname, signusername, signpassword, signemail);
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
            //sql statement
            String loginTableAdd = "INSERT INTO login(username, password, email) VALUES (?,?,?)";
            PreparedStatement loginstatement = connection.prepareStatement(loginTableAdd);
            loginstatement.setString(1, signusername);
            loginstatement.setString(2, signpassword);
            loginstatement.setString(3, signemail);
            loginstatement.executeUpdate();
            String studentTableAdd = "INSERT INTO student(name, email, info, schoolname) VALUES (?,?,?,?);";
            PreparedStatement studentstatement = connection.prepareStatement(studentTableAdd);
            studentstatement.setString(1, signname);
            studentstatement.setString(2, signemail);
            studentstatement.setString(3, defaultinfo);
            studentstatement.setString(4, signSchool);
            studentstatement.executeUpdate();
            String attendanceTableAdd = "INSERT INTO attendance(name, schoolname, datestart, dateend) VALUES (?,?,?,?);";
            PreparedStatement attendancestatement = connection.prepareStatement(attendanceTableAdd);
            attendancestatement.setString(1, signname);
            attendancestatement.setString(2, signSchool);
            attendancestatement.setString(3, signdatestart);
            attendancestatement.setString(4, signdateend);
            attendancestatement.executeUpdate();
            Statement listStatement = connection.createStatement();
            ArrayList schoolCollection = new ArrayList();
            String schoolListsql = "SELECT * from school";
            ResultSet listResult = listStatement.executeQuery(schoolListsql);
            while (listResult.next()) {
                String schoolName = listResult.getString("schoolName");
                String schoolID = listResult.getString("schoolId");
                School schoolList = new School(schoolName, schoolID);
                schoolCollection.add(schoolList);
            }
            request.setAttribute("Accountsigndetails", account);
            request.setAttribute("schoolList", schoolCollection);
            request.getRequestDispatcher("signUpConfirmation.jsp").forward(request, response);
            connection.close();
        }

        //check if the log in fields were used
        if (!loginusername.isEmpty() && !loginpassword.isEmpty()) {
            //creates
            Account login = new Account(id, loginusername, loginpassword);
            int myStartDate = 0;
            int myEndDate = 0;
            String mySchool = null;
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
            Statement statement = connection.createStatement();

            String getEmails = "SELECT email FROM login WHERE username='" + loginusername + "' AND password='"+loginpassword+"';";
            ResultSet resultSet = statement.executeQuery(getEmails);
            //got username and email from login
            while (resultSet.next()) //
            {
                String gottenEmail = resultSet.getString("email");

                String getStudent = "SELECT * FROM student WHERE email='" + gottenEmail + "';";
                ResultSet studentResultSet = statement.executeQuery(getStudent);
                while (studentResultSet.next()) {
                    int studentID = studentResultSet.getInt("studentid");
                    String studentName = studentResultSet.getString("name");
                    String studentEmail = studentResultSet.getString("email");
                    String studentInfo = studentResultSet.getString("info");
                    String studentSchool = studentResultSet.getString("schoolName");

                    Student student = new Student(studentID, studentName, studentEmail, studentInfo, studentSchool);
                    connection.close();


                    Class.forName("org.postgresql.Driver");
                    Connection myconnection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
                    Statement mystatement = myconnection.createStatement();
                    String mySelfsql = "SELECT DISTINCT * FROM attendance WHERE attendanceid='" + studentID + "';";
                    ResultSet myResultSet = mystatement.executeQuery(mySelfsql);
                    while (myResultSet.next()) {
                        myStartDate = Integer.parseInt(myResultSet.getString("datestart"));
                        myEndDate = Integer.parseInt(myResultSet.getString("dateend"));
                        mySchool = myResultSet.getString("schoolname");
                    }
                    
                    Class.forName("org.postgresql.Driver");
                    Connection allfriendconnection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
                    Statement allfriendstatement = allfriendconnection.createStatement();
                    String allfriendListsql = "SELECT DISTINCT * FROM attendance;";
                    ResultSet allfriendResultSet = allfriendstatement.executeQuery(allfriendListsql);
                    while (allfriendResultSet.next()) 
                    {
                        int allfriendid = allfriendResultSet.getInt("attendanceid");
                        String allfriendname = allfriendResultSet.getString("name");
                        String allfriendSchool = allfriendResultSet.getString("schoolName");
                        String allfriendStartDate = allfriendResultSet.getString("datestart");
                        String allfriendEndDate = allfriendResultSet.getString("dateend"); 
                        
                        Attendance allfriends = new Attendance (allfriendid, allfriendname, allfriendSchool, allfriendStartDate, allfriendEndDate);
                        allfriendList.add(allfriends);
                    }
                    
                   
                    
                    
                    Class.forName("org.postgresql.Driver");
                    Connection friendconnection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
                    Statement friendstatement = friendconnection.createStatement();
                    String friendListsql = "SELECT DISTINCT * FROM attendance WHERE schoolName='"+mySchool+"';";
                    ResultSet friendResultSet = friendstatement.executeQuery(friendListsql);
                    while (friendResultSet.next()) {
                        int friendid = friendResultSet.getInt("attendanceid");
                        String friendname = friendResultSet.getString("name");
                        String friendSchool = friendResultSet.getString("schoolName");
                        String friendStartDate = friendResultSet.getString("datestart");
                        String friendEndDate = friendResultSet.getString("dateend");
                        int startDate = Integer.parseInt(friendStartDate);
                        int endDate = Integer.parseInt(friendEndDate);
                        
                        for (int i = startDate; i < endDate+1; i++) {
                            if (myStartDate == startDate || myEndDate == endDate)//check course overlaps
                            {
                                Attendance afriend = new Attendance(friendid, friendname, friendSchool, friendStartDate, friendEndDate);
                                friendList.add(afriend);
                                myStartDate++;
                                myEndDate--;
                            }
                        }
                        
                    }
                    Class.forName("org.postgresql.Driver");
                    Connection bconnection = DriverManager.getConnection("jdbc:postgresql:postgres", "dbuser", "dbpassword");
                    Statement blistStatement = bconnection.createStatement();
                    ArrayList bschoolCollection = new ArrayList();
                    String bschoolListsql = "SELECT * from school;";
                    ResultSet blistResult = blistStatement.executeQuery(bschoolListsql);
                    while (blistResult.next()) 
                    {
                        String schoolName = blistResult.getString("schoolName");
                        String schoolID = blistResult.getString("schoolId");
                        School schoolList = new School(schoolName, schoolID);
                        bschoolCollection.add(schoolList);          
                    }
                    friendconnection.close();
                    session.setAttribute("friends", friendList);
                    session.setAttribute("bschoolList", bschoolCollection);
                    session.setAttribute("Studentdetails", student);
                    session.setAttribute("allfriends", allfriendList);
                    request.getRequestDispatcher("profilepage.jsp").forward(request, response);
                }
            }
            connection.close();
            response.sendRedirect("index.jsp");
        }
    }

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
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
