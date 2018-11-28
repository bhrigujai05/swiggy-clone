/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class SignUpDataBase {
    public String addData(String n, String p,String e,String g, String h, String m, String c) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", ""); 
        PreparedStatement ps = con.prepareStatement("insert into swiggy values(?,?,?,?,?,?,?)");
        ps.setString(1, n);
        ps.setString(2,p);
        ps.setString(3,e);
        ps.setString(4,g);
        ps.setString(5,h);
        ps.setString(6,m);
        ps.setString(7,c);
        int q = ps.executeUpdate();
        System.out.println(q);
        
        if (q > 0) {
            return "data inserted";
        } else
        return "data not inserted";
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        SignUpDataBase s = new SignUpDataBase();
        String result = s.addData("Bhrigu", "Sharma", "username", "male", "user", "tuffy", "password");
        System.out.println(result);
    }
} 
