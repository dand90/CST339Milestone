package com.gcu.data;

import java.util.List;

import com.gcu.entity.ApplicantsEntity;
/*
 * ApplicantDataServiceInterface uses CRUD operations
 * on database 
 */
//
public interface ApplicantDataServiceInterface {
    /*
     * Retrieve all applicants from database
     * 
     * @return all objects in list
     */
    List<ApplicantsEntity> findAll();
    /*
     * Find applicant by id
     * 
     * @param id
     * @return object if found
     */
    ApplicantsEntity findById(int id);
    /*
     * Create applicant
     * 
     * @param new applicant object
     * @return true if created, false if not
     */
    boolean create(ApplicantsEntity entity);
    /*
     * Update existing applicant
     * 
     * @param object of updated applicant
     * @return true if updated, false if not
     */
    boolean update(ApplicantsEntity entity);
    /*
     * Delete applicant
     * 
     * @param object of applicant to delete
     * @return true if deleted, false if not
     */
    boolean delete(ApplicantsEntity entity);

    /*
     * 
     * Retrieves list of applicants specific to job posting
     */   
    List<ApplicantsEntity> getApplicantsByJobPostingId(Long jobPosting_id);
}
