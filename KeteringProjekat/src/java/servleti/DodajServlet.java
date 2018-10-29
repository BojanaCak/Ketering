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
public class DodajServlet extends HttpServlet {
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
        String idKorisnika=(String)request.getParameter("idKorisnika");
        String imePrezime=(String)request.getParameter("imePrezime");
        String email=(String)request.getParameter("email");
        String telefon=(String)request.getParameter("telefon");
        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");        
                 
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement st=con.createStatement();
          ResultSet rs;
          String upit="Select username from korisnik";
          
          rs= st.executeQuery(upit);
          
        while(rs.next()){
            if(username.equals(rs.getString("username"))){
                request.setAttribute("msg","Username već postoji");
                request.getRequestDispatcher("KorisiciListaServlet").forward(request, response);
            }
        }
        
        st.close();
        con.close();
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
            String poruka=sqe.getMessage();
            request.setAttribute("msg",poruka);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if(imePrezime!=null && imePrezime.length()>0 && email!=null && 
                email.length()>0 && telefon!=null && telefon.length()>0 && username!=null && 
                username.length()>0 && password!=null && password.length()>0 ){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
                    Statement st=con.createStatement();
                    
                    st.executeUpdate("insert into korisnik(idKorisnika,imePrezime, email, telefon, username, password)"
                            + " VALUES('"+idKorisnika+"','"+imePrezime+"','"+email+"','"+telefon+"','"+username+"','"+password+"');");
                   
                    st.close();
                    con.close();
                    
                    request.setAttribute("msg","Uspešno dodat korisnik!");
                    request.getRequestDispatcher("KorisiciListaServlet").forward(request, response);
                    sesija.getAttribute("username");
                    
                }catch(ClassNotFoundException ex){}
                 catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("msg",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
                 }            
        }else{
                    request.setAttribute("msg","Morate popuniti sva polja!");
                    request.getRequestDispatcher("KorisiciListaServlet").forward(request, response);
            }
    }

}
