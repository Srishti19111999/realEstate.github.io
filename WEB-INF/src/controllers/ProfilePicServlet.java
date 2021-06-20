package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;


public class ProfilePicServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        
        String nextPage = "signin.jsp";
        if(user!=null){
            if(ServletFileUpload.isMultipartContent(request)){
                DiskFileItemFactory dfif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(dfif);

                List<FileItem> fileItems = null;

                try{
                    fileItems = sfu.parseRequest(request);
                }catch(FileUploadException e){
                    e.printStackTrace();
                }

                FileItem fileItem = fileItems.get(0);
                
                String username = user.getUsername();
                String userId = user.getUserId().toString();

                String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+username);
              

                String fileName = fileItem.getName();
                fileName = userId+""+fileName.substring(fileName.indexOf("."));

                File file = new File(uploadPath,fileName);
                file.delete();
                try{
                    fileItem.write(file);

                    user.setProfpic(username+"/"+fileName);
                    user.saveProfpic();
                }catch(Exception e){
                    e.printStackTrace();		
                }
            }

            response.sendRedirect("profile.jsp");
        }else{
            response.sendRedirect("signin.do");
        }
    }
}