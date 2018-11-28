package signup;

import java.io.*;  
import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

//@WebServlet("/abc")  
public class SignUpServlet extends HttpServlet {  
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n = request.getParameter("fnm");
String p=request.getParameter("lnm");  
String e=request.getParameter("unm");  
String g=request.getParameter("gender");
String h=request.getParameter("type");
String m=request.getParameter("code");
String c=request.getParameter("pswd");
System.out.println("SF");
    SignUpDataBase s = new SignUpDataBase();
    try {
        s.addData(n, p, e, g, h, m, c);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}  
  
}  
