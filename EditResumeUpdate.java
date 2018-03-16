import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EditResumeUpdate extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String s1=req.getParameter("name");
String s2=req.getParameter("specialty");
String s3=req.getParameter("address");
String s4=req.getParameter("email");
String s5=req.getParameter("phone");
String s6=req.getParameter("objective");
String s7=req.getParameter("year_s");
String s8=req.getParameter("school");
String s9=req.getParameter("year_c");
String s10=req.getParameter("college");
String s11=req.getParameter("branch");
String s12=req.getParameter("text1");
String s13=req.getParameter("s1");
String s14=req.getParameter("s2");
String s15=req.getParameter("s3");
String s16=req.getParameter("s4");
String s17=req.getParameter("l1");
String s18=req.getParameter("l2");
String s19=req.getParameter("l3");
String s20=req.getParameter("l4");
String s21=req.getParameter("p1");
String s22=req.getParameter("p2");
String s23=req.getParameter("p3");
String s24=req.getParameter("p4");
String s25=req.getParameter("website");



Connection con=null;
Statement st=null;


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
 st.executeUpdate("update resume set name='"+s1+"' where phone='"+s5+"'");
 st.executeUpdate("update resume set specialty='"+s2+"' where phone='"+s5+"'");
 st.executeUpdate("update resume set address='"+s3+"' where phone='"+s5+"'");
 st.executeUpdate("update resume set email='"+s4+"' where phone='"+s5+"'");
 st.executeUpdate("update resume set phone='"+s5+"' where phone='"+s5+"'");
st.executeUpdate("update resume set website='"+s6+"' where phone='"+s5+"'");
st.executeUpdate("update resume set objective='"+s7+"' where phone='"+s5+"'");
st.executeUpdate("update resume set year_s='"+s8+"' where phone='"+s5+"'");
st.executeUpdate("update resume set school='"+s9+"' where phone='"+s5+"'");
st.executeUpdate("update resume set year_c='"+s10+"' where phone='"+s5+"'");
st.executeUpdate("update resume set college='"+s11+"' where phone='"+s5+"'");
st.executeUpdate("update resume set branch='"+s12+"' where phone='"+s5+"'");
st.executeUpdate("update resume set text1='"+s13+"' where phone='"+s5+"'");
st.executeUpdate("update resume set s1='"+s14+"' where phone='"+s5+"'");
st.executeUpdate("update resume set s2='"+s15+"' where phone='"+s5+"'");
st.executeUpdate("update resume set s3='"+s16+"' where phone='"+s5+"'");
st.executeUpdate("update resume set s4='"+s17+"' where phone='"+s5+"'");
st.executeUpdate("update resume set l1='"+s18+"' where phone='"+s5+"'");
st.executeUpdate("update resume set l2='"+s19+"' where phone='"+s5+"'");
st.executeUpdate("update resume set l3='"+s20+"' where phone='"+s5+"'");
st.executeUpdate("update resume set l4='"+s21+"' where phone='"+s5+"'");
st.executeUpdate("update resume set p1='"+s22+"' where phone='"+s5+"'");
st.executeUpdate("update resume set p2='"+s23+"' where phone='"+s5+"'");
st.executeUpdate("update resume set p3='"+s24+"' where phone='"+s5+"'");
st.executeUpdate("update resume set p4='"+s25+"' where phone='"+s5+"'");


 
  
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

res.sendRedirect("SearchServlet");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}