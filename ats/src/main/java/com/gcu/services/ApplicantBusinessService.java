package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ApplicantDataService;
import com.gcu.entity.ApplicantsEntity;
import com.gcu.model.ApplicantModel;

/*
 * logic for managing applicants
 * mthods for getting, pushing, and setting, applicants
 * 
 */
@Service
public class ApplicantBusinessService implements ApplicantBusinessServiceInterface {

    @Autowired
    private ApplicantDataService service;
    /*
    * 
    * Returns applicants as an ApplicantModel list
         */
    public List<ApplicantModel> getApplicants() {
        List<ApplicantsEntity> applicantEntities = service.findAll();
        List<ApplicantModel> applicantsDomain = new ArrayList<>();
        
        for (ApplicantsEntity entity : applicantEntities) {
            applicantsDomain.add(new ApplicantModel(
                entity.getId(), 
                entity.getName(), 
                entity.getPhone(), 
                entity.getHistory(), 
                entity.getSkills(), 
                entity.getJobPostingId() 
            ));
        }
        return applicantsDomain;
    }
    /*
     *Adds an applicant and returns updated list
     */

    public List<ApplicantModel> addApplicant(ApplicantModel applicantModel) {
        /*
        *Map ApplicantModel to ApplicantsEntity
        */
        ApplicantsEntity applicantEntity = new ApplicantsEntity();
        applicantEntity.setName(applicantModel.getName());
        applicantEntity.setPhone(applicantModel.getPhone());
        applicantEntity.setHistory(applicantModel.getHistory());
        applicantEntity.setSkills(applicantModel.getSkills());
        applicantEntity.setJobPostingId(1L); 

        /*
         * Save the entity using service
         */
        // 
        boolean success = service.create(applicantEntity);
        /*
         * If creation is successful, return the updated list of applicants
         */
        // 
        return success ? getApplicants() : new ArrayList<>();
    }
    /*
     * Fetches a single applicant by ID
     */
    public ApplicantModel getApplicantById(long id) {
        ApplicantsEntity applicantsEntity = service.findById((int) id);
        if (applicantsEntity != null) {
            return new ApplicantModel(
                applicantsEntity.getId(),
                applicantsEntity.getName(),
                applicantsEntity.getPhone(),
                applicantsEntity.getHistory(),
                applicantsEntity.getSkills(),
                applicantsEntity.getJobPostingId() 
            );
        }
        return null;
    }

    /*
     * 
     */
    @Override
    public List<ApplicantModel> getApplicantsByJobPosting(Long jobPostingId) {
        List<ApplicantsEntity> applicants = service.getApplicantsByJobPostingId(jobPostingId);
        List<ApplicantModel> filteredApplicants = new ArrayList<>();
        
        for (ApplicantsEntity entity : applicants) {
            if (jobPostingId.equals(entity.getJobPostingId())) {  
                filteredApplicants.add(new ApplicantModel(
                    entity.getId(),
                    entity.getName(),
                    entity.getPhone(),
                    entity.getHistory(),
                    entity.getSkills(),
                    entity.getJobPostingId()  
                ));
            }
        }
    
        System.out.println("Applicants Found for Job ID " + jobPostingId + ": " + filteredApplicants.size());
        return filteredApplicants;
    }
    
}
