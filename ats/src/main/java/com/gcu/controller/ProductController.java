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

    //Get Products: view the products (job listings)
    @GetMapping("/products")
    public String getAllProducts(Model model) {

        List<ProductModel> products = service.getProducts();

        model.addAttribute("title", "My Job Postings");
		model.addAttribute("products", products);

        return "products";
    }

    //GET product by ID: user can click a product to view details and applications
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

    //POST delete a posting: deletes a filled or no longer needed job posting
    @PostMapping("/deletePosting/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id); 
        return "redirect:/products"; 
    }

    //GET edit posting: gets the posting by id and allows the user to edit posting details
    @GetMapping("/editPosting/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        ProductModel product = service.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "editPosting"; 
        } else {
            model.addAttribute("error", "Product not found");
            return "products"; 
        }
    }

    // POST update posting: posts the updated posting
    @PostMapping("/updatePosting/{id}")
    public String updateProduct(@PathVariable("id") int id, ProductModel updatedProduct) {
        service.updateProduct(id, updatedProduct); 
        return "redirect:/products"; 
    }
}
