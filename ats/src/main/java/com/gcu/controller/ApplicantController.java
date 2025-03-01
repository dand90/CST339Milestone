package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gcu.model.ApplicantModel;
import com.gcu.services.ApplicantBusinessServiceInterface;

/*
 * Controller for handlng applicant requests
 */
@Controller
public class ApplicantController 
{
     @Autowired
    private ApplicantBusinessServiceInterface service;

    /*
     * Maps to "/applicants" and retrieves all applicants
     * 
     * @param model object to pass to view
     * @return name of applicants view
     */
    @GetMapping("/applicants")
    public String getAllApplicants(Model model) {
        List<ApplicantModel> applicants = service.getApplicants();
        
        model.addAttribute("title", "Applicant List");
        model.addAttribute("applicants", applicants);
        
        return "applicants";  // View displaying the list of applicants
    }

    /*
     * Maps to "/applicants/{id}" and retrieves a specific applicant by ID
     * 
     * @param id of applicant
     * @param model object passed to view
     * @return resume details view
     */
    @GetMapping("/applicants/{id}")
    public String getApplicantById(@PathVariable("id") int id, Model model) {
        ApplicantModel applicant = service.getApplicantById(id);
        
        if (applicant != null) {
            model.addAttribute("applicant", applicant);
            return "resumeDetails";  // View showing the applicant's resume
        } else {
            model.addAttribute("error", "Applicant not found");
            return "error";  // Redirect to an error page if applicant is not found
        }
    }
    /*
     * Retrieve view of details for specified job
     * 
     * @param id of job posting
     * @param model object to pass to view
     * @return job details view
     */
    @GetMapping("/applicants/{id}/product")
    public String getJobDetails(@PathVariable("id") Long jobId, Model model) {
        // Retrieve applicants for this jobPosting_id
        List<ApplicantModel> applicants = service.getApplicantsByJobPosting(jobId);
    
        // Debugging: Check if applicants are retrieved
        System.out.println("Applicants Found for Job ID " + jobId + ": " + applicants.size());
    
        for (ApplicantModel applicant : applicants) {
            System.out.println("Applicant: " + applicant.getName() + ", ID: " + applicant.getId());
        }
    
        model.addAttribute("jobId", jobId);
        model.addAttribute("applicants", applicants);
    
        return "jobDetails";  
    }
    
    
}
