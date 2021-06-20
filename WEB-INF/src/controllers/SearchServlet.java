package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.ArrayList;

import models.Property;
import models.User;

import com.google.gson.Gson;

public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        System.out.println("SEarch");
		
		String searchKeyword = request.getParameter("search");
		String byKeyword = request.getParameter("by");
        System.out.println(byKeyword);

		String city = request.getParameter("city");


		Integer price = Integer.parseInt(request.getParameter("price"));


		Integer type = Integer.parseInt(request.getParameter("type"));


		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Property> properties = null;
		if(byKeyword.equals("\"\"")){
			System.out.println("SEarch");

			properties = Property.searchProperty(city,price,type);
		}else{
			System.out.println("NOSEarch");

			properties = Property.searchProperty(byKeyword,searchKeyword,user.getUserId());
		}
		
		Gson gson = new Gson();
		String prods = gson.toJson(properties);

		response.getWriter().write(prods);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Property> properties = Property.getNearByProperty(user.getUserId());
		Gson gson = new Gson();
		String prods = gson.toJson(properties);

		response.getWriter().write(prods);
	}
}