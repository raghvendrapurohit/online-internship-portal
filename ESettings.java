import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ESettings extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

HttpSession session=req.getSession();
String user=(String)session.getAttribute("mob");

String s1="",s2="",s3="",s4="",s5="",s6="";

Connection con=null;
Statement st2=null;
ResultSet rs2=null;

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

pw.println("<!doctype html>");
pw.println("<html>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Untitled Document</title>");


pw.println("<link rel='stylesheet' href='css/setting.css'>");
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'>");
        
          pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            pw.println("<link rel='stylesheet' href='css/bootstrap-theme.css'>");
              pw.println("<link rel='stylesheet' href='css/<bootstrap-theme.min.css'>");
              
               pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");

pw.println("</head>");

pw.println("<body>");

 pw.println("<div class='container'>");
   pw.println("<h2>Account Settings</h2>");
  
  pw.println("<form action='EUpdateProfile' method='get'>");
   pw.println("<div class='tab-content'>");
    
     pw.println("<div id='home' class='tab-pane fade in active'>");
     pw.println("<img src='images/2.jpg' class='img-circle' alt='Cinque Terre' width='304' height='236'><br/>");
     pw.println("<span><a href='#'>Change image<h4 class='glyphicon glyphicon-pencil'></h4></a></span><br/>");
     pw.println("<table>");


 try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from profile where mobno='"+user+"' ");

int i=0; 
 while(rs2.next())
 {
s1=rs2.getString(1);
s2=rs2.getString(2);
s3=rs2.getString(3);
s4=rs2.getString(6);
s5=rs2.getString(7);
s6=rs2.getString(8);

     
 pw.println("<tr><td><label>Username:</label></td><td>");
     
 pw.println("<input type='text' value='"+s1+"' name='name'/></td></tr><br/>");
 pw.println("<tr><td><label>Full name:</label></td>");
 pw.println("<td><input type='text' value='"+s5+"' name='fullname'/></td></tr><br/>");
 pw.println("<tr><td><label>D.O.B:</label></td>");
 pw.println("<td><input type='text' value='"+s4+"'name='D.O.B'/></td></tr><br/>");
 pw.println("<tr><td><label>Address:</label></td>");
 pw.println("<td><input type='text' value='"+s6+"' name='address' /></td></tr><br/>");
 pw.println("<tr><td><label>Phone:</label></td>");
 pw.println("<td><input type='text' value='"+s3+"' readonly='readonly' name='phone'/></td></tr><br/>");
 pw.println("<tr><td><label>Email:</label></td>");
 pw.println("<td><input type='text' value='"+s2+"' name='email'/></td></tr><br/>");

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


 pw.println("</table>");
 pw.println("<button type='submit'>Submit</button>");

 pw.println("</form>");

      pw.println("</div>");
     
     
   
  
 pw.println("</div>");
 pw.println("<footer>");
 pw.println("website");
 pw.println("</footer>");



 pw.println("</body>");
 pw.println("</html>");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}