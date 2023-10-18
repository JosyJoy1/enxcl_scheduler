/*package SendEmail;

import java.io.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import java.util.Properties;

import org.apache.catalina.Session;

public class SendEmail {
	private String uemail;
	private String upass;
	boolean flag = false;
	public SendEmail(String uemail,String upass) {
		super();
		this.uemail = uemail;
		this.upass=upass;
	}
	public boolean SendEmail(String uemail2, String upass2) {

        String username = "trainingschedulerexample";
        String password = "yrrpfrniiaqkzdnh";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("josyjoy455@gmail.com");
            message.setFrom(new InternetAddress("trainingschedulerexample@gmail.com"));
            message.setSubject("Welcome");
            message.setText("Explore this new World");
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return flag;
	}

}*/


