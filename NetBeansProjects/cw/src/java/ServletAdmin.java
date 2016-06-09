/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//imports
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ysj13kxu
 */
@WebServlet(urlPatterns = {"/ServletAdmin"})
public class ServletAdmin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //output into browser admin page
            out.println("<!DOCTYPE html>");
            out.println("<html>\n");
            out.println("<head>\n");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"); 
            out.println("<title>Norwich Bike Hire</title>\n"); 
            out.println("<link rel = \"stylesheet\" type = \"text/css\" href = \"newcss.css\" />");            
            out.println("</head>\n");
            out.println("<body>\n");
            out.println("<div id=\"head\">\n"); 
            out.println("<div id=\"header\">\n"); 
            out.println("<h1> \n"); 
            out.println("Norwich Bike Hire     \n"); 
            out.println("\n"); 
            out.println("</h1>\n"); 
            out.println("</div>\n");
            out.println("</div>\n");
            out.println("<div id=\"navigation-container\">\n");
            out.println("<div id=\"navigation\"><!-- NAvigation fo my website -->\n"); 
            out.println("<ul>\n");
            //navigation
            out.println("<li><a href=\"http://localhost:8084/cw/Homepage.jsp\">Homepage</a></li>\n"); 
            out.println("<li><a href=\"http://localhost:8084/cw/ServletBook\">Booking</a></li>\n");
            out.println("<li><a href=\"http://localhost:8084/cw/contactus.html\">Contact Us</a></li>\n");
            out.println("<li><a href=\"http://localhost:8084/cw/FAQ.html\">FAQ</a></li>\n"); 
            out.println("<li><a href=\"http://localhost:8084/cw/bikegallery.html\">Bike Gallery</a></li>\n"); 
            out.println("<li><a href=\"http://localhost:8084/cw/CycleRoutes.html\">Cycle Routes</a></li>\n"); 
            out.println("\n"); 
            out.println("</ul>\n");
            out.println("</div>\n");
            out.println("</div>");
            out.println("<div id=\"content-container\">\n");
            out.println("<div id=\"content-container2\">\n");
            out.println("<div id=\"content-container3\"><!-- content of my webpage -->\n");
            out.println("<div id=\"content\">\n");
            out.println("<h2>Admin Page</h2>\n");//admin page title
            out.println("<p>");
            out.println("<form method=\"post\">"); 
            //search booking by date
            out.println("Search by Date:");
            out.println("<select name=\"year\">");
            //enter year
            out.println("<option value=\"2013\" id=\"bookyear13\"> 2013 </option>\n" +
"                    <option value=\"2014\" id=\"bookyear14\"> 2014 </option>\n" +
"                    <option value=\"2015\" id=\"bookyear15\"> 2015 </option>\n" +
"                    <option value=\"2016\" id=\"bookyear16\"> 2016 </option>");
            out.println("</select>");
            out.println("/");
            //enter month
            out.println("<select name=\"month\">");
            out.println("<option value=\"01\" id=\"bookmonth1\"> 01 </option>\n" +
"                    <option value=\"02\" id=\"bookmonth2\"> 02 </option>\n" +
"                    <option value=\"03\" id=\"bookmonth3\"> 03 </option>\n" +
"                    <option value=\"04\" id=\"bookmonth4\"> 04 </option>\n" +
"                    <option value=\"05\" id=\"bookmonth5\"> 05 </option>\n" +
"                    <option value=\"06\" id=\"bookmonth6\"> 06 </option>\n" +
"                    <option value=\"07\" id=\"bookmonth7\"> 07 </option>\n" +
"                    <option value=\"08\" id=\"bookmonth8\"> 08 </option>\n" +
"                    <option value=\"09\" id=\"bookmonth9\"> 09 </option>\n" +
"                    <option value=\"10\" id=\"bookmonth10\"> 10 </option>\n" +
"                    <option value=\"11\" id=\"bookmonth11\"> 11 </option>\n" +
    "                    <option value=\"12\" id=\"bookmonth12\"> 12 </option>");
            out.println("</select>");
            out.println("/");
            //enter day
            out.println("<select name=\"day\">");
            out.println("<option value=\"01\" id=\"bookday1\"> 01 </option>\n" +
"                    <option value=\"02\" id=\"bookday2\"> 02 </option>\n" +
"                    <option value=\"03\" id=\"bookmonth3\"> 03 </option>\n" +
"                    <option value=\"04\" id=\"bookmonth4\"> 04 </option>\n" +
"                    <option value=\"05\" id=\"bookmonth5\"> 05 </option>\n" +
"                    <option value=\"06\" id=\"bookmonth6\"> 06 </option>\n" +
"                    <option value=\"07\" id=\"bookmonth7\"> 07 </option>\n" +
"                    <option value=\"08\" id=\"bookmonth8\"> 08 </option>\n" +
"                    <option value=\"09\" id=\"bookmonth9\"> 09 </option>\n" +
"                    <option value=\"10\" id=\"bookmonth10\"> 10 </option>\n" +
"                    <option value=\"11\" id=\"bookmonth11\"> 11 </option>\n" +
"                    <option value=\"12\" id=\"bookmonth12\"> 12 </option>\n" +
"                    <option value=\"13\" id=\"bookmonth13\"> 13 </option>\n" +
"                    <option value=\"14\" id=\"bookmonth14\"> 14 </option>\n" +
"                    <option value=\"15\" id=\"bookmonth15\"> 15 </option>\n" +
"                    <option value=\"16\" id=\"bookmonth16\"> 16 </option>\n" +
"                    <option value=\"17\" id=\"bookmonth17\"> 17 </option>\n" +
"                    <option value=\"18\" id=\"bookmonth18\"> 18 </option>\n" +
"                    <option value=\"19\" id=\"bookmonth19\"> 19 </option>\n" +
"                    <option value=\"20\" id=\"bookmonth20\"> 20 </option>\n" +
"                    <option value=\"21\" id=\"bookmonth21\"> 21 </option>\n" +
"                    <option value=\"22\" id=\"bookmonth22\"> 22 </option>\n" +
"                    <option value=\"23\" id=\"bookmonth23\"> 23 </option>\n" +
"                    <option value=\"24\" id=\"bookmonth24\"> 24 </option>\n" +
"                    <option value=\"25\" id=\"bookmonth25\"> 25 </option>\n" +
"                    <option value=\"26\" id=\"bookmonth26\"> 26 </option>\n" +
"                    <option value=\"27\" id=\"bookmonth27\"> 27 </option>\n" +
"                    <option value=\"28\" id=\"bookmonth28\"> 28 </option>\n" +
"                    <option value=\"29\" id=\"bookmonth29\"> 29 </option>\n" +
"                    <option value=\"30\" id=\"bookmonth30\"> 30 </option>\n" +
"                    <option value=\"31\" id=\"bookmonth31\"> 31 </option>");
            out.println("</select> (YYYY/MM/DD)<br/><br/>"); //user info: how layout shows on page
            out.println("<input type=\"submit\" value=\"Search\">"); //submit
            out.println("<input type=\"submit\" value=\"Clear\">"); //clear (submits nothing)
            out.println("<table>"); //tabel start to show results
            //titles
            out.println("<tr> <th> BOOKNG ID </th> <th> CUSTOMER EMAIL </th> <th> BOOKING DATE </th> <th> BOOKING PERIOD </th><th> AMOUNT </th> <th> NOTE </th></tr> ");
            
            //pulling out values of date 
            String year = request.getParameter("year").toString();
            String month = request.getParameter("month").toString();
            String day = request.getParameter("day").toString();
            String date = year+"-"+month+"-"+day; //concat into a date string
            
            //start connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres","dbuser","dbpassword");
            Statement statement = connection.createStatement();
            //sql statement 
            String sqlStatementdate = "SELECT * FROM booking WHERE booking_date='"+date+"'";
            ResultSet resultSet = statement.executeQuery(sqlStatementdate);
            while(resultSet.next()) //create table 
            {
                out.println("<tr>");//create one row 
                //output in relevant columns
                out.println("<td>" + resultSet.getInt("booking_id") + "</td>");
                out.println("<td>" + resultSet.getString("customer_email") + "</td>");
                out.println("<td>" + resultSet.getString("booking_date") + "</td>");
                out.println("<td>" + resultSet.getString("booking_period") + "</td>");
                out.println("<td>" + resultSet.getString("amount") + "</td>");
                out.println("<td>" + resultSet.getString("note") + "</td>");
                out.println("</tr>");
            }
            //close connction
            connection.close();
            } 
            catch (ClassNotFoundException ex)  //catch Class Error
            {
                Logger.getLogger(ServletCon.class.getName()).log(Level.SEVERE, null, ex);
                out.println("ERROR: " + ex);
            } 
            catch (SQLException ex) //catch sql error
            {
                Logger.getLogger(ServletCon.class.getName()).log(Level.SEVERE, null, ex);
                out.println("ERROR: " + ex);
            } 
            finally 
            {            
                out.close(); //finish
            }
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            out.println("<div id=\"right-side\">\n");
            out.println("<p><img src=\"logo2.png\" alt=\"some_text\" height=\"250\" width=\"250\">");
            out.println("</p>");
            out.println("</div>\n");
            out.println("</div>\n");
            out.println("</div>\n");
            out.println("<div id=\"footer-container\">\n");
            out.println("<div id=\"footer\"><!-- footer which appears at the bottom of the webpage -->\n"); 
            out.println("<p> Copyright 2013 Norwich Bike Hire</p>\n");
            out.println("</div>\n");
            out.println("</div>\n");
            out.println("</body>");
            out.println("</html>");
            
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
