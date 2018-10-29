<%-- 
    Document   : signup
    Created on : Feb 23, 2018, 2:36:20 AM
    Author     : korisnik
--%>
<%@page import="beans.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
             padding: 50px;           
        }
        .reg{
            border:2px solid black;
            background-color:  hsla(600, 33%, 65%, 0.9);
            width:330px ;
            height:380px;
            margin:auto;
            top: 50%;
            left: 50%;
            padding: 10px;
        }
    </style>
    <body>
        <form method="post" action="registracija">
            <div class="reg" align="center">
            <h2>REGISTRACIJA</h2>
            <table>
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="id" ></td>
                </tr>
               <tr>
                    <td>Ime i prezime:</td>
                    <td><input type="text" name="imePrezime" ></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" ></td>
                </tr>
                <tr>
                    <td>Telefon:</td>
                    <td><input type="text" name="telefon"></td>
                </tr>
                <tr>
                    <td>Korisničko ime:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Lozinka:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Potvrda lozinke:</td>
                    <td><input type="password" name="potvrda" value="${klijent.potvrda}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Registrujte se"></td>
                    <td><input type="reset" value="Poništite"></td>
                </tr>
                
            </table>
                <br><br>Već ste registrovani? <a href="index.jsp">Ulogujte se!</a>
            <br> <% String poruka= (String) request.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
               %>
               <p><%= poruka%></p>
               <%} %></div>
        </form>
    </body>
</html>
