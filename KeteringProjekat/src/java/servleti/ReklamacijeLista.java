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
import beans.Reklamacija;
import java.util.ArrayList;

/**
 *
 * @author korisnik
 */
public class ReklamacijeLista extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesija=request.getSession();
        ArrayList<Reklamacija> reklamacije= new ArrayList<>();
        
        Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement stmt=con.createStatement();
          String upit="select reklamacije.idReklamacije,reklamacije.opis,reklamacije.telefon,reklamacije.idNarudzbenice,reklamacije.username from reklamacije";
          ResultSet rs=stmt.executeQuery(upit);
          while(rs.next()){
              Reklamacija reklamacija= new Reklamacija();
              int idReklamacije=rs.getInt("idReklamacije");
              String opis=rs.getString("opis");
              String telefon=rs.getString("telefon");
              int idNarudzbenice=rs.getInt("idNarudzbenice");
              String username=rs.getString("username");
              reklamacija.setIdReklamacije(idReklamacije);
              reklamacija.setOpis(opis);
              reklamacija.setTelefon(telefon);
              reklamacija.setIdNarudzbenice(idNarudzbenice);
              reklamacija.setUsername(username);
              reklamacije.add(reklamacija);              
              sesija.setAttribute("reklamacija",reklamacija);
          }
                
              sesija.setAttribute("reklamacije",reklamacije);
              request.getRequestDispatcher("listaReklamacija.jsp").forward(request, response);
              
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
