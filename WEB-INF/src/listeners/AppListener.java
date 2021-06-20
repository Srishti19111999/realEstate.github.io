package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import utils.EmailSender;
import utils.EmailSender.MailPasswordAuthenticator;
import utils.DBBoard;

public class AppListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent ev){
        ServletContext context = ev.getServletContext();
        String driverClass = context.getInitParameter("DBDriver");
        try{
            Class.forName(driverClass);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String dbHost = context.getInitParameter("DBHost");
        String dbPort = context.getInitParameter("DBPort");
        String database = context.getInitParameter("Database");
        String dbUser = context.getInitParameter("DBUser");
        String dbPassword = context.getInitParameter("DBPassword");

        DBBoard.dbURL = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+database+"?user="+dbUser+"&password="+dbPassword;


        EmailSender.MailPasswordAuthenticator.senderEmail = context.getInitParameter("sender_email");
        EmailSender.MailPasswordAuthenticator.senderEmailPassword = context.getInitParameter("sender_email_password");
        
    }
    public void contextDestroyed(ServletContextEvent ev){
        
    }
}

