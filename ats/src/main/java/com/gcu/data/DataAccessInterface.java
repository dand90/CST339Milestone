package com.gcu.data;

import java.util.List;

/*
 * DataAccessInterface uses generics for CRUD operations
 * on database 
 */
//

public interface DataAccessInterface<T> {
    /*
     * @return list from database
     */
    public List<T> findAll();
    /*
     * @return id if found, null if not
     */
    public T findById(int id);
    /*
     * create new entity
     * @return true if updated false if not.
     */
    public boolean create(T t);
    /*
     * updates entity
     * @return true if updated false if not.
     */
    public boolean update(T t);
    /*
     * deletes entity
     * @return true if updated false if not.
     */
    public boolean delete(T t);

}
