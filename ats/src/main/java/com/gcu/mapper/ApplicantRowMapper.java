package com.gcu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ApplicantsEntity;

//UserRowMapper Class
public class ApplicantRowMapper implements RowMapper<ApplicantsEntity> {
    //mapRow Method: maps UserEntity to MySQL columns
    @Override
    public ApplicantsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new ApplicantsEntity(rs.getLong("id"), rs.getString("name"), rs.getString("phone"), rs.getString("history"), rs.getString("skills"), rs.getLong("jobposting_id"));
    }

}
