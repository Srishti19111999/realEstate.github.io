package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import models.User;
import models.Chat;

import com.google.gson.Gson;

public class GetChatsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        Integer recieverId = Integer.parseInt(request.getParameter("reciever_id"));
        Integer senderId = Integer.parseInt(request.getParameter("sender_id"));
		
		System.out.println(recieverId);
		System.out.println(senderId);
		
		String resp = "expired";

		if(user!=null){

			ArrayList<Chat> list = Chat.getChats(senderId,recieverId);

			Gson gson = new Gson();
			resp = gson.toJson(list);			
		}

		response.getWriter().write(resp);
	}
}