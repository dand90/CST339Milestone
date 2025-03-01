package com.gcu.model;

/*
 * Model for applicant controller
 * includes applicants detiails and associated job id
 * 
 */

public class ApplicantModel 
{

    private Long id;
	private String name;
	private String phone;
	private String history;
	private String skills;
	private Long jobPosting_id;

	
	/**
     * ApplicanttModel constructor
     *
     * @param id             Unique identifier for the applicant.
     * @param name           Full name of the applicant.
     * @param phone          Phone number of the applicant.
     * @param history        Work history or experience of the applicant.
     * @param skills         Skills possessed by the applicant.
     * @param jobPosting_id  ID of the associated job posting.
     */
	public ApplicantModel(Long id, String name, String phone, String history, String skills, Long jobPosting_id) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.history = history;
		this.skills = skills;
		this.jobPosting_id = jobPosting_id;
	}

	/**
     * Default constructor for ApplicantModel.
     */
    public ApplicantModel() {
    }

    /**
     * Retrieves  applicant ID.
     *
     * @return applicant's unique id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets applicant ID.
     *
     * @param id unique id to set for the applicant.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves applicant's full name.
     *
     * @return the name of applicant.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets applicant full name.
     *
     * @param name the name to set.
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
     * Sets applicant phone number.
     *
     * @param phone the phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves applicant's work history.
     *
     * @return the work history.
     */
    public String getHistory() {
        return history;
    }

    /**
     * Sets applicant's work history.
     *
     * @param history work history set for applicant.
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * Retrieves applicant skills.
     *
     * @return skills of applicant.
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Setse applicant skills.
     *
     * @param skills to set for applicant.
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Retrieves job posting ID associated with applicant.
     *
     * @return ID of the associated job posting.
     */
    public Long getjobPosting_Id() {
        return jobPosting_id;
    }

    /**
     * Sets job posting ID associated with applicant.
     *
     * @param jobPosting_id job posting ID to set.
     */
    public void setjobPosting_id(Long jobPosting_id) {
        this.jobPosting_id = jobPosting_id;
    }
}