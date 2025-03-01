package com.gcu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.ApplicantsEntity;

/*
 * Repository interface extending CrudRepository
 */

public interface ApplicantsRepository extends CrudRepository<ApplicantsEntity, Long> {
    /*
     * 
     * @param Id of job posting
     * @return list of applicants to the specified job id
     */
    List<ApplicantsEntity> findByJobPostingId(Long jobPostinId);
    
}
