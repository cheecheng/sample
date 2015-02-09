package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component	// Lecture 6
public class MockMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(MockMailSender.class);

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

	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body)
	{
		demoOjbect.doSomething();

		log.info("Sending mock mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
