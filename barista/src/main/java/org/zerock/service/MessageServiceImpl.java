package org.zerock.service;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private JavaMailSender mailSender; // xml에 등록한 bean autowired
	
	public void sendMail(String from, String to, String title, String htmlCode) {
		
		try {
			System.out.println("request : " + from+","+to+","+title+","+"htmlCode");
			
			MimeMessage message = mailSender.createMimeMessage();

			  message.setFrom(new InternetAddress(from));  

			  message.addRecipient(RecipientType.TO, new InternetAddress(to));

			  message.setSubject(title); //메일제목

			  message.setText(htmlCode, "utf-8", "html");
			  
			  
			  mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
