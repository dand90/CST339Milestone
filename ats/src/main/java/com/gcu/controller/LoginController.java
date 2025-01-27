package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;

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
		
	//Controller for doLogin, displays contents of products (Job Postings)
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		if(security.authenticate(loginmodel.getUsername(), loginmodel.getPassword())) {
			List<ProductModel> products = new ArrayList<ProductModel>();
			products.add(new ProductModel(0L, "Head Chef", "Sushi Restaurant", 34.00f, 1));
			products.add(new ProductModel(1L, "Cook", "Pizza Palace", 23.00f, 2));
			products.add(new ProductModel(2L, "Kitchen Staff", "Sunday's", 17.00f, 3));
			products.add(new ProductModel(3L, "Server", "Sushi Restaurant", 15.00f, 4));
			products.add(new ProductModel(4L, "Host", "Sunday's", 15.00f, 2));
		
			model.addAttribute("title", "My Job Postings");
			model.addAttribute("products", products);
		
			return "products";
		}
		else return "login";
		
	}

}
