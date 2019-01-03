package fr.adaming.model;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailActivation {
	
public void sendMailToCl(Client cl) {

		
		final String username = "bovoyageconfirmation@gmail.com";
		final String password = "zdigffsxabwwtpqj";

		// Recipient's email ID needs to be mentioned.
		String to = cl.getMail();

		// Sender's email ID needs to be mentioned
		String from = "web@gmail.com";

		// Assuming you are sending email from smtp?
		String host = "smtp.gmail.com";

		// Get system properties
		Properties props = System.getProperties();

		// Setup mail server

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the default Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("BOVoyage : Activation du Compte");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Now set the actual message
			String recap = "Merci de vous être inscrit sur BoVoyage. Afin d'activer votre compte client merci de cliquer sur ce lien :" +
					"http://localhost:8080/BoVoyage/bovoyage/client/activeClient/"+cl.getId();
					

			messageBodyPart.setText("Mr/Mme " + cl.getNom()
					+ ", \nBonjour,\n" + recap);

			
			//parte 2 anterior, insertar imagen
			messageBodyPart= new MimeBodyPart();
			 DataSource fds = new FileDataSource(
					 "C:\\Users\\inti0490\\Desktop\\Cosas para proyectos\\logoBoVoyage.png");

			         messageBodyPart.setDataHandler(new DataHandler(fds));
			         messageBodyPart.setHeader("Content-ID", "image");

			         // add image to the multipart
			         multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
