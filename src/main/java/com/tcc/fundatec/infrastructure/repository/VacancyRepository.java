package com.tcc.fundatec.infrastructure.repository;

import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.domain.repository.VacancyRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long>, VacancyRepositoryQueries {

    List<Vacancy> findAllByIdIn(List<Long> ids);

}
