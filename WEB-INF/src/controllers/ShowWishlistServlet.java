package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.ArrayList;


import models.*;

import com.google.gson.Gson;

public class ShowWishlistServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
   
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
		ArrayList<UserProperty> wishlists = UserProperty.getWishlist(user.getUserId());
		Gson gson = new Gson();
		String wishlist = gson.toJson(wishlists);

		response.getWriter().write(wishlist);
	}
}