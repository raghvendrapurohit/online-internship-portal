import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();

res.setContentType("text/html");

HttpSession session=req.getSession();
String s1=(String)session.getAttribute("mob");

pw.println("<!doctype html>");
pw.println("<html>");
pw.println("<head>");
pw.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
pw.println("<title>Resume</title>");
pw.println("<link type='text/css' rel='stylesheet' href='css/blue.css' />");
  pw.println("<link type='text/css' rel='stylesheet' href='css/print.css' media='print'/>");

  pw.println("<link href='css/ie7.css' rel='stylesheet' type='text/css' />");
          pw.println("<link href='css/ie6.css' rel='stylesheet' type='text/css' />");
            pw.println("<script type='text/javascript' src='js/jquery-1.4.2.min.js'></script>");
              pw.println("<script type='text/javascript' src='js/jquery.tipsy.js'></script>");
              
     pw.println("<script type='text/javascript' src='js/cufon.yui.js'></script>");
  pw.println("<script type='text/javascript' src='js/scrollTo.js'></script>");
  pw.println("<script type='text/javascript' src='js/myriad.js'></script>");
    pw.println("<script type='text/javascript' src='js/jquery.colorbox.js'></script>");
    pw.println("<script type='text/javascript' src='js/custom.js'></script>");
   pw.println("<script type='text/javascript'>Cufon.replace('h1,h2');</script>");
   
pw.println("<style>");
pw.println("input[name='name']{position:relative;left:20%;bottom:45px;}");
pw.println("input[name='specialty']{position:relative;left:20%;bottom:40px;}");
pw.println("input[name='address']{position:relative;left:10%;bottom:37px;}");
pw.println("input[name='email']{position:relative;left:10%;bottom:37px;}");
pw.println("input[name='phone']{position:relative;left:10%;bottom:37px;}");
pw.println("input[name='website']{position:relative;left:10%;bottom:37px;}");
pw.println("input[name='objective']{position:relative;left:-10%;bottom:6px;width:450px;height:70px;}");
pw.println("input[name='year_s']{position:relative;left:100%;bottom:;}");
pw.println("input[name='school']{position:relative;left:-20%;bottom:;}");
pw.println("input[name='year_c']{position:relative;left:100%;bottom:20px;}");
pw.println("input[name='college']{position:relative;left:-20%;bottom:20px;}");
pw.println("input[name='branch']{position:relative;left:;bottom:-10px;}");
pw.println("textarea[name='text1']{position:relative;left:5%;bottom:;width:500px;}");


pw.println("input[name='s1']{position:absolute;right:35%;}");
pw.println("input[name='s2']{position:absolute;left:35%;}");
pw.println("input[name='s3']{position:absolute;right:35%;}");
pw.println("input[name='s4']{position:absolute;left:35%;}");


pw.println("input[name='l1']{position:absolute;right:35%;}");
pw.println("input[name='l2']{position:absolute;left:35%;}");
pw.println("input[name='l3']{position:absolute;right:35%;}");
pw.println("input[name='l4']{position:absolute;left:35%;}");


pw.println("input[name='p1']{position:absolute;right:35%;}");
pw.println("input[name='p2']{position:absolute;left:35%;}");
pw.println("input[name='p3']{position:absolute;right:35%;}");
pw.println("input[name='p4']{position:absolute;left:35%;}");

pw.println("input[type='file']{position:relative;left:-75%;bottom:1370px;background:none;border:none;width:85px;}");



pw.println("button[type='submit']{position:relative;left:43%;bottom:70px;width:200px;color:#0E1855;height:30px;cursor:pointer;}");
pw.println("</style>");

pw.println("</head>");

pw.println("<body>");
pw.println("<form name='form1' method='get' action='ResumeServlet'>");
pw.println("<div id='wrapper'>");
pw.println("<h1>Resume</h1>");
  pw.println("<div class='wrapper-top'></div>");
    pw.println(" <div class='wrapper-mid'>");
      pw.println(" <div id='paper'>");
    pw.println("<div class='paper-top'></div>");
    
    pw.println(" <div id='paper-mid'>");
 pw.println("<div class='entry'>");
