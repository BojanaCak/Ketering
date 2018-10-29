<%-- 
    Document   : error
    Created on : Feb 23, 2018, 2:35:02 AM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Greška</title>
    </head>
        <style>
            body{
            background-image: url("slike/image85376.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
                        
        }
            .reg{
            border:2px solid black;
            background-color:  hsla(600, 33%, 65%, 0.9);
            width:330px ;
            height:380px;
            margin:auto;
            top: 50%;
            left: 50%;
            }
        </style>
    </style>
    <body>
        <div class="reg">
        <h1>Greška u radu sa bazom podataka</h1>
        <h3>${errormsg}</h3></div>
    </body>
</html>
