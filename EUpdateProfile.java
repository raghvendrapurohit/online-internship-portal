import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EUpdateProfile extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String s1=req.getParameter("name");
String s2=req.getParameter("fullname");
String s3=req.getParameter("D.O.B");
String s4=req.getParameter("address");
String s5=req.getParameter("email");
String s6=req.getParameter("phone");


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
 st2.executeUpdate("update profile set name='"+s1+"' where mobno='"+s6+"'");
 st2.executeUpdate("update profile set address='"+s4+"' where mobno='"+s6+"'");
 st2.executeUpdate("update profile set email='"+s5+"' where mobno='"+s6+"'");
 st2.executeUpdate("update profile set fullname='"+s2+"' where mobno='"+s6+"'");
st2.executeUpdate("update profile set dob='"+s3+"' where mobno='"+s6+"'");
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

res.sendRedirect("ESettings");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}