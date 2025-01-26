package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

import javax.validation.Valid;

@Controller
public class RegisterController {

    //Controller for the register page
	@GetMapping("/register")
	public String register(Model model) {
			
		model.addAttribute("title", "Register");
		model.addAttribute("userModel", new UserModel());
		
		return "register";
	}
    
	//Controller for the page after Registration to redirect to login
	@PostMapping("/reLogin")
	public String reLogin(@Valid UserModel userModel, BindingResult bindingresult, Model model) {
		//check for errors in the register form
		if (bindingresult.hasErrors()) {
			model.addAttribute("title", "Register");
			model.addAttribute("loginModel", new LoginModel());
			return "register";
		}
		
		model.addAttribute("title", "return");
		return "reLogin";	
	}
}
