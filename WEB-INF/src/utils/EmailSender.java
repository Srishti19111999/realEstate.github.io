package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.Message;


public class EmailSender{

    public static class MailPasswordAuthenticator extends  Authenticator{
        public static String senderEmail;
        public static String senderEmailPassword;

        public PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(senderEmail,senderEmailPassword);
        }
    }

    public static void sendEmail(String email,String subject, String msg){
        Properties props = new Properties();

        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.starttls.enable","true");

        Session session = Session.getInstance(props,new MailPasswordAuthenticator());

        MimeMessage message = new MimeMessage(session);

        try{
            message.setFrom(MailPasswordAuthenticator.senderEmail);
            message.setRecipients(Message.RecipientType.TO,email);
            message.setSubject(subject);
            message.setContent(msg,"text/html");

            Transport.send(message);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}