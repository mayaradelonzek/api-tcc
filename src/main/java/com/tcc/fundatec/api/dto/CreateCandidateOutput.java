package com.tcc.fundatec.api.dto;

import com.tcc.fundatec.domain.model.Candidate;
import lombok.Data;

@Data
public class CreateCandidateOutput {

    private String name;
    private String cpf;
    private String email;
    private String linkedin;
    private String phone;
    private String resume;

    public CreateCandidateOutput(Candidate candidate) {
        this.name = candidate.getName();
        this.cpf = candidate.getCpf();
        this.email = candidate.getEmail();
        this.linkedin = candidate.getLinkedin();
        this.phone = candidate.getPhone();
        this.resume = candidate.getResume();
    }

}
