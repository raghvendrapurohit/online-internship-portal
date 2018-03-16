import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MakeAdmin extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");





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
   pw.println("<h2>Make a new Admin:</h2>");
  
  pw.println("<form action='AddAdmin' method='get'>");
   pw.println("<div class='tab-content'>");
  
     pw.println("<div id='home' class='tab-pane fade in active'>");
    
     pw.println("<table>");



     
 pw.println("<tr><td><label>Username:</label></td><td>");
     
 pw.println("<input type='text' placeholder='Enter the name of the new Admin' name='name'/></td></tr><br/>");
 pw.println("<tr><td><label>Mobile no:</label></td>");
 pw.println("<td><input type='text' placeholder='Enter his mobile no' name='mobno'/></td></tr><br/>");
 pw.println("<tr><td><label>Password:</label></td>");
 pw.println("<td><input type='text' placeholder='password'name='pwd'/></td></tr><br/>");
 pw.println("<tr><td><label>ID:</label></td>");
 pw.println("<td><input type='text' placeholder='type a ID' name='id' /></td></tr><br/>");
 pw.println("<tr><td><label>email:</label></td>");
 pw.println("<td><input type='text' placeholder='Enter his email' name='email'/></td></tr><br/>");
 pw.println("<tr><td><label>preference:</label></td>");
 pw.println("<td><input type='text' value='2' name='pref' readonly='readonly' /></td></tr><br/>");




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