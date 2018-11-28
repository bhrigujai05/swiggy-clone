package login; 
  
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;  
import java.io.PrintWriter;  
import static java.lang.System.out;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LoginServlet extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");
        //request.getRequestDispatcher("login.html").include(request, response);  
          
        String name=request.getParameter("user"); 
        String password=request.getParameter("pwsd");    
          boolean s=false;
  
          validate obj = new validate();
        //
        if(s=obj.user(name,password)){ 
            
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+name);  
              out.println(s);
               request.getRequestDispatcher("restaurants.html").include(request, response); 
                           Cookie ck=new Cookie("name",name);  
                             response.addCookie(ck);  
            }
        else{  
            out.print("sorry, username or password error!"); 
             request.getRequestDispatcher("login.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  