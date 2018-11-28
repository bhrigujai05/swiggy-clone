/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author
 */
public class validate {
    public  boolean user(String name,String pass) 
     {
      boolean st =false;
      //System.out.println(name+" "+pass);
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","");
         Statement ps=con.createStatement();  
         
       String query="select * from swiggy where username='"+name+"' and pwd='"+pass+"'";  
      // ps.setString(1, name);
        // ps.setString(2, pass);
         ResultSet rs =ps.executeQuery(query);
         
         System.out.println(name+" "+pass);
         while(rs.next())
         {
          String u=rs.getString("username");
                String p=rs.getString("pwd");
                if(u.equals(name) && p.equals(pass))
                {
                   System.out.println("helloworld");
                 return true;
               }
         }
        // st = rs.next();
      }catch(ClassNotFoundException | SQLException e)
      {
          e.printStackTrace();
      }
      System.out.println(st);
        return st;                 
  }
    
    public static void main(String args[])
    {
        validate obj = new validate();
        obj.user("abc@123","321");
    }

    /**
     *
     * @param name
     * @param password
     * @return
     */
   
}
