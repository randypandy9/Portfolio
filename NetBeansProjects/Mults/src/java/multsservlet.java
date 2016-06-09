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
@WebServlet(urlPatterns = {"/multsservlet"})
public class multsservlet extends HttpServlet {

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
            out.println("<title>Servlet multsservlet</title>");            
            out.println("</head>");
            out.println("<body>");

            int mults = 0;
            int mini = 0;          
            int maxi = 0;  
            
            try
            {
               mini = (Integer.parseInt(request.getParameter("mini")));
            }
            catch (Exception e)
            {
                out.println("no mini");
                
            }
            
            
            try
            {
               maxi = (Integer.parseInt(request.getParameter("maxi")));           
            }
            catch (Exception e)
            {
                out.println("no maxi");
               
            }
            
            
           
            try
            {             
               mults = (Integer.parseInt(request.getParameter("multiply")));
            }
            catch (Exception e)
            {
                out.println("no mults");
                
            }
            
            
            
            
  
            if (mini > maxi)
            {
                out.println("<h1> Woah woah woah, watch out, min is higher than the max! </h1>");
                out.println("ERROR!");
            }
            else 
            {
                out.println("Attempting... <br />");
                for (int changer = mini; changer <= maxi; changer = changer + 1)
                    {
                        out.println("<p>");
                        int res = mults * changer;
                        out.println(changer + "*" + mults + "        " + res);
                        out.println("</p>");
                    }
            }

            
            out.println("</body>");
            out.println("</html>");
        } 
        finally 
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
