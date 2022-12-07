package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateService.class);

    private final CandidateRepository candidateRepository;
    private final VacancyService vacancyService;

    @Transactional
    public Candidate create(Candidate candidate) {
        Candidate savedCandidate = this.candidateRepository.save(candidate);
        LOGGER.info("Candidato Salvo - '{}' ", savedCandidate);

        return savedCandidate;
    }

    private Candidate findOrFail(Long id) {
        return this.candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
    }

    public Candidate associateVacancies(Long id, List<Long> vacanciesIds) {
        List<Vacancy> vacancies = this.vacancyService.findVacancies(vacanciesIds);
        Candidate candidate = this.findOrFail(id);
        candidate.setVacancies(vacancies);
        return candidate;
    }

    public List<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }



}
