package com.gcu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("jobpostings")
public class ProductEntity {
    @Id
    private long id;

    @Column("jobposting_name")
    String jobPosting;

    @Column("employer_name")
    String employerName;

    @Column("hourly_salary")
    float salaryHr;

    @Column("openings")
    int openingsNo;

    @Column("job_description")
    String jobDesc;

    @Column("users_id")
    long users_id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public long getUsers_Id() {
        return id;
    }

    public void setUsers_Id(long users_id) {
        this.users_id = users_id;
    }

    public ProductEntity(long id, String jobPosting, String employerName, float salaryHr, int openingsNo, String jobDesc, long users_id) {
        this.id = id;
        this.jobPosting = jobPosting;
        this.employerName = employerName;
        this.salaryHr = salaryHr;
        this.openingsNo = openingsNo;
        this.jobDesc = jobDesc;
        this.users_id = users_id;
    }

    public ProductEntity() {
    }

    
}
