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
public class ObrisiPorudzbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idNarudzbenice=(String)request.getParameter("idNarudzbenice");     
                 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
            Statement st=con.createStatement();
                    
            st.executeUpdate("DELETE FROM `narudzbenica` WHERE `narudzbenica`.`idNarudzbenice` = '"+idNarudzbenice+"';");
                   
                    st.close();
                    con.close();
                    
                    request.setAttribute("msg","Uspešno izbrisana porudzbina!");
                    request.getRequestDispatcher("brisanjep.jsp").forward(request, response);                   
                    
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("msg",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
        } 
    }

 

}
