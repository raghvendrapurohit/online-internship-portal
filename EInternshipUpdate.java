import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;


public class EInternshipUpdate extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");

PrintWriter pw=res.getWriter();

Connection con=null;
Statement st1=null,st2=null,st3=null;
ResultSet rs1=null,rs2=null,rs3=null;


String label=req.getParameter("label");
String objective=req.getParameter("objective");
String experience=req.getParameter("experience");
String platform=req.getParameter("platform");
String applicants=req.getParameter("applicants");
String last_date=req.getParameter("last_date");
String working_hours=req.getParameter("working_hours");
String work_from=req.getParameter("work_from");
String intern_id=req.getParameter("intern_id");
String location=req.getParameter("location");
String company_name=req.getParameter("company_name");


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
 st1.executeUpdate("update internships set label='"+label+"',objective='"+objective+"',experience='"+experience+"',platform='"+platform+"',applicants='"+applicants+"',last_date='"+last_date+"',working_hours='"+working_hours+"',work_from='"+work_from+"',location='"+location+"',company_name='"+company_name+"' where internid='"+intern_id+"'");



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