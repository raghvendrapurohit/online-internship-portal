import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminMessageView extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");


String from_mob=req.getParameter("sender");
String to_mob=req.getParameter("receiver");




Connection con=null;
Statement st1=null;
ResultSet rs1=null;


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

pw.println("<div class='jumbotron'>");
  pw.println("<h1>View Message</h1>");
  pw.println("<p>From mob:"+from_mob+"   To mob:"+to_mob+"</p>");
  
pw.println("</div>");

pw.println("<div class='container'>");

 try
 {
 st1=con.createStatement();
 rs1=st1.executeQuery("select * from messages where from_mob='"+from_mob+"' and to_mob='"+to_mob+"'");
 int i=0;
while(rs1.next())
{
String from_email=rs1.getString(3);
String to_email=rs1.getString(4);
String date=rs1.getString(5);
String subject=rs1.getString(6);
String message=rs1.getString(7);


pw.println("<div class='panel-group'>");
  pw.println("<div class='panel panel-default'>");
    pw.println("<div class='panel-heading'>");
     pw.println(" <h4 class='panel-title'>");
        pw.println("<a data-toggle='collapse' href='#"+i+"'><strong>Subject:</strong>"+subject+"</a>");
      pw.println("</h4>");
    pw.println("</div>");
    pw.println("<div id='"+i+"' class='panel-collapse collapse'>");
      pw.println("<ul class='list-group'>");
        pw.println("<li class='list-group-item'><strong>date:</strong>"+date+"</li>");
		 
  pw.println("<li class='list-group-item'><strong>Receivers email:"+to_email+"</li>");
   pw.println("<li class='list-group-item'><strong>Senders email:"+from_email+"</li>");  
      pw.println("</ul>");
      pw.println("<div class='panel-footer'><strong>Message:</strong>"+message+"</div>");
    pw.println("</div>");
  pw.println("</div>");
pw.println("</div> ");    
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




 
pw.println("</div>");

pw.println("</body>");
pw.println("</html>");

}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}
