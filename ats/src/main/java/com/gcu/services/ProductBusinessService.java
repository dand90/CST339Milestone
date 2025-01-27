package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

    private List<ProductModel> products = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        // Initialize the products
        products = new ArrayList<>();
        products.add(new ProductModel(0L, "Head Chef", "Sushi Restaurant", 34.00f, 1));
        products.add(new ProductModel(1L, "Cook", "Pizza Palace", 23.00f, 2));
        products.add(new ProductModel(2L, "Kitchen Staff", "Sunday's", 17.00f, 3));
        products.add(new ProductModel(3L, "Server", "Sushi Restaurant", 15.00f, 4));
        products.add(new ProductModel(4L, "Host", "Sunday's", 15.00f, 2));
    }

    @Override
    public List<ProductModel> getProducts() {
        
        return products;
    }

    public void addProduct(ProductModel product) {
        products.add(product);
    }

}
