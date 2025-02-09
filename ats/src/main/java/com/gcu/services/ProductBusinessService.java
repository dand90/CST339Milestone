package com.gcu.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductDataService;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductModel;

//ProductBusinessService implements ProductBusinessInterface 
@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

    @Autowired
    ProductDataService service;
    
    //getProducts Method: returns products using findAll as a productsDomain ArrayList
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

    // addProduct Method: sets ProductEntity to ProductModel
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
            // return previous list upon failure
            return new ArrayList<>();
        }
    }

    @Override
    public ProductModel getProductById(int id) {
        ProductEntity productEntity = service.findById(id);
        if (productEntity != null) {
            return new ProductModel(
                productEntity.getId(),
                productEntity.getJobPosting(),
                productEntity.getEmployerName(),
                productEntity.getSalaryHr(),
                productEntity.getOpeningsNo(),
                productEntity.getJobDesc(),
                productEntity.getUsers_Id()
            );
        } else {
            return null;
        }
    }

    

    

}
