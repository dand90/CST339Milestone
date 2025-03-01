package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.UserRegistrationService;
import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

/*
 * Controller for user registration
 */
@Controller
public class RegisterController {

	@Autowired
	private UserRegistrationService registrationService;

	/*
	 * Controller for the register page
	 * @return register view
	 */
	@GetMapping("/register")
	public String register(Model model) {
			
		model.addAttribute("title", "Register");
		model.addAttribute("userModel", new UserModel());
		
		return "register";
	}
    /*
	 * Controller for the page after Registration to redirect to login
	 */
	@PostMapping("/reLogin")
	public String reLogin(@Valid UserModel userModel, BindingResult bindingresult, Model model) {
		//check for errors in the register form
		if (bindingresult.hasErrors()) {
			model.addAttribute("title", "Register");
			model.addAttribute("loginModel", new LoginModel());
			return "register";
		}
		/*
		 * calls registerUser from UserRegistrationService to create new user
		 */
		if (registrationService.registerUser(userModel)) {
			model.addAttribute("title", "Registration Successful");
			return "reLogin";
		}
		else {
		
		model.addAttribute("title", "return");
		return "register";	
		}
	}
}
