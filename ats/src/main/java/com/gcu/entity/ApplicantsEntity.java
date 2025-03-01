package com.gcu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/*
 * table of resumes and applicant info
 */
@Table("resumes")
public class ApplicantsEntity {

    @Id
    private long id;

    @Column("name")
    private String name;

    @Column("phone")
    private String phone;

    @Column("history")
    private String history;

    @Column("skills")
    private String skills;

    @Column("jobPosting_id") 
    private Long jobPostingId;  

    /**
     * Retrieves applicant ID.
     *
     * @return applicant ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets applicant ID.
     *
     * @param id unique id for applicant.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves applicant name.
     *
     * @return applicant name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets applicant name.
     *
     * @param name of applicant.
     */ 
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves applicant phone number.
     *
     * @return phone number of applicant.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets applicant's phone number.
     *
     * @param phone phone number of applicant.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves applicant's work history.
     *
     * @return work history of applicant.
     */
    public String getHistory() {
        return history;
    }

    /**
     * Sets applicant's work history.
     *
     * @param history work history of applicant.
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * Retrieves applicant's skills.
     *
     * @return skills of applicant.
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets applicant's skills.
     *
     * @param skills of the applicant.
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Retrieves ID of job posting associated with applicant.
     *
     * @return job posting ID.
     */
    public Long getJobPostingId() {  
        return jobPostingId;
    }

    /**
     * Sets the ID of job posting associated with applicant.
     *
     * @param jobPostingId the job posting ID.
     */
    public void setJobPostingId(Long jobPostingId) {  
        this.jobPostingId = jobPostingId;
    }

    /**
     * Constructs a new ApplicantsEntity with all properties initialized.
     *
     * @param id           the unique identifier for the applicant.
     * @param name         the name of the applicant.
     * @param phone        the phone number of the applicant.
     * @param history      the work history of applicant.
     * @param skills       the skills of applicant.
     * @param jobPostingId the ID of job posting associated with applicant.
     */
    public ApplicantsEntity(long id, String name, String phone, String history, String skills, Long jobPostingId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.history = history;
        this.skills = skills;
        this.jobPostingId = jobPostingId;
    }

    /**
     * Default constructor ApplicantsEntity.
     * 
     */
    public ApplicantsEntity() {
    }
}