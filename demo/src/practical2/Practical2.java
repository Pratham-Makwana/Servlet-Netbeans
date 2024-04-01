/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Pratham
 */
public class Practical2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String loadDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/demo";
        String dbUSERNAME = "root";
        String dbPASSWORD = "";
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName(loadDriver);
            Connection con = null;
            PreparedStatement ps = null;
            con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
            String sid;
            String sname;
            String sage;
            String grade;

            System.out.println("Menu");
            System.out.println("1. Insert student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show Student");
            System.out.println("5.Exit");

            int choice;
            do {
                System.out.println("Enter your choice");
                String userChoice = sc.nextLine();
                choice = Integer.parseInt(userChoice);

                switch (choice) {
                    case 1:
                        System.out.println("Enter student name: ");
                        sname = sc.nextLine();
                        System.out.println("Enter student age: ");
                        sage = sc.nextLine();
                        System.out.println("Enter student grade: ");
                        grade = sc.nextLine();
                        ps = con.prepareStatement("INSERT INTO `student`(`name`,`age`,`grade`) VALUES (?,?,?)");
                        ps.setString(1, sname);
                        ps.setString(2, sage);
                        ps.setString(3, grade);
                        int count = ps.executeUpdate();
                        if (count > 0) {
                            System.out.println("Data Inserted");
                        } else {
                            System.out.println("Data not Inserted");
                        }
                        break;
                    case 2:
                        System.out.print("Enter Student ID : ");
                        sid = sc.nextLine();
                        System.out.println("Enter student name: ");
                        sname = sc.nextLine();
                        System.out.println("Enter student age: ");
                        sage = sc.nextLine();
                        System.out.println("Enter student grade: ");
                        grade = sc.nextLine();

                        ps = con.prepareStatement("UPDATE `student` SET `name`=?,`age`=?,`grade`=? WHERE `student_id`=?");
                        ps.setString(1, sname);
                        ps.setString(2, sage);
                        ps.setString(3, grade);
                        ps.setString(4, sid);
                        count = ps.executeUpdate();
                        if (count > 0) {
                            System.out.println("Data Inserted");
                        } else {
                            System.out.println("Data not Inserted");
                        }

                        break;
                    case 3:
                        System.out.print("Enter Student ID : ");
                        sid = sc.nextLine();
                        ps = con.prepareStatement("DELETE FROM `student` WHERE `student_id`=?");
                        ps.setString(1, sid);
                        count = ps.executeUpdate();
                        if (count > 0) {
                            System.out.println("Data Deleted");
                        } else {
                            System.out.println("Data not deleted");
                        }
                        break;
                    case 4:
                        ps = con.prepareStatement("SELECT * FROM `student`");
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            System.out.println("Student ID : " + rs.getString(1) + " Student Name : " + rs.getString(2) + " Student age : " + rs.getString(3) + " Student Grade : " + rs.getString(4));
                        } else {
                            System.out.println("No record found");
                        }

                        break;

                    case 5:
                        System.out.println("byeee!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;

                }
            } while (choice != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
