/<%-- 
    Document   : Practical 8
    Author     : Jigar Vakil
--%>

<%@page import="BANK.Bankops"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><form action="Result.jsp"><table>
        <%
            String wd = request.getParameter("btn");
            Bankops bnk = new Bankops();
            if(wd.equals("withdraw"))
            {
                float amt = Float.parseFloat(request.getParameter("txtamtwithdraw"));
                String rs=bnk.withdraw(amt);
                out.print(rs);
            }
            else if(wd.equals("Deposit"))
            {
                float amt = Float.parseFloat(request.getParameter("txtamtdeposit"));
                out.print(bnk.deposit(amt));
            }
            else if(wd.equals("Exit"))
            {
                response.sendRedirect("index.jsp");
            }
        %>
    </table></form></center>
    </body>
</html>
