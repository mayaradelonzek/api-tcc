package com.tcc.fundatec.api.converter;

import com.tcc.fundatec.api.dto.CreateCompanyInput;
import com.tcc.fundatec.domain.model.Company;
import com.tcc.fundatec.domain.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class CompanyConverter {

    public static Company createCompanyDtoToModel(CreateCompanyInput createCompanyInput) {
        List<Vacancy> vacancies = new ArrayList<>();
        createCompanyInput.getVacanciesIds().forEach(vId -> vacancies.add(new Vacancy(vId)));

        Company company = new Company();
        company.setTradingName(createCompanyInput.getTradingName());
        company.setCompanyName(createCompanyInput.getCompanyName());
        company.setCnpj(createCompanyInput.getCnpj());
        company.setPaymentTier(createCompanyInput.getPaymentTier());
        company.setVacancies(vacancies);

        company.setLinkedin(createCompanyInput.getLinkedin());
        company.setPhone(createCompanyInput.getPhone());
        company.setEmail(createCompanyInput.getEmail());
        company.setAddress(createCompanyInput.getAddress());

        return company;
    }

}
