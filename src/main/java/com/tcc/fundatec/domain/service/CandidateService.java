package com.tcc.fundatec.domain.service;

import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Service
@AllArgsConstructor
public class CandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateService.class);

    private final CandidateRepository candidateRepository;
    private final VacancyService vacancyService;
    private final FileService fileService;

    @Transactional
    public Candidate create(Candidate candidate, MultipartFile resume) {
        String filePath = fileService.getStoragePath() + resume.getOriginalFilename();

        candidate.setResume(filePath);
        Candidate savedCandidate = this.candidateRepository.save(candidate);
        fileService.uploadFile(resume);
        LOGGER.info("Candidato Salvo - '{}' ", savedCandidate);

        return savedCandidate;
    }

    public Candidate findById(Long id) {
        return this.findOrFail(id);
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

    public void remove(Long id) {
        Candidate candidateToDelete = findOrFail(id);
        candidateRepository.deleteById(id);
    }

    public Candidate update(Long id, Candidate candidate) {
        Candidate candidateDB =  this.findOrFail(id);
        BeanUtils.copyProperties(candidate, candidateDB, "id");
        return this.candidateRepository.save(candidateDB);
    }

    public List<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }



}
