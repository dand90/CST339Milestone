package com.gcu.services;

public interface UserDataAccessInterface <T>
{
    public T findByUsername(String username);
}
