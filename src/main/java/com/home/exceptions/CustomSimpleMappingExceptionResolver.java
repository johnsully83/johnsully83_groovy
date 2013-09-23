package com.home.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
	private static final String DEFAULTMESSAGE = "An unhandled exception occurred in the application...";
	
	private final Logger log = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception exception) {
		exception = new SullyException(DEFAULTMESSAGE, exception);
		
		log.error(DEFAULTMESSAGE, exception);
		
		return super.doResolveException(req, resp, handler, exception);
	}
	
}
