
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BANK</title>
        <style>
            input{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="bnk" class="BANK.Bankops" scope="session"> </jsp:useBean>
        <jsp:setProperty property="ac_no" name="bnk" value='<%= request.getParameter("txtACNO") %>' ></jsp:setProperty>
        <jsp:setProperty property="ac_type" name="bnk" value='<%= request.getParameter("actype") %>' ></jsp:setProperty>
        <jsp:setProperty property="ac_holder_name" name="bnk" value='<%= request.getParameter("txtName") %>' ></jsp:setProperty>
        <jsp:setProperty property="ac_bal" name="bnk" value='<%= Float.parseFloat(request.getParameter("txtbal")) %>' ></jsp:setProperty>
        <center>
            <table>
                <tr>
                    <th colspan="2">Welcome to bank</th>
                </tr>
                <tr>
                    <td>Account No.:</td>
                    <td> <jsp:getProperty name="bnk" property="ac_no"></jsp:getProperty> </td>
                </tr>
                <tr>
                    <td>Account Holder Name:</td>
                    <td><jsp:getProperty name="bnk" property="ac_holder_name"></jsp:getProperty></td>
                </tr>
                <tr>
                    <td>Account type:</td>
                    <td><jsp:getProperty name="bnk" property="ac_type"></jsp:getProperty></td>
                </tr>
                <tr>
                    <td>Balance:</td>
                    <td><jsp:getProperty name="bnk" property="ac_bal"></jsp:getProperty></td>
                </tr>
                <tr>
                    <td>Request for 10000 withdraw: </td>
                    <td><% out.print(bnk.withdrawAmt(10000));%></td>
                </tr>
                <tr>
                    <td>Request for 20000 Deposit:  </td>
                    <td><% out.print(bnk.deposit(20000));%></td>
                </tr>
            </table>
        </center>
    </body>
</html>
