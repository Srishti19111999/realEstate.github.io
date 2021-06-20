package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.*;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

import models.User;
import utils.EmailSender;
import utils.EmailMessages;
import utils.ActivationCode;


import utils.GoogleCaptcha;

public class SignupServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
      boolean flag = true;
      String  unerror="";
      String  eerror="";
      String  perror="";
      String  reperror="";
      String  cerror="";
      String  uneerror="";

       String captchaResponse = request.getParameter("g-recaptcha-response");

       flag = GoogleCaptcha.checkRecaptcha(captchaResponse);
      
      if(flag){
          String username = request.getParameter("username");
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          String rePassword = request.getParameter("repassword");

          //------------------------------validation---------------------
        
          Pattern p = null;
          Matcher m = null;

          p = Pattern.compile("^[a-zA-Z0-9_\\-\\.][a-zA-Z0-9_\\-\\.]{4,29}$");
          m = p.matcher(username);

          if(!m.matches()){
              flag = false;
              unerror = "Use appropriate username";
              request.setAttribute("unerror",unerror);
          }

          p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
          m = p.matcher(email);
          if(!m.matches()){
            flag = false;
            eerror="Use appropriate email";
            request.setAttribute("eerror",eerror);
          }

          int pswLength= password.length();
          if(pswLength<8||pswLength>15){
              flag = false;
             perror="Password must be at least 8 and at max 15 characters length";
            request.setAttribute("perror",perror);
        }
          if(!password.equals(rePassword)){
            flag = false;
            reperror = "password and repassword must match!!";
           request.setAttribute("reperror",reperror);
        }

        if(flag){
           String activationCode = ActivationCode.generateActivationCode();
            User user = new User(username,email,password,activationCode);
            if(user.saveUser()){
             String message = EmailMessages.getAccountActivationMail(username,activationCode);
             String subject = "Real Estate Account Activation Mail";
             EmailSender.sendEmail(email,subject,message);

              String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads");
              File file = new File(uploadPath,username);
              file.mkdir();

              
              response.sendRedirect("signin.do");
            }else{
              flag  = false;
              uneerror = "Either duplicate username or duplicate email";
              request.setAttribute("uneerror",uneerror);
            }
        }
      }else{
          cerror="Captcha test failed";
          request.setAttribute("cerror",cerror);
      }

      if(!flag){
        request.getRequestDispatcher("signup.jsp").forward(request,response);
      }
     
       
    }
}

