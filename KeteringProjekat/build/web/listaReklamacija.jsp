<%-- 
    Document   : listaReklamacija
    Created on : Feb 27, 2018, 10:37:39 AM
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
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            width:200px ;
            height:50px;
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
                           
                <h2>Reklamacije</h2>
                    <table>
                            <tr>
                                <th width="98px">Id reklamacije</th>
                                <th width="98px">Opis</th>
                                <th width="98px">Telefon</th>
                                <th width="98px">Id narudzbenice</th>
                                <th width="98px">Username korisnika</th>
                                <th width="98px">Obriši</th>
                            </tr>
                        <c:forEach items="${reklamacije}" var="reklamacija">

                            <tr><td align="center">${reklamacija.idReklamacije}</td>
                                <td align="center">${reklamacija.opis}</td>
                                <td align="center">${reklamacija.telefon}</td>
                                <td align="center">${reklamacija.idNarudzbenice}</td>
                                <td align="center">${reklamacija.username}</td>
                                <td align="center"><a href="ObrisiReklServlet?idReklamacije=${reklamacija.idReklamacije}">&#10007</a></td>
                            </tr>    
                        </c:forEach>
                    </table>
               
                   <% String msg= (String) request.getAttribute("msg");
                   if(msg != null && msg.length()>0){
                   %>
                   <p><%= msg%></p>
                   <%} %>
               
            </div>
       
    </body>
</html>
