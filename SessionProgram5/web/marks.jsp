<%-- 
    Document   : marks
    Created on : 14-Apr-2024, 11:19:57 pm
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
        <h1>Hello <%= session.getAttribute("name") %> </h1>
        <form action="result.jsp" method="post">
            <input type="number" name="mark1"><!-- comment -->
            <input type="number" name="mark2"><!-- comment -->
            <input type="number" name="mark3"><!-- comment -->
            <input type="number" name="mark4"><!-- comment -->
            <input type="number" name="mark5"><!-- comment -->
            <input type="number" name="mark6"><!-- comment -->
            <input type="submit" value="generate result"><!-- comment -->
        </form>
    </body>
</html>
