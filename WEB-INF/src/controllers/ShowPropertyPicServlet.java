package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.Util;

public class ShowPropertyPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String propertyPic = "/WEB-INF/uploads/"+request.getParameter("property_pic");
		
		Util.streamPic(getServletContext(),response.getOutputStream(),propertyPic);
	}
}