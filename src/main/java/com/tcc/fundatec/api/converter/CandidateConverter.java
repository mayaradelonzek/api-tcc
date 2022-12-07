package com.tcc.fundatec.api.converter;

import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.model.Competence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CandidateConverter {

    public static Candidate createCandidateDtoToModel(CreateCandidateInput createCandidateInput) {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateInput.getName());
        candidate.setCpf(createCandidateInput.getCpf());
        candidate.setEmail(createCandidateInput.getEmail());
        candidate.setPhone(createCandidateInput.getPhone());
        candidate.setLinkedin(createCandidateInput.getLinkedin());
        candidate.setResume(createCandidateInput.getResume());
        candidate.setAddress(createCandidateInput.getAddress());

        return candidate;
    }
}
