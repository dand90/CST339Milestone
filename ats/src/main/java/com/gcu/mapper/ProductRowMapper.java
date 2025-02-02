package com.gcu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new ProductEntity(rs.getLong("id"), rs.getString("jobposting_name"), rs.getString("employer_name"), rs.getFloat("hourly_salary"), rs.getInt("openings"), rs.getString("job_description"), rs.getLong("users_id"));
    }

}
