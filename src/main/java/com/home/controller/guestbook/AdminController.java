package com.home.controller.guestbook;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.model.form.LoginForm;

@Controller
@RequestMapping(value="guestbook/admin/*")
public class AdminController {
	
	public AdminController() {
		super();
	}
	
	@RequestMapping(value="getLogin")
	public String getLogin() {
		return "guestbook/login";
	}
	
	@RequestMapping(value="login")
	public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm) {
		
		return "guestbook/admin";
	}

}
