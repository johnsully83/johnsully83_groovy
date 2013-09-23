package com.home;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter {
	private final Logger log = Logger.getLogger(SessionFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Filter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	public void destroy() {
		log.info("Filter destroyed");
	}


}
