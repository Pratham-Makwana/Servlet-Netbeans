<%-- 
    Document   : home
    Created on : 13-May-2024, 7:59:17 am
    Author     : Pratham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String un = (String) session.getAttribute("un"); %>
        <h1> Welcome <%= un %></h1>
    </body>
</html>
