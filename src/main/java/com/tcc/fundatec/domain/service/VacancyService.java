package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.domain.model.TopPriorityVacancy;
import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.infrastructure.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> findVacancies(List<Long> ids) {
        return this.vacancyRepository.findAllByIdIn(ids);
    }

    public Page<Vacancy> findAll(Pageable pageable) {
        Page<Vacancy> vacancyPage = this.vacancyRepository.findAll(pageable);

        return vacancyPage;
    }

    public List<TopPriorityVacancy> findTopPriorityVacancies() {
        List<TopPriorityVacancy> vacancyPage = this.vacancyRepository.findTopPriorityVacancies();
        Collections.shuffle(vacancyPage);
        return vacancyPage.subList(0, 3);
    }

}
