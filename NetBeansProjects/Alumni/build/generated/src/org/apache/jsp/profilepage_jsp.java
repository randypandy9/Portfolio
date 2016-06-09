package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AlumniPackage.School;
import AlumniPackage.Attendance;
import AlumniPackage.Student;
import java.util.Iterator;
import java.util.List;
import AlumniPackage.Account;

public final class profilepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Profile Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css\" type=\"text/css\" media=\"all\" /> \n");
      out.write("        <script src=\"http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <link rel = \"stylesheet\" type = \"text/css\" href = \"alumnicss.css\" />\n");
      out.write("        <script src=\"jquery.validate.js\" type=\"text/javascript\"> </script>\n");
      out.write("        <script src=\"profilePageJS.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <img src=\"Banner.jpg\" class=\"image\"/>\n");
      out.write("            <div class=\"gap\">\n");
      out.write("                ");

                    Student student = (Student) session.getAttribute("Studentdetails");                  
                
      out.write(" \n");
      out.write("                <br /><hr>\n");
      out.write("                <form id=\"updateprofile\" method=\"POST\" action=\"profileController\">\n");
      out.write("                <h1>Welcome!</h1>                \n");
      out.write("                <hr><div class=\"rightside\">\n");
      out.write("                    <div id=\"menu\">\n");
      out.write("                        <ul>\n");
      out.write("                            \n");
      out.write("                            <li><a href=\"newmsg.jsp\"> Compose New Message </a></li>\n");
      out.write("                            <li><a href=\"InboxController\"> Inbox </a></li> \n");
      out.write("                            <li><a href=\"LogOut\"> Logout </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>                 \n");
      out.write("                </div> \n");
      out.write("                <br />\n");
      out.write("                Welcome to your profile page,              \n");
      out.write("                <h4>");
      out.print( student.getName() );
      out.write("</h4>\n");
      out.write("               \n");
      out.write("                <br />\n");
      out.write("                Your email address:<br/>\n");
      out.write("                <h4>");
      out.print( student.getEmail() );
      out.write("</h4>\n");
      out.write("                \n");
      out.write("                <br />\n");
      out.write("                About you:<br/>\n");
      out.write("                <h4>");
      out.print( student.getInfo() );
      out.write("</h4>\n");
      out.write("                \n");
      out.write("                <br />\n");
      out.write("                Your School:<br/>\n");
      out.write("                <h4>");
      out.print( student.getSchool() );
      out.write("</h4>\n");
      out.write("                \n");
      out.write("                <br /><hr>\n");
      out.write("                <h3>\n");
      out.write("                    Edit\n");
      out.write("                </h3>\n");
      out.write("                <p>\n");
      out.write("                <form id=\"newdetails\" method=\"POST\" action=\"profileController\">\n");
      out.write("                New details form<br/>\n");
      out.write("                New name:<input type=\"text\" id=\"newname\" name=\"newname\" size=\"20\"/><br />\n");
      out.write("                New email:<input type=\"text\" id=\"newemail\" name=\"newemail\" size=\"20\"/><br />\n");
      out.write("                New info:<input type=\"text\" id=\"newinfo\" name=\"newinfo\" size=\"20\"/><br />\n");
      out.write("                New School:<select name=\"newschool\" id=\"newschool\">\n");
      out.write("                ");

                List schoolList = (List) session.getAttribute("bschoolList");
                Iterator it = schoolList.iterator();
                while(it.hasNext()){

                    School school = (School) it.next();
                 
      out.write("\n");
      out.write("\n");
      out.write("                 <option value=\"");
      out.print(school.getSchoolName());
      out.write('"');
      out.write('>');
      out.print(school.getSchoolName());
      out.write("</option>\n");
      out.write("\n");
      out.write("\n");
      out.write("                 ");

                }
                
      out.write("    \n");
      out.write("            </select><br />\n");
      out.write("                <input id=\"update\" name=\"update\" value=\"Update\" type=\"submit\">\n");
      out.write("                </form>\n");
      out.write("                </p>\n");
      out.write("                <hr>\n");
      out.write("                <h3>\n");
      out.write("                    Request to Administrator\n");
      out.write("                </h3>             \n");
      out.write("                <p>\n");
      out.write("                <form id=\"profiletoadmin\" method=\"POST\" action=\"AdminRequests\">\n");
      out.write("                Name of School you would like to request:<br/><br/>\n");
      out.write("                <input type=\"text\" id=\"propSchool\" name=\"propSchool\" size=\"20\"/><br />\n");
      out.write("                <input id=\"SendtoAdmin\" name=\"SendtoAdmin\" value=\"Submit\" type=\"submit\">\n");
      out.write("                </form>\n");
      out.write("                </p>\n");
      out.write("                <hr><br />\n");
      out.write("                Alumni's that were in your school at the same time you were: <br/><br/>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>School</th>\n");
      out.write("                        <th>Course Start</th>\n");
      out.write("                        <th>Course End</th>\n");
      out.write("                    </tr>\n");
      out.write("                ");

                    List friends = (List) session.getAttribute("friends");
                    Iterator friendit = friends.iterator();
                    while (friendit.hasNext())
                    {
                        Attendance afriend = (Attendance) friendit.next();
                    
                
      out.write(" \n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( afriend.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( afriend.getSchoolName() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( afriend.getDateStart() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( afriend.getDateEnd() );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <br /><hr><br/>\n");
      out.write("                <form action=\"SchoolController\" method =\"get\">\n");
      out.write("                <input type=\"submit\" value=\"List schools\"/> \n");
      out.write("                </form> \n");
      out.write("                 <br /><hr><br/>\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("                \n");
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
