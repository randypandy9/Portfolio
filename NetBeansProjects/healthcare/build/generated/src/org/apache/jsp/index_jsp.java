package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Health Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\" action=\"Controller\"> \n");
      out.write("            <h1>Enter details</h1>\n");
      out.write("            \n");
      out.write("            PATIENT <br/><br/>\n");
      out.write("            Name: <input type=\"text\" name=\"name\" size=\"20\"/> <br/><br />\n");
      out.write("            Address: <input type=\"text\" name=\"address\" size=\"40\"/> <br/><br />\n");
      out.write("            Doctor Name: <input type=\"text\" name=\"PDocName\" size=\"20\"/> <br/><br />\n");
      out.write("            <br/><br />\n");
      out.write("            \n");
      out.write("            DOCTOR <br/><br />\n");
      out.write("            Doctor Name: <input type=\"text\" name=\"DDocname\" size=\"20\"/> <br/><br />\n");
      out.write("            Room Number: <input type=\"text\" name=\"room\" size=\"2\"/> <br/><br />\n");
      out.write("            <br/><br />\n");
      out.write("            \n");
      out.write("            TEST <br/><br />\n");
      out.write("            Patient Name: <input type=\"text\" name=\"TDocname\" size=\"20\"/> <br/><br />\n");
      out.write("            Test: <input type=\"text\" name=\"test\" size=\"20\"/> <br/><br />\n");
      out.write("            Outcome: <input type=\"text\" name=\"outcome\" size=\"20\"/> <br/><br />\n");
      out.write("            Date: <input type=\"text\" name=\"date\" size=\"20\"/> <br/><br />\n");
      out.write("            <br/><br />\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Submit\">\n");
      out.write("            <input type=\"reset\" value=\"Reset\">\n");
      out.write("            \n");
      out.write("        </form>       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
