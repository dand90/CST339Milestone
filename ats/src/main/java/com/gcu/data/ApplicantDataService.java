package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.ApplicantsEntity;
import com.gcu.repository.ApplicantsRepository;
/*
 * Service class with ApplicantDataServiceInterface for managing applicants
 */
@Service
public class ApplicantDataService implements ApplicantDataServiceInterface {
    
    @Autowired
    private ApplicantsRepository applicantsRepository;
    /*
     * Constructor to start repository
     * @param repository for accessing applicant data
     */
    public ApplicantDataService(ApplicantsRepository applicantsRepository) {
        this.applicantsRepository = applicantsRepository;
    }
    /*
     * Retrieves all applicants 
     * @return a list of applicant objects
     */
    @Override
    public List<ApplicantsEntity> findAll() {
        List<ApplicantsEntity> applicants = new ArrayList<>();
        try {
            Iterable<ApplicantsEntity> applicantsIterable = applicantsRepository.findAll();
            applicantsIterable.forEach(applicants::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicants;
    }
    /*
     * Finds applicant by id
     * 
     * @param id of applicant
     * @return object if found, otherwise null
     */
    @Override
    public ApplicantsEntity findById(int id) {
        try {
            return applicantsRepository.findById((long) id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Creates new applicant
     * 
     * @param new applicant
     * @return true if created, false if not 
     */
    @Override
    public boolean create(ApplicantsEntity applicant) {
        try {
            applicantsRepository.save(applicant);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Update existing applicant
     * 
     * @param new applicant object details
     * @return true if updated, false if not
     */
    @Override
    public boolean update(ApplicantsEntity applicant) {
        try {
            if (applicantsRepository.existsById(applicant.getId())) {
                applicantsRepository.save(applicant);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Deletes applicant
     * 
     * @param applicant object
     * @return true if deleted, false if not.
     */
    @Override
    public boolean delete(ApplicantsEntity applicant) {
        try {
            if (applicantsRepository.existsById(applicant.getId())) {
                applicantsRepository.delete(applicant);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Gets list of applicant for specific job
     * 
     * @param job posting id
     * @return list of applicant objects
     */
    @Override
    public List<ApplicantsEntity> getApplicantsByJobPostingId(Long jobPostingId) {
        try {
            List<ApplicantsEntity> applicants = applicantsRepository.findByJobPostingId(jobPostingId);
            
            // Debugging: Print to console
            System.out.println("Applicants retrieved for jobPostingId " + jobPostingId + ": " + applicants.size());
            for (ApplicantsEntity applicant : applicants) {
                System.out.println("Applicant: " + applicant.getName() + ", ID: " + applicant.getId());
            }
            
            return applicants;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    
    
}
