/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author ysj13kxu
 */
@WebServlet(urlPatterns = {"/ServletCon"})
public class ServletCon extends HttpServlet {

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
           try 
           {
           //print html to show confirmation page
           out.println("<!DOCTYPE HTML>\n");        
           out.println("<html>\n");
           out.println("<head>\n");
           out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
           out.println("<title>Norwich Bike Hire</title>\n");
           //title
           out.println("<link rel = \"stylesheet\" type = \"text/css\" href = \"newcss.css\" /> \n");
           out.println("</head>\n");
           out.println("\n");
           out.println("<body>\n");
           out.println("<div id=\"head\">\n");
           out.println("	<div id=\"header\">\n");
           out.println("		<h1> \n");
           out.println("			Norwich Bike Hire     \n");
           out.println("            \n");
           out.println("        </h1>\n");
           out.println("	</div>\n");
           out.println("</div>\n");
           out.println("<div id=\"navigation-container\">\n");
           out.println("	<div id=\"navigation\"><!-- NAvigation fo my website -->\n");
           out.println("		<ul>\n");
           //navigation
           out.println("<li><a href=\"http://localhost:8084/cw/Homepage.jsp\">Homepage</a></li>\n"); 
           out.println("<li><a href=\"http://localhost:8084/cw/ServletBook\">Booking</a></li>\n");
           out.println("<li><a href=\"http://localhost:8084/cw/contactus.html\">Contact Us</a></li>\n");
           out.println("<li><a href=\"http://localhost:8084/cw/FAQ.html\">FAQ</a></li>\n"); 
           out.println("<li><a href=\"http://localhost:8084/cw/bikegallery.html\">Bike Gallery</a></li>\n"); 
           out.println("<li><a href=\"http://localhost:8084/cw/CycleRoutes.html\">Cycle Routes</a></li>\n"); 
           out.println("		\n");
           out.println("		</ul>\n");
           out.println("	</div>\n" );
           out.println("</div>\n" );
           out.println("<div id=\"content-container\">\n");
           out.println("<div id=\"content-container2\">\n");
           out.println("	  <div id=\"content-container3\"><!-- content of my webpage -->\n");
           out.println("			<div id=\"content\">\n");
           out.println("				<h2>Confirmation</h2>\n");
           out.println("				<p>");
           out.println("Thank you for your booking, </p>\n"); //shows thank you

            //option to print out order and email to a friend
            out.println("<p> To print your order please click below. Why not email our site to a friend? </p>");
            out.println("<button onclick=\"printFunction()\">Print this page</button>\n"); 
            out.println("\n");
            //buttons
            out.println("<button onclick=\"javascript:emailCurrentPage()\">Email this page</button>\n");
            out.println("<script language=\"javascript\">\n"); 
            out.println("function emailCurrentPage(){\n");
            out.println("            window.location.href=\"mailto:?subject=\"+document.title+\"&body=\"+escape(window.location.href + \" Hello \" );\n");
            out.println("        }\n");
            out.println("    </script>");
            out.println("<script>\n");
            out.println("function printFunction()\n");
            out.println("{\n");
            out.println("window.print();\n");
            out.println("}\n");
            out.println("</script>");
            //scripts from javascriptkit.com
                   
out.println("                \n" +
"\n" +
"        </div>\n" +
"		  <div id=\"right-side\">\n" + //right side container
"          <p><img src=\"logo2.png\" alt=\"some_text\" height=\"250\" width=\"250\">				          \n" +
"          <!-- right section of the webpage with a hover image as the logo --></div> \n" +
"                \n" +
"                \n" +
"	  </div>\n" +
"  </div>\n" +
"	</div>\n" +
"	<div id=\"footer-container\">\n" + //footer container
"		<div id=\"footer\"><!-- footer which appears at the bottom of the webpage -->\n" +
"		  <p> Copyright 2013 Norwich Bike Hire</p>\n" +
"	  </div>\n" +
"	</div>\n" +
"\n" +
"</body>\n" +
"</html>");     
                
               
                
            
            }
            
            finally 
            {            
                out.close(); //finish
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
