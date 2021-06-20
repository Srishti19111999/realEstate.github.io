package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.PropertyPic;
import java.util.ArrayList;

import com.google.gson.Gson;

public class PropertyPicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));

		ArrayList<PropertyPic> propertyPics = PropertyPic.getAllPropertyPics(propertyId);

		Gson gson = new Gson();
		String resp = gson.toJson(propertyPics);

		response.getWriter().write(resp);
	}
}
