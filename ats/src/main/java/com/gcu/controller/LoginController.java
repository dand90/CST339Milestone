package com.gcu.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

//import com.gcu.model.LoginModel;
//import com.gcu.model.ProductModel;
//import com.gcu.model.UserModel;
//import com.gcu.services.ProductBusinessService;
//import com.gcu.business.UserRegistrationService;

//import javax.validation.Valid;

/*
 * Controller for user authentication and login views
 */
//Master Controller 
@Controller
public class LoginController {
	//Controller for the login page
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		return "login";
		
	}
	
	/**@Autowired
    ProductBusinessService service;

	@Autowired
	private UserRegistrationService security;

	//Controller for doLogin, displays contents of products (Job Postings), uses UserRegistrationService for user authentication
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		boolean isAuthenticated = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		if(isAuthenticated) {
			List<ProductModel> products = service.getProducts();
		
			model.addAttribute("title", "My Job Postings");
			model.addAttribute("products", products);
		
			return "products";
		}
		else return "login";
		
	}**/

}
