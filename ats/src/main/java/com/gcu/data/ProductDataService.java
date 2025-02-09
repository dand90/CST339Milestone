package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.ProductEntity;
import com.gcu.repository.ProductRepository;

//ProductDataService implements DataAccessInterface for CRUD operations
@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

    @Autowired
    private ProductRepository productsRepository;

    public ProductDataService(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    
    // findAll selects all products in jobpostings table
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

    // findById selects products containing a matching ID
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

    //Create inserts a new product into the table
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

    //Update updates a product in the table
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

    //Delete removes a row from the table
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
