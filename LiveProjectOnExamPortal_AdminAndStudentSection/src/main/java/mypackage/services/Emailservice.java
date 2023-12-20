package mypackage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mypackage.model.*;

@Service
public class Emailservice {

	@Autowired
	private JavaMailSender mailsender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public String SendEmail(EmailModel email) {
		try {
			SimpleMailMessage s=new SimpleMailMessage();
			s.setFrom(sender);
			s.setTo(email.getEmail_address());
			s.setSubject(email.getSubject());
			s.setText(email.getMessage_body());
			mailsender.send(s);
		}
		catch(Exception ex) {
			return (ex.getMessage());
		}
		return "Email Sent Successfully";
	}

	
}

