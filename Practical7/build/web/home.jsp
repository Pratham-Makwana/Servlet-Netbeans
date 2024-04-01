<%-- 
    Document   : home
    Created on : 27-Mar-2024, 9:19:02 am
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
         <% String un =(String)session.getAttribute("un"); %>
        <h1>welcome <%= un %></h1>
    </body>
</html>
