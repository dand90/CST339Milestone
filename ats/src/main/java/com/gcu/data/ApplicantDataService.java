package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.entity.ApplicantsEntity;
import com.gcu.repository.ApplicantsRepository;

@Service
public class ApplicantDataService implements ApplicantDataServiceInterface {
    
    @Autowired
    private ApplicantsRepository applicantsRepository;

    public ApplicantDataService(ApplicantsRepository applicantsRepository) {
        this.applicantsRepository = applicantsRepository;
    }

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

    @Override
    public ApplicantsEntity findById(int id) {
        try {
            return applicantsRepository.findById((long) id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
