package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

import java.util.ArrayList;

import com.google.gson.Gson;

public class GetFiltersServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

            ArrayList<PropertyType> propTypes = PropertyType.collectTypes();
            session.setAttribute("propTypes",propTypes);
    
			response.getWriter().write("done");
	}
}
