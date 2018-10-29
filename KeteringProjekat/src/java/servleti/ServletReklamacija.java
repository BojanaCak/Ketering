
package servleti;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Reklamacija;
import beans.Korisnik;
import beans.Narucivanje;

/**
 *
 * @author korisnik
 */
public class ServletReklamacija extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesija=request.getSession();
       
        Narucivanje narucivanje=new Narucivanje();        
        int idNarudzbenice=narucivanje.getIdNarudzbenice();
        String telefon=(String)request.getParameter("brtelefona");
        String opis=(String)request.getParameter("opis");
        String username= (String)sesija.getAttribute("poruka");
        int i= 1;
         
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
                    Statement st=con.createStatement();
                    
                    st.executeUpdate("insert into reklamacije(username, idNarudzbenice, telefon, opis)"
                            + " VALUES('"+username+"','"+i+"','"+telefon+"','"+opis+"');");
                   
                    st.close();
                    con.close();
                    
                    sesija.setAttribute("mess","Reklamacija poslata.");
                    request.getRequestDispatcher("reklamacija.jsp").forward(request, response);
                    
                    
                }catch(ClassNotFoundException ex){}
                 catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("poruka",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
                 }
    }


}
