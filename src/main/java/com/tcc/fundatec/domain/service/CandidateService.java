package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.api.converter.CandidateConverter;
import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.api.dto.CreateCandidateOutput;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateService.class);

    private final CandidateRepository candidateRepository;

    private final CandidateConverter candidateConverter;

    @Transactional
    public CreateCandidateOutput create(CreateCandidateInput createCandidateInput) {
        Candidate candidate = candidateConverter.candidateDtoToModel(createCandidateInput);

        Candidate savedCandidate = this.candidateRepository.save(candidate);
        LOGGER.info("Candidato Salvo - '{}' ", savedCandidate);

        return new CreateCandidateOutput(savedCandidate);
    }

    public List<CreateCandidateOutput> findAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(CreateCandidateOutput::new)
                .collect(Collectors.toList());
    }



}
