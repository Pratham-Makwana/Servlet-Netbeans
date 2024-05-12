/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pratham
 */



public class MyServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from tbl_user where username = ? and password = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, pswd);
            ResultSet rs = stm.executeQuery();
            pw.println((rs.next()) ? "<H2>Hello" + name + "</H2>" : "<H2>Invalid Crendentials </H2>");

        } catch (ClassNotFoundException | SQLException ex) {
            pw.println("<H2>Error...</H2>");
        }
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//    

}
