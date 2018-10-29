package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class brisanje_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 HttpSession sesija= request.getSession();
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("        <style>\n");
      out.write("     body{\n");
      out.write("            background-image: url(\"slike/image85376.jpg\");\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-attachment: fixed;\n");
      out.write("            background-size: 100% 100%;\n");
      out.write("                        \n");
      out.write("        }\n");
      out.write("       .log {\n");
      out.write("            position: absolute;\n");
      out.write("            border:2px solid white;\n");
      out.write("            background-color:  hsla(600, 33%, 65%, 0.4);\n");
      out.write("            width:300px ;\n");
      out.write("            height:300px;\n");
      out.write("            margin: auto;\n");
      out.write("            top: 30%;\n");
      out.write("            left: 30%;\n");
      out.write("            padding: 15px;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        .user{\n");
      out.write("             background-color:hsla(600, 33%, 65%, 0.9);\n");
      out.write("             width:200px ;\n");
      out.write("             float:right;\n");
      out.write("             text-align:center;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("            <div class=\"user\" > ");
 String poruka= (String) sesija.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
                   
      out.write("\n");
      out.write("               <p>");
      out.print( poruka);
      out.write("</p>\n");
      out.write("               ");
} 
      out.write("\n");
      out.write("               <a href=\"logout\">Odjavi se</a>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"log\">\n");
      out.write("            \n");
      out.write("        ");
 String msg= (String) request.getAttribute("msg");
                        if(msg != null && msg.length()>0){
                   
      out.write("\n");
      out.write("                        <h2>");
      out.print( msg);
      out.write("</h2>\n");
      out.write("                        ");
} 
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <form action=\"KorisiciListaServlet\" method=\"post\">\n");
      out.write("                        <button >Vrati se na listu korisnika</button>                   \n");
      out.write("                        </form>\n");
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
