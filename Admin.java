import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Admin extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");

Connection con=null;
Statement st1=null,st2=null,st3=null,st4=null;
ResultSet rs1=null,rs2=null,rs3=null,rs4=null;

String intern_id=req.getParameter("intern_id");

HttpSession session=req.getSession();
String s1=(String)session.getAttribute("phone");


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

try
 {
 st4=con.createStatement();
 rs4=st4.executeQuery("select * from admins where mobno='"+s1+"'");


 while(rs4.next())
 {
	String admin=rs4.getString(1);
  pw.println("<h1>Welcome! "+admin+"</h1>");      
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
 
       
  pw.println("<a href='AdminSetting'><button type='button' class='btn'>Settings</button></a>");
  pw.println("<a href='Logout'><button type='button' class='btn'>Logout</button></a>");
   pw.println("<a href='MakeAdmin'><button type='button' class='btn btn-success'>Make a New Admin</button></a>");
   pw.println("<a href='DeleteAdmin'><button type='button' class='btn btn-danger'>Delete a Admin</button></a>");
 
pw.println("</div>");

pw.println("<div class='container'>");

pw.println("<div class='page-header'>");
    pw.println("<h1>Manage Interships Categories</h1>");     
  pw.println("</div>");
      pw.println("<h2>Add Category</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
 pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal1'>Click to add</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='AddInterncat'>");
  pw.println("<div class='modal fade' id='myModal1' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Add Internship Category</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
		pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The Category To Add:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='addinterncat'>");
      pw.println("</div>");
        
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		  pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
  pw.println("</form>");
  
   pw.println("<h2>Delete Category</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal2'>Click to Delete</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='DInterncat'>");
  pw.println("<div class='modal fade' id='myModal2' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete Internship Category</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
		
		 pw.println("<div class='form-group'>");
      pw.println("<label for='sel1'>Select from list to Delete:</label>");
      pw.println("<select class='form-control' id='sel1' name='interncat'>");
		
try
 {
 st1=con.createStatement();
 rs1=st1.executeQuery("select * from interncat");


 while(rs1.next())
 {
 String interncat=rs1.getString(1);
 pw.println("<option value='"+interncat+"'>"+interncat+"</option>");
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
 
		
     
      pw.println("</select>");
	  pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  

  pw.println("<div class='page-header'>");
    pw.println("<h1>Manage Internships Locations Category</h1>");      
  pw.println("</div>");
   
   pw.println("<h2>Add Location</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal3'>Click to add Location</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='AddInternloc'>");
  pw.println("<div class='modal fade' id='myModal3' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Add internship Location</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
        
		pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The Location To Add:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='addinternloc'>");
      pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  
   pw.println("<h2>Delete Location</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal4'>Click to Delete Location</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='DInternloc'>");
  pw.println("<div class='modal fade' id='myModal4' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete Location</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
		
          pw.println("<div class='form-group'>");
      pw.println("<label for='sel1'>Select from list to Delete:</label>");
      pw.println("<select class='form-control' id='sel1' name='internloc'>");
		
try
 {
 st2=con.createStatement();
 rs2=st2.executeQuery("select * from internloc");


 while(rs2.next())
 {
 String internloc=rs2.getString(1);
 pw.println("<option value='"+internloc+"'>"+internloc+"</option>");
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
 
		
     
      pw.println("</select>");
	  pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
  pw.println("</form>");
  




  

  
  pw.println("<div class='page-header'>");
    pw.println("<h1>Users Manager</h1>");      
  pw.println("</div>");

   pw.println("<h2>View User Profile</h2>");
   pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal7'>Click to view</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='ViewUser'>");
  pw.println("<div class='modal fade' id='myModal7' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>View User Profile</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
        
		  pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The mobile no. of the user to view:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='usermob'>");
      pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
			pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
    pw.println("</form>");
  
  
  
  
   pw.println("<h2>Delete User Completely</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal8'>Click to delete</button>");

  pw.println("<!-- Modal -->");
   pw.println("<form method='get' action='DeleteUser'>");
  pw.println("<div class='modal fade' id='myModal8' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete a user</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
         
		  pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The mobile no. of the user to delete:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='dusermob'>");
      pw.println("</div>");
	  
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
    pw.println("</form>");
  
  
  
  
 
  pw.println("<div class='page-header'>");
    pw.println("<h1>Internships Manager</h1>");     
  pw.println("</div>");

  
  
  pw.println("<h2>View Internship by ID</h2>");
 pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal9'>Click to View</button>");

  pw.println("<!-- Modal -->");
   pw.println("<form method='get' action='ViewInternshipbyID'>");
  pw.println("<div class='modal fade' id='myModal9' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>View a Internship:</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
         
		  pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The Intern id for the internship to view:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='viewintern'>");
      pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
			pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
  pw.println("</form>");
  
   pw.println("<h2>View All Internships</h2>");
   pw.println("<a href='ViewAllInternships'><button type='button' class='btn btn-success'>Click here to View</button></a>");
  
  
   pw.println("<h2>Delete Internship by ID:</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal10'>Click to delete</button>");

  pw.println("<!-- Modal -->");
    pw.println("<form method='get' action='DInternshipbyID'>");
  pw.println("<div class='modal fade' id='myModal10' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete a Internship</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
		
           pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The Intern id for the internship to delete:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='deleteintern'>");
      pw.println("</div>");
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  
  
  
  
   pw.println("<div class='page-header'>");
    pw.println("<h1>Messages Manager</h1>");      
  pw.println("</div>");
  
   pw.println("<h2>View Messages</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal11'>Click to open</button>");

  pw.println("<!-- Modal -->");
   pw.println("<form method='get' action='AdminMessageView'>");
  pw.println("<div class='modal fade' id='myModal11' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Messages</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
        
		 pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The sender mobile no:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='sender'>");
      pw.println("</div>");
	  
	   pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The receiver mobile no:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='receiver'>");
      pw.println("</div>");
		 
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		
			pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  
  
  
  
   pw.println("<div class='page-header'>");
    pw.println("<h1>Resume Manager</h1>");    
  pw.println("</div>");
  
   pw.println("<h2>View Resume</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal12'>Click to view</button>");

  pw.println("<!-- Modal -->");
   pw.println("<form method='get' action='AdminResumeView'>");
  pw.println("<div class='modal fade' id='myModal12' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>view Resume</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
    
	
		 pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The user mobile no to view resume:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='viewresume'>");
      pw.println("</div>");
	
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  
  
  
  
   pw.println("<h2>Delete Resume</h2>");
  pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal13'>Click to delete</button>");

  pw.println("<!-- Modal -->");
  pw.println("<form method='get' action='AdminDeleteResume'>");
  pw.println("<div class='modal fade' id='myModal13' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete a Resume</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
         
		 	
		 pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The user mobile no to delete resume:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='deleteresume'>");
      pw.println("</div>");
		 
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
		pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  
  
    pw.println("<div class='page-header'>");
    pw.println("<h1>Registered Startups/Companies</h1>");      
  pw.println("</div>");
  
    pw.println("<h2>Add Startup</h2>");
   pw.println("<a href='AdminAddStartup1'><button type='button' class='btn btn-success'>Click to Add</button></a>");
   
   
   pw.println("<h2>Show List</h2>");
   pw.println("<a href='AdminStartupList'><button type='button' class='btn btn-success'>Click to show</button></a>");
   
   
   
   pw.println("<h2>Delete Startup/Company</h2>");
   pw.println("<!-- Trigger the modal with a button -->");
  pw.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal15'>Click to Delete</button>");

  pw.println("<!-- Modal -->");
   pw.println("<form method='get' action='DCompany'>");
  pw.println("<div class='modal fade' id='myModal15' role='dialog'>");
    pw.println("<div class='modal-dialog modal-lg'>");
      pw.println("<div class='modal-content'>");
        pw.println("<div class='modal-header'>");
          pw.println("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
          pw.println("<h4 class='modal-title'>Delete a Company/Startup</h4>");
        pw.println("</div>");
        pw.println("<div class='modal-body'>");
      
	    
		 	
		 pw.println("<div class='form-group'>");
    pw.println("<label for='inputlg'>Type The Company name to delete:</label>");
    pw.println("<input class='form-control input-lg' id='inputlg' type='text' name='deletecompany'>");
      pw.println("</div>");
	  
	  
        pw.println("</div>");
        pw.println("<div class='modal-footer'>");
				pw.println("<input type='submit' class='btn btn-default' />");
          pw.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
        pw.println("</div>");
      pw.println("</div>");
    pw.println("</div>");
  pw.println("</div>");
   pw.println("</form>");
  
  pw.println("</div>");
 pw.println("</body>");
 pw.println("</html>");
 
 
 }

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}



}

