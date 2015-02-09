package com.naturalprogrammer.spring.sample.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

//@Component	// Lecture 7
//@Primary
//@Component("mailSender")	// Lecture 7
//@Qualifier("smtp")	// Lecture 8
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	/*
	// Leccture 12, to simulate a class /  an object we don't have source code
	// can do injection on variable or method
	@Autowired
	private DemoObject demoOjbect;

	// can do injection on variable or method
	//@Autowired
	public void setDemoObject(DemoObject demoObject)
	{
		this.demoOjbect = demoObject;
	}
	*/

	private JavaMailSender javaMailSender;
	
	public void setJavaMailSender(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}

	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) throws MessagingException
	{
		/*
		demoOjbect.doSomething();

		log.info("Sending SMTP mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
		*/

		MimeMessage message = javaMailSender.createMimeMessage();	// true indicates multipart message
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true);

		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);	// true indicates html
		// continue using helper object for more functionalities like adding attachment
		
		javaMailSender.send(message);
	}
}
