<%-- 
    Document   : Practical 8
    Author     : Jigar Vakil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Bank</title>
    </head>
    <body>
    <center>
        <form action="Customer.jsp">
            <table>
                <tr>
                    <th colspan="2"><h1>Enter your Account details</h1></th>
                </tr>
                <tr>
                    <td>Account Holder Name:</td>
                    <td><input type="text" name="txtName" placeholder="Enter Your Name."></td>
                </tr>
                <tr>
                    <td>Account No.:</td>
                    <td><input type="text" name="txtACNO" placeholder="Your Account No."></td>
                </tr>
                <tr>
                    <td>Account type:</td>
                    <td><input type="radio" name="actype" value="saving">saving&nbsp;<input type="radio" name="actype" value="currant">currant</td>
                </tr>
                <tr>
                    <td>Account balance</td>
                    <td><input type="number" name="txtbal" placeholder="Enter Your Balance."></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="btnsubmit" value="Submit"></td>
                </tr>
            </table>
        </form>
    </center>
        
    </body>
</html>
