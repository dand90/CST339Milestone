package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.UserModel;

/*
 * Controller for handling user requests
 */

@Controller
public class UserController {
	/*
	 * get user details and apply to view
	 * @return view
	 */

	@GetMapping("/userDetails")
    public String newPosting(Model model) {
			
		model.addAttribute("title", "User Details");
		model.addAttribute("user", new UserModel());
		
		return "userDetails";
	} 
}
