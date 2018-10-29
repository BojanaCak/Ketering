<%-- 
    Document   : pregledMenija
    Created on : Feb 27, 2018, 10:35:43 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList"%>
<%@page import="beans.Korisnik" %>
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
            width:700px ;
            height:430px;
            margin: auto;
            top: 10%;
            left: 30%;
            padding: 15px;
        }
        .user{
             background-color:hsla(600, 33%, 65%, 0.9);
             width:200px ;
             float:right;
             text-align:center;
        }
        .rn{
           background-color:hsla(600, 33%, 65%, 0.6);
             width:200px ;
             float:left;
             text-align:center; 
        }
    </style>
    <body>
            <div class="user" > <% String poruka= (String) sesija.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
                   %>
               <p>Dobro dosli, <%= poruka%></p>
               
               <%}else{ 
                    sesija.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%>
               
               <a href="logout">Odjavi se</a>
            </div>
            <div class="rn">   
                <p><a href="reklamacija.jsp">Reklamacija</a></p>
                <p><a href="narudzbenica.jsp">Korpa</a></p>
            </div>
        <div class="log">
            
              <h2>Meni</h2>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Ime</th>
                        <th>Cena</th>
                        <th>Kategorija</th>
                        <th>Zalihe</th>
                        <th>Količina</th>
                        <th>Dodaj u korpu</th>
                    </tr>
                    <c:forEach items="${proizvodi}" var="proizvod">
                        <form action="DodajStavkuServlet" method="get"> 
                        <tr>
                            <td><input type="text" size="5" name="idProizvoda" value="${proizvod.idProizvoda}" readonly="readonly"></td>
                            <td><input type="text" name="imeProizvoda" value="${proizvod.imeProizvoda}" readonly="readonly"></td>
                            <td><input type="text" size="5" name="cena" value="${proizvod.cena}" readonly="readonly"></td>
                            <td><input type="text" size="6" name="kategorija" value="${proizvod.kategorija}" readonly="readonly"></td>
                            <td><input type="number" size="4" name="zalihe" value=${proizvod.zalihe} readonly="readonly"></td>                            
                            <td><input size="4" type="number" name="kolicina"  max=${proizvod.zalihe} min=1  ></td>
                            
                            <td><input type="submit" value="&#9989"></td>
                        </tr>     </form>
                    </c:forEach>
               
              
               <% String msg= (String) request.getAttribute("msg");
                   if(msg != null && msg.length()>0){
                   %>
                   <p><%= msg%></p>
                   <%} %>
            </table>
              
        </div>
        
            
    </body>
</html>
