package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.ArrayList;


import models.*;

import com.google.gson.Gson;

public class ShowBidsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
   
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
		ArrayList<UserProperty> bids = UserProperty.getBids(user.getUserId());
		Gson gson = new Gson();
		String bid = gson.toJson(bids);

		response.getWriter().write(bid);
	}
}