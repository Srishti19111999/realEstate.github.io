package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SignOutServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
      HttpSession session = request.getSession();
      
      session.invalidate();

      request.getRequestDispatcher("signin.do").forward(request,response);
    }
}