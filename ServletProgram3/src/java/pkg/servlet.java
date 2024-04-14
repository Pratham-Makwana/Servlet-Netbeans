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

/**
 *
 * @author Pratham
 */
public class servlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       String url = "jdbc:mysql://localhost:3306/ajdbc";
       String username = "root";
       String password = "";
       
       String name = request.getParameter("nn");
       String Email = request.getParameter("em");
       String dob = request.getParameter("dob");
       String number = request.getParameter("no");
       
       
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           Connection con = DriverManager.getConnection(url,username,password);
           String query = "insert into gen_form (name,email,dob,contact) values (?,?,?,?)";
           PreparedStatement stm = con.prepareStatement(query);
           stm.setString(1, name);
           stm.setString(2,Email);
           stm.setString(3,dob);
           stm.setString(4, number);
           
           int rs = stm.executeUpdate();
           
           if (rs > 0) {
               out.println("<h2>Data Inserted Sucessfully</h2>");
               
               String sqlquery = "select * from gen_form";
               ResultSet re = stm.executeQuery(sqlquery);
               out.println("<TABLE border = 2><tr><th>ID</th><th>Name</th><th>Email</th><th>DOB</th><th>Conatact</th></tr>");
               while (re.next()) {
                   out.println("<tr><td>"+re.getInt("id")+"</td>");
                   out.println("<td>"+re.getString("name")+"</td>");
                   out.println("<td>"+re.getString("email")+"</td>");
                   out.println("<td>"+re.getString("dob")+"</td>");
                   out.println("<td>"+re.getString("contact")+"</td></tr>");
               }
               
               out.println("</TABLE>");
           }
           
           stm.close();
           con.close();
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }

 
  
}
