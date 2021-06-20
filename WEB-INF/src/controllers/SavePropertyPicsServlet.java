package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

import models.User;
import models.Property;
import models.PropertyPic;

public class SavePropertyPicsServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String nextPage = "signin.do";

        if(user!=null){
            if(ServletFileUpload.isMultipartContent(request)){
                DiskFileItemFactory dfif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(dfif);

                List<FileItem> fileItems = null;

                try{
                    fileItems = sfu.parseRequest(request);

                    Property property = (Property)session.getAttribute("property");
                    String picUploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUsername()+"/"+property.getPropertyId());
                   
                   
                    String dbPicPath = user.getUsername()+"/"+property.getPropertyId()+"/";
                    ArrayList<String> dbPicPaths = new ArrayList<String>();
                    System.out.println("_________099090898-----------------");
                    for(FileItem fileItem : fileItems){
						String fileName = fileItem.getName();
                        dbPicPaths.add(dbPicPath+fileName);

                        try{							
							File file = new File(picUploadPath,fileName);

							fileItem.write(file);
						}catch(Exception e){
							e.printStackTrace();
						}
                    }
                    System.out.println("_________900000000000000000000000-----------------");

                    PropertyPic.savePropertyPics(property.getPropertyId(),dbPicPaths);
					nextPage = "seller_dashboard.jsp";
                }catch(FileUploadException e){
                    e.printStackTrace();
                }
            }
        }else{

        }
        response.sendRedirect(nextPage);
    }
}