package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.WishCount;
import models.*;


import com.google.gson.Gson;

public class AddToWishlistServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));
		User user =(User) session.getAttribute("user");
		if(user!=null){
			Integer wishCount = WishCount.getWishCount(propertyId);
			UserProperty userProperty = new UserProperty(new Property(propertyId),user, new PropertyAction(2),wishCount);
			if(userProperty.addToWishlist()){
				session.setAttribute("userProperty",userProperty);
				
				Gson gson = new Gson();
				String resp = gson.toJson(userProperty);
				response.getWriter().write(resp);
			}else{
				response.getWriter().write("{}");
			}
		}else{
			response.getWriter().write("{\"resp\":0}");
		}
				

				

		//String cartItemsCount = Integer.valueOf(cart.keySet().size()).toString();
		//response.getWriter().write("{\"count\":"+cartItemsCount+"}");
	}
}