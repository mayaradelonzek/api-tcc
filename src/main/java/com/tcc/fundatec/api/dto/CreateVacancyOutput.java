package com.tcc.fundatec.api.dto;

import com.tcc.fundatec.domain.model.Vacancy;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateVacancyOutput {

    private Long companyId;
    private String name;
    private String description;
    private List<Long> competencesIds;
    private BigDecimal salary;

    public CreateVacancyOutput(Vacancy vacancy) {
        this.companyId = vacancy.getId();
        this.name = vacancy.getName();
        this.description = vacancy.getDescription();
        this.salary = vacancy.getSalary();
    }
}
