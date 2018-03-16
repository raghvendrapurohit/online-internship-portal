import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;

public class MessageSend extends HttpServlet
{



public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st=null,st1=null;
ResultSet rs=null;

Date date = new Date();
String current_date=date.toString();

String to_mob=req.getParameter("phone");
String to_email=req.getParameter("email");
String subject=req.getParameter("subject");
String message=req.getParameter("message");

String from_mob="",from_email="";

HttpSession session=req.getSession();
String phone1=(String)session.getAttribute("mob");

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


 
rs=st1.executeQuery("select mobno,email from profile where mobno='"+phone1+"'");
 while(rs.next())
{
  from_mob=rs.getString(1);
  from_email=rs.getString(2);
 }

pw.println(from_mob);
pw.println(from_email);

 st1.executeUpdate("insert into messages values('"+from_mob+"','"+to_mob+"','"+from_email+"','"+to_email+"','"+current_date+"','"+subject+"','"+message+"')");

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
