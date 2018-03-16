import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminStartupList extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");




Connection con=null;
Statement st2=null;
ResultSet rs2=null;


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
    pw.println("<h1>Registered Startups/Companies List:</h1>");
  pw.println("</div>");
 
 try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from registeredcompanies");
int i=0;
 while(rs2.next())
  {
	String educator=rs2.getString(1);
    String startup=rs2.getString(2);

	
	 pw.println("<div class='panel-group'>");
  pw.println("<div class='panel panel-default'>");
    pw.println("<div class='panel-heading'>");
      pw.println("<h4 class='panel-title'>");
       pw.println("<a data-toggle='collapse' href='#"+i+"'><strong>Startup/Company name:  </strong>"+startup+"</a>");
      pw.println("</h4>");
    pw.println("</div>");
    pw.println("<div id='"+i+"' class='panel-collapse collapse'>");
      pw.println("<div class='panel-body'><strong>Educator:   </strong>"+educator+"</div>");
      pw.println("<div class='panel-footer'><a href='AdminViewEducator?educator="+educator+"'>View full Profile</a></div>");
    pw.println("</div>");
  pw.println("</div>");
pw.println("</div>");
i++;
  }
 con.close();
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }

 
pw.println("</div>");

pw.println("</body>");
pw.println("</html>");


 



}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}