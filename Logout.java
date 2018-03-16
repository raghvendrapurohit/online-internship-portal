import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Logout extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

HttpSession session=req.getSession();
session.invalidate();


res.sendRedirect("Front");

}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);

}

}
