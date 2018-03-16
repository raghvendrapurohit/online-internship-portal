import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminLoginCheck extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st=null,st1=null;
ResultSet rs=null;
ResultSet rs2=null;


String mobno=req.getParameter("mobno");
String pwd=req.getParameter("pwd");

HttpSession session=req.getSession();
session.setAttribute("phone",mobno);

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
 st=con.createStatement();
 rs=st.executeQuery("select * from admins where mobno='"+mobno+"' and pwd='"+pwd+"'");


 
 if(rs.next())
{
 if(mobno.equals("8764104949")) 
   {
   res.sendRedirect("Admin");
   }
   else
   {	   
   res.sendRedirect("Admin2");
   }
 }

else
pw.println("invalid username or password");

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
