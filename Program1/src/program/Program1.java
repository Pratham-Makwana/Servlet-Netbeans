/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Pratham
 */
public class Program1 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String uname = sc.nextLine();
        System.out.println("Enter Your Password: ");
        String password = sc.nextLine();
        
        String url = "jdbc:mysql://localhost:3306/ajdbc";
        String user = "root";
        String pass = "";
        
        try{
            
            Connection connection = DriverManager.getConnection(url,user,pass);
            if (connection != null) {
                System.out.println("Connected!!");
            }
            
            Statement st = connection.createStatement();
            String query = "select * from tbl_user where username = '"+uname+"' and password = '"+password+"'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                System.out.println("Login Successfully "+ rs.getString("username"));
            }else{
                System.out.println("Login Failed!!!");
            }
            
             rs.close();
            st.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
                
        
    }
}
