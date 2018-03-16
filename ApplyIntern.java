import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ApplyIntern extends HttpServlet
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

String educator="";
String ques1=req.getParameter("ques1");
String ques2=req.getParameter("ques2");
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
 rs1=st1.executeQuery("select educator from internships where internid='"+intern_id+"'");


 while(rs1.next())
 {
 educator=rs1.getString(1);
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
 
 
 
 try
 {
 st2=con.createStatement();
 st2.executeUpdate("insert into appliedinterns values('"+phone1+"','"+intern_id+"','"+ques1+"','"+ques2+"','"+educator+"','Applied')");


  
 st2.close();
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }
 
 pw.println("Successfully Applied");
 
}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}




























