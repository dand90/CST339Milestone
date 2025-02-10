package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.UserEntity;
import com.gcu.repository.UserRepository;

//UserDataService implements DataAccessInterface for CRUD Operations, mapped to UserRepository
@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    @Autowired
    private UserRepository usersRepository;

    public UserDataService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    //findAll selects and returns all rows in table
    @Override
    public List<UserEntity> findAll() {
       List<UserEntity> users = new ArrayList<>();
       try {
        Iterable<UserEntity> usersIterable = usersRepository.findAll();
        users = new ArrayList<UserEntity>();
        usersIterable.forEach(users::add);
       }
       catch (Exception e)
       {
        e.printStackTrace();
       }
       return users;
    }

    //findById finds a row with a matching ID
    @Override
    public UserEntity findById(int id) {
       return null;
    }

    //create inserts a user and returns boolean
    @Override
    public boolean create(UserEntity user) {
        try {
            this.usersRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //update updates a row in the table
    @Override
    public boolean update(UserEntity t) {
        return true;
    }

    //delete removes a row from the table
    @Override
    public boolean delete(UserEntity t) {
        return true;
    }

}
