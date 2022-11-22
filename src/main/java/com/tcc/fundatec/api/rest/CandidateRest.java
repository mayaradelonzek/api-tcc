package com.tcc.fundatec.api.rest;

import com.tcc.fundatec.api.dto.CreateCandidateInput;
import com.tcc.fundatec.api.dto.CreateCandidateOutput;
import com.tcc.fundatec.api.exception.BusinessException;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.service.CandidateService;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
//@Api(tags = "Candidates")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CandidateRest {

    private final CandidateService candidateService;
    private final CandidateRepository candidateRepository;

    @PostMapping
    public ResponseEntity<CreateCandidateOutput> create(@RequestBody @Valid CreateCandidateInput createCandidateInput) {
        var candidate = candidateService.create(createCandidateInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

    @GetMapping
    public ResponseEntity<List<CreateCandidateOutput>> findAll() {
        return ResponseEntity.ok(candidateService.findAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Optional<Candidate> candidateToDelete = candidateRepository.findById(id);
        ResponseEntity.ok(candidateToDelete.orElseThrow(() -> new BusinessException("Candidato não encontrado")));
        candidateRepository.deleteById(id);
    }

    public ResponseEntity<Candidate> edit(@PathVariable Long id, @Valid @RequestBody Candidate candidate) {
        Optional<Candidate> candidateToEdit = candidateRepository.findById(id);
        return ResponseEntity.ok(candidateToEdit.orElseThrow(() -> new BusinessException("Candidato não encontrado")));
    }
}
