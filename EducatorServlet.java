import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;


public class EducatorServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");

PrintWriter pw=res.getWriter();

Connection con=null;
Statement st1=null,st2=null,st3=null;
ResultSet rs1=null,rs2=null,rs3=null;





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
    pw.println(" <form action='InternshipPost' method='get'>");
    pw.println(" <div class='mid'>");
     pw.println("   <!-- Trigger the modal with a button -->");
 pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal'>Post an Internship</button>");

 pw.println("<!-- Modal -->");
 pw.println("<div id='myModal' class='modal fade' role='dialog'>");
 pw.println("  <div class='modal-dialog'>");

   pw.println("  <!-- Modal content-->");
    pw.println(" <div class='modal-content'>");
      pw.println(" <div class='modal-header'>");
       pw.println("  <button type='button' class='close' data-dismiss='modal'>&times;</button>");
       pw.println("  <h4 class='modal-title'>New Internship</h4>");
      pw.println(" </div>");
     pw.println("  <div class='modal-body'>");
    pw.println("     <div class='form-group'>");
 pw.println("  <label for='usr'>Label:</label>");
 pw.println("  <input type='text' class='form-control' id='usr' name='label'>");
 pw.println("</div>");
          
    pw.println("       <div class='form-group'>");
   pw.println("<label for='comment'>Objective:</label>");
   pw.println("<textarea class='form-control' rows='5' id='comment' name='objective'></textarea>");
 pw.println("</div>");
       pw.println("<div class='form-group'>");
 pw.println("<label for='usr'>Experience Required:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='experience'>");
 pw.println("</div>");
      pw.println("     <div class='form-group'>");
  pw.println(" <label for='usr'>Platform:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='platform'>");
 pw.println("</div>");
   pw.println("        <div class='form-group'>");
   pw.println("<label for='usr'>Applicants Required:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='applicants'>");
 pw.println("</div>");

     pw.println("       <div class='form-group'>");
   pw.println("<label for='usr'>Last date:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='last_date'>");
 pw.println("</div>");
          
 pw.println(" <div class='form-group'>");
   pw.println("<label for='usr'>Working hours per day:</label>");
   pw.println("<input type='text' class='form-control' id='usr' name='working_hours'>");
 pw.println("</div>");

   pw.println(" <label class='radio-inline'><input type='radio' name='optradio' value='work from home'>Work from Home</label>");
 pw.println("<label class='radio-inline'><input type='radio' name='optradio' value='live'>Live</label>");
 pw.println("<label class='radio-inline'><input type='radio' name='optradio' value='both'>Both</label><br/><br/>");
pw.println("Intern_id<input type='text' name='intern_id'><a href='#'>check availabilty</a><br/>");
 pw.println("       <div class='form-group'>");
   pw.println("<label for='usr'>Location:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='location'>");
 pw.println("</div>");
          
 pw.println("       <div class='form-group'>");
   pw.println("<label for='usr'>Company Name:</label>");
  pw.println(" <input type='text' class='form-control' id='usr' name='company_name'>");
 pw.println("</div>");
 
   pw.println("      <button type='submit'>Post</button>");
   pw.println("    </div>");
    pw.println("   <div class='modal-footer'>");
     pw.println("    <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
   pw.println("    </div> </div> </div></div> </div> </form>");
    pw.println("  <main>   ");
    pw.println(" <div class='sep'>");
 pw.println("  <ul class='nav nav-tabs'>");
  pw.println(" <li class='active'><a data-toggle='tab' href='#home'>My Internships</a></li>");
  pw.println(" <li><a href='MessagesServlet'>Messages</a></li>");
  pw.println(" <li><a href='NotieServlet'>Notifications</a></li>");
 pw.println("</ul>");
 pw.println("</div> ");

 pw.println("<div class='tab-content'>");
  pw.println(" <div id='home' class='tab-pane fade in active'>");
   pw.println(" <div class='container'>");
    pw.println(" <div class='row'>");
        




try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from internships where educator='"+phone1+"'");
int i=0;
while(rs2.next())
{

String label=rs2.getString(1);

String objective=rs2.getString(2);

String platform=rs2.getString(4);

String last_date=rs2.getString(6);

String intern_id=rs2.getString(9);




pw.println("<div class='col-sm-4 col-md-4'>");
           pw.println("  <div class='post'>");
               pw.println("  <div class='post-img-content'>");
                    pw.println(" <img src='images/jquery.png' class='img-responsive' />");
                   pw.println("  <span class='post-title'><b>"+label+"</b><br />");
                       pw.println("  <b>"+platform+"</b></span>");
                 pw.println("</div> <div class='content'>");
                    pw.println(" <div class='author'>");
                    pw.println("inter_id=<b>"+intern_id+"</b> |");
                     pw.println("    <time datetime='2014-01-20'>last date="+last_date+"</time>");
                    pw.println(" </div> <div>");
                    pw.println(""+objective+"");
                 
                   pw.println("  </div><div>");
                   pw.println("      <a href='EInternshipView?intern_id="+intern_id+"'>Read more</a>");
                pw.println("     </div></div></div></div>");
     
i++;
if(i%2==0)
{
pw.println("<br/>");

}
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
   
        

pw.println("</div></div> </div>");













}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}