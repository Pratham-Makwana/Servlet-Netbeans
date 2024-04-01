/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Pratham
 */
public class Practical1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String loadDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/demo";
            String dbUSERNAME = "root";
            String dbPASSWORD = "";

            Scanner sc = new Scanner(System.in);
            String uname, pass;
            System.out.print("enter user name :");
            uname = sc.nextLine();
            System.out.print("enter password :");
            pass = sc.nextLine();

            try {
                Class.forName(loadDriver);
                Connection con = null;
                con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
                String query = "SELECT * FROM user WHERE username = ? AND pass = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, uname);
                preparedStatement.setString(2, pass);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Successful Login");
                } else {
                    System.out.println("Invalid Username and Password");
                }
            } 
            catch (Exception e) {
                System.out.println(e);
            } 
    }
    
}



