package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.ArrayList;

import models.PropertyPoint;

import com.google.gson.Gson;

public class ShowPropertyPointsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));

		ArrayList<PropertyPoint> propertyPoints = PropertyPoint.collectAllPropertyPoints(propertyId);

		Gson gson = new Gson();
		String resp = gson.toJson(propertyPoints);

		response.getWriter().write(resp);
	}
}