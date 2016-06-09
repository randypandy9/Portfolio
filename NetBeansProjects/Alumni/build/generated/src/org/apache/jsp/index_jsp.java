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
      out.write("        <title>Alumni Home Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css\" type=\"text/css\" media=\"all\" /> \n");
      out.write("        <script src=\"http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js\" type=\"text/javascript\"></script>      \n");
      out.write("        <link rel = \"stylesheet\" type = \"text/css\" href = \"alumnicss.css\" /> \n");
      out.write("        <script src=\"jquery.validate.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"myJS.js\" type=\"text/javascript\"></script>      \n");
      out.write("    </head>\n");
      out.write("    <body>    \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <img src=\"Banner.jpg\" class=\"image\"/>\n");
      out.write("            <div class=\"gap\">\n");
      out.write("            <br /><hr>\n");
      out.write("            <div class=\"rightside\">\n");
      out.write("            <input name=\"Button\" type=\"button\" onClick=\"password();\" value=\"Enter Admin Area\">         \n");
      out.write("            <script>\n");
      out.write("                                function password() { //password check\n");
      out.write("                                    var testV = 1;\n");
      out.write("                                    var pass1 = prompt('Please Enter Your Password','');\n");
      out.write("                                    while (testV < 3) {\n");
      out.write("                                        if (!pass1)\n");
      out.write("                                            history.go(-1);\n");
      out.write("                                        if (pass1.toLowerCase() === \"password\")\n");
      out.write("                                        {\n");
      out.write("                                            alert('Correct Password');\n");
      out.write("                                            window.open('http://localhost:8084/Alumni/RequestController');\n");
      out.write("                                            break;\n");
      out.write("                                        }\n");
      out.write("                                        testV += 1;\n");
      out.write("                                        var pass1 =\n");
      out.write("                                                prompt('Access Denied - Incorrect Password, Please Try Again.', 'Password');\n");
      out.write("                                    }\n");
      out.write("                                    if (pass1.toLowerCase() !== \"password\" & testV === 3)\n");
      out.write("                                        history.go(-1);\n");
      out.write("                                    return \" \";\n");
      out.write("                                }\n");
      out.write("            </script>\n");
      out.write("            </div>         \n");
      out.write("            <h1>Alumni Home Page</h1>           \n");
      out.write("            <hr>\n");
      out.write("            <div class=\"login\">\n");
      out.write("            <h2>\n");
      out.write("                Log In!\n");
      out.write("            </h2>\n");
      out.write("            <p>          \n");
      out.write("            <form id=\"login\" method=\"POST\" action=\"Controller\">       \n");
      out.write("            Username: <input type=\"text\" id=\"loginusername\" name=\"loginusername\" size=\"20\"/><br /><br />\n");
      out.write("            Password: <input type=\"password\" id=\"loginpassword\"name=\"loginpassword\" size=\"20\"/><br /><br /> \n");
      out.write("            <input id=\"logIn\" name=\"logIn\" value=\"Log In\" type=\"submit\">\n");
      out.write("            </form>\n");
      out.write("            </p>\n");
      out.write("            </div>\n");
      out.write("            <hr>           \n");
      out.write("            <h2>\n");
      out.write("                Sign Up!\n");
      out.write("            </h2>\n");
      out.write("            <p>          \n");
      out.write("            <form id=\"signup\" onsubmit=\"return checkEmail(this);\" method=\"POST\" action=\"Controller\" >\n");
      out.write("            Full Name: <input type=\"text\" id=\"signfullname\" name=\"signfullname\" size=\"20\"/><br /><br />\n");
      out.write("            Email: <input name=\"signemail\" id=\"signemail\" type=\"email\" size=\"20\" class=\"required email\"/><br /><br />\n");
      out.write("            Re-enter Email: <input name=\"signemailconfirm\" id=\"signemailconfirm\" type=\"email\" size=\"20\" class=\"required email\"/><br /><br />\n");
      out.write("            <script>\n");
      out.write("                function checkEmail(signup)\n");
      out.write("                {\n");
      out.write("                    if(signup.signemail.value !== signup.signemailconfirm.value)\n");
      out.write("                    {\n");
      out.write("                        alert('Email Addresses do not match');\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                    {\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            Username: <input type=\"text\" id=\"signusername\" name=\"signusername\" size=\"20\"/><br /><br />\n");
      out.write("            Password: <input type=\"password\" id=\"signpassword\" name=\"signpassword\" size=\"20\"/><br /><br />\n");
      out.write("            <br/>\n");
      out.write("            <input name=\"CreateAccount\" id=\"CreateAccount\" value=\"Create Account\" type=\"submit\"> \n");
      out.write("            <input value=\"Reset\" id=\"reset\" type=\"reset\">    \n");
      out.write("            <script>\n");
      out.write("                $(\"#signup\").validate();\n");
      out.write("            </script>\n");
      out.write("            </form>\n");
      out.write("            </p>\n");
      out.write("            <hr>\n");
      out.write("            <br />           \n");
      out.write("            <br />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
