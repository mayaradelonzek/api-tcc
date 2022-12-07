package com.tcc.fundatec.infrastructure.repository;

import com.tcc.fundatec.domain.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findAllByIdIn(List<Long> ids);

}
