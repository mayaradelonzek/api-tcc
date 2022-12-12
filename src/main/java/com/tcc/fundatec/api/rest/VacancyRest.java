package com.tcc.fundatec.api.rest;

import com.tcc.fundatec.domain.model.TopPriorityVacancy;
import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.domain.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@AllArgsConstructor
public class VacancyRest {

    private final VacancyService vacancyService;

    @GetMapping
    public Page<Vacancy> findAll(Pageable pageable) {
        return this.vacancyService.findAll(pageable);

        /*
            Page<Vacancy> vacanciesPage = this.vacancyService.findAll(pageable);
            List<vacancyDTO> dtos = converter(pageable.getContent())

            Page<vacancyDTO> dtosPage = new PageImpl<>(dtos, pageable, vacanciesPage.getTotalElements());
         * */
    }

    @GetMapping("/list")
    public List<TopPriorityVacancy> findAllList() {
        List<TopPriorityVacancy> v= this.vacancyService.findTopPriorityVacancies();
        return v;
    }

}
