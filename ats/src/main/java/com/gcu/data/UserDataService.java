package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.UserEntity;
import com.gcu.repository.UserRepository;
/*
 * CRUD operatons for user Entity objects
 * uses user repository to interact with database
 */
//UserDataService implements DataAccessInterface for CRUD Operations, mapped to UserRepository
@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    /*
     * repository for accessing user related data
     */
    @Autowired
    private UserRepository usersRepository;

    /*
     * Constructs UserDataService with user repository related date
     * @param usersRepository for user data access
     */
    public UserDataService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    /*
     * findAll selects and 
     * @return all users rows in table
     */
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
    /*
     * findByUsername selects a user by username
     * 
     * @param username to search for
     * @return object if found otherwise null
     */
    
public UserEntity findByUsername(String username) {
    try {
        return usersRepository.findByUsername(username);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    /*
     * findById (WIP)
     * @param id of user
     * @return object user, otherwise null
     */
    @Override
    public UserEntity findById(int id) {
    	try {
            // Find by ID using the repository
            return usersRepository.findById((long) id).orElse(null);  // Convert 'id' to 'Long'
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // Return null if something goes wrong
        }
    }

    /*
     * Creates a new user
     * 
     * @param user object to create
     * @return true if create, false if not
     */

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
    /*
     * updates existing user
     */
    @Override
    public boolean update(UserEntity t) {
        return true;
    }
    /*
     * deletes user
     */
    @Override
    public boolean delete(UserEntity t) {
        return true;
    }

}
