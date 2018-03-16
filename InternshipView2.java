import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InternshipView2 extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");

Connection con=null;
Statement st1=null;
ResultSet rs1=null;

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



 pw.println("<html>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Intern</title>");
 
    pw.println("<link rel='stylesheet' href='css/student.css'>");
    
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'>");
          pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            pw.println("<link rel='stylesheet' href='css/bootstrap-theme.css'>");
              pw.println("<link rel='stylesheet' href='css/<bootstrap-theme.min.css'>");
              
               pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
pw.println("<style>");
 pw.println(".well{background:#2e2c2c;color:#FFFFFF;position:relative;top:-125px;right:70%;border:none;}");
 pw.println("header{width:1510px;background:#000B31;height:75px;color:#F0EBEB;}"); 
pw.println(".bg-primary{width:280px;height:50px;background:#2e2c2c;font-family:Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}");
pw.println("header{font-size:45px;font-family:TOMMY HILFIGER AF;color:#EBEBEB;}");
pw.println("header span{background:#2e2c2c;border-radius:20px;height:30px;}");
pw.println("body{background:#1f2348;width:1510px;}");

pw.println(".mssg{width:80px;height:50px;position:relative;left:50%;bottom:40px;background:none;}");

pw.println(".noti{width:80px;height:50px;position:relative;left:60%;bottom:140px;background:none;}");
pw.println(".video{width:80px;height:50px;position:relative;left:55%;bottom:90px;background:none;}");



pw.println("img{position:relative;bottom:210px;left:85%;}");
pw.println(".settings{position:relative;left:88%;bottom:245px;}");
pw.println(".settings .dropdown button[type='button']{background:none;border:none;color:white;}");



pw.println("section{width:1200px;height:600px;background:#2e2c2c;position:relative;left:20%;top:-530px;border:none;border-radius:5px;}");
pw.println(".panel-body{font-family:TOMMY HILFIGER AF;font-size:18px;background:#D9D9D9;color:#000B31;text-shadow: 2px 2px 8px #373b5f;}");

 pw.println("</style>");
 pw.println("</head>");



pw.println("<body>");
pw.println("<header><span>S</span><span>t</span><span>u</span><span>d</span><span>e</span><span>n</span><span>t</span>");



pw.println("</header>");

pw.println("<div class='mssg'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-envelope'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='MessagesServlet'>View Messages</a></li>");
    
  pw.println("</ul>");
pw.println("</div>");
pw.println("</div>");




pw.println("<div class='video'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-facetime-video'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='#'>no chat</a></li>");
    
  pw.println("</ul>");
pw.println("</div>");
pw.println("</div>");

pw.println("<div class='noti'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-bullhorn'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='NotieServlet'>View notifications</a></li>");
    
  pw.println("</ul>");
pw.println("</div>");
pw.println("</div>");

pw.println("<img src='images/user-png-image-15189.png' class='img-circle' alt='Cinque Terre' width='48' height='50'>");

pw.println("<div class='settings'>");
pw.println("<div class='dropdown'>");
 pw.println("<button type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-cog'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='EducatorProfile'>profile</a></li>");
	 pw.println("<li><a href='ESettings'>settings</a></li>");
     pw.println("<li><a href='EditResumeServlet'>Edit Resume</a></li>");
	 pw.println("<li><a href='Logout'>Logout</a></li>");
    
  pw.println("</ul>");
pw.println("</div>");
pw.println("</div>");
      pw.println("<main>");
	
	
  pw.println("<h2>More Information</h2>");
  pw.println("<form method='get' action='ApplyIntern'>");
    pw.println("<div class='form-group'>");
      pw.println("<label>Why should you be HIRED for this internship?:</label>");
      pw.println("<textarea  class='form-control' placeholder='Enter answer' name='ques1'></textarea>");
    pw.println("</div>");
    pw.println("<div class='form-group'>");
      pw.println("<label>Any Projects?(if yes then mention them!):</label>");
      pw.println("<textarea type='' class='form-control' placeholder='Enter answer' name='ques2'></textarea>");
    pw.println("</div>");
	
	pw.println("<input type='hidden' value='"+intern_id+"' name='intern_id'/>");
  
    pw.println("<input type='submit' value='Submit'/>");
  pw.println("</form>");
    
    
    
             
    pw.println("</main>");
    pw.println("<footer>");
    pw.println("<h1>website</h1>");
    pw.println("</footer>");
            
    
    pw.println("</main>");
    
    
 pw.println("</body>");
pw.println("</html>");
 
 
 
 
}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}




























