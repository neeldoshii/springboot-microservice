package com.neeldoshi.first_spring_project.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neeldoshi.first_spring_project.companies.Companies;
import jakarta.persistence.*;

@Entity
@Table(name = "Jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;

    @Transient  // This field won't be persisted to database
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Companies company;

    public Jobs(Companies companies) {
        this.company = companies;
    }

    @JsonIgnore
    public Companies getCompanies() {
        return company;
    }

    public void setCompanies(Companies companies) {
        this.company = companies;
    }

    public Jobs() {}

    public Jobs(Integer id, String title, String description, String minSalary, String maxSalary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }
}
