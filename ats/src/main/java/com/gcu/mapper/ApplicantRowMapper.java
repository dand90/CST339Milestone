package com.gcu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ApplicantsEntity;

/*
 * UserRowMapper Class
 */

public class ApplicantRowMapper implements RowMapper<ApplicantsEntity> {
    /*
     * UserRowMapper Class
     * @return object data from result
     */

    @Override
    public ApplicantsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new ApplicantsEntity(rs.getLong("id"), rs.getString("name"), rs.getString("phone"), rs.getString("history"), rs.getString("skills"), rs.getLong("jobPosting_id"));
    }

}
