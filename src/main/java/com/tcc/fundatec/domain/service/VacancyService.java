package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.infrastructure.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> findVacancies(List<Long> ids) {
        return this.vacancyRepository.findAllByIdIn(ids);
    }

}
