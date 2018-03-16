import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminAddStartup2 extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String name=req.getParameter("name");
String email=req.getParameter("email");
String mobno=req.getParameter("mobno");
String pwd=req.getParameter("pwd");
String dob=req.getParameter("dob");
String full_name=req.getParameter("full_name");
String address=req.getParameter("address");
String startupname=req.getParameter("startupname");


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
 st2.executeUpdate("insert into profile values('"+name+"','"+email+"','"+mobno+"','"+pwd+"','educator','"+dob+"','"+full_name+"','"+address+"')");
 st2.executeUpdate("insert into registeredcompanies values('"+mobno+"','"+startupname+"')");

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

pw.println("Added");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}