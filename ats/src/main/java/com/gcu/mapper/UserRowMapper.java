package com.gcu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.UserEntity;

/*
 * UserRowMapper Class converts data SQL into object
 */

public class UserRowMapper implements RowMapper<UserEntity> {
    /*
     * mapRow Method: maps UserEntity to MySQL columns
     * @return object with data
     */

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new UserEntity(rs.getLong("id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("emailaddress"), rs.getString("phone_no"), rs.getString("username"), rs.getString("password"));
    }

}
