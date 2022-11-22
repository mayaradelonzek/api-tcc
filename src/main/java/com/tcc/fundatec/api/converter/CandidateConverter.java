package com.tcc.fundatec.api.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.domain.model.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class CandidateConverter {

    final ObjectMapper objectMapper;

    public Candidate candidateDtoToModel(CreateCandidateInput createCandidateInput) {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateInput.getName());
        candidate.setCpf(createCandidateInput.getCpf());
        candidate.setEmail(createCandidateInput.getEmail());
        candidate.setPhone(createCandidateInput.getPhone());
        candidate.setLinkedin(createCandidateInput.getLinkedin());
        candidate.setResume(createCandidateInput.getResume());
        candidate.setUpdateDate(LocalDateTime.now());
        candidate.setCreateDate(LocalDateTime.now());

        return candidate;
    }
}
