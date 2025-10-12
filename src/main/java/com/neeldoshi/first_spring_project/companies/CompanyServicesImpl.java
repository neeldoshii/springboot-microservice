package com.neeldoshi.first_spring_project.companies;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServicesImpl implements CompanyServices {
    CompaniesRepository companiesRepository;

    public CompanyServicesImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public List<Companies> getCompanies() {
        return companiesRepository.findAll();
    }

    @Override
    public Companies getCompanyById(Integer id) {
        return companiesRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean createCompany(Companies companies) {
        try {
            companiesRepository.save(companies);
            return true;
        } catch (Exception e){
            return false;
        }


    }

    @Override
    public Boolean deleteCompany(Companies companies) {
        try{
            companiesRepository.delete(companies);
            return true;
        } catch (Exception e){
            return false;
        }


    }
}
