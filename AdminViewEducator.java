import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminViewEducator extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

HttpSession session=req.getSession();
String user=(String)session.getAttribute("mob");

String educator=req.getParameter("educator");

Connection con=null;
Statement st2=null,st3=null,st4=null;
ResultSet rs2=null,rs3=null,rs4=null;

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
    pw.println("<h1>Educator Profile:</h1>");
	pw.println("<p><strong>Educator:  </strong>"+educator+"</p>");
  pw.println("</div>");

 try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from profile where mobno='"+educator+"' ");
 

 while(rs2.next())
 {
String s1=rs2.getString(1);
String s2=rs2.getString(2);
String s3=rs2.getString(3);
String s4=rs2.getString(6);
String s5=rs2.getString(7);
String s6=rs2.getString(8);

pw.println("<label>Educator name:</label>"+s1+"<br/>");
pw.println("<label>Email:</label>"+s2+"<br/>");
pw.println("<label>mobile no:</label>"+s3+"<br/>");
pw.println("<label>D.O.B:</label>"+s4+"<br/>");
pw.println("<label>Full name:</label>"+s5+"<br/>");
pw.println("<label>Address:</label>"+s6+"<br/>");
}
  
 
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }
 
  try
 {
 st3=con.createStatement();
 rs3=st3.executeQuery("select * from registeredcompanies where educator='"+educator+"' ");
 

 while(rs3.next())
 {
String startup=rs3.getString(2);
pw.println("<label>Startup/Company name:</label>"+startup+"<br/>");

}
  
 
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }
 
  try
 {
 st4=con.createStatement();
 rs4=st4.executeQuery("select * from internships where educator='"+educator+"'");
 
int i=0; 
 while(rs4.next())
 {
 i++;
 }
   pw.println("<button type='button' class='btn btn-success'>Interns posted: <span class='badge'>"+i+"</span></button>");    
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



}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}


}
