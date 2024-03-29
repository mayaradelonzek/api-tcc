package com.tcc.fundatec.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "VAGA")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    @JsonIgnoreProperties(value = { "vacancies" })
    private Company company;

    @Column(name = "nome")
    private String name;

    @Column(name = "descricao")
    private String description;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "data_ultima_atualizacao")
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "VAGA_COMPETENCIA",
            joinColumns = @JoinColumn(name = "id_vaga"),
            inverseJoinColumns = @JoinColumn(name = "id_competencia"))
    @JsonIgnoreProperties(value = { "candidates" })
    private List<Competence> competences;

    @ManyToMany(mappedBy = "vacancies")
    @JsonIgnoreProperties(value = { "vacancies", "competences" })
    private List<Candidate> candidates;

    @Enumerated(EnumType.STRING)
    private VacancyStatusEnum status;

    @Column(name = "remuneracao", precision = 15, scale = 2)
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "senioridade")
    private VacancyLevelEnum level;

    public Vacancy(Long id) {
        this.id = id;
    }

}
