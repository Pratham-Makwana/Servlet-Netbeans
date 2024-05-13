<%-- 
    Document   : Display
    Created on : 17 Apr, 2021, 11:09:24 PM
    Author     : 91991
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
            if(wd.equals("Withdraw"))
            {
        %>
        <tr>
            <td colspan="2">Withdraw</td>
        </tr>
        <tr>
            <td>Enter amount for withdraw:</td>
            <td><input type="number" name="txtamtwithdraw" min="0"></td>
        </tr>
        <tr>
            <td><input type="submit" name="btn" value="withdraw"></td>
        </tr>
        <%
            }
            else if(wd.equals("Deposit"))
            {
        %>
            <tr>
                <td colspan="2">Deposit</td>
            </tr>
            <tr>
                <td>Enter amount to Deposit:</td>
                <td><input type="number" name="txtamtdeposit" min="0"></td>
            </tr>
            <tr>
                <td><input type="submit" name="btn" value="diposit"></td>
            </tr>
        <%
            }
            else if(wd.equals("Balance"))
            {
        %>
            <jsp:useBean id="bnk" class="BANK.Bankops" scope="session"> </jsp:useBean>
            <tr>
                <td><h3>Your Balance: </h3></td>
                <td><h3><jsp:getProperty name="bnk" property="ac_bal"></jsp:getProperty></h3></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="btnexit" value="Exit" style="width: 100%;"></td>
            </tr>
            
        <%
            }
        %>
    </table></form></center>
    </body>
</html>
