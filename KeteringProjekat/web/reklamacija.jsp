<%-- 
    Document   : reklamacija
    Created on : Feb 27, 2018, 10:39:16 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesija= request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reklamacija</title>
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
            width:490px ;
            height:290px;
             margin: -115px 0 0 -165px;
            top: 50%;
            left: 50%;
            padding: 20px;
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
             .user{
             background-color:hsla(600, 33%, 65%, 0.9);
             width:200px ;
             float:right;
             text-align:center;}
    </style>
    <body>
            <div class="user" > <% String poruka= (String) sesija.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
                   %>
               <p><%= poruka%></p>
               <%} %>
               <a href="logout">Odjavi se</a>
            </div>
            <form action="ServletReklamacija" method="post">
            <div class="log">
                
                <h2>Reklamacija</h2>
                <table>
                    <tr>
                        <td>Broj telefona:</td>
                        <td><input type="text" name="brtelefona" value="${reklamacija.brtelefona}"></td>
                    </tr>
                    <tr>
                        <td>Opis:</td>
                        <td><textarea rows="4" cols="30" maxlength="300" name="opis" value="${reklamacija.opis}"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Pošalji"></td>
                    </tr>
                    <tr>
                        <td><a href="pregledMenija.jsp">Idi na pregled menija</a></td>
                    </tr>
                
                </table>
                    <% String mess= (String) sesija.getAttribute("mess");
               if(mess != null && mess.length()>0){
                   %>
               <p><%= mess%></p>
               <%} %>
            </div>
            </form>
    </body>
</html>
