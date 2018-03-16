import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InternshipPost extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st=null;
ResultSet rs=null;


HttpSession session=req.getSession();
String phone1=(String)session.getAttribute("mob");

String label=req.getParameter("label");
String objective=req.getParameter("objective");
String experience=req.getParameter("experience");
String platform=req.getParameter("platform");
String applicants=req.getParameter("applicants");
String last_date=req.getParameter("last_date");
String working_hours=req.getParameter("working_hours");
String work_from=req.getParameter("optradio");
String internid=req.getParameter("intern_id");
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

try
 {
 st=con.createStatement();

 st.executeUpdate("insert into internships values('"+label+"','"+objective+"','"+experience+"','"+platform+"','"+applicants+"','"+last_date+"','"+working_hours+"','"+work_from+"','"+internid+"','"+location+"','"+company_name+"','"+phone1+"')");

 res.sendRedirect("EducatorServlet");




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
