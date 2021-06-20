package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;
import utils.Util;

public class ShowProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        
        HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
    
        //OutputStream os = response.getOutputStream();

        String profpicPath = "static/images/default.jpg";

        if(user!=null){
            String profpic = user.getProfpic();

            System.out.println(profpic);

            if(profpic!=null){
                profpicPath = "/WEB-INF/uploads/"+profpic;
                System.out.println(profpicPath);
            }else{
                System.out.println("oooppppp");
            }
            
        }

        Util.streamPic(getServletContext(),response.getOutputStream(),profpicPath);
    }
}