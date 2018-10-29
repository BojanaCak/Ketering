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
import beans.*;
import java.util.ArrayList;
/**
 *
 * @author korisnik
 */
public class NarudzbenicaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesija=request.getSession();
        String imeProizvoda=(String)request.getParameter("imeProizvoda");
        int cena=Integer.parseInt(request.getParameter("ukupnaCena"));
        String zalihe=(String)request.getParameter("zalihe");
        String kategorija=(String)request.getParameter("kategorija"); 
        String adresa=(String)request.getParameter("adresa"); 
        String date=(String)request.getParameter("date"); 
        String kolicina=(String)request.getParameter("kolicina");
        String telefon=(String)request.getParameter("telefon");
        String username=(String)sesija.getAttribute("poruka");
        
           ArrayList<Proizvod> korpa = (ArrayList<Proizvod>) sesija.getAttribute("korpa");
           
    if(date!=null && date.length()>0 && username!=null && username.length()>0 && telefon!=null && 
                telefon.length()>0 && adresa!=null && adresa.length()>0 ){
        if(!(korpa==null)){ 
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
                    Statement st=con.createStatement();
                    
                    st.executeUpdate("insert into narudzbenica(datumDostave,adresaDostave,telefon,UkupnaCena,username)"
                            + " VALUES('"+date+"','"+adresa+"','"+telefon+"','"+cena+"','"+username+"')");               
                          
                    st.close();
                    con.close();
                    
                    request.setAttribute("msg","Uspešno naruceno!");
                    request.getRequestDispatcher("narudzbenica.jsp").forward(request, response);                   
                    
                }catch(ClassNotFoundException ex){}
                 catch(SQLException sqe){
                    String poruka=sqe.getMessage();
                    request.setAttribute("msg",poruka);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                 
                 }            
        }else{
                    request.setAttribute("msg","Korpa je prazna!");
                    request.getRequestDispatcher("narudzbenica.jsp").forward(request, response);
            }
        }else{
                    request.setAttribute("msg","Morate popuniti sva polja!");
                    request.getRequestDispatcher("narudzbenica.jsp").forward(request, response);
    }

    
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
