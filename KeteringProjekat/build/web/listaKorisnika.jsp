<%-- 
    Document   : listaKorisnika
    Created on : Feb 27, 2018, 10:36:33 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
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
            background-color:  hsla(600, 33%, 65%, 0.8);
            width:1060px ;
            height:520px;
            margin: auto;
            top: 10%;
            left: 4%;
            padding: 15px;
            align-items: center;
            text-align:center;
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
               <p><%= poruka%></p>
               <%}else{ 
                    sesija.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%>
               <a href="logout">Odjavi se</a>
            </div>
               
            <div class="log">
                
              <h3>Lista korisnika</h3>
              
                <table>
                    <tr>
                        <th width="80px">Id korisnika</th>
                        <th width="170px">Ime i prezime</th>
                        <th width="170px">Email</th>
                        <th width="170px">Telefon</th>
                        <th width="170px">Username</th>
                        <th width="170px">Password</th>
                        <th width="60px" >Obriši</th>
                    </tr>
                    <c:forEach items="${klijenti}" var="klijent">
                        
                        <tr>
                            <td>${klijent.idKorisnika}</td>
                            <td>${klijent.imePrezime}</td>
                            <td>${klijent.email}</td>
                            <td>${klijent.telefon}</td>
                            <td>${klijent.username}</td>
                            <td>${klijent.password}</td> 
                            <td><a href="ObrisiKorisnikaServlet?username=${klijent.username}">&#10007</a></td>
                            
                        </tr>    
                    </c:forEach>
                </table>
                    <form action="DodajServlet" method="post" >
                        <table>
                            <h3>Dodavanje korisnika</h3>
                        <tr>
                            <td><input size=6 type="text" name="idKorisnika" ></td>
                            <td><input size=20 type="text" name="imePrezime" ></td>
                            <td><input size=20 type="text" name="email" ></td>
                            <td><input size=20 type="text" name="telefon" ></td>
                            <td><input size=20 type="text" name="username"></td>
                            <td><input size=20 type="text" name="password"></td>
                            <td><input size=20 type="submit" value="&#10004;"></td>
                        </tr>
                        </table>
                    </form>
              <form action="IzmenaKorisnikaServlet" method="get">
                  <table>
                       <h3>Izmena korisnika</h3>
                       <tr>
                           <td><input size=6 type="text" name="idKorisnika" ></td>
                           <td><input type="text" name="imePrezime"> </td>
                            <td><input type="text" name="email"> </td>
                            <td><input type="text" name="telefon"> </td>
                            <td width="170"><select><c:forEach items="${klijenti}" var="klijent">
                                        <option> ${klijent.username}</option>
                            </c:forEach></select></td>
                            <td><input type="text" name="password" > </td> 
                            <td><input type="submit" value="&#9998;"></td>
                        </tr>
                  </table>
              </form>
                
               
              <br> <% String msg= (String) request.getAttribute("msg");
                        if(msg != null && msg.length()>0){
                   %>
                        <p><%= msg%></p>
                        <%} %>
            </div>
        
    </body>
</html>
