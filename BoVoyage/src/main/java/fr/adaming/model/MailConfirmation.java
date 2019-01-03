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

public class MailConfirmation {

	public void sendMailToCl(Formule fo, Client cl) {

		
		final String username = "bovoyageconfirmation@gmail.com";
		final String password = "zdigffsxabwwtpqj";

		// Recipient's email ID needs to be mentioned.
		String to = "ingridregada@gmail.com";

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
			message.setSubject("BOVoyage : commande numéro " + fo.getId());

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Now set the actual message
			String recap = "Vous avez choisi la formule " + fo.getVoyage().getVilleDepart() + "-"
					+ fo.getVoyage().getDestination().getVilleArrive() + " pour " + fo.getNombrePersonne() + " personnes."
					+ "\nVous partirez de " + fo.getVoyage().getVilleDepart() + " le " + fo.getVoyage().getDateDepart() + " et reviendrez de "
					+ fo.getVoyage().getDestination().getVilleArrive() + " le " + fo.getVoyage().getDateRetour() + "."
					+ "\nVous avez choisi l'hôtel " + fo.getHotel().getType() + " avant " + fo.getHotel().getCategorie()
					+ " étoiles et se situant à " + fo.getVoyage().getDestination().getVilleArrive() + "."
					+ "\nVous avez choisi la location d'une " + fo.getVehicule().getType();

			messageBodyPart.setText("Mr/Mme " + cl.getNom()
					+ ", \nBonjour,\nNous vous confirmons l'enregistrement de votre commande numéro " + fo.getId()
					+ ".\nRécapitulatif de votre voyage:" + recap + "\n\nMontant total du voyage: " + fo.getVoyage().getPrix()
					+ fo.getHotel().getPrix() + fo.getVehicule().getPrix() + "€, avec une remise de " + fo.getVoyage().getRemise()+" en faisant une montant total de "+fo.getPrixFinal()
							+ "."
					+ "\n\nVous trouverez le détail de votre facture en pièce jointe au format pdf.\n\n"
					+ "En espérant vous revoir bientôt sur notre site, cordialement\n\nToute l'équipe de BoVoyage");

			
			//parte 2 anterior, insertar imagen
			messageBodyPart= new MimeBodyPart();
			 DataSource fds = new FileDataSource(
					 "C:\\Users\\inti0490\\Desktop\\Cosas para proyectos\\logoBoVoyage.png");

			         messageBodyPart.setDataHandler(new DataHandler(fds));
			         messageBodyPart.setHeader("Content-ID", "image");

			         // add image to the multipart
			         multipart.addBodyPart(messageBodyPart);
			
			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1");
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Récapitulatif commande n°" + fo.getId() + ".pdf");
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
