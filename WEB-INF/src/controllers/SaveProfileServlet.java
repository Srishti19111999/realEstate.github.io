package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.Date;

import models.User;

public class SaveProfileServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
      HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            boolean flag = true;
            String  unerror="";
            String  eerror="";

            String username = request.getParameter("username");
            
            String email = request.getParameter("email");
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            String dob = request.getParameter("dob");
            String mobile = request.getParameter("mob");
            
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

            if(flag){
                String otpClient = request.getParameter("otp");
                String otpSession = (String)session.getAttribute("otp");
               //otpSession = "123456";
                if(otpSession.equals(otpClient)){
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setDOB(Date.valueOf(dob));
                    user.setMobile(mobile);

        
                    if(user.saveProfile()){
                        request.getRequestDispatcher("profile.jsp").forward(request,response);
                    }
                    else{
                    request.getRequestDispatcher("editProfile.jsp").forward(request,response);
                    }  
                }else{
                    request.getRequestDispatcher("editProfile.jsp").forward(request,response);
                    }   
            }else{
                response.sendRedirect("signin.jsp");
            }
        }
        else{
            response.sendRedirect("signin.jsp");
        }
    }
}