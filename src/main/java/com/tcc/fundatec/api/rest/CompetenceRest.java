package com.tcc.fundatec.api.rest;

import com.tcc.fundatec.domain.model.Competence;
import com.tcc.fundatec.domain.service.CompetenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/competences")
@AllArgsConstructor
public class CompetenceRest {

    private final CompetenceService competenceService;

    @GetMapping
    public List<Competence> findAll() {
        return competenceService.findAll();
    }

}
