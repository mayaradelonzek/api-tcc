package com.tcc.fundatec.infrastructure.repository.impl;

import com.tcc.fundatec.domain.model.TopPriorityVacancy;
import com.tcc.fundatec.domain.model.Vacancy;
import com.tcc.fundatec.domain.repository.VacancyRepositoryQueries;
import com.tcc.fundatec.infrastructure.repository.converter.VacancyConverter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VacancyRepositoryImpl implements VacancyRepositoryQueries {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TopPriorityVacancy> findTopPriorityVacancies() {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT v ");
//        query.append(" SELECT new com.tcc.fundatec.infrastructure.repository.model.TopPriorityVacanciesResult( ");
//        query.append("   v.name, v.level, v.salary, c ");
//        query.append(" ) ");
        query.append(" FROM Vacancy v ");
        query.append(" JOIN v.competences cpt ");
        query.append(" JOIN v.company cpn ");
        query.append(" JOIN cpn.paymentTier pt ");
        query.append(" WHERE pt.name = 'SUPER_PREMIUM' ");

        TypedQuery<Vacancy> tQuery = em.createQuery(query.toString(), Vacancy.class);

        List<Vacancy> result = tQuery.setMaxResults(10).getResultList();

        return result.stream().map(VacancyConverter::toTopPriority).collect(Collectors.toList());
    }
}
