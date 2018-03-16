import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteUser extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");




String dusermob=req.getParameter("dusermob");
String type="";

Connection con=null;
Statement st2=null,st1=null;
ResultSet rs1=null;

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
 rs1=st1.executeQuery("select * from profile where mobno='"+dusermob+"'");
 
 while (rs1.next())
 {
	type=rs1.getString(5);
 }

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

 if(type.equals("educator"))
	 pw.println("Go to startup delete");

 else
 {
 try
 {
 st2=con.createStatement();
 st2.executeUpdate("delete from profile where mobno='"+dusermob+"'");
 st2.executeUpdate("delete from resume where phone='"+dusermob+"'");

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

pw.println("user deleted");


}
}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}