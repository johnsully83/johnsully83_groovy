package com.johnsully83.controller.guestbook;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnsully83.model.form.LoginForm;

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
	
	@ModelAttribute(value="loginForm")
	public void newLoginForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
	}

}
