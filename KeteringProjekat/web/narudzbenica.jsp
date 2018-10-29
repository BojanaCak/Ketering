<%-- 
    Document   : narudzbenica
    Created on : Feb 28, 2018, 11:01:08 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.*;"%>
<% HttpSession sesija= request.getSession();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
     body{
            background-image: url("slike/image85376.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
                        
        }
       .log {
            position: absolute;
            border:2px solid white;
            background-color:  hsla(600, 33%, 65%, 0.7);
            width:760px ;
            height:430px;
            margin: auto;
            top: 10%;
            left: 25%;
            padding: 15px;
        }
        .user{
             background-color:hsla(600, 33%, 65%, 0.9);
             width:200px ;
             float:right;
             text-align:center;
        }
    </style>
    <body>
        <div class="user" > <% String poruka= (String) sesija.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
                   %>
               <p>Dobro dosli,<%= poruka%></p>             
               
               <%}else{ 
                    request.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%>
               
               <a href="logout">Odjavi se</a><br>
        </div>
        <div class="log">
            
                <h2>Korpa</h2>
            <table>
                <tr><th>Id</th>
                        <th>Ime</th>
                        <th>Cena</th>
                        <th>Kategorija</th>
                        <th>Zalihe</th>
                        <th>Količina</th>
                        <th>Ukupno</th>
                        <th>Izbaci</th>
                </tr>
                <c:set var="ukupnaCena" value="${0}" />
              <c:forEach items="${korpa}" var="proizvodk">
                  <form action="ObrisiStavkuServlet" method="get">
                <tr>
                    <td><input type="text" size="3" name="idProizvoda" readonly value="${proizvodk.idProizvoda}"></td>
                        <td><input type="text" name="imeProizvoda" readonly value="${proizvodk.imeProizvoda}"></td>
                        <td><input size="4" type="text" name="cena" readonly value="${proizvodk.cena}"></td>
                        <td><input size="7" type="text" name="kategorija" readonly value="${proizvodk.kategorija}"></td>
                        <td><input type="text" size="5" name="zalihe" readonly value="${proizvodk.zalihe}"></td>
                        <td><input size="4" type="number" name="kolicina" readonly value=${proizvodk.kolicina} ></td>
                        <c:set var="ukupno" value="${proizvodk.cena * proizvodk.kolicina}" />
                        <td><input type="text" size="5" name="ukupno" value=${ukupno} readonly="readonly"></td>
                        <td><input type="submit" value=&#10007></td>
                         <c:set var="ukupnaCena" value="${ukupnaCena + ukupno}" />
                </tr></form>
              </c:forEach>
            </table>
                <br><br><form action="NarudzbenicaServlet">
                  <table>
                       <tr>
                        <th>Datum dostave:</th>
                        <th>Adresa dostave:</th>
                        <th>Broj telefona:</th>
                        <th>Ukupna cena:</th>
                        <th>Završi sa porudzbinom</th>
                        </tr>
                        <tr> 
                            <td> <input type="date" name="date"></td>
                            <td> <textarea name="adresa" length="300" ></textarea> </td>
                            <td> <input type="text" name="telefon"></td>                           
                            <td> <input type="text" name="ukupnaCena" value="${ukupnaCena}"></td>
                            <td><input type="submit" value="Naruči"></td>
                        </tr>                   
                            
                <% String msg= (String) request.getAttribute("msg");
                   if(msg != null && msg.length()>0){
                   %>
                   <p><%= msg%></p>
                   <%} %>
                  </table>
            </form>
              <form action="pregledProizvoda" method="post">
                  <button>Vrati se na pregled menija</button>
              </form>
                            
        </div>
    </body>
</html>
