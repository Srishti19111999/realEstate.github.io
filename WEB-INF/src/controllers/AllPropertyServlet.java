package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import models.User;
import models.Property;

import com.google.gson.Gson;

public class AllPropertyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String resp = "expired";

		if(user!=null){

			ArrayList<Property> list = Property.collectAllProperty(user.getUserId());

			Gson gson = new Gson();
			resp = gson.toJson(list);			
		}

		response.getWriter().write(resp);
	}
}