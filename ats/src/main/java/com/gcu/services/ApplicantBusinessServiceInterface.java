package com.gcu.services;

import java.util.List;

import com.gcu.model.ApplicantModel;

/*
 * provides methods for pulling, pushing, and getting applicants
 */
public interface ApplicantBusinessServiceInterface 
{
    /*
     * retrieves applicants list
     * @return list of applicants
     */
    public List<ApplicantModel> getApplicants();
    /*
     * adds applicants to database
     * @param applicantModel object
     * @return list of appliants with new applicant added
     */
    public List<ApplicantModel> addApplicant(ApplicantModel applicantModel);
    /*
     * Gets applicant by id
     * @return applicant with id that matches one provided
     */
    public ApplicantModel getApplicantById(long id);

    /*
     * Method to get applicants by job posting ID
     */

    List<ApplicantModel> getApplicantsByJobPosting(Long jobPostingId);
}
