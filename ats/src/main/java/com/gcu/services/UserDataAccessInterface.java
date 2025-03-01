package com.gcu.services;

/*
 * 
 * @param <T> is the type of entity that is handled.
 */
public interface UserDataAccessInterface <T>
{

    /*
     * Finds and returns username
     * @param username to find
     * @return user object if found, null if not.
     */
    public T findByUsername(String username);
}
