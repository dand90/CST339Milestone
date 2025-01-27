package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;
import com.gcu.services.ProductBusinessService;
import com.gcu.business.LoginSecurityService;
import com.gcu.business.OrdersBusinessInterface;

import javax.validation.Valid;

//Master Controller 
@Controller
public class LoginController {
	//Controller for the login page
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
		
	}
	
	@Autowired
    ProductBusinessService service;

	@Autowired
	LoginSecurityService security;

	//Controller for doLogin, displays contents of products (Job Postings)
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		if(security.authenticate(loginModel.getUsername(), loginModel.getPassword())) {
			List<ProductModel> products = service.getProducts();
		
			model.addAttribute("title", "My Job Postings");
			model.addAttribute("products", products);
		
			return "products";
		}
		else return "login";
		
	}

}
