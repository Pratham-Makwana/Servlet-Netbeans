package com.practical;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Pratham
 */
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        out.print("<h2>welcome to register page </h2>");
        
        String name = req.getParameter("user-name");
        String password = req.getParameter("user-password");
        String email = req.getParameter("user-email");
        String gender = req.getParameter("user-gender");
        String course = req.getParameter("user course");
        String con = req.getParameter("condition");
        
        if (con != null) {
            
            if (con.equals("checked")) {
                out.println("<h2> Name:" + name + "</h2>");
                out.println("<h2> password:" + password + "</h2>");
                out.println("<h2> email:" + email + "</h2>");
                out.println("<h2> gender:" + gender + "</h2>");
                out.println("<h2> course:" + course + "</h2>");
                
                RequestDispatcher rd = req.getRequestDispatcher("success");                
                rd.forward(req, resp);
            } else {
                out.println("<h2>Your have not tick term and condition</h2>");
            }
        } else {
            out.println("<h2>Your have not tick term and condition</h2>");
            // RequestDispatcher rd =request.getRequestDispatcher("index.html");
            //    rd.include(req, resp);
            
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
        
    }
    
}
