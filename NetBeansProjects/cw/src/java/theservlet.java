/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ysj13kxu
 */
@WebServlet(urlPatterns = {"/theservlet"})
public class theservlet extends HttpServlet {
    public static String directory;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Group ZW - Checkout </title>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"checkout.css\" media=\"all\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"get\" action=\"ServletCon\" name=\"myform\">");
            out.println("<div class=\"titles\">"); 
            out.println("<h1> Checkout </h1>");
            out.println("</div>");
            out.println("<hr>");
            out.println("<div>");
            out.println("<table class=\"cpr\">");
            out.println("<tr>");
            out.println("<th> CHECKOUT AND</th>");
            out.println("<th> PAYMENT </th>");
            out.println("<th>/ Review </th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("<br /><br />");
            out.println("<hr>");
            out.println("<div class=\"titles\">");
            out.println("<h2> Your order details / Basket </h2>");
            out.println("</div>");
            out.println("<div>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Item(s)</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Price</th>");
            out.println("<th>Remove</th>");
            out.println("</tr>");
            out.println("<tr align=\"center\">");
            out.println("<td>(booked bikes would be displayed here)</td>");
            out.println("<td>");
            out.println("<select>");
            out.println("<option value=\"1\" id=\"bikesamount1\"> 1 </option>");
            out.println("<option value=\"2\" id=\"bikesamount2\"> 2 </option>");
            out.println("<option value=\"3\" id=\"bikesamount3\"> 3 </option>");
            out.println("</select>");
            out.println("</td>");
            out.println("<td> £(Price of bike hire)</td>");
            out.println("<td><input type=\"checkbox\"> Remove </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("<hr>");
            out.println("<div class=\"details1\">");
            out.println("<h3> Customer Details </h3>");
            out.println("*First Name: <input type=\"text\" name=\"fname\" size=\"10\"/>");
            out.println("*Last Name: <input type=\"text\" name=\"lname\" size=\"10\"/>");
            out.println("<br /> *Address:");
            out.println("<div> <div class=\"indent\">");
            out.println("*Line 1 <input type=\"text\" name=\"address1\" size=\"20\"/><br />");
            out.println(" Line 2 <input type=\"text\" name=\"address2\" size=\"20\"/><br />");
            out.println(" Line 3 <input type=\"text\" name=\"address3\" size=\"20\"/><br />");
            out.println("*Town/City <input type=\"text\" name=\"addresstown\" size=\"20\"/><br />");
            out.println("*County <input type=\"text\" name=\"addresscounty\" size=\"20\"/><br />");
            out.println("*Post Code <input type=\"text\" name=\"addresspc\" size=\"20\"/><br />");
            out.println("</div></div>");
            out.println("*Phone Number: <input type=\"text\" name=\"email\" size=\"20\"/><br />");
            out.println("*Email Address: <input type=\"text\" name=\"email\" size=\"20\"/><br /><br />");
            out.println("<p>Fields marked with a * must be filled in.</p>");
            out.println("</div>");
            out.println("<div>");
            out.println("<h3> Card Details </h3>");
            out.println("*Name on card: <input type=\"text\" name=\"cardname\" size=\"16\"/> <br/><br />");
            out.println("*Card Number: <input type=\"text\" name=\"cardno\" size=\"16\"/> <br/><br />");          
            out.println("*Start Date:");
            out.println("<select>");
            out.println("<option value=\"01\" id=\"sttmonth1\"> 01 </option>");
            out.println("<option value=\"02\" id=\"sttmonth2\"> 02 </option>");
            out.println("<option value=\"03\" id=\"sttmonth3\"> 03 </option>");
            out.println("<option value=\"04\" id=\"sttmonth4\"> 04 </option>");
            out.println("<option value=\"05\" id=\"sttmonth5\"> 05 </option>");
            out.println("<option value=\"06\" id=\"sttmonth6\"> 06 </option>");
            out.println("<option value=\"07\" id=\"sttmonth7\"> 07 </option>");
            out.println("<option value=\"08\" id=\"sttmonth8\"> 08 </option>");
            out.println("<option value=\"09\" id=\"sttmonth9\"> 09 </option>");
            out.println("<option value=\"10\" id=\"sttmonth10\"> 10 </option>");
            out.println("<option value=\"11\" id=\"sttmonth11\"> 11 </option>");
            out.println("<option value=\"12\" id=\"sttmonth12\"> 12 </option>");
            out.println("</select> / <select>");
            out.println("<option value=\"07\" id=\"sttyear7\"> 07 </option>");
            out.println("<option value=\"08\" id=\"sttyear8\"> 08 </option>");
            out.println("<option value=\"09\" id=\"sttyear9\"> 09 </option>");
            out.println("<option value=\"10\" id=\"sttyear9\"> 10 </option>");
            out.println("<option value=\"11\" id=\"sttyear9\"> 11 </option>");
            out.println("</select> (MM/YY) <br/><br />");
            out.println("*Expiration Date:");
            out.println("<select>");
            out.println("<option value=\"01\" id=\"expmonth1\"> 01 </option>");
            out.println("<option value=\"02\" id=\"expmonth2\"> 02 </option>");
            out.println("<option value=\"03\" id=\"expmonth3\"> 03 </option>");
            out.println("<option value=\"04\" id=\"expmonth4\"> 04 </option>");
            out.println("<option value=\"05\" id=\"expmonth5\"> 05 </option>");
            out.println("<option value=\"06\" id=\"expmonth6\"> 06 </option>");
            out.println("<option value=\"07\" id=\"expmonth7\"> 07 </option>");
            out.println("<option value=\"08\" id=\"expmonth8\"> 08 </option>");
            out.println("<option value=\"09\" id=\"expmonth9\"> 09 </option>");
            out.println("<option value=\"10\" id=\"expmonth10\"> 10 </option>");
            out.println("<option value=\"11\" id=\"expmonth11\"> 11 </option>");
            out.println("<option value=\"12\" id=\"expmonth12\"> 12 </option>");
            out.println("</select> / <select>");
            out.println("<option value=\"12\" id=\"expyear12\"> 12 </option>");
            out.println("<option value=\"13\" id=\"expyear13\"> 13 </option>");
            out.println("<option value=\"14\" id=\"expyear14\"> 14 </option>");
            out.println("<option value=\"15\" id=\"expyear15\"> 15 </option>");
            out.println("<option value=\"16\" id=\"expyear16\"> 16 </option>");
            out.println("</select> (MM/YY) <br /><br />");
            out.println("*Security Code: <input type=\"text\" name=\"seccode\" size=\"3\"/> <br/>");
            out.println("(The last 3 digits displayed on the back of your Debit/Credit Card.) <br /><br />");
            out.println("</div>");
            out.println("<hr> <br/>");
            out.println("<div class=\"totals\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Subtotal:</th>");
            out.println("<th>(subtotal price)</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>VAT:</th>");
            out.println("<th>(added VAT)</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>TOTAL:</th>");
            out.println("<th>(TOTAL Price)</th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("<br />");
            out.println("<div class=\"buttons\">");
            out.println("<input type=\"submit\" value=\"Continue\">");
            out.println("<input type=\"reset\" value=\"Reset\">");
            out.println("</div>");
            out.println("</form>");         
            out.println("</body>");
            out.println("</html>");
        } finally {            
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
