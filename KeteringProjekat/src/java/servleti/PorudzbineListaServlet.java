/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Narucivanje;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author korisnik
 */
public class PorudzbineListaServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               HttpSession sesija=request.getSession();
        ArrayList<Narucivanje> narudzbenice= new ArrayList<>();
                
        Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement stmt=con.createStatement();
          String upit="select username,datumDostave,ukupnaCena,idNarudzbenice,adresaDostave,telefon from narudzbenica";
          ResultSet rs=stmt.executeQuery(upit);
          while(rs.next()){
              Narucivanje narudzbenica= new Narucivanje();
              String adresaDostave=rs.getString("adresaDostave");
              Date datum=rs.getDate("datumDostave");
              int ukupnaCena=rs.getInt("ukupnaCena");
              String username=rs.getString("username");
              String telefon=rs.getString("telefon");
              int idNarudzbenice=rs.getInt("idNarudzbenice");
              narudzbenica.setDatum(datum);
              narudzbenica.setAdresaDostave(adresaDostave);
              narudzbenica.setUkupnaCena(ukupnaCena);
              narudzbenica.setUsername(username);
              narudzbenica.setTelefon(telefon);
              narudzbenica.setIdNarudzbenice(idNarudzbenice);
              narudzbenice.add(narudzbenica);              
              sesija.setAttribute("narudzbenica",narudzbenica);
          }
                
              sesija.setAttribute("narudzbenice",narudzbenice);
              request.getRequestDispatcher("listaPorudzbina.jsp").forward(request, response);
              sesija.getAttribute("username");
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
