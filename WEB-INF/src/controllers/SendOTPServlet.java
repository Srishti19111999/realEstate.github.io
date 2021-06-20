package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import utils.OTPGenerator;
import utils.TextLocal;

import models.User;
public class SendOTPServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if(user!=null){
            String mobileNo = request.getParameter("mobile");
            String otp = OTPGenerator.generateOTP();
            String message = "Your One Time Password is: "+otp;
            System.out.println(message);
            System.out.println(mobileNo);


           TextLocal.sendSms(mobileNo,message);
            session.setAttribute("otp",otp);
        }else{
            response.getWriter().write("Expired");
        }
    }
}