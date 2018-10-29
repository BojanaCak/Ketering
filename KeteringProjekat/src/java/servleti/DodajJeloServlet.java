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
public class DodajJeloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession sesija=request.getSession();
        String imeProizvoda=(String)request.getParameter("imeProizvoda");
        String cena=(String)request.getParameter("cena");
        String zalihe=(String)request.getParameter("zalihe");
        String kategorija=(String)request.getParameter("kategorija");        
                 
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement st=con.createStatement();
          ResultSet rs;
          String upit="Select imeProizvoda from proizvodi";
          
          rs= st.executeQuery(upit);
          
        while(rs.next()){
            if(imeProizvoda.equals(rs.getString("imeProizvoda"))){
                request.setAttribute("msg","Jelo već postoji");
                request.getRequestDispatcher("JelaListaServlet").forward(request, response);
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
        if(imeProizvoda!=null && imeProizvoda.length()>0 && cena!=null && cena.length()>0 && zalihe!=null && 
                zalihe.length()>0 && kategorija!=null && kategorija.length()>0 ){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
                    Statement st=con.createStatement();
                    
                    st.executeUpdate("insert into proizvodi(imeProizvoda,cena,zalihe,kategorija)"
                            + " VALUES('"+imeProizvoda+"','"+cena+"','"+zalihe+"','"+kategorija+"')");
                    
                                                           
                    st.close();
                    con.close();
                    
                    request.setAttribute("msg","Uspešno dodato jelo!");
                    request.getRequestDispatcher("JelaListaServlet").forward(request, response);                   
                    
                }catch(ClassNotFoundException ex){}
                 catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("msg",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);                 
                 }            
        }else{
                    request.setAttribute("msg","Morate popuniti sva polja!");
                    request.getRequestDispatcher("JelaListaServlet").forward(request, response);
            }
        
    }


}
