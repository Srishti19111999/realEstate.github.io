package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.BidCount;
import utils.WishCount;

import models.*;

import java.util.*;
import com.google.gson.Gson;

public class GetCountsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));
		User user =(User) session.getAttribute("user");
		if(user!=null){
            String bidCount = BidCount.getBidCount(propertyId).toString();
			String wishCount = WishCount.getWishCount(propertyId).toString();
            
            ArrayList<String> counts = new ArrayList<String>();
               
				response.getWriter().write("{\"bCount\":"+bidCount+",\"wCount\":"+wishCount+"}");
			}
		else{
			response.getWriter().write("{\"resp\":0}");
		}
	}
}