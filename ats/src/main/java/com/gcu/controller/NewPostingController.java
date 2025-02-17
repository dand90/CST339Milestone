package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;
import com.gcu.services.ProductBusinessService;

@Controller
public class NewPostingController {

	@Autowired
    ProductBusinessService service;

    @GetMapping("/newPosting")
    public String newPosting(Model model) {
			
		model.addAttribute("title", "Create a New Job Posting");
		model.addAttribute("productModel", new ProductModel());
		
		return "newPosting";
	} 

    @PostMapping("/doPosting")
	public String doPosting(@Valid ProductModel productModel, BindingResult bindingresult, Model model) {
		//check for errors in the new job posting form
		if (bindingresult.hasErrors()) {
			model.addAttribute("title", "Create a New Job Posting");
			return "newPosting";
		}
		
		// Add the new product to the list
        List<ProductModel> products = service.addProduct(productModel);


        model.addAttribute("title", "My Job Postings");
		model.addAttribute("products", products);
		
		return "products";	
	}

}
