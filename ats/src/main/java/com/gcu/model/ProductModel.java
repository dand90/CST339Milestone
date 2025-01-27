package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

// ProductModel class: Declares private values for the job postings page.
public class ProductModel {
	private Long id;

	@NotNull(message="Job Posting Title must be filled out")
	@Size(min=1, max=20, message="Title must be between 1 and 20")
	private String jobPosting;

	@NotNull(message="Employer Name must be filled out")
	@Size(min=1, max=20, message="Employer Name must be between 1 and 20")
	private String employerName;

	@NotNull(message="Salary must be filled out")
	@Positive(message="Salary must at least include 1 digit")
	private float salaryHr;

	@NotNull(message="Number of Openings must be filled out")
	@Positive(message="Number of Openings must at least include 1 digit")
	private int openingsNo;

	// Product model default constructor.
	public ProductModel(Long id, String jobPosting, String employerName, float salaryHr, int openingsNo) {
		this.id = id;
		this.jobPosting = jobPosting;
		this.employerName = employerName;
		this.salaryHr = salaryHr;
		this.openingsNo = openingsNo;
	}
	public ProductModel() {
		//TODO Auto-generated constructor stub
	}
	// Getters and setters for product model.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobPosting() {
		return jobPosting;
	}

	public void setJobPosting(String jobPosting) {
		this.jobPosting = jobPosting;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public float getSalaryHr() {
		return salaryHr;
	}

	public void setSalaryHr(float salaryHr) {
		this.salaryHr = salaryHr;
	}

	public int getOpeningsNo() {
		return openingsNo;
	}

	public void setOpeningsNo(int openingsNo) {
		this.openingsNo = openingsNo;
	}

	
}
