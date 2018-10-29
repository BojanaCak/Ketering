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

/**
 *
 * @author korisnik
 */
public class registracija extends HttpServlet {

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
        String idKorisnika=(String)request.getParameter("id");
        String imePrezime=(String)request.getParameter("imePrezime");
        String email=(String)request.getParameter("email");
        String telefon=(String)request.getParameter("telefon");
        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");
        String potvrda=(String)request.getParameter("potvrda");       
                 
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con;
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement st=con.createStatement();
          ResultSet rs;
          String upit="Select username from korisnik";
          
          rs= st.executeQuery(upit);
          
        while(rs.next()){
            if(username.equals(rs.getString("username"))){
                request.setAttribute("poruka","Username već postoji");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
        
        st.close();
        con.close();
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
            String poruka=sqe.getMessage();
            request.setAttribute("poruka",poruka);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if(idKorisnika!=null && idKorisnika.length()>0 && imePrezime!=null && imePrezime.length()>0 && email!=null && 
                email.length()>0 && telefon!=null && telefon.length()>0 && username!=null && 
                username.length()>0 && password!=null && password.length()>0 && 
                potvrda!=null && potvrda.length()>0 ){
            if(password.equals(potvrda)){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
                    Statement st=con.createStatement();
                    
                    st.executeUpdate("insert into korisnik(idKorisnika,imePrezime, email, telefon, username, password)"
                            + " VALUES('"+idKorisnika+"','"+imePrezime+"','"+email+"','"+telefon+"','"+username+"','"+password+"');");
                   
                    st.close();
                    con.close();
                    
                    request.setAttribute("poruka","Registrovanje uspesno!Ulogujte se!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    
                    
                }catch(ClassNotFoundException ex){}
                 catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("poruka",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
                 }
            }else{
                    request.setAttribute("poruka","Lozinke se ne podudaraju!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }else{
                    request.setAttribute("poruka","Morate popuniti sva polja!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
    }

    

}
