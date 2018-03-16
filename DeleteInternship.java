import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;


public class DeleteInternship extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");

PrintWriter pw=res.getWriter();

Connection con=null;
Statement st1=null,st2=null,st3=null;
ResultSet rs1=null,rs2=null,rs3=null;


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

HttpSession session=req.getSession();
String phone1=(String)session.getAttribute("mob");



        
 
try
 {
 st1=con.createStatement();
 st1.executeUpdate("delete from internships where internid='"+intern_id+"'");



rs2.close();
st2.close();
}

catch(SQLException e4)
 {
 pw.println(e4);
 }
catch(Exception e5)
 {
 pw.println(e5);
 }
   
res.sendRedirect("EducatorServlet");        













}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}