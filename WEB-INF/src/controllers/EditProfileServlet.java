package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class EditProfileServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
         request.getRequestDispatcher("editProfile.jsp").forward(request,response);
    }
}