package com.tcc.fundatec.infrastructure.repository.converter;

import com.tcc.fundatec.domain.model.Competence;
import com.tcc.fundatec.domain.model.TopPriorityVacancy;
import com.tcc.fundatec.domain.model.Vacancy;

import java.util.List;

public class VacancyConverter {

    public static TopPriorityVacancy toTopPriority(Vacancy vacancy) {
        TopPriorityVacancy topPriorityVacancy = new TopPriorityVacancy();
        List<String> competencesNames = vacancy.getCompetences().stream()
                .map(Competence::getName)
                .toList();

        topPriorityVacancy.setSalary(vacancy.getSalary());
        topPriorityVacancy.setLevel(vacancy.getLevel());
        topPriorityVacancy.setCompetencesNames(competencesNames);
        topPriorityVacancy.setName(vacancy.getName());

        return topPriorityVacancy;
    }

}
