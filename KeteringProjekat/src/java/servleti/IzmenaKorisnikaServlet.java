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

/**
 *
 * @author korisnik
 */
public class IzmenaKorisnikaServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesija=request.getSession();
        Korisnik klijent =(Korisnik)sesija.getAttribute("klijent");
        String imePrezime=(String)request.getParameter("imePrezime");
        String email=(String)request.getParameter("email");
        String telefon=(String)request.getParameter("telefon");
        String password=(String)request.getParameter("password"); 

        klijent.setImePrezime(imePrezime);
        klijent.setEmail(email);
        klijent.setTelefon(telefon);
        klijent.setPassword(password);     
              
        
         try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement st=con.createStatement();
          String upit="update korisnik set imePrezime='"+imePrezime+"',email='"+email+"',telefon='"+telefon+"'"
                  + ", password='"+password+"'"
                  + "where username= '"+klijent.getUsername()+"'";
          
          st.executeUpdate(upit);
                  
        st.close();
        con.close();
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
            String poruka=sqe.getMessage();
            request.setAttribute("msg",poruka);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
         request.setAttribute("msg","Podaci su uspesno izmenjeni");
            request.getRequestDispatcher("brisanje.jsp").forward(request, response);
    }
    }

//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

//}
