package com.naturalprogrammer.spring.sample.core;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;
import com.naturalprogrammer.spring.sample.mail.MockMailSender;

@RestController
public class MailController {

	// Lecture 5
	//private MailSender mailSender = new MockMailSender();

	//@Resource	// Lecture 6, 7
	//@Resource(name="smtpMailSender")	// Lecture 7
	//@Autowired
	//@Qualifier("smtp")	// Lecture 8
	private MailSender mailSender;


	@Autowired
	//public MailController(@Qualifier("smtpMailSender") MailSender mailSender) {
	// Don't need @Qualifier("smtpMailSender") if use @Profile, because at any
	// instant, only one MailSender will be in the application context
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	/*
	@Autowired
	//@Qualifier("smtp")	// Lecture 8
	public void setMailSender(@Qualifier("smtp") MailSender mailSender) {
		this.mailSender = mailSender;
	}
	*/

	@RequestMapping("/mail")
	public String sendMail() throws MessagingException
	{
		//mailSender.send("abc@example.com", "Some Subject", "the content");
		mailSender.send("ckcheng@tribune.com", "From Gmail", "Spring app test sending mail from gmail.");
		
		return "Mail Sent";
	}
}
