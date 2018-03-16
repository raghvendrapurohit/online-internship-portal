import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminLogin extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");



Connection con=null;
Statement st2=null;
ResultSet rs1=null;




pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
  pw.println("<title>Bootstrap Example</title>");
  pw.println("<meta charset='utf-8'>");
  pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
  pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
  pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
pw.println("</head>");
pw.println("<body>");

pw.println("<div class='container'>");
  pw.println("<div class='jumbotron'>");
    pw.println("<h1>Admin Login:</h1>");

  pw.println("</div>");
 
 pw.println("<form method='get' action='AdminLoginCheck'>");
   pw.println("<div class='input-group'>");
     pw.println("<span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>");
     pw.println("<input id='email' type='number' class='form-control' name='mobno' placeholder='Enter admin mobile no.'><br/>");
   pw.println("</div>");
   pw.println("<div class='input-group'>");
     pw.println("<span class='input-group-addon'><i class='glyphicon glyphicon-lock'></i></span>");
     pw.println("<input id='password' type='password' class='form-control' name='pwd' placeholder='Password'><br/>");
   pw.println("</div>");
   pw.println("<br/><input type='submit' class='btn' value='Login'/>");
 pw.println("</form>");


			       
pw.println("</div>");

pw.println("</body>");
pw.println("</html>");

 
 
 
 
 
 

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}