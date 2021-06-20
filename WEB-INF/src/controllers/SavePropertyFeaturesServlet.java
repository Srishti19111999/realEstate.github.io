package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;
import models.Property;
import models.PropertyPoint;

public class SavePropertyFeaturesServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String resp = null;
		if(user!=null){
			String[] features = request.getParameterValues("prop_feature");

			Property property = (Property)session.getAttribute("property");

			PropertyPoint.savePropertyFeaturePoints(property.getPropertyId(),features);
			
			resp = "{\"resp\":1}";

		}else{
			resp = "{\"resp\":-1}";
		}

		response.getWriter().write(resp);
	}
}