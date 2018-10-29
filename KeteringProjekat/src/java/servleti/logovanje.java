/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;
import java.sql.*;

/**
 *
 * @author korisnik
 */
public class logovanje extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
      
  HttpSession sesija=request.getSession();
        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");
        String admin="admin";
        String sefkuh="sefkuh";
        String sefposl="sefposl";
        String glmen="glmen";
        if(username.isEmpty() || password.isEmpty()){
            request.setAttribute("poruka","Morate popuniti sva polja!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
      Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement stmt=con.createStatement();
          String upit="select * from korisnik where username='"+username+"' and password='"+password+"';";
          ResultSet rs=stmt.executeQuery(upit);
          if(rs.next()){
              if(username.equals(admin)){
                  sesija.setAttribute("poruka",username);
                  request.getRequestDispatcher("KorisiciListaServlet").forward(request, response);                 
                  
              }else if(username.equals(sefkuh)){
                  sesija.setAttribute("poruka",username);
                  request.getRequestDispatcher("JelaListaServlet").forward(request, response);
              }else if(username.equals(glmen)){
                  sesija.setAttribute("poruka",username);
                  request.getRequestDispatcher("ReklamacijeLista").forward(request, response);
              }else if(username.equals(sefposl)){
                  sesija.setAttribute("poruka",username);
                  request.getRequestDispatcher("PorudzbineListaServlet").forward(request, response);
              }else{
                  sesija.setAttribute("poruka",username);
                  request.getRequestDispatcher("pregledProizvoda").forward(request, response);
                
                  
              }
          }else{
                request.setAttribute("poruka","Nisu uneti tacni podaci!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
          
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

  

}
