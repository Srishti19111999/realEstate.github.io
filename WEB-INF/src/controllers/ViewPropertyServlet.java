package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.Property;

public class ViewPropertyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));

		Property property = new Property(propertyId);
		property.getPropertyInfo();

		request.setAttribute("property",property);

		request.getRequestDispatcher("property.jsp").forward(request,response);
	}
}