pw.println("<img class='portrait' src='images/image.jpg' alt='John Smith'/>");
pw.println("<div class='self'>");
pw.println("<h1 class='name'><input type='text' placeholder='your full name' name='name'/> <br />");
pw.println("<span><input type='text' placeholder='specialty' name='specialty'/></span></h1>");
pw.println("<ul>");
pw.println("<li class='ad'><input type='text' placeholder='your permanent address'name='address'/></li><br/>");
pw.println(" <li class='mail'><input type='text' placeholder='your email' name='email'/></li><br/>");
pw.println(" <li class='tel'><input type='text' value='"+s1+"' name='phone' readonly='readonly'/></li><br/>");
pw.println("<li class='web'><input type='text' placeholder='your website if any(separated by commas' name='website'/></li><br/>");
pw.println("</ul></div>");
pw.println("<div class='social'>");
pw.println("<ul>");
pw.println("<li><a class='north' href='#' title='Download .pdf'><img src='images/icn-save.jpg' alt='Download the pdf version' /></a></li>");
pw.println("<li><a class='north' href='javascript:window.print()' title='Print'><img src='images/icn-print.jpg' alt='' /></a></li>");
pw.println("<li><a class='north' id='contact' href='contact/index.html' title='Contact Me'><img src='images/icn-contact.jpg' alt='' /></a></li>");
pw.println("<li><a class='north' href='#' title='Follow me on Twitter'><img src='images/icn-twitter.jpg' alt='' /></a></li>");
pw.println("<li><a class='north' href='#' title='My Facebook Profile'><img src='images/icn-facebook.jpg' alt='' /></a></li>");
pw.println(" </ul></div>");
pw.println(" </div>");
pw.println("<div class='entry'>");
pw.println(" <h2>OBJECTIVE</h2>");
pw.println("<p><input type='text' placeholder='your objective here' name='objective'/></p>");
pw.println(" </div>");
pw.println("<div class='entry'>");
pw.println("<h2>EDUCATION</h2>");
pw.println("<div class='content'>");
pw.println("<h3><input type='text' placeholder='school duration eg.2000-2012' name='year_s'/></h3>");
pw.println(" <p><input type='text' placeholder='School name' name='school'/> <br />");
pw.println("</p> </div>");
pw.println("<div class='content'>");
pw.println("<h3><input type='text' placeholder='college duration eg.2000-2012' name='year_c'/></h3>");
pw.println("<p><input type='text' placeholder='College name' name='college'/><br />");
pw.println("<em><input type='text' placeholder='Branch' name='branch'/></em></p>");
pw.println(" </div> </div>");
pw.println("<div class='entry'>");
pw.println("<h2>EXPERIENCE</h2>");
pw.println("<textarea cols='70' rows='10' value='' name='text1' placeholder='enter your experiences by sequence no.'></textarea>");
pw.println(" </div>");
pw.println(" <div class='entry'>");
pw.println("<h2>SKILLS</h2>");
pw.println(" <div class='content'>");
pw.println("<h3>Software Knowledge</h3>");
pw.println("<li><input type='text' placeholder='enter software' name='s1'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter software' name='s2'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter software' name='s3'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter software' name='s4'/></li><br/>");

pw.println("</div>");
pw.println("<div class='content'>");
pw.println("<h3>Languages</h3>");
pw.println("<li><input type='text' placeholder='enter language' name='l1'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter language' name='l2'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter language' name='l3'/></li><br/>");
pw.println("<li><input type='text' placeholder='enter language' name='l4'/></li><br/>");


pw.println(" </div> </div>");
pw.println("<div class='entry'>");
pw.println("<h2>Projects</h2>");
pw.println("<ul class='projects'>");
pw.println("<li><input type='text' placeholder='project' name='p1'/></li><br/>");
pw.println("<li><input type='text' placeholder='project' name='p2'/></li><br/>");
pw.println("<li><input type='text' placeholder='project' name='p3'/></li><br/>");
pw.println("<li><input type='text' placeholder='project' name='p4'/></li><br/>");

pw.println("</ul></div></div>");
pw.println(" <div class='clear'></div>");
pw.println("<div class='paper-bottom'></div>");
pw.println("</div>");
pw.println("<input type='file'/>");
pw.println(" <button type='submit'>submit</button>");
pw.println("</div>");
pw.println("<div class='wrapper-bottom'></div>");
pw.println("</div>");
pw.println("</form>");
pw.println("<div id='message'><a href='#top' id='top-link'>Go to Top</a></div>");
pw.println("</body>");
pw.println("</html>");



}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}