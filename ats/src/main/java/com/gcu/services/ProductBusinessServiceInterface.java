package com.gcu.services;

import java.util.List;

import com.gcu.model.ProductModel;

//ProductBusinessInterface: defines methods used in ProductServiceInterface
public interface ProductBusinessServiceInterface {

    public List<ProductModel> getProducts();

    public List<ProductModel> addProduct(ProductModel productModel);
    
    public ProductModel getProductById(int id);
}
