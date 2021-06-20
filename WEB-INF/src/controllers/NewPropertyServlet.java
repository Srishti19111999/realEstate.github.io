package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.*;

import com.google.gson.Gson;

import models.User;
import models.PropertyStatus;
import models.PropertyType;
import models.PropertyFor;
import models.Property;
import java.util.ArrayList;

public class NewPropertyServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		

        if(user!=null){
            String propName = request.getParameter("propName");
			System.out.println(propName);
			if(propName!=null){
				try{
					int sellRent =  Integer.parseInt(request.getParameter("sell_rent"));				
                    int prptyType = Integer.parseInt(request.getParameter("prpty_type"));
					int prptyStatus= Integer.parseInt(request.getParameter("prpty_status"));
					
                    int propPerPrice = Integer.parseInt(request.getParameter("propPerPrice"));
                    int proptotalPrice = Integer.parseInt(request.getParameter("proptotalPrice"));
                    String propArea = request.getParameter("propArea");
                    
					System.out.println(sellRent);
					
					Property property = new Property(user,new PropertyFor(sellRent),new PropertyStatus(prptyStatus),new PropertyType(prptyType),propName,propPerPrice,proptotalPrice,propArea);
					if(property.saveProperty()){

						String propertyPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUsername());
						File file = new File(propertyPath,Integer.toString(property.getPropertyId()));
						file.mkdir();

						session.setAttribute("property",property);

						Gson gson = new Gson();
						String resp = gson.toJson(property);

						response.getWriter().write(resp);
						//System.out.println(resp);

					}else{
						response.getWriter().write("{}");
					}

				}catch(NumberFormatException e){
					response.getWriter().write("{}");
				}			
			}
		}else{
			response.getWriter().write("{\"resp\":0}");
		}		
	}  

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		ArrayList<PropertyType> propTypes = PropertyType.collectTypes();
		session.setAttribute("propTypes",propTypes);

		ArrayList<PropertyStatus> propStatuses = PropertyStatus.collectStatus();
		session.setAttribute("propStatuses",propStatuses);

		
		ArrayList<PropertyFor> propFors = PropertyFor.collectFor();
		session.setAttribute("propFors",propFors);

		if(user!=null){
			nextPage = "add_property.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}