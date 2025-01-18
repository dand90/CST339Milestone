package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import javax.validation.Valid;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
		
	}
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "000000002", "Product 2", 3.00f, 2));
		orders.add(new OrderModel(2L, "000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "000000005", "Product 5", 5.00f, 5));
		
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		
		return "orders";
	}

}
