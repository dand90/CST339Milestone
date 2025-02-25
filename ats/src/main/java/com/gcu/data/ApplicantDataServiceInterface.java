package com.gcu.data;

import java.util.List;

import com.gcu.entity.ApplicantsEntity;

public interface ApplicantDataServiceInterface {
    List<ApplicantsEntity> findAll();
    ApplicantsEntity findById(int id);
    boolean create(ApplicantsEntity entity);
    boolean update(ApplicantsEntity entity);
    boolean delete(ApplicantsEntity entity);

    // Specific to applicants 
    List<ApplicantsEntity> getApplicantsByJobPostingId(Long jobPosting_id);
}
