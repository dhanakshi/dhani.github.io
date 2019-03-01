package com.mvc.dao;
 
import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import com.mvc.bean.LoginBean;
 import com.mvc.util.DBConnection;
 public class LoginDao {
 public String authenticateUser(LoginBean loginBean)
 {
 
 String username = loginBean.getUserName(); 
 String password = loginBean.getPassword();

Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String usernameDB = "";
 String passwordDB = "";
 
try
 {
 con = DBConnection.createConnection(); 
 statement = con.createStatement();
 resultSet = statement.executeQuery("select username,password from customers"); 

while(resultSet.next()) 
 {
  usernameDB = resultSet.getString("username"); 
  passwordDB = resultSet.getString("password");
 
   if(username.equals(usernameDB) && password.equals(passwordDB))
   {System.out.println("success");
      return "SUCCESS";
   }
 }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials"; 
 }
 	LoginBean log=new LoginBean();
 	public LoginBean giveProfile(String username){
 		System.out.println(username);
 		
 		Connection con = null;
 		 Statement statement = null;
 		 ResultSet resultSet = null;
 		try
 		 {
 		 con = DBConnection.createConnection(); 
 		 statement = con.createStatement();
 		 resultSet = statement.executeQuery("select * from customers");
 		 
 		while(resultSet.next()) 	
 		 {if(resultSet.getString("username").equals(username)){
 			 log.setUserName(resultSet.getString("username"));
 			 log.setId(resultSet.getString("id"));
 			 log.setOffice(resultSet.getString("office"));
 			 log.setDesig(resultSet.getString("desig"));
 			 System.out.println(resultSet.getString("username"));
 			 return log;
 		 }
 		  
 		
 		 }
 		 }catch(SQLException e)
 		 {
 			 e.printStackTrace();
 			 }
 		return log;
 	}
 		
 }
 