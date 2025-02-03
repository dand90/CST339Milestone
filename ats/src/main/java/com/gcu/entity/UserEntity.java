package com.gcu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//The UserEntity Class
@Table("users")
public class UserEntity {
     @Id
    private long id;

    @Column("lastname")
    String lName;

    @Column("firstname")
    String fName;

    @Column("emailaddress")
    String email;

    @Column("phone_no")
    String pNumber;

    @Column("username")
    String username;

    @Column("password")
    String password;

    //Getters and Setters for UserEntity
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Default constructor for UserEntity
    public UserEntity() {
    }

    //Constructor for UserEntity with Parameters
    public UserEntity(long id, String lName, String fName, String email, String pNumber, String username,
            String password) {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.email = email;
        this.pNumber = pNumber;
        this.username = username;
        this.password = password;
    }

    
}
