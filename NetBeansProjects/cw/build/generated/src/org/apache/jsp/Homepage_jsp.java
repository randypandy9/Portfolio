package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!--\n");
      out.write("To change this template, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Norwich Bike Hire <!--title--> </title>\n");
      out.write("        <link rel = \"stylesheet\" type = \"text/css\" href = \"newcss.css\" /> \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <h1> \n");
      out.write("                    Norwich Bike Hire     \n");
      out.write("                    <!--title-->\n");
      out.write("                </h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navigation-container\">\n");
      out.write("            <div id=\"navigation\"><!-- NAvigation fo my website -->\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/Homepage.jsp\">Homepage</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/ServletBook\">Booking</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/contactus.html\">Contact Us</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/FAQ.html\">FAQ</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/bikegallery.jsp\">Bike Gallery</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/CycleRoutes.html\">Cycle Routes</a></li>\n");
      out.write("                    <!--navigation--> \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content-container\">\n");
      out.write("            <div id=\"content-container2\">\n");
      out.write("                <div id=\"content-container3\"><!-- content of my web page -->\n");
      out.write("                    <div id=\"content\">\n");
      out.write("                        <h2>Welcome to Norwich Bike Hire</h2>\n");
      out.write("                        <p>Norwich bike hire has a range of bikes that you can rent including mens, womens and childrens bikes all over norwich. Fill out our easy form online and get cycling striaght away!</p>\n");
      out.write("                        <p><img src=\"bikes.gif\" width=\"403\" height=\"232\"></p>\n");
      out.write("                        <p>Come find us, we are place all over Norwich allowing you to get the best possible experience.</p>\n");
      out.write("                        <p><iframe width=\"425\" height=\"350\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"https://maps.google.co.uk/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=norwich+cycle+hire&amp;aq=&amp;sll=52.630354,1.323166&amp;sspn=0.086582,0.218697&amp;ie=UTF8&amp;hq=cycle+hire&amp;hnear=Norwich,+Norfolk,+United+Kingdom&amp;t=m&amp;fll=52.634495,1.297073&amp;fspn=0.021644,0.054674&amp;st=114141868259560747061&amp;rq=1&amp;ev=p&amp;split=1&amp;z=11&amp;output=embed\"></iframe><br /><small><a href=\"https://maps.google.co.uk/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=norwich+cycle+hire&amp;aq=&amp;sll=52.630354,1.323166&amp;sspn=0.086582,0.218697&amp;ie=UTF8&amp;hq=cycle+hire&amp;hnear=Norwich,+Norfolk,+United+Kingdom&amp;t=m&amp;fll=52.634495,1.297073&amp;fspn=0.021644,0.054674&amp;st=114141868259560747061&amp;rq=1&amp;ev=p&amp;split=1&amp;z=11\" style=\"color:#0000FF;text-align:left\"></a></small>\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                            /***********************************************\n");
      out.write("     \n");
      out.write("                             * Animated Information Bar- by JavaScript Kit (www.javascriptkit.com)\n");
      out.write("     \n");
      out.write("     \n");
      out.write("                             ***********************************************/\n");
      out.write("\n");
      out.write("                            function informationbar() {\n");
      out.write("                                this.displayfreq = \"always\"\n");
      out.write("                                this.content = '<a href=\"javascript:informationbar.close()\"><img src=\"close.gif\" style=\"width: 14px; height: 14px; float: right; border: 0; margin-right: 5px\" /></a>'\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            informationbar.prototype.setContent = function(data) {\n");
      out.write("                                this.content = this.content + data\n");
      out.write("                                document.write('<div id=\"informationbar\" style=\"top: -500px\">' + this.content + '</div>')\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            informationbar.prototype.animatetoview = function() {\n");
      out.write("                                var barinstance = this\n");
      out.write("                                if (parseInt(this.barref.style.top) < 0) {\n");
      out.write("                                    this.barref.style.top = parseInt(this.barref.style.top) + 5 + \"px\"\n");
      out.write("                                    setTimeout(function() {\n");
      out.write("                                        barinstance.animatetoview()\n");
      out.write("                                    }, 50)\n");
      out.write("                                }\n");
      out.write("                                else {\n");
      out.write("                                    if (document.all && !window.XMLHttpRequest)\n");
      out.write("                                        this.barref.style.setExpression(\"top\", 'document.compatMode==\"CSS1Compat\"? document.documentElement.scrollTop+\"px\" : body.scrollTop+\"px\"');\n");
      out.write("                                    else\n");
      out.write("                                        this.barref.style.top = 0;\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            informationbar.close = function() {\n");
      out.write("                                document.getElementById(\"informationbar\").style.display = \"none\";\n");
      out.write("                                if (this.displayfreq == \"session\");\n");
      out.write("                                    document.cookie = \"infobarshown=1;path=/\";\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            informationbar.prototype.setfrequency = function(type) {\n");
      out.write("                                this.displayfreq = type;\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            informationbar.prototype.initialize = function() {\n");
      out.write("                                if ((this.displayfreq == \"session\" ) && (document.cookie.indexOf(\"infobarshown\") == -1) || (this.displayfreq == \"always\"))\n");
      out.write("                                {\n");
      out.write("                                    this.barref = document.getElementById(\"informationbar\");\n");
      out.write("                                    this.barheight = parseInt(this.barref.offsetHeight);\n");
      out.write("                                    this.barref.style.top = this.barheight * (-1) + \"px\";\n");
      out.write("                                    this.animatetoview();\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            window.onunload = function() {\n");
      out.write("                                this.barref = null;\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <script type=\"text/javascript\">\n");
      out.write("                        <!--Invocation code-->\n");
      out.write("\n");
      out.write("                            var infobar = new informationbar();\n");
      out.write("                            infobar.setContent('Welcome to Norwich Bike Hire, Looking to make a quick book? <a href=\"ServletBook\">Book Now</a>');\n");
      out.write("                            infobar.initialize();\n");
      out.write("\n");
      out.write("                        </script>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"right-side\">\n");
      out.write("                        <p><img src=\"logo2.png\" alt=\"some_text\" height=\"250\" width=\"250\">\t\t\t\t\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <SCRIPT LANGUAGE=\"JavaScript\">\n");
      out.write("                            \n");
      out.write("\n");
      out.write("                                var initialsubj = \"Hello, check out this awesome site \";\n");
      out.write("                                var initialmsg = \"Hi:\\n You may want to check out this site: \" + window.location;\n");
      out.write("                                var good;\n");
      out.write("                                function checkEmailAddress(field) { //check email validation\n");
      out.write("\n");
      out.write("                                    var goodEmail = field.value.match(/\\b(^(\\S+@).+((\\.com)|(\\.net)|(\\.edu)|(\\.mil)|(\\.gov)|(\\.org)|(\\.info)|(\\.sex)|(\\.biz)|(\\.aero)|(\\.coop)|(\\.museum)|(\\.name)|(\\.pro)|(\\..{2,2}))$)\\b/gi);\n");
      out.write("                                    if (goodEmail) {\n");
      out.write("                                        good = true;\n");
      out.write("                                    }\n");
      out.write("                                    else {\n");
      out.write("                                        alert('Please enter a valid address.');\n");
      out.write("                                        field.focus();\n");
      out.write("                                        field.select();\n");
      out.write("                                        good = false;\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                                u = window.location;\n");
      out.write("                                function mailThisUrl() {\n");
      out.write("                                    good = false;\n");
      out.write("                                    checkEmailAddress(document.eMailer.email);\n");
      out.write("                                    if (good) {\n");
      out.write("\n");
      out.write("                            //window.location = \"mailto:\"+document.eMailer.email.value+\"?subject=\"+initialsubj+\"&body=\"+document.title+\" \"+u;\n");
      out.write("                                        window.location = \"mailto:\" + document.eMailer.email.value + \"?subject=\" + initialsubj + \"&body=\" + initialmsg;\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("\n");
      out.write("                            </script>\n");
      out.write("                            <!-- Email Access from JavaSriptkit.com-----> \n");
      out.write("\n");
      out.write("                        <form name=\"eMailer\">\n");
      out.write("                            Tell a friend:\n");
      out.write("                            <input type=\"text\" name=\"email\" size=\"26\" value=\"     Enter Address Here\" onFocus=\"this.value = ''\" onMouseOver=\"window.status = 'Enter email address here and tell a friend about this site...';\n");
      out.write("        return true\" onMouseOut=\"window.status = '';\n");
      out.write("        return true\">\n");
      out.write("                            <br />\n");
      out.write("                            <input type=\"button\" value=\"Send this Email\" onMouseOver=\"window.status = 'Click to send an email (with this page address) to a friend! Enter email address above...';\n");
      out.write("        return true\" onMouseOut=\"window.status = '';\n");
      out.write("        return true\" onClick=\"mailThisUrl();\"> <!--weather check-->\n");
      out.write("                        </form></p>\n");
      out.write("                        <p><a href=\"http://www.accuweather.com/en/gb/norwich/nr1-1/weather-forecast/329791\" class=\"aw-widget-legal\">\n");
      out.write("\n");
      out.write("                            </a><div id=\"awcc1386348249638\" class=\"aw-widget-current\"  data-locationkey=\"329791\" data-unit=\"f\" data-language=\"en-us\" data-useip=\"false\" data-uid=\"awcc1386348249638\"></div><script type=\"text/javascript\" src=\"http://oap.accuweather.com/launch.js\"></script></p.\n");
      out.write("                        ><p><SCRIPT>\n");
      out.write("                            function passWord() { //password check\n");
      out.write("                                var testV = 1;\n");
      out.write("                                var pass1 = prompt('Please Enter Your Password', ' ');\n");
      out.write("                                while (testV < 3) {\n");
      out.write("                                    if (!pass1)\n");
      out.write("                                        history.go(-1);\n");
      out.write("                                    if (pass1.toLowerCase() == \"password\") \n");
      out.write("                                    {\n");
      out.write("                                        alert('Correct Password');\n");
      out.write("                                        window.open('http://localhost:8084/cw/ServletAdmin');\n");
      out.write("                                        break;\n");
      out.write("                                    }\n");
      out.write("                                    testV += 1;\n");
      out.write("                                    var pass1 =\n");
      out.write("                                            prompt('Access Denied - Password Incorrect, Please Try Again.', 'Password');\n");
      out.write("                                }\n");
      out.write("                                if (pass1.toLowerCase() != \"password\" & testV == 3)\n");
      out.write("                                    history.go(-1);\n");
      out.write("                                return \" \";\n");
      out.write("                            }\n");
      out.write("                            </SCRIPT>\n");
      out.write("                        <FORM>\n");
      out.write("                            <p>Admin Access:   </p>\n");
      out.write("                            <p>\n");
      out.write("                                <input name=\"Button\" type=\"button\" onClick=\"passWord()\" value=\"Enter Admin Area\">\n");
      out.write("                            </p>\n");
      out.write("                        </FORM>\n");
      out.write("\n");
      out.write("                        <!-- right section of the web page with a hover image as the logo --></div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer-container\">\n");
      out.write("            <div id=\"footer\"><!-- footer which appears at the bottom of the web page -->\n");
      out.write("                <p> Copyright 2013 Norwich Bike Hire</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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