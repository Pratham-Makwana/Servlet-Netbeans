/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program2;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Pratham
 */
public class Program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String tbl_name = "";
       String uname = "";
       int age;
       int uid ;
       int rs;
        
        while(true){
            Scanner sc = new Scanner(System.in);
        
            System.out.println("Select action: ");
            System.out.println("1. Create");
            System.out.println("2. Insert: ");
            System.out.println("3. Update: ");
            System.out.println("4. Delete: ");
            System.out.println("5. Exit: ");
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            String url = "jdbc:mysql://localhost:3306/ajdbc";
            String username = "root";
            String password = "";
            
            String query = "";
            
            try{
                Connection con = DriverManager.getConnection(url,username,password);
                if (con!= null) {
                    System.out.println("Connected");
                }
                
                Statement stm = con.createStatement();
                
                switch(choice){
                    case 1:
                        System.out.println("Enter tabel name:");
                        tbl_name = sc.nextLine();
                        query = "create table `" +tbl_name+ "` (id int auto_increment primary key,username varchar(50), age int(10))";
                        stm.executeUpdate(query);
                        System.out.println("Table Created ");
                        break;
                    case 2:
                        System.out.println("Enter tabel name:");
                        tbl_name = sc.nextLine();
                        System.out.println("Enter username:");
                        uname = sc.nextLine();
                        System.out.println("Enter age:");
                        age = sc.nextInt();
                        query = "insert into `" + tbl_name + "` (username,age) values ('"+uname+"', "+ age +")";
                        rs = stm.executeUpdate(query);
                        
                        if (rs > 0) {
                            System.out.println("Inserted");
                        }else{
                            System.out.println("Insertion Failed");
                        }
                        break;
                    case 3:
                        
                        System.out.println("Enter tabel name:");
                        tbl_name = sc.nextLine();
                        System.out.println("Enter user id:");
                        uid = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.println("Enter username:");
                        uname = sc.nextLine();
                        System.out.println("Enter age:");
                        age = sc.nextInt();
                        query = "update `" + tbl_name + "` set username ='"+ uname +"' , age = "+ age +" where id = " + uid + "";
                        rs = stm.executeUpdate(query);
                        
                        if (rs > 0) {
                            System.out.println("Updated");
                        }else{
                            System.out.println("updation Failed");
                        }
                        break;
                    case 4:
                        System.out.println("Enter tabel name:");
                        tbl_name = sc.nextLine();
                         System.out.println("Enter user id:");
                        uid = sc.nextInt();
                        sc.nextLine();
                        query = "delete from `" + tbl_name + "` where id = '"+ uid +"'";
                        
                        rs = stm.executeUpdate(query);
                        
                        if (rs > 0) {
                            System.out.println("deletd");
                        }else{
                            System.out.println("deletion Failed");
                        }
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                
                stm.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
        
        }
    }
    
}
