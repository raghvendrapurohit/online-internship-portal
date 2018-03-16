import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;


public class EInternshipEdit extends HttpServlet
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


 pw.println("<html>");
 pw.println("<head>");
 pw.println("<meta charset='utf-8'>");
 pw.println("<title>educator</title>");
     

      pw.println("   <link rel='stylesheet' href='css/educator.css'>");
       pw.println("  <link rel='stylesheet' href='css/bootstrap.css'>");
       pw.println("    <link rel='stylesheet' href='css/bootstrap.min.css'>");
         pw.println("    <link rel='stylesheet' href='css/bootstrap-theme.css'>");
         pw.println("      <link rel='stylesheet' href='css/bootstrap-theme.min.css'>");
             pw.println("<style> header h2{font-size: 20px;position:relative;bottom:52px;left:22%;border-bottom: 0.1px solid white;color: white;}</style>");
           pw.println("     <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
   pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
    pw.println(" </head>");
 pw.println("<body>");
  pw.println("  <header>");
      pw.println("  <h1>EDUCATOR</h1>");
       pw.println(" <h2>Let's Hire !!</h2>");
try
 {
 st1=con.createStatement();
  
 rs1=st1.executeQuery("select * from profile where mobno='"+phone1+"'");
 while(rs1.next())
{

  pw.println(" <h3>"+rs1.getString(1)+"</h3>");
}  
  rs1.close();
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


    
        pw.println("<div class='po'>");
       pw.println(" <img src='images/user-png-image-15189.png' class='img-circle' alt='Cinque Terre' width='48' height='50'>");
     pw.println("   <div class='settings'>");
 pw.println("<div class='dropdown'>");
 pw.println(" <button type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-cog'></span></button>");
  
  pw.println(" <ul class='dropdown-menu'>");
    pw.println(" <li><a href='EducatorProfile'>profile</a></li>");
	 pw.println(" <li><a href='ESettings'>settings</a></li>");
  
	 pw.println("  <li><a href='Logout'>Logout</a></li>");
    
  pw.println(" </ul>");
 pw.println("</div>");
 pw.println("</div>");
       pw.println("     </div>");
       pw.println("     </header>");
   




try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from internships where internid='"+intern_id+"'");

while(rs2.next())
{

String label=rs2.getString(1);
String objective=rs2.getString(2);
String experience=rs2.getString(3);
String platform=rs2.getString(4);
String applicants=rs2.getString(5);
String last_date=rs2.getString(6);
String working_hours=rs2.getString(7);
String work_from=rs2.getString(8);
intern_id=rs2.getString(9);
String location=rs2.getString(10);
String company_name=rs2.getString(11);


pw.println("<form method='get' action='EInternshipUpdate'>");
pw.println("<h2><b><u>LABEL:</u></b><input type='text' value='"+label+"' name='label'/></h2>");
pw.println("<h2><b><u>Objective:</u></b>  <input type='text' value='"+objective+"' name='objective'/></h2>");
pw.println("<h2><b><u>Experience:</u></b>  <input type='text' value='"+experience+"' name='experience'/></h2>");
pw.println("<h2><b><u>Platform:</u></b>  <input type='text' value='"+platform+"' name='platform'/></h2>");
pw.println("<h2><b><u>Applicants:</u></b>  <input type='text' value='"+applicants+"' name='applicants'/></h2>");
pw.println("<h2><b><u>Last Date:</u></b>  <input type='text' value='"+last_date+"' name='last_date'/></h2>");     
pw.println("<h2><b><u>Working Hours:</u></b>  <input type='text' value='"+working_hours+"' name='working_hours'/></h2>");
pw.println("<h2><b><u>Work_from:</u></b>  <input type='text' value='"+work_from+"' name='work_from'/></h2>");
pw.println("<h2><b><u>Intern id:</u></b>  <input type='text' readonly='readonly' value='"+intern_id+"' name='intern_id'/></h2>");
pw.println("<h2><b><u>Location:</u></b>  <input type='text' value='"+location+"' name='location'/></h2>");
pw.println("<h2><b><u>Company Name:</u></b>  <input type='text' value='"+company_name+"' name='company_name'/></h2>");
pw.println("<button type='submit' class='btn btn-warning'>Submit</button>");
pw.println("</form>");















}

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
   
        













}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}