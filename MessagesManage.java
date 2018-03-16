import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MessagesManage extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st1=null,st2=null,st3=null,st4=null,st5=null;
String to_email="",subject="",date="",from_email="",email_id="";
ResultSet rs5=null;

HttpSession session=req.getSession();
String s1=(String)session.getAttribute("mob");


String cat=req.getParameter("cat");

if(cat.equals("sent"))
{
to_email=req.getParameter("to_email");
subject=req.getParameter("subject");
date=req.getParameter("date");
}
else
{
from_email=req.getParameter("from_email");
subject=req.getParameter("subject");
date=req.getParameter("date");
}


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
st5=con.createStatement();
rs5=st5.executeQuery("select email from profile where mobno='"+s1+"'");

while(rs5.next())
{
email_id=rs5.getString(1);
}
rs5.close();
st5.close();
}

catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }


if(cat.equals("sent"))
{
try
 {
 st1=con.createStatement();
 st1.executeUpdate("insert into trashmessages values('"+to_email+"','"+subject+"','"+date+"','sent','"+s1+"','"+email_id+"')");
 
 
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
 st2.executeUpdate("delete from messages where to_email='"+to_email+"' and date='"+date+"'");
 
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

}

else
{
try
 {
 st3=con.createStatement();
 st3.executeUpdate("insert into trashmessages values('"+from_email+"','"+subject+"','"+date+"','received','"+s1+"','"+email_id+"')");
 
 
 st3.close(); 
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
 st4.executeUpdate("delete from messages where from_email='"+from_email+"' and date='"+date+"'");
 
 st4.close();
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


pw.println("task complete");









}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);

}

}
