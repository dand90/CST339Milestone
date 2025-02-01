package com.gcu.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductDataService;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductModel;

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

    @Autowired
    ProductDataService service;
    
    @Override
    public List<ProductModel> getProducts() {
        List<ProductEntity> productEntity = service.findAll();
        List<ProductModel> productsDomain = new ArrayList<>();
        for(ProductEntity entity : productEntity)
        {
            productsDomain.add(new ProductModel(entity.getId(), entity.getJobPosting(), entity.getEmployerName(), entity.getSalaryHr(), entity.getOpeningsNo(), entity.getJobDesc(), entity.getUsers_Id()));
        }
        
        return productsDomain;
    }

    @Override
    public List<ProductModel> addProduct(ProductModel productModel) {
        // Map the ProductModel to ProductEntity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setJobPosting(productModel.getJobPosting());
        productEntity.setEmployerName(productModel.getEmployerName());
        productEntity.setSalaryHr(productModel.getSalaryHr());
        productEntity.setOpeningsNo(productModel.getOpeningsNo());
        productEntity.setJobDesc(productModel.getJobDesc());
        productEntity.setUsers_Id(1L); // Set users_id to 1 for testing purposes
        
        // Save the entity using ProductDataService
        boolean success = service.create(productEntity);
        
        // If creation is successful, return the updated list of products
        if (success) {
            return getProducts();  // Fetch and return the updated list of products
        } else {
            // Handle failure (perhaps throw an exception or return an empty list)
            return new ArrayList<>();
        }
    }

    

    

}
