package com.tcc.fundatec.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVacancyInput {

    private Long companyId;
    private String name;
    private String description;
    private List<Long> competencesIds;
    private BigDecimal salary;

}
