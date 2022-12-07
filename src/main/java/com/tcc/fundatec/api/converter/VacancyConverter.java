package com.tcc.fundatec.api.converter;

import com.tcc.fundatec.api.dto.CreateVacancyInput;
import com.tcc.fundatec.domain.model.Company;
import com.tcc.fundatec.domain.model.Competence;
import com.tcc.fundatec.domain.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyConverter {

    public static Vacancy createVacancyDtoToModel(CreateVacancyInput createVacancyInput) {
        Company company = new Company(createVacancyInput.getCompanyId());
        List<Competence> competences = new ArrayList<>();
        createVacancyInput.getCompetencesIds().forEach(cId -> competences.add(new Competence(cId)));

        Vacancy vacancy = new Vacancy();
        vacancy.setCompany(company);
        vacancy.setName(createVacancyInput.getName());
        vacancy.setDescription(createVacancyInput.getDescription());
        vacancy.setCompetences(competences);
        vacancy.setSalary(createVacancyInput.getSalary());

        return vacancy;
    }

}
