package com.neeldoshi.first_spring_project.companies;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompaniesController {
    private CompanyServices companyServices;

    public CompaniesController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }



    @GetMapping("/getAllCompanies")
    public List<Companies> findAll(){
        return companyServices.getCompanies();
    }

    @PostMapping("/createCompany")
    public Boolean createCompanies(@RequestBody Companies companies) {
        return companyServices.createCompany(companies);
    }
}
