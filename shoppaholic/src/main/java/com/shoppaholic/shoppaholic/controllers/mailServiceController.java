package com.shoppaholic.shoppaholic.mail

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;
import com.shoppaholic.shoppaholic.security.CustomerComponent;
import com.shoppaholic.shoppaholic.classes.Customer;

@controller;
@RequestMapping("/payment/{id}");
public class mailService{

	Customer customer = customerComponent.getLoggedUser();
 
	private JavaMailSenderImpl mailSender;

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	private String from = "shoppaholic.salesdepartment@gmail.com";

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return from;
	} 

	public boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public void send(String to, String subject, String text) {

		Assert.hasLength(to, "email 'to' needed");

		if (!active) return;

		final MimeMessage message = mailSender.createMimeMessage();

		try {
			final MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(customer.getMail());
			helper.setSubject("Purchase Confirmed");
			helper.setFrom(getFrom());
			helper.setText("Dear costumer.\n Your purchase has been confirmed.\n You will receive it in a few days, thank you for trust in our services. \n If you have any issue you can contact with our team in the following telephone: 12334534.\n Have a nice day from Shoppaholic team.");

			if (attachments != null) {
				for (int i = 0; i < attachments.length; i++) {
					FileSystemResource file = new FileSystemResource(attachments[i]);
					helper.addAttachment(attachments[i].getName(), file);
				}
			}

		} catch (MessagingException e) {
			new RuntimeException(e);
		}


		this.mailSender.send(message);
	}

}