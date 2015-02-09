/**
 * 
 */
package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is used to simulate a class / an object
 * that we don't have source code to annotate with
 * @Component (or any subtype of @Component)
 * 
 * @author ccheng
 *
 */
public class DemoObject {

	private static final Log log = LogFactory.getLog(DemoObject.class);

	public DemoObject() {
		log.info("Creating DemoObject...");
	}
	
	public void doSomething()
	{
		log.info("Inside DemoObject.doSomething()");
	}

}
