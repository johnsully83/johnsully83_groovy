package com.home.controller.main;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("navigate/*")
public class NavigationController {
	private final Logger log = Logger.getLogger(NavigationController.class);

	public NavigationController() {
		super();
	}
	
	@RequestMapping(value="base", method=RequestMethod.GET)
	public String baseNavigate(@RequestParam("page") String viewName) {
		log.info("Navigating to new base page: "+viewName);
		
		return viewName;
	}
	
	@RequestMapping(value="code", method=RequestMethod.GET)
	public String codeNavigate(@RequestParam("page") String viewName) {
		log.info("Navigating to new code page: "+viewName);
		
		return "code/"+viewName;
	}
	
	@RequestMapping(value="math", method=RequestMethod.GET)
	public String mathNavigate(@RequestParam("page") String viewName) {
		log.info("Navigating to new math page: "+viewName);
		
		return "math/"+viewName;
	}
	
	
}
