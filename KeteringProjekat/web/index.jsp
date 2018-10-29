<%-- 
    Document   : index
    Created on : Feb 23, 2018, 2:34:36 AM
    Author     : korisnik
--%>

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
                        
        }
       .log {
            position: absolute;
            border:2px solid black;
            background-color:hsla(600, 33%, 65%, 0.9);
            width:330px ;
            height:230px;
             margin: -115px 0 0 -165px;
            top: 50%;
            left: 50%;
        }
    </style>
    <body>
        <form method="post" action="logovanje">
            <div class="log" align="center">
            <h2>LOGOVANJE</h2>
            <table>
                <tr>
                    <td>Korisničko ime:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Lozinka:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Ulogujte se"></td>
                    <td><input type="reset" value="Poništite"></td>
                </tr>
            </table>
            <br><br> Niste registrovani? <a href="signup.jsp">Registruj se!</a>
            <br>  <% String poruka= (String) request.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
               %>
               <p><%= poruka%></p>
               <%} %>
            </div>
        </form>
    </body>
</html>
