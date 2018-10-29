<%-- 
    Document   : korisnik
    Created on : Feb 27, 2018, 5:26:24 PM
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
            border:2px solid white;
            background-color:  hsla(600, 33%, 65%, 0.7);;
            width:530px ;
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
    </style>
    <body>
        <div class="user"><h3> <% String poruka= (String) request.getAttribute("poruka");
               if(poruka != null && poruka.length()>0){
                   %>
               <p><%= poruka%></p>
               <%}else{ 
                    sesija.setAttribute("poruka", "Morate se ulogovati");
                    request.getRequestDispatcher("index.jsp").forward(request, response); }%>
               <a href="logout">Odjavi se</a>
        </div>
            <div class="log">
                <table>
                    <tr align="center">
                        <td><button><a href="pregledProizvoda">Pregled menija</a></button></td>
                    </tr>                    
                    <tr align="center">
                        <td></td>
                        <td></td>
                    </tr>
                    <tr align="center">
                        <td></td>
                    </tr>
                    
                </table>
            </div>
        </form>
    </body>
</html>