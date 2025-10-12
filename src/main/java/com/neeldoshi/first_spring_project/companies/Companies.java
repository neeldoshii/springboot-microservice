package com.neeldoshi.first_spring_project.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neeldoshi.first_spring_project.job.Jobs;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"jobs"})
    private List<Jobs> jobs;


    public Companies(List<Jobs> jobs, String description, String companyName, Integer id) {
        this.jobs = jobs;
        this.description = description;
        this.companyName = companyName;
        this.id = id;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public Companies() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
