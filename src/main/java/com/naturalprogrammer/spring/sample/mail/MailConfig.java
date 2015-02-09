package com.naturalprogrammer.spring.sample.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

//@Component
@Configuration
public class MailConfig {

	// The object (bean) created and put in the application context
	// will have a name same as the method name.
	@Bean
	@Profile("dev")
	public MailSender mockMailSender()
	{
		/*
		MockMailSender mailSender = new MockMailSender();
		mailSender.setDemoObject(demoObject());
		return mailSender;
		*/
		return new MockMailSender();
	}

	/*
	@Bean
	//@Profile("!dev")
	@Primary
	public MailSender smtpMailSender()
	{
		/*
		SmtpMailSender mailSender = new SmtpMailSender();
		mailSender.setDemoObject(demoObject());
		return mailSender;
		*
		return new SmtpMailSender();
	}
	*/

	/* Can either do it this way, calling the setter method here,
	 * or do the DemoObject way, bye creating JavaMailSender bean
	 * in another method, and use @Autowired in SmtpMailSender */
	@Bean
	@Profile("!dev")
	//@Primary
	public MailSender smtpMailSender(JavaMailSender javaMailSender)
	{
		SmtpMailSender mailSender = new SmtpMailSender();
		mailSender.setJavaMailSender(javaMailSender);
		return mailSender;
	}

	@Bean
	public DemoObject demoObject()
	{
		return new DemoObject();
	}
}
