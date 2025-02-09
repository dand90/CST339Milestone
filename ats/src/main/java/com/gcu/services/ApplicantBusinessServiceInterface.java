package com.gcu.services;

import java.util.List;

import com.gcu.model.ApplicantModel;

public interface ApplicantBusinessServiceInterface 
{
    public List<ApplicantModel> getApplicants();

    public List<ApplicantModel> addApplicant(ApplicantModel applicantModel);
    
    public ApplicantModel getApplicantById(long id);

    //Method to get applicants by job posting ID
    List<ApplicantModel> getApplicantsByJobPosting(Long jobPostingId);
}
