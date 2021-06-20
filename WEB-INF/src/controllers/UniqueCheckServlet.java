package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class UniqueCheckServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String key = request.getParameter("key");
        boolean flag = User.uniqueKey(key);
        response.getWriter().write(Boolean.toString(flag));
    }
}