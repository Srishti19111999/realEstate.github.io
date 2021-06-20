package controllers;

import  javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class AccountActivationServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String username = request.getParameter("user");
        String activationCode = request.getParameter("code");
    
        if(User.activateAccount(username,activationCode)){
            request.setAttribute("success","Account Activated");
        }else{
            request.setAttribute("fail","Account Activation Failed");
        }

        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
