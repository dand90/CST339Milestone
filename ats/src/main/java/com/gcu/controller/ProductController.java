package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;
import com.gcu.services.ProductBusinessService;

//ProductController class maps /products and returns products
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

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") int id, Model model) {
        ProductModel product = service.getProductById(id);

        if (product != null) {
            model.addAttribute("product", product);
        } else {
            model.addAttribute("error", "Posting not found");
        }

        return "postingDetails";  // The view for displaying the product detail
    }

    @PostMapping("/deletePosting/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id); // Call the service to handle product deletion
        return "redirect:/products"; // Redirect back to the products list after deletion
    }
}
