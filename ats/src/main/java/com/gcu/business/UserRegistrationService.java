package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UserDataService;
import com.gcu.entity.UserEntity;
import com.gcu.model.UserModel;

//User RegistrationService implements OrdersBusiness Interface
@Service
public class UserRegistrationService implements OrdersBusinessInterface{

    @Autowired
    private UserDataService userDataService;

    //RegisterUser method: creates a newUser UserEntity and takes UserModel as a parameter, returns call to create method from userDataService 
    public boolean registerUser(UserModel userModel) {
        UserEntity newUser = new UserEntity();
        newUser.setlName(userModel.getlName());
        newUser.setfName(userModel.getfName());
        newUser.setEmail(userModel.getEmail());
        newUser.setpNumber(userModel.getpNumber());
        newUser.setUsername(userModel.getUsername());
        newUser.setPassword(userModel.getPassword());

        return userDataService.create(newUser);
    }

    //Authenticate method compares username and password entered to user in UserEntity (returns a boolean for LoginController)
    @Override
    public boolean authenticate(String username, String password) {
        UserEntity user = userDataService.findAll().stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
