package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import models.User;
import models.Property;
import models.UserProperty;

import com.google.gson.Gson;

public class GetAllBiddersServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        Integer propertyId = Integer.parseInt(request.getParameter("property_id"));
		String resp = "expired";

		if(user!=null){

			ArrayList<UserProperty> list = UserProperty.getAllBidders(propertyId);
			session.setAttribute("bidder",list);
			Gson gson = new Gson();
			resp = gson.toJson(list);			
		}

		response.getWriter().write(resp);
	}
}