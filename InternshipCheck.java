import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InternshipCheck extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");

Connection con=null;
Statement st1=null,st2=null;
ResultSet rs1=null,rs2=null;

HttpSession session=req.getSession();
String phone1=(String)session.getAttribute("mob");


String intern_id=req.getParameter("intern_id");

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
 st1=con.createStatement();
 rs1=st1.executeQuery("select * from appliedinterns where user='"+phone1+"' and internid='"+intern_id+"'");


 if(rs1.next())
 {
     res.sendRedirect("AlreadyApplied?intern_id="+intern_id+"");
 }
 else
 {
	 res.sendRedirect("InternshipView?intern_id="+intern_id+"");
 }
 rs1.close();
 st1.close();
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




























