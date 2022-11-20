package com.tcc.fundatec.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.fundatec.api.dto.CandidateDTO;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateService.class);

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public CandidateDTO create(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.getName());
        candidate.setCpf(candidateDTO.getCpf());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setLinkedin(candidateDTO.getLinkedin());
        candidate.setPhone(candidateDTO.getPhone());
        candidate.setResume(candidateDTO.getResume());
        candidate.setCreateDate(candidateDTO.getCreateDate());
        candidate.setUpdateDate(LocalDateTime.now());

        Candidate savedCandidate = this.candidateRepository.save(candidate);
        LOGGER.info("Candidato Salvo - '{}' ", savedCandidate);

        return convertToCandidateDTO(savedCandidate);
    }

    public List<CandidateDTO> findAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(this::convertToCandidateDTO)
                .collect(Collectors.toList());
    }

    private CandidateDTO convertToCandidateDTO(Candidate candidate) {
        return objectMapper.convertValue(candidate, CandidateDTO.class);
    }

}
