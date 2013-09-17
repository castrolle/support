package com.dev.puppet.client.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public static void send(String subject, String text,
			List<String> recipientList) {

		if (recipientList != null) {

			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);

			String msgBody = "...";

			try {
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("oiestradag@gmail.com",
						"Example.com Admin"));
				msg.setRecipients(Message.RecipientType.TO,
						getRecipients(recipientList));

				// msg.addRecipient(Message.RecipientType.TO, new
				// InternetAddress(
				// "oi.estrada@uniandes.edu.co", "Mr. User"));
				msg.setSubject("Your Example.com account has been activated");
				msg.setText(msgBody);
				Transport.send(msg);

			} catch (AddressException e) {
				Log.error(e.toString());
			} catch (MessagingException e) {
				Log.error(e.toString());
			} catch (UnsupportedEncodingException e) {
				Log.error(e.toString());
			}

		}

	}

	public static InternetAddress[] getRecipients(List<String> recipientList)
			throws AddressException {
		InternetAddress[] address = new InternetAddress[recipientList.size()];
		for (int i = 0; i < recipientList.size(); i++) {
			address[i] = new InternetAddress(recipientList.get(i));
		}
		return address;
	}
}
