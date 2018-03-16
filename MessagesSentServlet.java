import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MessagesSentServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

Connection con=null;
Statement st=null;
ResultSet rs=null;

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

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("  <title>Message</title>");
 pw.println(" <meta charset='utf-8'>");
 pw.println(" <meta name='viewport' content='width=device-width, initial-scale=1'>");
 pw.println(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
 pw.println("  <link rel='stylesheet' href='css/messagessent.css'>");
 pw.println(" <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
 pw.println(" <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
pw.println("<style>");
pw.println(".list-group a span{margin-right:215px;}");
pw.println("</style>");

pw.println("</head>");
pw.println("<body>");

pw.println("<div class='jumbotron'>");
pw.println("  <h1>Messages</h1>     "); 

pw.println("</div>");

pw.println("<div class='container'>");

pw.println(" <div class='alert alert-info'>");
 pw.println("   <a href='#' class='alert-link'><strong>Sent Messages</strong></a>");
 pw.println("   <form>");
 pw.println(" <div class='input-group'>");
 pw.println("   <input type='text' class='form-control' placeholder='Search Message'>");
 pw.println("   <div class='input-group-btn'>");
 pw.println("     <button class='btn btn-default' type='submit'>");
 pw.println("       <i class='glyphicon glyphicon-search'></i>");
 pw.println("     </button>");
 pw.println("   </div>");
 pw.println(" </div>");
pw.println("</form>");
pw.println("</div>");
  
 pw.println(" <div class='list-group'>");


 try
 {
 st=con.createStatement();
 rs=st.executeQuery("select * from messages where from_mob='"+phone1+"'");
 
while(rs.next())
{
 String to_email=rs.getString(4);
 String date=rs.getString(5);
 String subject=rs.getString(6); 

 pw.println(" <a href='#' class='list-group-item'>");
pw.println("<span>"+to_email+"</span>");
pw.println("<span>"+subject+"</span>");
pw.println("<span>"+date+"</span>");
pw.println("<span><a class='glyphicon glyphicon-trash' href='MessagesManage?to_email="+to_email+"&subject="+subject+"&date="+date+"&cat=sent'>Delete</a></span>");
pw.println("</a>");

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
  
  
pw.println("  <div class='sidesection'>");

 pw.println(" <!-- Trigger the modal with a button -->");
 pw.println(" <button type='button' class='btn btn-info btn-lg' name='compose' data-toggle='modal' data-target='#myModal'>Compose</button>");
 pw.println(" <form method='get' action='MessageSend'>");
 pw.println(" <!-- Modal -->");
pw.println("  <div class='modal fade' id='myModal' role='dialog'>");
pw.println("    <div class='modal-dialog modal-lg'>");
pw.println("      <div class='modal-content'>");
 pw.println("       <div class='modal-header'>");
 pw.println("         <button type='button' class='close' data-dismiss='modal'>&times;</button>");
 pw.println("         <h4 class='modal-title'>Message</h4>");
 pw.println("       </div>");
 pw.println("       <div class='modal-body'>");
  pw.println("      <div class='form-group'>");
  pw.println("      <label>TO:</label><br/>");
  pw.println("<label for='usr'>Phone no:</label>");
 pw.println(" <input type='text' name='phone' class='form-control' id='usr'>");
pw.println("</div>");
pw.println("<div class='form-group'>");
pw.println("  <label for='pwd'>email:</label>");
pw.println("  <input type='text' name='email' class='form-control' id='pwd'>");
 
pw.println("</div>");
pw.println("<div class='form-group'>");
pw.println("  <label for='pwd'>Subject:</label>");
pw.println("  <input type='text' name='subject' class='form-control' id='pwd");
 
pw.println("</div>");

pw.println("<div class='form-group'>");
 pw.println(" <label for='comment'>Your Message:</label>");
 pw.println(" <textarea name='message' class='form-control' rows='5' id='comment'></textarea>");
pw.println("</div>");
 pw.println("       </div>");
 pw.println("       <div class='modal-footer'>");
  pw.println("        <input type='submit' class='btn btn-primary' value='Send'/>");
  pw.println("        <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
  pw.println("      </div>");
  pw.println("    </div>");
  pw.println("  </div>");
 pw.println(" </div>");
 pw.println(" </form>");
 pw.println(" <br/>");
 
pw.println("  <div class='mssgsection'>");
 pw.println("  <a href='MessagesServlet' class='btn btn-success btn-lg'>");
 pw.println("     <span class='glyphicon glyphicon-inbox'></span> Inbox ");
 pw.println("   </a><br/><br/>");
   
 pw.println("  <a href='MessagesSentServlet' class='btn btn-primary btn-lg'>");
  pw.println("    <span class='glyphicon glyphicon-envelope'></span> Sent Messages");
  pw.println("  </a><br/><br/>");
    

   pw.println("  <a href='MessagesTrashServlet' class='btn btn-warnings btn-lg'>");
   pw.println("   <span class='glyphicon glyphicon-trash'></span> Trash </a>");
pw.println("</div></div>");
pw.println("<ul class='pager'>");
 pw.println(" <li><a href='#'>Previous</a></li>");
pw.println("  <li><a href='#'>Next</a></li>");
pw.println("</ul></div></body></html>");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);

}

}
