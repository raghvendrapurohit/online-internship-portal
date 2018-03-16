import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DCompany extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String deletecompany=req.getParameter("deletecompany");


String educator="";

Connection con=null;
Statement st2=null,st3=null;
ResultSet rs3=null;


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
 st3=con.createStatement();
 rs3=st3.executeQuery("select * from registeredcompanies where company_name='"+deletecompany+"' ");
 

 while(rs3.next())
 {
educator=rs3.getString(1);

}
  
 
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
 st2.executeUpdate("delete from registeredcompanies where company_name='"+deletecompany+"'");
 st2.executeUpdate("delete from profile where mobno='"+educator+"'");

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

 
 
 
pw.println("Company deleted");


}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}