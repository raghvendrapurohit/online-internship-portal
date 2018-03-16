import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminSetting extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

HttpSession session=req.getSession();
String sp=(String)session.getAttribute("phone");

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
   pw.println("<h2>Change Account Settings</h2>");
  
  pw.println("<form action='UpdateAdminSettings' method='get'>");
   pw.println("<div class='tab-content'>");
  
     pw.println("<div id='home' class='tab-pane fade in active'>");
    
     pw.println("<table>");


 try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from admins where mobno='"+sp+"' ");

int i=0; 
 while(rs2.next())
 {
s1=rs2.getString(1);
s2=rs2.getString(2);
s3=rs2.getString(3);
s4=rs2.getString(4);
s5=rs2.getString(5);
s6=rs2.getString(6);

     
 pw.println("<tr><td><label>Username:</label></td><td>");
     
 pw.println("<input type='text' value='"+s1+"' name='name'/></td></tr><br/>");
 pw.println("<tr><td><label>Mobile no:</label></td>");
 pw.println("<td><input type='text' value='"+s2+"' readonly='readonly' name='mobno'/></td></tr><br/>");
 pw.println("<tr><td><label>Password:</label></td>");
 pw.println("<td><input type='text' value='"+s3+"'name='pwd'/></td></tr><br/>");
 pw.println("<tr><td><label>ID:</label></td>");
 pw.println("<td><input type='text' value='"+s4+"' name='id' /></td></tr><br/>");
 pw.println("<tr><td><label>email:</label></td>");
 pw.println("<td><input type='text' value='"+s5+"' name='email'/></td></tr><br/>");
 pw.println("<tr><td><label>preference:</label></td>");
 pw.println("<td><input type='text' value='"+s6+"' readonly='readonly' name='pref'/></td></tr><br/>");

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