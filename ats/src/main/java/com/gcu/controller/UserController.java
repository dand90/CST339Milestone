package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.UserModel;


@Controller
public class UserController {

	@GetMapping("/userDetails")
    public String newPosting(Model model) {
			
		model.addAttribute("title", "User Details");
		model.addAttribute("user", new UserModel());
		
		return "userDetails";
	} 
}
