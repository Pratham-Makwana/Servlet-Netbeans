<%-- 
    Document   : pra6
    Created on : 12-May-2024, 7:54:47 pm
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
        <%
            String u = request.getParameter("url");
            if(u.startsWith("http://") || u.startsWith("https://")){
            response.sendRedirect(u);
            }else{
                session.setAttribute("Error", "Not a valid url");
            }
        %>
    </body>
</html>
