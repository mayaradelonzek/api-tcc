package com.tcc.fundatec.api.converter;

import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.model.Competence;

import java.util.List;

public class CandidateConverter {

    public static Candidate createCandidateDtoToModel(CreateCandidateInput createCandidateInput,
                                                      List<Competence> competences) {
        Candidate candidate = new Candidate();

        candidate.setName(createCandidateInput.getName());
        candidate.setCpf(createCandidateInput.getCpf());
        candidate.setEmail(createCandidateInput.getEmail());
        candidate.setPhone(createCandidateInput.getPhone());
        candidate.setLinkedin(createCandidateInput.getLinkedin());
        candidate.setAddress(createCandidateInput.getAddress());
        candidate.setCompetences(competences);

        return candidate;
    }
}
