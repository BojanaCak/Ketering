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
public class ObrisiReklServlet extends HttpServlet {

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
               String idReklamacije=(String)request.getParameter("idReklamacije");     
                 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
            Statement st=con.createStatement();
                    
            st.executeUpdate("DELETE FROM `reklamacije` WHERE `reklamacije`.`idReklamacije` = '"+idReklamacije+"';");
                   
                    st.close();
                    con.close();
                    
                    request.setAttribute("msg","Uspešno izbrisana reklamacija!");
                    request.getRequestDispatcher("brisanjer.jsp").forward(request, response);                   
                    
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("msg",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
        } 

    }
    
}
