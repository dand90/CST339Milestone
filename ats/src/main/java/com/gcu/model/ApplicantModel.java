package com.gcu.model;


//Model for applicant controller
public class ApplicantModel 
{

    private Long id;
	private String name;
	private String phone;
	private String history;
	private String skills;
	private Long jobPosting_id;

	// ApplicanttModel constructor
	public ApplicantModel(Long id, String name, String phone, String history, String skills, Long jobPosting_id) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.history = history;
		this.skills = skills;
		this.jobPosting_id = jobPosting_id;
	}

	//Default Construcotr for ApplicantModel
	public ApplicantModel() {
	}
	// Getters and setters for ProductModel
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Long getjobPosting_Id() {
		return jobPosting_id;
	}

	public void setjobPosting_id(Long jobPosting_id) {
		this.jobPosting_id = jobPosting_id;
	}
    
}
