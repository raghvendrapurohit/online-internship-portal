import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginCheck extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st=null,st1=null;
ResultSet rs=null;
ResultSet rs2=null;


String mobno1=req.getParameter("mob_no");
String password=req.getParameter("passwordinput");
String se=req.getParameter("t1");

HttpSession session=req.getSession();
session.setAttribute("mob",mobno1);

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
 rs=st.executeQuery("select * from profile where mobno='"+mobno1+"' and pwd='"+password+"' and type='"+se+"'");

if(rs.next())
{
  if(se.equals("student")) 
   {
 st1=con.createStatement();

rs2=st1.executeQuery("select * from resume where phone='"+mobno1+"'");
 if(rs2.next())
res.sendRedirect("SearchServlet");
   else
res.sendRedirect("LoginServlet");
   }
  else
 res.sendRedirect("EducatorServlet");
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
