package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.ProductEntity;

/*
 * performs CRUD operations on ProductEntity
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
