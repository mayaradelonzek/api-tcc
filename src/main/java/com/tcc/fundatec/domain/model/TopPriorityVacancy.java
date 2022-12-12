package com.tcc.fundatec.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopPriorityVacancy {
    private String name;
    private VacancyLevelEnum level;
    private BigDecimal salary;
    private List<String> competencesNames;
}
