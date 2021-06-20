package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

public class SavePropertyOtherDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
        System.out.println("#################################");
        User user = (User)session.getAttribute("user");
        
        System.out.println(user);
        String resp = "";
        if(user!=null){
            System.out.println("#################################");
            int propertyId = Integer.parseInt(request.getParameter("property_id"));
            System.out.println("#################################");

            String propAddress = request.getParameter("propAddress");
            String description = request.getParameter("description");
            String cityName = request.getParameter("propCity");
            Integer cityId = Integer.parseInt(request.getParameter("city_id"));
            Integer stateId = Integer.parseInt(request.getParameter("state_id"));
            String stateName = request.getParameter("state");
            Integer countryId =  Integer.parseInt(request.getParameter("country_id"));
            String countryName = request.getParameter("country");
            Float lat =  Float.parseFloat(request.getParameter("lat"));
            Float lng =  Float.parseFloat(request.getParameter("lng"));

System.out.println(" "+propAddress+" "+stateId+" "+countryName);
            
            Property property = (Property)session.getAttribute("property");
            
            property.setPropertyDescription(description);
            Country country = new Country(countryId,countryName);
            State state = new State(stateId,stateName,country);
            property.setCity(new City(cityId,cityName,state));

            property.setAddress(propAddress);
            property.setLatitude(lat);
            property.setLongitude(lng);

            if(property.saveotherDetails()){
                System.out.println("--------------------------");

                resp += "{\"resp\":1}";
            }else{
                resp += "{\"resp\":0}";
            }			
        }else{
            resp += "{\"resp\":-1}";
        }

		response.getWriter().write(resp);
    }
}
