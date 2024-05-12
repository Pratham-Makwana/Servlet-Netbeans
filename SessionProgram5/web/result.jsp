<%-- 
    Document   : result
    Created on : 14-Apr-2024, 11:27:36 pm
    Author     : Pratham
--%>

<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String name = (String) session.getAttribute("name");
    String id = (String) session.getAttribute("id");
    String department = (String) session.getAttribute("department");

    int[] marks = new int[6];
    String[] grade = new String[6];
    String result = "pass";

    for (int i = 0; i < 6; i++) {
        marks[i] = Integer.parseInt(request.getParameter("mark" + (i + 1)));
        grade[i] = (marks[i] >= 90) ? "A" : (marks[i] >= 70) ? "B" : (marks[i] >= 60) ? "C" : (marks[i] >= 45) ? "D" : (marks[i] >= 35) ? "E" : "F";
        if (grade[i].equals("F")) {
            result = "Fail";
        }
    }
    int total = Arrays.stream(marks).sum();
    float avg = total / 6;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            Student Name = <%= name%>
            ID = <%= id%>
            Department = <%= department%>
        </h3>

        <table border="1">
            <tr><th>Subjects</th><th>Marks</th><th>Grades</th></tr>
                    <% for (int i = 0; i < 6; i++) {%>

            <tr>
                <td>Subject: <%= i + 1%></td>
                <td><%= marks[i]%></td>
                <td><%=grade[i]%></td>
            </tr>
            <% }%>

            <tr><td colspan="3">Total <%= total%></td></tr>
            <tr><td colspan="3">Total <%= avg%></td></tr>


        </table>
        <p style="color: <%= (result.equals("Fail")) ? "Red" : "Green"%>"> <%= (result.equals("Fail")) ? "Fail" : "Pass"%> </p>
    </body>
</html>
