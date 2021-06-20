package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.PropertyPic;
public class PropertyImageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int propertyId = Integer.parseInt(request.getParameter("property_id"));

		String picPath = PropertyPic.getSinglePropertyPic(propertyId);

		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+picPath);
		OutputStream os = response.getOutputStream();

		int count = 0;
		byte[] ar = new byte[1024];

		while((count=is.read(ar))!=-1){
			os.write(ar);
		}
		
		os.flush();
		os.close();
	}
}