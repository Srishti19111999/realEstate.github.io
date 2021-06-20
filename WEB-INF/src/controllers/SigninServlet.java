package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import utils.GoogleCaptcha;
import models.User;


public class SigninServlet extends HttpServlet{
   
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.getRequestDispatcher("signin.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uneperror = "";
        HttpSession session = request.getSession();
        String nextPage = "signin.jsp";
        
        String captchaResponse = request.getParameter("g-recaptcha-response");
        boolean flag = GoogleCaptcha.checkRecaptcha(captchaResponse);
        
        if(flag){
            String nameemail = request.getParameter("nameemail");
            String password = request.getParameter("password");

            User user = new User();
            String message = user.loginUser(nameemail,password);
            if(message.equals("success")){
                session.setAttribute("user",user);
                response.sendRedirect("profile.do");
            }else{
                uneperror = message;
                request.setAttribute("uneperror",uneperror);
                request.getRequestDispatcher(nextPage).forward(request,response);
            }
        }else{
            request.setAttribute("cerror","Captcha test failed");
            request.getRequestDispatcher(nextPage).forward(request,response);
        }
    }
}

