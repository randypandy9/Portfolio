/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//imports
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;


/**
 *
 * @author ysj13kxu
 */
@WebServlet(urlPatterns = {"/ServletBook"})
public class ServletBook extends HttpServlet {

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
            // the servlet which contains the booking form
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>Norwich Bike Hire</title>\n" +
"        <link rel = \"stylesheet\" type = \"text/css\" href = \"newcss.css\" /></title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"head\">\n" +
"            <div id=\"header\">\n" +
"                <h1> \n" +
"                    Norwich Bike Hire     \n" +
"                </h1>\n" +
"            </div>\n" +
"        </div>");
            out.println("<div id=\"navigation-container\">\n" +
"            <div id=\"navigation\"><!-- NAvigation fo my website -->\n" +
"                <ul>\n" +
"                    <li><a href=\"http://localhost:8084/cw/Homepage.jsp\">Homepage</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/cw/ServletBook\">Booking</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/cw/contactus.html\">Contact Us</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/cw/FAQ.html\">FAQ</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/cw/bikegallery.html\">Bike Gallery</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/cw/CycleRoutes.html\">Cycle Routes</a></li>\n" +
"\n" +//links to different pages within our website
"                </ul>\n" +
"            </div>\n" +
"        </div>");
            out.println("<div id=\"content-container\">");
            out.println("<div id=\"content-container2\">");
            out.println("<div id=\"content-container3\"><!-- content of my webpage -->");
            out.println("<div id=\"content\">");
            out.println("<h2>Booking Page</h2>");
            out.println("<p>");
            out.println("<form name=\"validation\" method=\"post\">");
            //creating the connection to database
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:postgres","dbuser","dbpassword");
            Statement statement = connection.createStatement();
            out.println("<hr><br/>");
            
            //mens mtb Kona Nunu
            out.println("<h3>Mens Mountain bike(s):</h3><br/>");
            out.println("Kona Nunu:");
            out.println("<select name=\"mensmtbKN\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            
            //mens hybrid Kona Dew
            out.println("<h3>Mens Hybrid bike(s):</h3><br/>");
            out.println("Kona Dew SE FRR:");
            out.println("<select name=\"menshybKD\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/>");
            //mens hybrid Scott Sportster 60
            out.println("Scott Sportster 60:");
            out.println("<select name=\"menshybSS\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            //womens mtb Kona Lisa
            out.println("<h3>Womens Mountain bike(s):</h3><br/>");
            out.println("Kona Lisa HT:");
            out.println("<select name=\"womensmtbKL\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            //womens hybrid Ridgeback velocity
            out.println("<h3>Womens Hybrid bike(s):</h3><br/>");
            out.println("Ridgeback Velocity:");
            out.println("<select name=\"womenshybRV\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/>");
            //womens hybrid Pinnacle Lithium One
            out.println("Pinnacle Lithium One:");
            out.println("<select name=\"womenshybPLO\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            //childs mtb Specialized Hotrock 24
            out.println("<h3>Childrens Mountain bike(s):</h3><br/>");
            out.println("Specialized Hotrock 24:");
            out.println("<select name=\"childsmtbSH24\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/>");
            //childs mtb Jamie X.24
            out.println("Jamie X.24:");
            out.println("<select name=\"hello\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/>");
            //childs mtb Specialized Hotrock 20
            out.println("Specialized Hotrock 20:");
            out.println("<select name=\"childsmtbSH20\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            //tandem bike dawes duet
            out.println("<h3>Tandem bike(s):</h3><br/>");
            out.println("Dawes Duet:");
            out.println("<select name=\"tandemDD\">");
            out.println("<option value=\"0\"> 0 </option>");
            out.println("<option value=\"1\"> 1 </option>");
            out.println("<option value=\"2\"> 2 </option>");
            out.println("<option value=\"3\"> 3 </option>");
            out.println("</select><br/><br/>");
            
            out.println("<hr>"); //rule to seperate bikes from customer info
            out.println("Fields marked with a * are mandatory.");
            out.println("<h3>Booking Details</h3>"); //booking details start
            out.println("*Email address:");
            //enter email
            out.println("<input type=\"text\" size=20 name=\"emailcheck\"><br/><br/>");
            out.println("*Booking Date:");
            //choose booking date
            //by year
            out.println("<select name=\"bookyear\">");
            out.println("<option value=\"2013\" id=\"bookyear13\"> 2013 </option>\n" +
"                    <option value=\"2014\" id=\"bookyear14\"> 2014 </option>\n" +
"                    <option value=\"2015\" id=\"bookyear15\"> 2015 </option>\n" +
"                    <option value=\"2016\" id=\"bookyear16\"> 2016 </option>");
            out.println("</select>");
            out.println("/");
            //by month
            out.println("<select name=\"bookmonth\">");
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
            //by day
            out.println("<select name=\"bookday\">");
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
            out.println("</select> (YYYY/MM/DD)<br/><br/>");
            out.println("*Booking period:");
            //by period
            out.println("<select name=\"bookperiod\">");
            out.println("<option value=\"AM\" id=\"AM\"> AM </option>\n" +
"                    <option value=\"PM\" id=\"PM\"> PM </option>\n" +
"                    <option value=\"ALL\" id=\"ALL\"> ALL </option>");
            out.println("</select>");
      
            out.println("<hr>"); //rule to seperate customer info from card details
            //card details start
            out.println("<h3> Card Details </h3>");
            //card name
            out.println("*Name on card: <input type=\"text\" name=\"cardname\" size=\"16\"/> <br/><br />");
            out.println("*Card Number: <input type=\"text\" name=\"cardno\" size=\"16\"/> <br/><br />");
            out.println("*Card Type: <br/> <br/>");//card type
            out.println("<select name=\"cardtype\">");
            out.println("<option value=\"MC\" id=\"expyear12\"> MASTERCARD </option>\n" +
"                    <option value=\"V\" id=\"expyear13\"> VISA </option>\n" +
"                    <option value=\"AE\" id=\"expyear14\"> AMERICAN EXPRESS </option>\n" +
"                    <option value=\"A\" id=\"expyear16\"> A </option>");
            out.println("</select>");
            //expiry date
            //by month
            out.println("<br /><br />");
            out.println("*Expiration Date:");
            out.println("<select name=\"expmonth\">");
            out.println("<option value=\"01\" id=\"expmonth1\"> 01 </option>\n" +
"                    <option value=\"02\" id=\"expmonth2\"> 02 </option>\n" +
"                    <option value=\"03\" id=\"expmonth3\"> 03 </option>\n" +
"                    <option value=\"04\" id=\"expmonth4\"> 04 </option>\n" +
"                    <option value=\"05\" id=\"expmonth5\"> 05 </option>\n" +
"                    <option value=\"06\" id=\"expmonth6\"> 06 </option>\n" +
"                    <option value=\"07\" id=\"expmonth7\"> 07 </option>\n" +
"                    <option value=\"08\" id=\"expmonth8\"> 08 </option>\n" +
"                    <option value=\"09\" id=\"expmonth9\"> 09 </option>\n" +
"                    <option value=\"10\" id=\"expmonth10\"> 10 </option>\n" +
"                    <option value=\"11\" id=\"expmonth11\"> 11 </option>\n" +
"                    <option value=\"12\" id=\"expmonth12\"> 12 </option>");
            out.println("</select> / <select select name=\"expyear\">");
            //by year
            out.println("<option value=\"12\" id=\"expyear12\"> 12 </option>\n" +
"                    <option value=\"13\" id=\"expyear13\"> 13 </option>\n" +
"                    <option value=\"14\" id=\"expyear14\"> 14 </option>\n" +
"                    <option value=\"15\" id=\"expyear15\"> 15 </option>\n" +
"                    <option value=\"16\" id=\"expyear16\"> 16 </option>");
            out.println("</select> (MM/YY)<br/><br/>\n" +
"                <br />");
            out.println("*Billing Address: <br />"); //billing address
            out.println("*Line 1: <input type=\"text\" name=\"bline1\" size=\"20\"/> <br/><br/>");
            out.println(" Line 2: <input type=\"text\" name=\"bline2\" size=\"20\"/> <br/><br/>");
            out.println(" Line 3: <input type=\"text\" name=\"bline3\" size=\"20\"/> <br/><br/>");
            out.println("*Town / City: <input type=\"text\" name=\"btowncity\" size=\"20\"/> <br/><br/>");
            out.println("*County: <input type=\"text\" name=\"bcounty\" size=\"20\"/> <br/><br/>");
            out.println("*Post Code: <input type=\"text\" name=\"bpc\" size=\"20\"/> <br/><br/>");
            out.println("<br/><br/>");
            //submit and clear button.
            out.println("<input type=\"submit\" onClick=\"con()\" value=\"Submit\">");
            out.println("<input type=\"reset\" value=\"Clear\">");
            out.println("</form>");
            //scripts
            out.println("<script language=\"JavaScript1.2\">");
            out.println("var testresults;");
            out.println("function checkemail()");
            out.println("{\n" +
"                                var str = document.validation.emailcheck.value;\n" +
"                                var filter = /^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$/i;\n" +
"                                if (filter.test(str))\n" +
"                                    testresults = true;\n" +
"                                else {\n" +
"                                    alert(\"Please input a valid email address!\");\n" +
"                                    testresults = false;\n" +
"                                }\n" +
"                                return (testresults);\n" +
"                            }");
            out.println("</script>");
              
            //script to show confirmation after bookings
            out.println("<script>");
            out.println("function con()");
            out.println("{");
            out.println("window.open('http://localhost:8084/cw/ServletCon')");
            out.println("window.close('http://localhost:8084/cw/ServletBook')");
            out.println("}");
            out.println("</script>");
            
            
            
            out.println("<script>");
            out.println("function checkbae() {\n" +
"                                if (document.layers || document.getElementById || document.all)\n" +
"                                    return checkemail();\n" +
"                                else\n" +
"                                    return true;\n" +
"                            }");
            out.println("</script>");
            
            out.println("</div>");
            out.println("<div id=\"right-side\">");
            out.println("<p><img src=\"logo2.png\" alt=\"some_text\" height=\"250\" width=\"250\">\n" +
"\n" +
"\n" +
"                            <!-- right section of the webpage with a hover image as the logo --></div>");
            out.println("</div>");
            
            out.println("</div>");
            out.println("<div>");
            
            
            
            out.println("<div id=\"footer-container\">\n" +
"            <div id=\"footer\"><!-- footer which appears at the bottom of the webpage -->\n" +
"                <p> Copyright 2013 Norwich Bike Hire</p>\n" +
"            </div>\n" +
"        </div>");
            
            
            
            out.println("</body>");
            out.println("</html>");
            
            //create booking id for bike orders
            Random randomGenerator = new Random();
            int value = randomGenerator.nextInt(8999)+1000;
            String ValueString = Integer.toString(value);
            //to pass in to confimation page
            
            String bookyear = request.getParameter("bookyear").toString();
            //pull year value
            String bookmonth = request.getParameter("bookmonth").toString();
            //pull month value
            String bookday = request.getParameter("bookday").toString();
            //pull day value
            String bookperiod = request.getParameter("bookperiod");
            //pull periiod value
            
            String bookdate = bookyear+"-"+bookmonth+"-"+bookday; 
            //concat to create date
            
            
            int mensMtbKN = Integer.parseInt(request.getParameter("mensmtbKN"));
            int mensHybKD = Integer.parseInt(request.getParameter("menshybKD"));
            int mensHybSS = Integer.parseInt(request.getParameter("menshybSS"));
            int womensMtbKL = Integer.parseInt(request.getParameter("womensmtbKL"));
            int womensHybRV = Integer.parseInt(request.getParameter("womenshybRV"));
            int womensHybPLO = Integer.parseInt(request.getParameter("womenshybPLO"));           
            int childsMtbSH24 = Integer.parseInt(request.getParameter("childsmtbSH24"));
            //int Jamie = Integer.parseInt(request.getParameter("hello"));
            int childsMtbSH20 = Integer.parseInt(request.getParameter("childsmtbSH20"));
            int tandemDD = Integer.parseInt(request.getParameter("tandemDD"));
            //pull all values to book each bike
            
            
            //switch cases that correspond to number of bikes chosen for each bike model
            switch (childsMtbSH20) //switch case for childs hotrock 20
            {
            
            case 1:  String sqlStatementbookchildsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH20);
                    
            case 2:  sqlStatementbookchildsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH20);
                     String sqlStatementbook2childsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH341', 'new order');";
                     statement.execute(sqlStatementbook2childsMtbSH20);
                     
            case 3:  sqlStatementbookchildsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH20);
                     sqlStatementbook2childsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH341', 'new order');";
                     statement.execute(sqlStatementbook2childsMtbSH20);
                     String sqlStatementbook3childsMtbSH20 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH319', 'new order');";
                     statement.execute(sqlStatementbook3childsMtbSH20);
                    
            default: break;
            }
            
            /**switch (Jamie) //switch case for childs Jamie X.24
            {
            
            case 1:  String sqlStatementbookJamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookJamie);
                    
            case 2:  sqlStatementbookJamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookJamie);
                     String sqlStatementbook2Jamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH341', 'new order');";
                     statement.execute(sqlStatementbook2Jamie);
                     
            case 3:  sqlStatementbookJamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH326', 'new order');";
                     statement.execute(sqlStatementbookJamie);
                     sqlStatementbook2Jamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH341', 'new order');";
                     statement.execute(sqlStatementbook2Jamie);
                     String sqlStatementbook3Jamie = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH319', 'new order');";
                     statement.execute(sqlStatementbook3Jamie);
                    
            default: break;
            }*/
            
            switch (childsMtbSH24) //switch case for childs hotrock 24
            {
            
            case 1:  String sqlStatementbookchildsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH324', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH24);
                    
            case 2:  sqlStatementbookchildsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH324', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH24);
                     String sqlStatementbook2childsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH342', 'new order');";
                     statement.execute(sqlStatementbook2childsMtbSH24);
                    
            case 3:  sqlStatementbookchildsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH324', 'new order');";
                     statement.execute(sqlStatementbookchildsMtbSH24);
                     sqlStatementbook2childsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH342', 'new order');";
                     statement.execute(sqlStatementbook2childsMtbSH24);
                     String sqlStatementbook3childsMtbSH24 = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH359', 'new order');";
                     statement.execute(sqlStatementbook3childsMtbSH24);
                    
            default: break;
            }
           
            switch (womensHybPLO) //switch case for Pinnacle Lithium One
            {
                
            case 1:  String sqlStatementbookwomensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH105', 'new order');";
                     statement.execute(sqlStatementbookwomensHybPLO);
                     
            case 2:  sqlStatementbookwomensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH105', 'new order');";
                     statement.execute(sqlStatementbookwomensHybPLO);
                     String sqlStatementbook2womensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH128', 'new order');";
                     statement.execute(sqlStatementbook2womensHybPLO);
                     
            case 3:  sqlStatementbookwomensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH105', 'new order');";
                     statement.execute(sqlStatementbookwomensHybPLO);
                     sqlStatementbook2womensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH128', 'new order');";
                     statement.execute(sqlStatementbook2womensHybPLO);
                     String sqlStatementbook3womensHybPLO = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH136', 'new order');";
                     statement.execute(sqlStatementbook3womensHybPLO);
                     
            default: break;
            }
            
            switch (womensHybRV) //switch case for womens hybrid Ridgeback Velocity
            {
                
            case 1:  String sqlStatementbookwomensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH111', 'new order');";
                     statement.execute(sqlStatementbookwomensHybRV);
                     
            case 2:  sqlStatementbookwomensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH111', 'new order');";
                     statement.execute(sqlStatementbookwomensHybRV);
                     String sqlStatementbook2womensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH209', 'new order');";
                     statement.execute(sqlStatementbook2womensHybRV);
                     
            case 3:  sqlStatementbookwomensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH111', 'new order');";
                     statement.execute(sqlStatementbookwomensHybRV);
                     sqlStatementbook2womensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH209', 'new order');";
                     statement.execute(sqlStatementbook2womensHybRV);
                     String sqlStatementbook3womensHybRV = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH291', 'new order');";
                     statement.execute(sqlStatementbook3womensHybRV);
                     
            default: break;
            }
            
            switch (womensMtbKL) //switch case for womens mtb Kona Lisa
            {
                
            case 1:  String sqlStatementbookwomensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH208', 'new order');";
                     statement.execute(sqlStatementbookwomensMtbKL);
                     
            case 2:  sqlStatementbookwomensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH208', 'new order');";
                     statement.execute(sqlStatementbookwomensMtbKL);
                     String sqlStatementbook2womensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH179', 'new order');";
                     statement.execute(sqlStatementbook2womensMtbKL);
                    
            case 3:  sqlStatementbookwomensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH208', 'new order');";
                     statement.execute(sqlStatementbookwomensMtbKL);
                     sqlStatementbook2womensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH179', 'new order');";
                     statement.execute(sqlStatementbook2womensMtbKL);
                     String sqlStatementbook3womensMtbKL = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH141', 'new order');";
                     statement.execute(sqlStatementbook3womensMtbKL);
                     
            default: break;
            }
            
            switch (mensHybSS) //switch case for mens hybrid Scott Sportster 
            {
                
            case 1:  String sqlStatementbookmensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH101', 'new order');";
                     statement.execute(sqlStatementbookmensHybSS);
                    
            case 2:  sqlStatementbookmensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH101', 'new order');";
                     statement.execute(sqlStatementbookmensHybSS);
                     String sqlStatementbook2mensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH148', 'new order');";
                     statement.execute(sqlStatementbook2mensHybSS);
                    
            case 3:  sqlStatementbookmensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH101', 'new order');";
                     statement.execute(sqlStatementbookmensHybSS);
                     sqlStatementbook2mensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH148', 'new order');";
                     statement.execute(sqlStatementbook2mensHybSS);
                     String sqlStatementbook3mensHybSS = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH120', 'new order');";
                     statement.execute(sqlStatementbook3mensHybSS);
                     
            default: break;
            }
            
            switch (mensHybKD) //switch case for mens hybrid Kona Dew
            {
                
            case 1:  String sqlStatementbookmensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH178', 'new order');";
                     statement.execute(sqlStatementbookmensHybKD);
                     
            case 2:  sqlStatementbookmensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH178', 'new order');";
                     statement.execute(sqlStatementbookmensHybKD);
                     String sqlStatementbook2mensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH248', 'new order');";
                     statement.execute(sqlStatementbook2mensHybKD);
                     
            case 3:  sqlStatementbookmensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH178', 'new order');";
                     statement.execute(sqlStatementbookmensHybKD);
                     sqlStatementbook2mensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH248', 'new order');";
                     statement.execute(sqlStatementbook2mensHybKD);
                     String sqlStatementbook3mensHybKD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH180', 'new order');";
                     statement.execute(sqlStatementbook3mensHybKD);
                     
            default:  break;
            }
            
            
            switch (mensMtbKN)  //switch case for mens mtb Kona Nunu
            {
               
            case 1:  String sqlStatementbookmensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH284', 'new order');";
                     statement.execute(sqlStatementbookmensMtbKN);
                     
            case 2:  sqlStatementbookmensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH284', 'new order');";
                     statement.execute(sqlStatementbookmensMtbKN);
                     String sqlStatementbook2mensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH228', 'new order');";
                     statement.execute(sqlStatementbook2mensMtbKN);
                     
            case 3:  sqlStatementbookmensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH284', 'new order');";
                     statement.execute(sqlStatementbookmensMtbKN);
                     sqlStatementbook2mensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH228', 'new order');";
                     statement.execute(sqlStatementbook2mensMtbKN);
                     String sqlStatementbook3mensMtbKN = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH125', 'new order');";
                     statement.execute(sqlStatementbook3mensMtbKN);
                     
            default: break;
            }
            
            switch (tandemDD) //switch case for Tandem bike
            {
            
            case 1:  String sqlStatementbooktandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH255', 'new order');";
                     statement.execute(sqlStatementbooktandemDD);
                     break;
            case 2:  sqlStatementbooktandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH255', 'new order');";
                     statement.execute(sqlStatementbooktandemDD);
                     String sqlStatementbook2tandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH126', 'new order');";
                     statement.execute(sqlStatementbook2tandemDD);
                     break;
            case 3:  sqlStatementbooktandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH255', 'new order');";
                     statement.execute(sqlStatementbooktandemDD);
                     sqlStatementbook2tandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH126', 'new order');";
                     statement.execute(sqlStatementbook2tandemDD);
                     String sqlStatementbook3tandemDD = "INSERT INTO booked_bike VALUES ('"+ value +"', 'NCH227', 'new order');";
                     statement.execute(sqlStatementbook3tandemDD);
                     break;
            default: break;
           }

            
            
            
            //passing into string values from card details
            String cardname = request.getParameter("cardname");
            String email = request.getParameter("emailcheck");
            String cardno = request.getParameter("cardno");
            String expmonth = request.getParameter("expmonth").toString();
            String expyear = request.getParameter("expyear").toString();
            String bline1 = request.getParameter("bline1");
            String bline2 = request.getParameter("bline2");
            String bline3 = request.getParameter("bline3");
            String btowncity = request.getParameter("btowncity");
            String bcounty = request.getParameter("bcounty");
            String bpc = request.getParameter("bpc");
            String cardtype = request.getParameter("cardtype").toString();
            
            //concat address
            String address = bline1 + ", " + bline2 + ", " + bline3 + ", " + btowncity + ", " + bcounty + ", " + bpc; 
            //concat expiry date
            String expiry = expmonth + "/" + expyear;

            //sql statement to delete null insertions in database
            String sqlStatementnuller = "DELETE FROM customer WHERE customer_email='null'; ";
            //sql statement to insert customer details
            String sqlStatement = "INSERT INTO customer VALUES ('" + cardname + "', '" + email + "', '" + address + "', '"+ cardtype +"', '"+ expiry +"', '" + cardno + "');";
            //sql statement to insert customer booking
            String sqlStatementbook = "INSERT INTO booking VALUES ('"+value+"', '" + email + "', '"+bookdate+"', '"+bookperiod+"');";
            
            //execute statements
            statement.execute(sqlStatementnuller);
            statement.execute(sqlStatement);
            statement.execute(sqlStatementbook);
            //close connection
            connection.close();

    
            } 
            catch (SQLException ex) //catch sql error
            {
                Logger.getLogger(ServletCon.class.getName()).log(Level.SEVERE, null, ex);
                out.println("ERROR: " + ex);
            } 
            catch (ClassNotFoundException ex) //catch Class Error
            {
                 Logger.getLogger(ServletCon.class.getName()).log(Level.SEVERE, null, ex);
                 out.println("ERROR: " + ex);
            } 
            finally //finish
            {            
                out.close();
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
