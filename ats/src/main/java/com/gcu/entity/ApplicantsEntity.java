package com.gcu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Long getJobPostingId() {  
        return jobPostingId;
    }

    public void setJobPostingId(Long jobPostingId) {  
        this.jobPostingId = jobPostingId;
    }

    // Constructor
    public ApplicantsEntity(long id, String name, String phone, String history, String skills, Long jobPostingId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.history = history;
        this.skills = skills;
        this.jobPostingId = jobPostingId;
    }

    // Default Constructor
    public ApplicantsEntity() {
    }
}
