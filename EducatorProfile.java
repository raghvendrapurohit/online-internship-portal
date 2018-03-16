import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EducatorProfile extends HttpServlet
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


pw.println("<link rel='stylesheet' href='css/profile.css'>");
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'>");
        
          pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            pw.println("<link rel='stylesheet' href='css/bootstrap-theme.css'>");
              pw.println("<link rel='stylesheet' href='css/<bootstrap-theme.min.css'>");
              
               pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");

pw.println("</head>");

pw.println("<body>");

pw.println("<header>");
pw.println("<img src='images/2.jpg' class='img-circle' alt='Cinque Terre' width='304' height='236'><br/>");
pw.println("<strong>User Details:</strong>");
pw.println("<span><a href='ESettings'>Edit Profile  <h4 class='glyphicon glyphicon-pencil'></h4></a></span>");
pw.println("</header>");

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
s6=rs2.getString(7);
s5=rs2.getString(8);

pw.println("<main>");
pw.println("<div class='data'>");
pw.println("<label>Full name:</label>");
pw.println(s6+"<br/>");
pw.println("<label>D.O.B:</label>");
pw.println(s4+"<br/>");
pw.println("<label>Address:</label>");
pw.println(s5+"<br/>");
pw.println("<label>Phone:</label>");
pw.println(s3+"<br/>");
pw.println("<label>Email:</label>");
pw.println(s2);
pw.println("</div>");
pw.println("<div class='resume'>");
pw.println("<h1>Resume</h1>");
pw.println("<label>file: </label>");
pw.println("<a href='#'>myresume.txt</a><br/>");
pw.println("</div>");
pw.println("</main>");


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

pw.println("<footer>");
pw.println("Website");

pw.println("</footer>");


pw.println("</body>");
pw.println("</html>");


}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}