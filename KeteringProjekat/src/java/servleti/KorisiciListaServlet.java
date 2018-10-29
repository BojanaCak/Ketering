/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Korisnik;
import java.util.ArrayList;

/**
 *
 * @author korisnik
 */
public class KorisiciListaServlet extends HttpServlet {
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
        ArrayList<Korisnik> klijenti= new ArrayList<>();
        
        Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement stmt=con.createStatement();
          String upit="select idKorisnika,imePrezime,email,telefon,username,password from korisnik";
          ResultSet rs=stmt.executeQuery(upit);
          while(rs.next()){
              Korisnik klijent= new Korisnik();
              int idKorisnika=rs.getInt("idKorisnika");
              String imePrezime=rs.getString("imePrezime");
              String email=rs.getString("email");
              String telefon=rs.getString("telefon");
              String username=rs.getString("username");
              String password=rs.getString("password");
              klijent.setIdKorisnika(idKorisnika);
              klijent.setImePrezime(imePrezime);
              klijent.setEmail(email);
              klijent.setTelefon(telefon);
              klijent.setUsername(username);
              klijent.setPassword(password);
              klijenti.add(klijent);              
              sesija.setAttribute("klijent",klijent);
          }
                
              sesija.setAttribute("klijenti",klijenti);
              request.getRequestDispatcher("listaKorisnika.jsp").forward(request, response);
      }catch(SQLException e){
          sesija.invalidate();
          String errormsg=e.getMessage();
          if(con!=null)
              try{
                  con.close();
              }catch(SQLException ex){
                  errormsg=errormsg+ex.getMessage();
              }
          request.setAttribute("errormsg",errormsg);
          RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
          rd.forward(request,response);
      }catch(ClassNotFoundException cnf){}
        
    }

    

}
