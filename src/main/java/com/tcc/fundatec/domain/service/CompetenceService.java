package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.domain.model.Competence;
import com.tcc.fundatec.infrastructure.repository.CompetenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public List<Competence> findAll() {
        return this.competenceRepository.findAll();
    }

    public List<Competence> findAll(List<Competence> competences) {
        List<Long> ids = competences.stream().map(Competence::getId).collect(Collectors.toList());
        return this.competenceRepository.findAllByIdIn(ids);
    }

}
