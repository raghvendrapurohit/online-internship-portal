import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddAdmin extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String s1=req.getParameter("name");
String s2=req.getParameter("mobno");
String s3=req.getParameter("pwd");
String s4=req.getParameter("id");
String s5=req.getParameter("email");
String s6=req.getParameter("pref");


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

 try
 {
 st2=con.createStatement();
 st2.executeUpdate("insert into admins values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");

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

pw.println("Admin added");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}