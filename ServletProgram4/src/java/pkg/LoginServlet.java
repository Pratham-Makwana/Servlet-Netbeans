/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("Text/HTML");
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("nm");
        String pswd = request.getParameter("ps");

        String url = "jdbc:mysql://localhost:3306/ajdbc";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from tbl_user where username = ? and password = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, pswd);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                pw.println("<H2>Hello" + name + "</H2>");
            }
           // pw.println((rs.next()) ? "<H2>Hello" + name + "</H2>" : "<H2>Invalid Crendentials </H2>");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            pw.println("<H2>Error...</H2>");
        }
    }

}
