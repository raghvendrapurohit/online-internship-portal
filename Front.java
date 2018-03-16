import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Front extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");


HttpSession session=req.getSession();
String user=(String)session.getAttribute("mob");

String s1="",s2="",s3="",s4="",s5="",s6="";

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

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");

    pw.println("<meta charset='utf-8'>");
    pw.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
    pw.println("<meta name='description' content=''>");
    pw.println("<meta name='author' content=''>");

    pw.println("<title>Front</title>");

              pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
              pw.println("<link rel='stylesheet' href='css/bootstrap-theme.css'>");
              pw.println("<link rel='stylesheet' href='css/bootstrap-theme.min.css'>");
              
               pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
               pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
               pw.println("<script src='js/hello.js'></script>");
  pw.println("<style>");



pw.println("body {height: 100%;background:#1f2348;}");

pw.println(".carousel,.item,.active {height: 100%;}");

pw.println(".carousel-inner {height: 100%;}");



pw.println(".fill {");
    pw.println("width: 100%;");
    pw.println("height: 100%;");
    pw.println("background-position: center;");
    pw.println("-webkit-background-size: cover;");
    pw.println("-moz-background-size: cover;");
    pw.println("background-size: cover;");
    pw.println("-o-background-size: cover;}");

pw.println("footer {margin: 50px 0;}");

pw.println("button[class='btn btn-primary btn-lg']{background:#E1E1E1;color:#000000;position:relative;left:1180%;}");
pw.println("button[class='btn btn-default']{background:#E1E1E1;position:relative;right:-950%;height:44px;width:100px;font-size:20px;}");
pw.println("button[class='btn btn-default'] a{text-decoration:none;color:#4482b8;}");


pw.println("<!--browse-->");
pw.println("@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,700);");

pw.println(".mega-dropdown {");
 pw.println(" position:static !important;");
pw.println("}");
pw.println(".mega-dropdown-menu {");
    pw.println("padding: 20px 0px;");
    pw.println("width:300%;");
    pw.println("box-shadow: none;");
    pw.println("-webkit-box-shadow: none;");
pw.println("}");
pw.println(".mega-dropdown-menu > li > ul {");
 pw.println("padding: 0;");
  pw.println("margin: 0;");
pw.println("}");
pw.println(".mega-dropdown-menu > li > ul > li {");
  pw.println("list-style: none;");
pw.println("}");
pw.println(".mega-dropdown-menu > li > ul > li > a {");
  pw.println("display: block;");
  pw.println("color:#000000;");
  pw.println("padding: 3px 5px;");
pw.println("}");
pw.println(".mega-dropdown-menu > li ul > li > a:hover,");
pw.println(".mega-dropdown-menu > li ul > li > a:focus {");
  pw.println("text-decoration: none;");
pw.println("}");
pw.println(".mega-dropdown-menu .dropdown-header {");
  pw.println("font-size: 18px;");
  pw.println("color: #1f2348;");
  pw.println("padding: 5px 60px 5px 5px;");
  pw.println("line-height: 30px;");
pw.println("}");

pw.println("<!--search-->");

pw.println("<!--ends-->");
 pw.println("a[class='dropdown-toggle']{position:relative;left:40%;}");
 pw.println("nav[class='navbar navbar-inverse']{width:300px;background:none;border:none;font-family:TOMMY HILFIGER AF;position:relative;left:25%;}");

pw.println("label[class='checkbox inline']{position:relative;left:10%;}");
pw.println("button[id='signin']{position:relative;left:32%;}");
pw.println("button[class='btn btn-link']{position:relative;left:34%;}");
pw.println("h1{color:#1f2348;}");
pw.println(".row{position:relative;top:190px;right:220%;}");
pw.println("button[class='btn btn-primary btn-sm']{position:relative;left:100%;top:-30px;}");
pw.println("h4{color:#1f2348;position:relative;top:310px;right:480%;}");

  pw.println("</style>");

pw.println("</head>");

