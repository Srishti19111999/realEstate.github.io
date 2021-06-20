package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;
import models.City;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CitySearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

			String skey = request.getParameter("skey");
			System.out.println(skey);

			ArrayList<City> cityList = City.searchCity(skey);
			
			Gson gson = new Gson();
			String citiesString = gson.toJson(cityList);

			response.getWriter().write(citiesString);
		
	}
}
