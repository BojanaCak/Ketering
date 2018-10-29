<%-- 
    Document   : izmenaMenija
    Created on : Feb 27, 2018, 10:36:10 AM
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
            background-color:  hsla(600, 33%, 65%, 0.7);
            width:930px ;
            height:430px;
            margin: auto;
            top: 10%;
            left: 10%;
            padding: 15px;
            text-align: center;
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
                    request.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%>
               <a href="logout">Odjavi se</a>
            </div>
            
            <div class="log">
               <form action="DodajJeloServlet" method="post" >
              <h2>Jela</h2>
                <table>                     
                    <tr>
                        <th width="98px">Id jela</th>
                        <th width="98px">Naziv jela</th>
                        <th width="98px">Cena</th>
                        <th width="98px">Kategorija</th>
                        <th width="98px">Zalihe</th>
                        <th width="98px">Obriši</th>
                    </tr>
                <c:forEach items="${proizvodi}" var="proizvod">                        
                    <tr><td>${proizvod.idProizvoda}</td>
                        <td>${proizvod.imeProizvoda}</td>
                        <td>${proizvod.cena}</td>
                        <td>${proizvod.kategorija}</td>
                        <td>${proizvod.zalihe}</td>
                        <td><a href="ObrisiJeloServlet?imeProizvoda=${proizvod.imeProizvoda}">&#10007</a></td>
                    </tr>    
                </c:forEach> 
                        <tr>
                            <td></td>
                            <td><input type="text" name="imeProizvoda" ></td>
                            <td><input type="text" name="cena" ></td>
                            <td>
                            <select name="kategorija" id="kategorija">
                                    <option value="" selected> Odaberi </option>
                                    <option name="kategorija">Slatko</option> 
                                    <option name="kategorija">Slano</option> 
                                    
                            </select>
                            </td>
                            <td><input type="text" name="zalihe" ></td>
                            <td><input type="submit" value="Dodaj"></td>
                        </tr>                    
                </table>
               </form>
        <form>
            
                <% String msg= (String) request.getAttribute("msg");
               if(msg != null && msg.length()>0){
               %>
               <p><%= msg%></p>
               <%} %>
          
        </form>  
               </div>
    </body>
</html>
