import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EResumeOpen extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

Connection con=null;
Statement st1=null,st2=null,st3=null;;
ResultSet rs1=null,rs2=null,rs3=null;

String user=req.getParameter("user");


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
 rs2=st2.executeQuery("select * from resume where phone='"+user+"'");

 
 while(rs2.next())
 {

String name=rs2.getString(1);
String specialty=rs2.getString(2);
String address=rs2.getString(3);
String email=rs2.getString(4);
String phone=rs2.getString(5);
String website=rs2.getString(6);
String objective=rs2.getString(7);
String year_s=rs2.getString(8);
String school=rs2.getString(9);
String year_c=rs2.getString(10);
String college=rs2.getString(11);
String branch=rs2.getString(12);
String Experience=rs2.getString(13);
String s1=rs2.getString(14);
String s2=rs2.getString(15);
String s3=rs2.getString(16);
String s4=rs2.getString(17);
String l1=rs2.getString(18);
String l2=rs2.getString(19);
String l3=rs2.getString(20);
String l4=rs2.getString(21);
String p1=rs2.getString(22);
String p2=rs2.getString(23);
String p3=rs2.getString(24);
String p4=rs2.getString(25);

pw.println("<h2><b><u>Name:</u></b>  "+name+"</h2>");
pw.println("<h2><b><u>specialty:</u></b>  "+specialty+"</h2>");
pw.println("<h2><b><u>address:</u></b>  "+address+"</h2>");
pw.println("<h2><b><u>email:</u></b>  "+email+"</h2>");
pw.println("<h2><b><u>phone:</u></b>  "+phone+"</h2>");
pw.println("<h2><b><u>website:</u></b>  "+website+"</h2>");
pw.println("<h2><b><u>objective:</u></b>  "+objective+"</h2>");
pw.println("<h2><b><u>years under school:</u></b>  "+year_s+"</h2>");
pw.println("<h2><b><u>school:</u></b>  "+school+"</h2>");
pw.println("<h2><b><u>years under college:</u></b>  "+year_c+"</h2>");
pw.println("<h2><b><u>college:</u></b>  "+college+"</h2>");
pw.println("<h2><b><u>branch:</u></b>  "+branch+"</h2>");
pw.println("<h2><b><u>Experience:</u></b>  "+Experience+"</h2>");
pw.println("<h2><b><u>Skills:</u></b> <br/></h2>");
pw.println("<h2><b><u>Software Knowledge:</u></b><br/></h2>");
pw.println("<h2>"+s1+","+s2+","+s3+","+s4+"</h2>");
pw.println("<h2><b><u>Languages:</u></b> <br/></h2>");
pw.println("<h2>"+l1+","+l2+","+l3+","+l4+"</h2>");
pw.println("<h2><b><u>Projects</u></b><br/></h2>");
pw.println("<h2>"+p1+","+p2+","+p3+","+p4+"</h2>");



}

 rs2.close();
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

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}