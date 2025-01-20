package com.gcu.model;
// ProductModel class: Declares private values for the job postings page.
public class ProductModel {
	private Long id;
	private String jobPosting;
	private String employerName;
	private float salaryHr;
	private int openingsNo;
	// Product model default constructor.
	public ProductModel(Long id, String jobPosting, String employerName, float salaryHr, int openingsNo) {
		this.id = id;
		this.jobPosting = jobPosting;
		this.employerName = employerName;
		this.salaryHr = salaryHr;
		this.openingsNo = openingsNo;
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
