package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductDataService;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductModel;
/*
 * 
 * //ProductBusinessService implements ProductBusinessInterface 
 * handles CRUD operations
 * 
 */

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

    @Autowired
    ProductDataService service;
    /*
     * Retrieves data from database
     * //getProducts Method: returns products using findAll as a productsDomain ArrayList
     */

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
    /*
     *
     *
     * addProduct Method: sets ProductEntity to ProductModel and returns a boolean if the new product is created 
     */
    
    @Override
    public List<ProductModel> addProduct(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setJobPosting(productModel.getJobPosting());
        productEntity.setEmployerName(productModel.getEmployerName());
        productEntity.setSalaryHr(productModel.getSalaryHr());
        productEntity.setOpeningsNo(productModel.getOpeningsNo());
        productEntity.setJobDesc(productModel.getJobDesc());
        productEntity.setUsers_Id(1L); // Set users_id to 1 for testing purposes
        
        boolean success = service.create(productEntity);
    
        if (success) {
            return getProducts();  
        } else {
            return new ArrayList<>();
        }
    }
    /*
     * 
     * getProductById method: finds a row by id and maps the values to productEntity
     */
   
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
    /*
     *
     * DeleteProduct method finds the row by Id and deletes the product mapped to the product entity 
     */
    
    public void deleteProduct(int id) {
        ProductEntity productEntity = service.findById(id);  
        if (productEntity != null) {
            service.delete(productEntity);  // Delete the product
        }
    }
    /*
     * 
     * UpdateProduct method maps values to the product entity from product model and saves the update
     */
    
    public void updateProduct(int id, ProductModel updatedProduct) {
        ProductEntity productEntity = service.findById(id); 
        if (productEntity != null) {
           
            productEntity.setJobPosting(updatedProduct.getJobPosting());
            productEntity.setEmployerName(updatedProduct.getEmployerName());
            productEntity.setSalaryHr(updatedProduct.getSalaryHr());
            productEntity.setOpeningsNo(updatedProduct.getOpeningsNo());
            productEntity.setJobDesc(updatedProduct.getJobDesc());
            
           
            service.update(productEntity);
        }
    }

}