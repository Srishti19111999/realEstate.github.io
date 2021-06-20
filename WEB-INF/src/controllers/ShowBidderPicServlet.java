package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.Util;

public class ShowBidderPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        
        String userPic = "/WEB-INF/uploads/"+request.getParameter("picPath");
        if(userPic==null){
            userPic = "static/images/default.jpg";
        }
		
		Util.streamPic(getServletContext(),response.getOutputStream(),userPic);
	}
}