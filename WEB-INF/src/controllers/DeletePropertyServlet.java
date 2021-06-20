package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.BidCount;
import utils.WishCount;

import models.*;


import com.google.gson.Gson;

public class DeletePropertyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer propertyId = Integer.parseInt(request.getParameter("property_id"));


		User user =(User) session.getAttribute("user");
		if(user!=null){
            
               if(UserProperty.deleteProperty(propertyId,user.getUserId())) {
                if(PropertyPoint.deleteProperty(propertyId)&&PropertyPic.deleteProperty(propertyId)) {
                    if(Property.deleteProperty(propertyId,user.getUserId())) {
                        response.getWriter().write("{\"resp\":1}");
                    } else{
                        response.getWriter().write("{}");
                    }
                } else{
                    response.getWriter().write("{}");
                }   
               } else{
                response.getWriter().write("{}");
            }

			}else{
				response.getWriter().write("{}");
			}		

				

		//String cartItemsCount = Integer.valueOf(cart.keySet().size()).toString();
		//response.getWriter().write("{\"count\":"+cartItemsCount+"}");
	}
}