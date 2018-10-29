<%-- 
    Document   : brisanje
    Created on : Mar 29, 2018, 12:20:43 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            width:300px ;
            height:220px;
            margin: auto;
            top: 30%;
            left: 30%;
            padding: 15px;
            align-items: center;
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
               <%} %>
               <a href="logout">Odjavi se</a>
            </div>
        <div class="log">
            
        <% String msg= (String) request.getAttribute("msg");
                        if(msg != null && msg.length()>0){
                   %>
                        <h2><%= msg%></h2>
                        <%} %>
                        <br>
                        <form action="KorisiciListaServlet" method="post">
                        <button >Vrati se na listu korisnika</button>                   
                        </form>
        </div>
    </body>
</html>
