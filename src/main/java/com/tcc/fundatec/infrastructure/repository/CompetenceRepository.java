package com.tcc.fundatec.infrastructure.repository;

import com.tcc.fundatec.domain.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    List<Competence> findAllByIdIn(List<Long> ids);

}
