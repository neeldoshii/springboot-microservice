package com.neeldoshi.first_spring_project.companies;

import java.util.List;

public interface CompanyServices {
    List<Companies> getCompanies();
    Companies getCompanyById(Integer id);
    Boolean createCompany(Companies companies);
    Boolean deleteCompany(Companies companies);



}
