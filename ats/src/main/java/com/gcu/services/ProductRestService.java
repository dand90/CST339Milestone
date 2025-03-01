package com.gcu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;

/*
 * Rest controller for endpoints and retrieving product info
 * for APIs of one or all products
 * 
 */
@RestController
@RequestMapping("/service")
public class ProductRestService {

    @Autowired
    private ProductBusinessService productService;

    /*
    * Return a single product by ID
    *
    * @param id of product
    * @return product if found error if not for server or not existant
    */ 
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") int id) {
        try {
            ProductModel product = productService.getProductById(id);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    /*
     * // Return all products
     * 
     * @return list of all products and errors if occuring with server
     */
    
    @GetMapping("/products")
        public ResponseEntity<?> getAllProducts() {
        try {
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    
}