pw.println("<body>");



    pw.println("<!-- Navigation -->");
    pw.println("<nav class='navbar navbar-inverse navbar-fixed-top' role='navigation'>");
        pw.println("<div class='container'>");
            pw.println("<!-- Brand and toggle get grouped for better mobile display -->");
            pw.println("<div class='navbar-header'>");
                pw.println("<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1'>");
                    pw.println("<span class='sr-only'>Toggle navigation</span>");
                    pw.println("<span class='icon-bar'></span>");
                    pw.println("<span class='icon-bar'></span>");
                    pw.println("<span class='icon-bar'></span>");
                pw.println("</button>");
                pw.println("<a class='navbar-brand' href='#'><strong>Website</strong></a><br/>");
				pw.println("<a href='AdminLogin'><button type='button' class='btn'>Administrators</button></a>");
            pw.println("</div>");
            pw.println("<!-- Collect the nav links, forms, and other content for toggling -->");
            pw.println("<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>");
                pw.println("<ul class='nav navbar-nav'>");
                    pw.println("<li>");
                       pw.println("<button class='btn btn-primary btn-lg' href='#signup' data-toggle='modal' data-target='.bs-modal-sm'><a href='#'>Login</a></button>");
                    pw.println("</li>");
                    pw.println("<li>");
                        pw.println("<button type='button' class='btn btn-default'><a href='signup.html' target='_blank' title='my link'>Register</a></button>");
            pw.println("</li>");
                    
                   pw.println("<li>");
                    pw.println("<!--brose starts-->");
                    
                     pw.println("<nav class='navbar navbar-inverse'>");
    
	pw.println("<div class='collapse navbar-collapse js-navbar-collapse'>");
		pw.println("<ul class='nav navbar-nav'>");
			pw.println("<li class='dropdown mega-dropdown'>");
			pw.println("<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Browse Startups<span class='caret'></span></a>");			
			pw.println("<ul class='dropdown-menu mega-dropdown-menu'>");	
			    pw.println("<li class='col-sm-3'>");
			    pw.println("<ul>");
			    pw.println("<li class='dropdown-header'>Category</li>");                           
                            pw.println("<li class='divider'></li>");
                           

 try
 {
 st1=con.createStatement();
 rs1=st1.executeQuery("select * from interncat;");
 int i=0;
while(rs1.next())
{
	s1=rs1.getString(1);
pw.println("<li><a href='InternSearch?cat="+s1+"&loc=&star='>"+s1+"</a></li>");
i++;
if(i==5)
{
	pw.println("<li><a href='InternSearch'><u><b>view more</u></b></a></li>");
	break;
}

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
                            
                           
			    pw.println("</ul>");
			    pw.println("</li>");
					
                           pw.println("<li class='col-sm-3'>");
		           pw.println("<ul>");
			   pw.println("<li class='dropdown-header'>Location</li>");
                           pw.println("<li class='divider'></li>");

try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from internloc;");
 int i=0;
while(rs2.next())
{
	s2=rs2.getString(1);
pw.println("<li><a href='InternSearch?cat=&star=&loc="+s2+"'>"+s2+"</a></li>");
i++;
if(i==5)
{
	pw.println("<li><a href='InternSearch'><u><b>view more</u></b></a></li>");
	break;
}

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
 
                            
			    pw.println("</ul>");
			    pw.println("</li>");
					
					
					     pw.println("<li class='col-sm-3'>");
		           pw.println("<ul>");
			   pw.println("<li class='dropdown-header'>Startups</li>");
                           pw.println("<li class='divider'></li>");

try
 {
 st3=con.createStatement();
 rs3=st3.executeQuery("select * from internstartup;");
 int i=0;
while(rs3.next())
{
	s3=rs3.getString(1);
pw.println("<li><a href='InternSearch?cat=&loc=&star="+s3+"'>"+s3+"</a></li>");
i++;
if(i==5)
{
	pw.println("<li><a href='InternSearch'><u><b>view more</u></b></a></li>");
	break;
}

}



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
 
                            
			    pw.println("</ul>");
			    pw.println("</li>");
					
					
				pw.println("</ul>");				
			pw.println("</li>");
            
       
	pw.println("</div>");
  pw.println("</nav>");
                    pw.println("<!--ends-->");
                    pw.println("</li>");
                    
                    pw.println("<li>");
                    
                    pw.println("<div class='row'>");
		pw.println("<h1>Slider Search box</h1>");
        pw.println("<div class='search'>");
pw.println("<input type='text' class='form-control input-sm' maxlength='64' placeholder='Search a category' />");
 pw.println("<button type='submit' class='btn btn-primary btn-sm'>Search</button>");
pw.println("</div>");
                      
                      pw.println("</li>");
                    pw.println("<li>");
                    pw.println("<h4>Educator?<a href='#'>click here</a></h4>");
                    pw.println("</li>");
                    
                   
                pw.println("</ul>");
            pw.println("</div>");
            pw.println("<!-- /.navbar-collapse -->");
        pw.println("</div>");
        pw.println("<!-- /.container -->");
    pw.println("</nav>");

    pw.println("<!-- Full Page Image Background Carousel Header -->");
    pw.println("<header id='myCarousel' class='carousel slide'>");
        pw.println("<!-- Indicators -->");
        pw.println("<ol class='carousel-indicators'>");
            pw.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
            pw.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
            pw.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
       pw.println("</ol>");

        pw.println("<!-- Wrapper for Slides -->");
        pw.println("<div class='carousel-inner'>");
            pw.println("<div class='item active'>");
                pw.println("<!-- Set the first background image using inline CSS below. -->");
                pw.println("<div class='fill' style='background-image:url('images/slide1.PNG');'></div>");
                pw.println("<div class='carousel-caption'>");
                    pw.println("<h2>We will Listen to your work!!</h2>");
                pw.println("</div>");
            pw.println("</div>");
            pw.println("<div class='item'>");
                pw.println("<!-- Set the second background image using inline CSS below. -->");
                pw.println("<div class='fill' style='background-image:url('images/slide2.PNG');'></div>");
                pw.println("<div class='carousel-caption'>");
                    pw.println("<h2>Lets get a a perfect place for you</h2>");
                pw.println("</div>");
            pw.println("</div>");
            pw.println("<div class='item'>");
                pw.println("<!-- Set the third background image using inline CSS below. -->");
                pw.println("<div class='fill' style='background-image:url('images/slide3.PNG');'></div>");
                pw.println("<div class='carousel-caption'>");
                    pw.println("<h2>We have emplyed more tha 1000+emplyes here.</h2>");
                pw.println("</div>");
            pw.println("</div>");
            
            
            
            
            
        pw.println("</div>");

        pw.println("<!-- Controls -->");
        pw.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
            pw.println("<span class='icon-prev'></span>");
        pw.println("</a>");
        pw.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
            pw.println("<span class='icon-next'></span>");
        pw.println("</a>");

    pw.println("</header>");

  pw.println("<!-- jQuery -->");
    pw.println("<script src='js/jquery.js'></script>");

    pw.println("<!-- Bootstrap Core JavaScript -->");
    pw.println("<script src='js/bootstrap.min.js'></script>");

    pw.println("<!-- Script to Activate the Carousel -->");
    pw.println("<script>");
    pw.println("$('.carousel').carousel({");
        pw.println("interval: 5000 //changes the speed");
    pw.println("})");
    pw.println("</script>");




pw.println("<!--signin data modal starts-->");

pw.println("<div class='modal fade bs-modal-sm' id='myModal' tabindex='-1' role='dialog' aria-labelledby='mySmallModalLabel' aria-hidden='true'>");
  pw.println("<div class='modal-dialog modal-sm'>");
    pw.println("<div class='modal-content'>");
        pw.println("<br>");
        pw.println("<div class='bs-example bs-example-tabs'>");
            pw.println("<ul id='myTab' class='nav nav-tabs'>");
              pw.println("<li class='active'><a href='#signin' data-toggle='tab'>Student</a></li>");
              pw.println("<li class=''><a href='#signup' data-toggle='tab'>Educator</a></li>");
              
            pw.println("</ul>");
        pw.println("</div>");
      pw.println("<div class='modal-body'>");
        pw.println("<div id='myTabContent' class='tab-content'>");
        
        pw.println("<!--student signin-->");
        pw.println("<div class='tab-pane fade active in' id='signin'>");
        pw.println("<form method='get' name='form1' action='LoginCheck'>");
         pw.println("<input type='hidden' name='t1' value='student'/>");
            pw.println("<form class='form-horizontal'>");
            pw.println("<fieldset>");
            pw.println("<!-- Sign In Form -->");
            pw.println("<!-- Text input-->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='userid'>Mobileno.</label>");
              pw.println("<div class='controls'>");
                pw.println("<input required='' id='userid' name='mob_no' type='number' class='form-control' placeholder='' class='input-medium' required=''>");
              pw.println("</div>");
            pw.println("</div>");

            pw.println("<!-- Password input-->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='passwordinput'>Password:</label>");
              pw.println("<div class='controls'>");
                pw.println("<input required='' id='passwordinput' name='passwordinput' class='form-control' type='password' placeholder='********' class='input-medium'>");
              pw.println("</div>");
            pw.println("</div>");
            pw.println("</form>");
             pw.println("</form>");
            pw.println("<!-- Multiple Checkboxes (inline) -->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='rememberme'></label>");
              pw.println("<div class='controls'>");
                pw.println("<label class='checkbox inline' for='rememberme-0'>");
                  pw.println("<input type='checkbox' name='rememberme' id='rememberme-0' value='Remember me'>");
                  pw.println("Remember me");
                pw.println("</label>");
              pw.println("</div>");
            pw.println("</div>");

            pw.println("<!-- Button -->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='signin'></label>");
              pw.println("<div class='controls'>");
                pw.println("<input type='submit' id='signin' name='signin' class='btn btn-success'/>");
              pw.println("</div>");
            pw.println("</div>");
            
            pw.println("<!-- Button -->");
          
            
            pw.println("</fieldset>");
            
        pw.println("</div>");
        
        pw.println("<!--educator signin-->");
        pw.println("<div class='tab-pane fade' id='signup'>");
          pw.println("<form method='get' name='form1' action='LoginCheck'>");
           pw.println("<input type='hidden' name='t1' value='educator'/>");
            pw.println("<form class='form-horizontal'>");
            pw.println("<fieldset>");
           
            pw.println("<!-- Text input-->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='Email'>Mobileno</label>");
              pw.println("<div class='controls'>");
                pw.println("<input id='Email' name='mob_no' class='form-control' type='number' placeholder='' class='input-large' required=''>");
              pw.println("</div>");
            pw.println("</div>");
            
            
            
            pw.println("<!-- Password input-->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='password'>Password:</label>");
              pw.println("<div class='controls'>");
                pw.println("<input id='password' name='passwordinput' class='form-control' type='password' placeholder='********' class='input-large' required=''>");
               	
              pw.println("</div>");
            pw.println("</div>");
            pw.println("</form>");
            pw.println("</form>");
             pw.println("<!-- Multiple Checkboxes (inline) -->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='rememberme'></label>");
              pw.println("<div class='controls'>");
                pw.println("<label class='checkbox inline' for='rememberme-0'>");
                  pw.println("<input type='checkbox' name='rememberme' id='rememberme-0' value='Remember me'>");
                  pw.println("Remember me");
                pw.println("</label>");
              pw.println("</div>");
            pw.println("</div>");
          
           
            pw.println("<!-- Button -->");
            pw.println("<div class='control-group'>");
              pw.println("<label class='control-label' for='confirmsignup'></label>");
              pw.println("<div class='controls'>");
                pw.println("<input type='submit' id='signin' name='confirmsignup' class='btn btn-success'/>");
              pw.println("</div>");
            pw.println("</div>");
            
             pw.println("<!-- Button -->");
            
              
         
                
            
            
            
            pw.println("</fieldset>");
            
      pw.println("</div>");
    pw.println("</div>");
      pw.println("</div>");
    
    pw.println("</div>");
  pw.println("</div>");
pw.println("</div>");
pw.println("<!--sign in data modal ends-->");




pw.println("<!--searchbar-->");

pw.println("<!--searchbar ends-->");


  


 


pw.println("</body>");

pw.println("</html>");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}
