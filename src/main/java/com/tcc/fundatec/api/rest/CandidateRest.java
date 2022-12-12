package com.tcc.fundatec.api.rest;

import com.tcc.fundatec.api.converter.CandidateConverter;
import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.api.dto.CreateCandidateOutput;
import com.tcc.fundatec.api.exception.BusinessException;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.service.CandidateService;
import com.tcc.fundatec.domain.service.CompetenceService;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
//@Api(tags = "Candidates")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CandidateRest {

    private final CandidateService candidateService;
    private final CompetenceService competenceService;


    @PostMapping(consumes = {"multipart/form-data"})
        public ResponseEntity<Candidate> create(@RequestPart("candidate") @Valid CreateCandidateInput createCandidateInput,
                                            @RequestPart("resume") @Valid @NotNull @NotBlank MultipartFile resume) {
        var competences = competenceService.findAll(createCandidateInput.getCompetences());
        var candidate = candidateService.create(CandidateConverter.createCandidateDtoToModel(createCandidateInput, competences), resume);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> findAll() {
        return ResponseEntity.ok(candidateService.findAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable Long id) {
        Candidate candidate = candidateService.findById(id);
        return ResponseEntity.ok(candidate);
    }

    @PutMapping("/{id}/associate-vacancies")
    public ResponseEntity<Candidate> associateVacancies(@PathVariable Long id, @RequestBody List<Long> vacanciesIds) {
        Candidate candidate = this.candidateService.associateVacancies(id, vacanciesIds);
        return ResponseEntity.ok(candidate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.candidateService.remove(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> edit(@PathVariable Long id, @Valid @RequestBody Candidate candidate) {
        return ResponseEntity.ok(this.candidateService.update(id, candidate));
    }
}
