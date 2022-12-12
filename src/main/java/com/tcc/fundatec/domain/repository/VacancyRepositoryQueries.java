package com.tcc.fundatec.domain.repository;

import com.tcc.fundatec.domain.model.TopPriorityVacancy;
import com.tcc.fundatec.domain.model.Vacancy;

import java.util.List;

public interface VacancyRepositoryQueries {

    List<TopPriorityVacancy> findTopPriorityVacancies();

}
