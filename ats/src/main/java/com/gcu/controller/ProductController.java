package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.ProductModel;
import com.gcu.services.ProductBusinessService;

@Controller
public class ProductController {

    @Autowired
    ProductBusinessService service;


    @GetMapping("/products")
    public String getAllProducts(Model model) {

        List<ProductModel> products = service.getProducts();

        model.addAttribute("title", "My Job Postings");
		model.addAttribute("products", products);

        return "products";
    }
}
