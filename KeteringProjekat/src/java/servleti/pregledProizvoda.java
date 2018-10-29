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
import beans.Proizvod;
import java.util.ArrayList;

/**
 *
 * @author korisnik
 */
public class pregledProizvoda extends HttpServlet {
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
        ArrayList<Proizvod> proizvodi;
        proizvodi = new ArrayList<>();              
        Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement stmt=con.createStatement();
          String upit;
          upit = "SELECT idProizvoda,imeProizvoda,cena,zalihe,kategorija from proizvodi";          
          ResultSet rs=stmt.executeQuery(upit);          
          while(rs.next()){
              Proizvod proizvod= new Proizvod();
              String imeProizvoda=rs.getString("imeProizvoda");
              int idProizvoda=rs.getInt("idProizvoda");
              int zalihe=rs.getInt("zalihe");
              int cena=rs.getInt("cena");
              String kategorija=rs.getString("kategorija");
              proizvod.setIdProizvoda(idProizvoda);
              proizvod.setImeProizvoda(imeProizvoda);
              proizvod.setZalihe(zalihe);
              proizvod.setCena(cena);
              proizvod.setKategorija(kategorija);
              proizvodi.add(proizvod);              
              sesija.setAttribute("proizvod",proizvod);
          }
              sesija.setAttribute("proizvodi",proizvodi);
              request.getRequestDispatcher("pregledMenija.jsp").forward(request, response);
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




