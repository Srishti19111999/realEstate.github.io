package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


import models.*;

import java.util.*;
import com.google.gson.Gson;

public class AddToChatsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer recieverId = Integer.parseInt(request.getParameter("reciever_id"));
        String message = request.getParameter("message");
		String recieverName = request.getParameter("reciever_name");
        
		

		User user =(User) session.getAttribute("user");
		System.out.println(message);
			if(user!=null){
            
				Chat chat = new Chat(user.getUserId(),user.getUsername(),recieverId,recieverName,message);
				
				if(chat.addToChats()){
					
					session.setAttribute("chat",chat);
					
					Gson gson = new Gson();
					String resp = gson.toJson(chat);
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