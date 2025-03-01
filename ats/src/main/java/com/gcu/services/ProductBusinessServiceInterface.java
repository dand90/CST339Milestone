package com.gcu.services;

import java.util.List;

import com.gcu.model.ProductModel;
/*
 * 
 * //ProductBusinessInterface: defines methods used in ProductServiceInterface
 * 
 */

public interface ProductBusinessServiceInterface {

    /*
     * @return list of available products
     */
    public List<ProductModel> getProducts();
    /*
     * @param object containing product to be added
     * @return updates list with new product
     */
    public List<ProductModel> addProduct(ProductModel productModel);
        /*
     * @param id - unique id
     * @return object that is assigned to unique id
     */
    public ProductModel getProductById(int id);
}
