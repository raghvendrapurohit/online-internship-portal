import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InternSearch extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
String cat1="",star1="",loc1="";

Connection con=null;
Statement st1=null,st2=null,st3=null,st4=null;
ResultSet rs1=null,rs2=null,rs3=null,rs4=null;



cat1=req.getParameter("cat");
loc1=req.getParameter("loc");
star1=req.getParameter("star");


long h1=cat1.hashCode();
long h2=loc1.hashCode();
long h3=star1.hashCode();
String s7="Any Category";
long hh1=s7.hashCode();
String s8="Any Location";
long hh2=s8.hashCode();
String s9="Any Startup";
long hh3=s9.hashCode();
String s10="";
long hh4=s10.hashCode();

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
  
  pw.println("<style>");
  pw.println(".cats{width:150px;position:relative;left:1%;}");
  pw.println(".container{position:relative;bottom:250px;}");
  pw.println("</style>");

  pw.println("</head>");
pw.println("<body>");

pw.println("<div class='jumbotron'>");
  pw.println("<h1>Search Internships:</h1>");
  pw.println("<a href='signup.html'><button type='button' class='btn btn-success'>Register</button></a>");
   pw.println("<a href='Front'><button type='button' class='btn btn-info'>Login</button></a>");
pw.println("</div>");



 
 
 pw.println("<div class='cats'>");
 pw.println("<form method='get' action='InternSearch'>");
   pw.println("<div class='form-group'>");
 pw.println("<label for='location1' class='control-label'>Category</label>");
  pw.println("<select  class='form-control' name='cat' id='location1' >");
 
 
 try
   {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from interncat");


while(rs2.next())
{
String cat=rs2.getString(1);
   if(cat.equals(cat1))
       pw.println("<option value='"+cat+"' selected>"+cat+"</option>");
   else 
   pw.println("<option value='"+cat+"'>"+cat+"</option>");



}
  pw.println("</select></div>");
 
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }

  pw.println("<div class='form-group'>");
 pw.println("<label for='location1' class='control-label'>Location</label>");
  pw.println("<select  class='form-control' name='loc' id='location1' >");
 

 try
   {
 st3=con.createStatement();
 rs3=st3.executeQuery("select * from internloc");
 

while(rs3.next())
{
String loc=rs3.getString(1);

  if(loc.equals(loc1))
       pw.println("<option value='"+loc+"' selected>"+loc+"</option>");
   else 
   pw.println("<option value='"+loc+"'>"+loc+"</option>");
}
  pw.println("</select></div>");
 
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }

  
  pw.println("<div class='form-group'>");
 pw.println("<label for='location1' class='control-label'>Startup/Company name</label>");
  pw.println("<select  class='form-control' name='star' id='location1' >");
   
   
   try
   {
 st4=con.createStatement();
 rs4=st4.executeQuery("select * from internstartup");


while(rs4.next())
{
String star=rs4.getString(1);

   if(star.equals(star1))
       pw.println("<option value='"+star+"' selected>"+star+"</option>");
   else 
   pw.println("<option value='"+star+"'>"+star+"</option>");

}
  pw.println("</select></div>");
 
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }


   pw.println("<br/><input type='submit' class='btn btn-primary' value='Search'/>");
  pw.println("</form></div>");
 

 try
 {
 st1=con.createStatement();
 
 if(h2==hh2 && h3!=hh3 && h1!=hh1)
rs1=st1.executeQuery("select * from internships where platform='"+cat1+"' and company_name='"+star1+"'");

else if(h3==hh3 && h2!=hh2 && h1!=hh1)
rs1=st1.executeQuery("select * from internships where platform='"+cat1+"' and location='"+loc1+"'");

else if(h1==hh1 && h3!=hh3 && h2!=hh2) 
rs1=st1.executeQuery("select * from internships where location='"+loc1+"' and company_name='"+star1+"'");

else if(h2==hh2  && h3==hh3 && h1!=hh1)
rs1=st1.executeQuery("select * from internships where platform='"+cat1+"'");

else if(h3==hh3 && h1==hh1 && h2!=hh2)
rs1=st1.executeQuery("select * from internships where location='"+loc1+"'");

else if(h2==hh2 && h1==hh1 && h3!=hh3)
rs1=st1.executeQuery("select * from internships where company_name='"+star1+"'");

else if(h1==hh1 && h3==hh3 && h2==hh2)
rs1=st1.executeQuery("select * from internships");

else if(h1!=hh4 && h2==hh4 && h3==hh4)
rs1=st1.executeQuery("select * from internships where platform='"+cat1+"'");

else if(h2!=hh4 && h1==hh4 && h3==hh4)
rs1=st1.executeQuery("select * from internships where location='"+loc1+"'");

else if(h3!=hh4 && h2==hh4 && h3==hh4)
rs1=st1.executeQuery("select * from internships where comapany_name='"+star1+"'");

else
rs1=st1.executeQuery("select * from internships where platform='"+cat1+"' and location='"+loc1+"' and company_name='"+star1+"'");
 
 int i=0;
while(rs1.next())
{
String label=rs1.getString(1);
String objective=rs1.getString(2);
String internid=rs1.getString(9);

 
pw.println("<div class='container'>");
	pw.println("<h2>Internship</h2>");
  pw.println("<div class='panel-group'>");
 pw.println("<div class='panel panel-info'>");
      pw.println("<div class='panel-heading'>"+label+"<input type='hidden' value='"+internid+"' name='internid'></div>");
      pw.println("<div class='panel-body'>"+objective+"<br/>");
	
	       pw.println("<a href='ViewInternshipWL?viewintern="+internid+"'>View full Internship</a></div>");
	  
	             
    pw.println("</div>");
 
  pw.println("</div>");
  pw.println("</div>");

i++;
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
 

 


pw.println("</body>");
pw.println("</html>");

}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}
