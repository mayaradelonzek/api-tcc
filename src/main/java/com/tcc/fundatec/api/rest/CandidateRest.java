package com.tcc.fundatec.api.rest;

import com.tcc.fundatec.api.dto.CandidateDTO;
import com.tcc.fundatec.domain.model.Candidate;
import com.tcc.fundatec.domain.service.CandidateService;
import com.tcc.fundatec.infrastructure.repository.CandidateRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CandidateRest {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public ResponseEntity<CandidateDTO> create(@RequestBody @Valid CandidateDTO candidateDTO) {
        var candidate = candidateService.create(candidateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findAll() {
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
        candidateRepository.deleteById(id);
    }

    public ResponseEntity<Candidate> edit(@PathVariable Long id, @Valid @RequestBody Candidate candidate) {
        Candidate candidateToEdit = candidateRepository.getById(id);
        return ResponseEntity.ok(candidateToEdit);
    }
}
