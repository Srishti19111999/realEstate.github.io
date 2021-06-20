package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.BidCount;
import utils.WishCount;

import models.*;


import com.google.gson.Gson;

public class AddToBidServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));
		Integer bidAmount = Integer.parseInt(request.getParameter("bid_amt"));


		User user =(User) session.getAttribute("user");
		if(user!=null){
            Integer bidCount = BidCount.getBidCount(propertyId);
			
            
			UserProperty userProperty = new UserProperty(new Property(propertyId),user, new PropertyAction(3),bidCount,bidAmount);
			
			if(userProperty.addToBids()){
				userProperty.deleteFromWishList();
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