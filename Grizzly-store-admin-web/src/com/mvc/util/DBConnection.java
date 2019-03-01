package com.mvc.util;



import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
 public static Connection createConnection()
 {
 Connection con = null;
 String url = "jdbc:oracle:thin:@localhost:1521:xe";
 String username = "system"; 
 String password = "root"; 
 
 try 
 {
 try 
 {
 Class.forName("oracle.jdbc.driver.OracleDriver"); 
 } 
 catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 } 
 con = DriverManager.getConnection(url, username, password); 
 System.out.println("Printing connection object "+con);
 } 
 catch (Exception e) 
 {
 e.printStackTrace();
 }
 System.out.println("connection");
 return con; 
 }
}