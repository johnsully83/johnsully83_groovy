package com.johnsully83;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApplicationStartup implements ServletContextListener {
	private final Log log = LogFactory.getLog(ApplicationStartup.class);

	public void contextDestroyed(ServletContextEvent event) {
		log.info("Application context destroyed");
	}

	public void contextInitialized(ServletContextEvent event) {
		log.info("Application context initialized");
	}

}
