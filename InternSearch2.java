import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InternSearch2 extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

String s1="",s2="",s3="",s4="",s5="",cat="",loc="",star="",cat1="",star1="",loc1="";

cat=req.getParameter("cat");

loc=req.getParameter("loc");
star=req.getParameter("star");


long h1=cat.hashCode();
long h2=loc.hashCode();
long h3=star.hashCode();
String s7="Any Category";
long hh1=s7.hashCode();
String s8="Any Location";
long hh2=s8.hashCode();
String s9="Any Startup";
long hh3=s9.hashCode();
String s10="";
long hh4=s10.hashCode();
           

Connection con=null;
Statement st1=null,st2=null,st3=null,st4=null;
ResultSet rs1=null,rs2=null,rs3=null,rs4=null;

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
pw.println("<title>search</title>");

        pw.println(" <link rel='stylesheet' href='css/student.css'>");
       pw.println(" <link rel='stylesheet' href='css/bootstrap.css'>");
          pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            pw.println("<link rel='stylesheet' href='css/bootstrap-theme.css'>");
              pw.println("<link rel='stylesheet' href='css/bootstrap-theme.min.css'>");
              
              pw.println(" <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
  pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
pw.println("<style>");
 pw.println(".well{background:#2e2c2c;color:#FFFFFF;position:relative;top:-125px;right:70%;border:none;}");
 pw.println(" header{width:1510px;background:#000B31;height:75px;color:#F0EBEB;}");
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
pw.println(".container div[class='interns'] h2{background-color:cadetblue;width: 80px;height: 91px;border-radius: 0px 0px 0px 8px;color: white; position: relative;bottom: 20px;padding:15px 8px;}");
pw.println(".interns h3{position: relative;bottom:120px;left:8%;width:680px; }");
pw.println(".panel-body{font-family:TOMMY HILFIGER AF;font-size:18px;background:#D9D9D9;color:#000B31;text-shadow: 2px 2px 8px #373b5f;}");
pw.println(".interns h4{position: relative;bottom:210px;left:70%;}");
pw.println("main{color: white;background-color:#6c9fbf;position: relative;bottom: 220px;text-align: center;height: 700px;}");
pw.println("main h3{color: black;}");
pw.println("main button{color: blue;}");
pw.println("footer{height: 200px;background-color:#2e2c2c;}");

 pw.println("</style></head><body>");
pw.println("<header><span>S</span><span>t</span><span>u</span><span>d</span><span>e</span><span>n</span><span>t</span>");

pw.println("</header>");

pw.println("<div class='mssg'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-envelope'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='#'>no messages</a></li>");
     pw.println("<li><a href='MessagesServlet'>View all</a></li>");
    
  pw.println("</ul></div></div>");

pw.println("<div class='video'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-facetime-video'></span></button>");
  
 pw.println(" <ul class='dropdown-menu'>");
    pw.println("<li><a href='#'>no chat</a></li>");
    
  pw.println("</ul></div></div>");

pw.println("<div class='noti'>");
pw.println("<div class='dropdown'>");
 pw.println("<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-bullhorn'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='#'>no notifications</a></li>");
pw.println("<li><a href='SNotieServlet'>View all</a></li>");
    
  pw.println("</ul></div></div>");

pw.println("<img src='images/user-png-image-15189.png' class='img-circle' alt='Cinque Terre' width='48' height='50'>");

pw.println("<div class='settings'>");
pw.println("<div class='dropdown'>");
 pw.println("<button type='button' data-toggle='dropdown'><span class='glyphicon glyphicon-cog'></span></button>");
  
  pw.println("<ul class='dropdown-menu'>");
    pw.println("<li><a href='Profile'>profile</a></li>");
	 pw.println("<li><a href='Settings'>settings</a></li>");
         pw.println(" <li><a href='EditResumeServlet'>Edit Resume</a></li>");
	 pw.println(" <li><a href='Logout'>Logout</a></li>");
    
  pw.println("</ul></div></div>");


pw.println("<div class='container'>");
	pw.println("<div class='row'>");
	
 	pw.println("<div class='col-lg-3 col-md-6 col-md-offset-3 col-lg-offset-0'>");
      pw.println("<div class='well'>");
      pw.println("<h3 align='center'>Search Interships</h3>");
        pw.println("<form class='form-horizontal' method='get' action='InternSearch2'>");
 pw.println("<div class='form-group'>");

    pw.println("<label for='location1' class='control-label'>Category</label>");
    pw.println("<select class='form-control' name='cat' id='location1'>");

 try
 {
 st1=con.createStatement();
 rs1=st1.executeQuery("select * from interncat");


while(rs1.next())
   { 
   cat1=rs1.getString(1);
   if(cat1.equals(cat))
       pw.println("<option value='"+cat1+"' selected>"+cat1+"</option>");
   else 
   pw.println("<option value='"+cat1+"'>"+cat1+"</option>");
     
}
 
 pw.println("</select>");
 pw.println(" </div>");
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

 
        
          pw.println("<div class='form-group'>");
           pw.println(" <label for='type1' class='control-label'>Loacation</label>");
            pw.println("<select class='form-control' name='loc' id='type1'>");
 try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from internloc");

while(rs2.next())
   { 
   loc1=rs2.getString(1);
    pw.println("<option value='"+loc1+"'>"+loc1+"</option>");
   }
 pw.println("</select>");
 pw.println(" </div>");
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
     
          
          pw.println(" <div class='form-group'>");
            pw.println("<label for='type1' class='control-label'>Startup name</label>");
            pw.println("<select class='form-control' name='star' id='type1'>");
 try
 {
 st3=con.createStatement();
 rs3=st3.executeQuery("select * from internstartup");

while(rs3.next())
   { 
    star1=rs3.getString(1);
    pw.println("<option value='"+star1+"'>"+star1+"</option>");
   }
 pw.println("</select>");
 pw.println(" </div>");
 rs3.close();
 st3.close();
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }
           
pw.println(" <p class='text-center'><input type='submit' class='btn btn-danger glyphicon glyphicon-search'/></p>");
        pw.println("</form></div></div></div></div><section>");
 pw.println("<div class='panel panel-default'>"); 
  pw.println("<div class='panel-body'><strong>DashBoard</strong></div>");
pw.println("</div>");


try
 {
 st4=con.createStatement();

if(h2==hh2 && h3!=hh3 && h1!=hh1)
rs4=st4.executeQuery("select * from internships where platform='"+cat+"' and company_name='"+star+"'");

else if(h3==hh3 && h2!=hh2 && h1!=hh1)
rs4=st4.executeQuery("select * from internships where platform='"+cat+"' and location='"+loc+"'");

else if(h1==hh1 && h3!=hh3 && h2!=hh2) 
rs4=st4.executeQuery("select * from internships where location='"+loc+"' and company_name='"+star+"'");

else if(h2==hh2  && h3==hh3 && h1!=hh1)
rs4=st4.executeQuery("select * from internships where platform='"+cat+"'");

else if(h3==hh3 && h1==hh1 && h2!=hh2)
rs4=st4.executeQuery("select * from internships where location='"+loc+"'");

else if(h2==hh2 && h1==hh1 && h3!=hh3)
rs4=st4.executeQuery("select * from internships where company_name='"+star+"'");

else if(h1==hh1 && h3==hh3 && h2==hh2)
rs4=st4.executeQuery("select * from internships");

else if(h1!=hh4 && h2==hh4 && h3==hh4)
rs4=st4.executeQuery("select * from internships where platform='"+cat+"'");

else if(h2!=hh4 && h1==hh4 && h3==hh4)
rs4=st4.executeQuery("select * from internships where location='"+loc+"'");

else if(h3!=hh4 && h2==hh4 && h3==hh4)
rs4=st4.executeQuery("select * from internships where comapany_name='"+star+"'");

else
rs4=st4.executeQuery("select * from internships where platform='"+cat+"' and location='"+loc+"' and company_name='"+star+"'");


 
 
int i=0; 
 while(rs4.next())
 {
s1=rs4.getString(1);
s2=rs4.getString(2);
s3=rs4.getString(4);
s4=rs4.getString(6);
s5=rs4.getString(9);

pw.println("<a href='InternshipCheck?intern_id="+s5+"'><div class='container'>");
  pw.println("<div class='interns'>");
    pw.println("<h1>"+s1+"</h1>"); 
      pw.println("<h2>"+s3+"</h2>");
      pw.println("<h3>"+s2+"<br/><br/>");
          pw.println("<input type='hidden' value='"+s5+"' name='intern'");
      pw.println("</h3>");
      pw.println("<h4>Last date:"+s4);
      pw.println("<br/><br/><br/>posted on:2-june-2017");
      pw.println("</h4>");
      pw.println("</div>");
pw.println("</div></a>");
i++;
if(i%3==0)
break;

}
  
 rs4.close();
 st4.close();
 }
catch(SQLException e3)
 {
 pw.println(e3);
 }
catch(Exception e4)
 {
 pw.println(e4);
 }


pw.println("</section>");
pw.println("</body>");
pw.println("</html>");





}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}