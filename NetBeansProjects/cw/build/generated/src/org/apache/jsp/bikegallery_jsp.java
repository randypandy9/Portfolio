package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bikegallery_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(' ');
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Norwich Bike Hire</title>\n");
      out.write("        <link rel = \"stylesheet\" type = \"text/css\" href = \"newcss.css\" /> \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <h1> \n");
      out.write("                    Norwich Bike Hire     \n");
      out.write("\n");
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
      out.write("                    <li><a href=\"http://localhost:8084/cw/bikegallery.html\">Bike Gallery</a></li>\n");
      out.write("                    <li><a href=\"http://localhost:8084/cw/CycleRoutes.html\">Cycle Routes</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content-container\">\n");
      out.write("            <div id=\"content-container2\">\n");
      out.write("                <div id=\"content-container3\"><!-- content of my webpage -->\n");
      out.write("                    <div id=\"content\">\n");
      out.write("                        <h2>Bike Gallery</h2>\n");
      out.write("                        <p>We have number of different bikes that are avialable to rent that are suitable for the whole family.</p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3>Childs Mountain Bike</h3>\n");
      out.write("                        <p><img src=\"bike_images/childs_mtb.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" >\t</p>\n");
      out.write("                        <p>This bike is an XC inspired bike designed to be fun, safe and reliable.</p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3>Mens Hybrid </h3>\n");
      out.write("                        <p><img src=\"bike_images/mens_hybrid.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" ></p>\n");
      out.write("                        <p>Our hybrid bikes are equipped with mudguards and a luggage rack suitable for panniers. If your route is mainly on country roads or good quality paths, this is a much faster, more efficient ride than our mountain bikes. </p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3>Mens Mountain Bike</h3>\n");
      out.write("                        <p><img src=\"bike_images/mens_mtb.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" ></p>\n");
      out.write("                        <p>Named for a God that personifies the vast freedom of the ocean, this is a solid bike with features designed to take a bite out of the trail.</p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3>Tandem</h3>\n");
      out.write("                        <p><img src=\"bike_images/tandem.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" ></p>\n");
      out.write("                        <p>Our touring Tandems will ensure you have a safe and comfortable trip and leave you hungry for your next tandem touring adventure. All tandems are fitted with a rear rack to give you the option of carrying luggage as well as mudguards to help keep you dry.</p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3> Womens Hybrid</h3>\n");
      out.write("                        <p><img src=\"bike_images/womens_hybrid.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" ></p>\n");
      out.write("                        <p> The Ridgeback Velocity 2010 Womens Hybrid Bike comes complete with a 6061 Double butted Aluminium frame, cro moly Forks and shimano gearing. The Lithium One Womens hybrid is a fast and capable 700c flatbar bike with a nice upright riding position and built-in comfort thanks to the skinny tapered steel fork and Kenda Kwest 38c tyres. A more compact frame geometry with low slung top tube combined with shorter crank arm length, stem, narrower handlebars and female specific saddle makes the Lithium One Womens as comfortable for female riders as possible. A 6sp 14-34T freewheel combined with 28-38-48T Suntour chainset make for a great urban gear range. Perfect for city commuting duties or weekend jaunts along the canal towpath. Ergonomic bar-ends add comfort and power on ascents and offer an additional hand position.</p>\n");
      out.write("                        <hr>\n");
      out.write("                        <h3>Womens Mountain Bike</h3>\n");
      out.write("                        <p><img src=\"bike_images/womens_mtb.jpg\" alt=\"some_text\" width=\"357\" height=\"208\" ></p>\n");
      out.write("                        <p>Our womens mountain bikes feature female-specific geometry to ensure new-to-the-sport female cyclists enter the world of the forest and trail with confidence and comfort.</p>\n");
      out.write("                        <hr>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"right-side\">\n");
      out.write("                        <p><img src=\"logo2.png\" alt=\"some_text\" height=\"250\" width=\"250\">\t\t\t\t          \n");
      out.write("                            <!-- right section of the webpage with a hover image as the logo --></div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer-container\">\n");
      out.write("            <div id=\"footer\"><!-- footer which appears at the bottom of the webpage -->\n");
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
