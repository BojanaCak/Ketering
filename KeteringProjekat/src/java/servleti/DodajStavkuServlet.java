/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;
import java.util.ArrayList;

/**
 *
 * @author korisnik
 */
public class DodajStavkuServlet extends HttpServlet {

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
            
            HttpSession sesija = request.getSession();
             ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();
            String ime = request.getParameter("imeProizvoda");             
            int cena = Integer.parseInt(request.getParameter("cena"));
            String kategorija = request.getParameter("kategorija");            
            int idProizvoda = Integer.parseInt(request.getParameter("idProizvoda"));
            int zalihe = Integer.parseInt(request.getParameter("zalihe"));
            int kolicina= Integer.parseInt(request.getParameter("kolicina"));
            String username=(String)sesija.getAttribute("poruka");
            zalihe=zalihe-kolicina;                     
            try {
                ArrayList<Proizvod> korpa = (ArrayList<Proizvod>) sesija.getAttribute("korpa");
                    
                       
                    if(korpa==null)
                    {
                        Proizvod proizvodk=new Proizvod();
                        proizvodk.setIdProizvoda(idProizvoda);
                        proizvodk.setImeProizvoda(ime);
                        proizvodk.setZalihe(zalihe);
                        proizvodk.setCena(cena);
                        proizvodk.setKategorija(kategorija);
                        proizvodk.setKolicina(kolicina);
                        proizvodi.add(proizvodk);
                        sesija.setAttribute("proizvodk", proizvodk);
                    }else{                      
                        proizvodi=korpa;
                        Proizvod proizvodk=new Proizvod();
                        proizvodk.setIdProizvoda(idProizvoda);
                        proizvodk.setImeProizvoda(ime);
                        proizvodk.setZalihe(zalihe);
                        proizvodk.setCena(cena);
                        proizvodk.setKategorija(kategorija);
                        proizvodk.setKolicina(kolicina);
                        proizvodi.add(proizvodk);
                        sesija.setAttribute("proizvodk", proizvodk);
                    }
                   
                    sesija.setAttribute("korpa", proizvodi); 
                   

            } catch (Exception e) 
            {
                sesija.setAttribute("greska", e.getMessage());
                request.getRequestDispatcher("pregledMenija.jsp").forward(request, response);
            }
         try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keteringdb", "root", "");
          Statement st=con.createStatement();
          String upit="update proizvodi set zalihe='"+zalihe+"' where idProizvoda= '"+idProizvoda+"'";
          
          st.executeUpdate(upit);
                  
        st.close();
        con.close();
        }catch(ClassNotFoundException ex){}
        catch(SQLException sqe){
            String poruka=sqe.getMessage();
            request.setAttribute("msg",poruka);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
         request.setAttribute("msg", "Uspesno dodato u korpu!");
         request.getRequestDispatcher("pregledMenija.jsp").forward(request, response);



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

}
}
