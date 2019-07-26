package org.zerock.service;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class MessageEngine {

	@Autowired
	private JavaMailSender mailSender; // xml에 등록한 bean autowired

	public void sendMail(String from, String to, String title, String htmlCode) throws FileNotFoundException, URISyntaxException {

	 try{

	  MimeMessage message = mailSender.createMimeMessage();

	  message.setFrom(new InternetAddress(from));  

	  message.addRecipient(RecipientType.TO, new InternetAddress(to));

	  message.setSubject(title); //메일제목

	  message.setText(htmlCode, "utf-8", "html");

	  mailSender.send(message);


	 }catch(Exception e){

	  e.printStackTrace();

	 }   

	}

}
