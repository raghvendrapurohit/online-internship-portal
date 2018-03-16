import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminAddStartup1 extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");




Connection con=null;
Statement st2=null;


 try
 {
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 con=DriverManager.getConnection("jdbc:odbc:mp");
 }

catch(ClassNotFoundException e1)
 {
 pw.println(e1);
 }

catch(SQLException e2)
 {
 pw.println(e2);
 }
 
 
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
    pw.println("<h1>Add a New Startup/Company</h1>");
  pw.println("</div>");
  pw.println("<form method='get' action='AdminAddStartup2'>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Educator name:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='text' name='name'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Email:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='email' name='email'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Mobile no:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='number' name='mobno'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Password</label>");
    pw.println("<input class='form-control' id='inputdefault' type='password' name='pwd'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Educator D.O.B:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='date' name='dob'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Educator full name:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='text' name='full_name'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Address:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='text' name='address'>");
  pw.println("</div>");
  pw.println("<div class='form-group'>");
    pw.println("<label for='inputdefault'>Startup/Company name:</label>");
    pw.println("<input class='form-control' id='inputdefault' type='text' name='startupname'>");
  pw.println("</div>");
 
 pw.println("<input type='submit' class='btn btn-info' value='Add Startup/Company'/>");
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