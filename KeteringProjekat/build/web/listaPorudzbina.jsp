<%-- 
    Document   : listaPorudzbina
    Created on : Feb 27, 2018, 10:39:38 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width:930px ;
            height:430px;
            margin: auto;
            top: 10%;
            left: 10%;
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
               <p><%= poruka%></p>
               <%}else{ 
                    sesija.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%><%} %>
                <a href="logout">Odjavi se</a>
            </div>
               
            <div class="log">
                
              <h2>Porudzbine</h2>
                <table>
                    
                    <tr>
                        <th width="98px">Id porudzbine</th>
                        <th width="98px">Username korisnika</th>
                        <th width="98px">Datum isporuke</th>
                        <th width="98px">Adresa dostave</th>
                        <th width="98px">Telefon</th>
                        <th width="98px">Ukupna cena</th>
                        <th width="98px">Obriši</th>
                    </tr>
                    <c:forEach items="${narudzbenice}" var="narudzbenica">
                        
                        <tr>
                            <td>${narudzbenica.idNarudzbenice}</td>
                            <td>${narudzbenica.username}</td>
                            <td>${narudzbenica.datum}</td>
                            <td>${narudzbenica.adresaDostave}</td>
                            <td>${narudzbenica.telefon}</td>
                            <td>${narudzbenica.ukupnaCena}</td>
                            <td><a href="ObrisiPorudzbServlet?idNarudzbenice=${narudzbenica.idNarudzbenice}">&#10007</a></td>
                        </tr>    
                    </c:forEach> 
                    
                    
                    
                       
       
                </table>
              
              <br> <% String msg= (String) request.getAttribute("msg");
                        if(msg != null && msg.length()>0){
                   %>
                        <p><%= msg%></p>
                        <%} %>
            </div>
        
    </body>
</html>
