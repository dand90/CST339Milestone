package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.ProductEntity;
import com.gcu.repository.ProductRepository;

/*
 * ProductDataService implements DataAccessInterface for 
 * CRUD operations
 * 
 */

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

    /*
     * Repository for product related data
     */
    @Autowired
    private ProductRepository productsRepository;

    /*
     * Constructs service with specified product
     * 
     * @param prodcutsRepository for product data access
     */
    public ProductDataService(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    /*
     * Gets all products
     * @return all products in jobpostings table
     */
    @Override
    public List<ProductEntity> findAll() {
       List<ProductEntity> products = new ArrayList<>();
       try {
        Iterable<ProductEntity> productsIterable = productsRepository.findAll();
        products = new ArrayList<ProductEntity>();
        productsIterable.forEach(products::add);
       }
       catch (Exception e)
       {
        e.printStackTrace();
       }
       return products;
    }
    /*
     * findById selects products containing a matching ID
     * @param id of product
     * @return object if found, otherwise null
     */
    @Override
    public ProductEntity findById(int id) {
        try {
            // Find by ID using the repository
            return productsRepository.findById((long) id).orElse(null);  // Convert 'id' to 'Long'
        } catch (Exception e) {
            e.printStackTrace();
            return null;  
        }
    }
    /*
     * Create inserts a new product into the table
     * @param object to create
     * @return true if success false if not
     */
    @Override
    public boolean create(ProductEntity product) {
        try {
            this.productsRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*
     * Update updates a product in the table
     * @param object with updated data
     * @return true if updated, false if not
     */
    @Override
    public boolean update(ProductEntity product) {
        try {
            productsRepository.save(product);  
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Delete removes a row from the table
     * 
     * @param object with updated data
     * @return true if updated false if not.
     */
    @Override
    public boolean delete(ProductEntity product) {
        try {
            productsRepository.delete(product); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
