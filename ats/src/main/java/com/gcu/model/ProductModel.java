package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*
 * 
 * ProductModel class: Declares private values for the job postings page.
 */
public class ProductModel {

    /** Unique identifier for the product/job posting. */
    private Long id;

    /** Title of the job posting. Must be between 1 and 20 characters. */
    @NotNull(message = "Job Posting Title must be filled out")
    @Size(min = 1, max = 20, message = "Title must be between 1 and 20")
    private String jobPosting;

    /** Name of the employer. Must be between 1 and 20 characters. */
    @NotNull(message = "Employer Name must be filled out")
    @Size(min = 1, max = 20, message = "Employer Name must be between 1 and 20")
    private String employerName;

    /** Hourly salary for the job posting. Must be a positive number. */
    @NotNull(message = "Salary must be filled out")
    @Positive(message = "Salary must at least include 1 digit")
    private float salaryHr;

    /** Number of available openings for the job. Must be a positive integer. */
    @NotNull(message = "Number of Openings must be filled out")
    @Positive(message = "Number of Openings must at least include 1 digit")
    private int openingsNo;

    /** Detailed description of the job posting. */
    private String jobDesc;

    /** The ID of the user associated with the job posting. */
    private Long users_id;

    /**
     * Constructs a new ProductModel with all fields initialized.
     *
     * @param id           The unique ID of the job posting.
     * @param jobPosting   The title of the job posting.
     * @param employerName The name of the employer.
     * @param salaryHr     The hourly salary for the job.
     * @param openingsNo   The number of openings available.
     * @param jobDesc      The description of the job.
     * @param users_id     The ID of the user associated with the job posting.
     */
    public ProductModel(Long id, String jobPosting, String employerName, float salaryHr, int openingsNo, String jobDesc, Long users_id) {
        this.id = id;
        this.jobPosting = jobPosting;
        this.employerName = employerName;
        this.salaryHr = salaryHr;
        this.openingsNo = openingsNo;
        this.jobDesc = jobDesc;
        this.users_id = users_id;
    }

    /**
     * Default constructor for ProductModel.
     */
    public ProductModel() {
        // Default constructor
    }

    /**
     * @return The unique ID of the job posting.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique ID of the job posting.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The title of the job posting.
     */
    public String getJobPosting() {
        return jobPosting;
    }

    /**
     * Sets the title of the job posting.
     *
     * @param jobPosting The job posting title to set.
     */
    public void setJobPosting(String jobPosting) {
        this.jobPosting = jobPosting;
    }

    /**
     * @return The name of the employer.
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * Sets the employer's name.
     *
     * @param employerName The employer's name to set.
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    /**
     * @return The hourly salary for the job.
     */
    public float getSalaryHr() {
        return salaryHr;
    }

    /**
     * Sets the hourly salary for the job.
     *
     * @param salaryHr The salary to set.
     */
    public void setSalaryHr(float salaryHr) {
        this.salaryHr = salaryHr;
    }

    /**
     * @return The number of available openings for the job.
     */
    public int getOpeningsNo() {
        return openingsNo;
    }

    /**
     * Sets the number of available openings.
     *
     * @param openingsNo number of openings.
     */
    public void setOpeningsNo(int openingsNo) {
        this.openingsNo = openingsNo;
    }

    /**
     * @return The description of job posting.
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * Sets the description of job posting.
     *
     * @param jobDesc job description to set.
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * @return  ID of the user associated with job posting.
     */
    public Long getUsers_Id() {
        return users_id;
    }

    /**
     * Sets the user ID associated with job posting.
     *
     * @param users_id user ID to set.
     */
    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }
}