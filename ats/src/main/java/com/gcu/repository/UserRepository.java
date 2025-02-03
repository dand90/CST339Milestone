package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.UserEntity;

//UserRepository interface extending CrudRepository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
