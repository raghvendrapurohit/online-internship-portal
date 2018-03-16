import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminResumeView extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");

String mobno=req.getParameter("viewresume");

String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",s10="",s11="",s12="",s13="",s14="",s15="",s16="",s17="",s18="",s19="",s20="",s21="",s22="",s23="",s24="",s25="";

Connection con=null;
Statement st2=null;
ResultSet rs=null;


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

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
  pw.println("<title>Bootstrap Example</title>");
  pw.println("<meta charset='utf-8'>");
  pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
  pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
  pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
pw.println("</head>");
pw.println("<body>");

pw.println("<div class='container'>");
  pw.println("<div class='jumbotron'>");
    pw.println("<h1>Resume</h1>");
    pw.println("<p>Of user: "+mobno+"</p>");
  pw.println("</div>");
  try
 {
 st2=con.createStatement();
 rs=st2.executeQuery("select * from resume where phone='"+mobno+"'");
  while(rs.next())
  {
s1=rs.getString(1);
  s2=rs.getString(2);
  s3=rs.getString(3);
  s4=rs.getString(4);
  s5=rs.getString(5);
 s6=rs.getString(6);
 s7=rs.getString(7);
s8=rs.getString(8);
s9=rs.getString(9);
s10=rs.getString(10);
s11=rs.getString(11);
s12=rs.getString(12);
s13=rs.getString(13);
s14=rs.getString(14);
s15=rs.getString(15);
s16=rs.getString(16);
s17=rs.getString(17);
s18=rs.getString(18);
s19=rs.getString(19);
s20=rs.getString(20);
s21=rs.getString(21);
s22=rs.getString(22);
s23=rs.getString(23);
s24=rs.getString(24);
s25=rs.getString(25);
	  
  pw.println("<p><label>Name:</label>"+s1+"</p>");
 pw.println("<p><label>Specialty:</label>"+s2+"</p>");    
  pw.println("<p><label>address:</label>"+s3+"</p>");    
   pw.println("<p><label>email:</label>"+s4+"</p>");    
    pw.println("<p><label>phone:</label>"+s5+"</p>");    
	 pw.println("<p><label>website:</label>"+s6+"</p>");    
	  pw.println("<p><label>objective:</label>"+s7+"</p>");    
	   pw.println("<p><label>Years under School:</label>"+s8+"</p>");    
	    pw.println("<p><label>School name:</label>"+s9+"</p>");    
		  pw.println("<p><label>Years under College:</label>"+s10+"</p>");    
		    pw.println("<p><label>College name:</label>"+s11+"</p>");    
			  pw.println("<p><label>Branch:</label>"+s12+"</p>");  
pw.println("<p><label>Experience:</label>"+s13+"</p>");  
pw.println("<p><label>Softwares knowown:</label>"+s14+","+s15+","+s16+","+s17+"</p>");  
pw.println("<p><label>Languages Known:</label>"+s18+","+s19+","+s20+","+s21+"</p>");  
pw.println("<p><label>Projects:</label>"+s22+","+s23+","+s24+","+s25+"</p>");  
  }
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


			       
pw.println("</div>");

pw.println("</body>");
pw.println("</html>");

 
 
 
 
 
 

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}