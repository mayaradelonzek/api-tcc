package com.tcc.fundatec.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "CANDIDATO")
public class Candidate extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(unique = true)
    private String cpf;
    @Column(name = "curriculo")
    private String resume;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "CANDIDATO_COMPETENCIA",
        joinColumns = @JoinColumn(name = "id_candidato"),
        inverseJoinColumns = @JoinColumn(name = "id_competencia"))
    private List<Competence> competences;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CANDIDATO_VAGA",
            joinColumns = @JoinColumn(name = "id_candidato"),
            inverseJoinColumns = @JoinColumn(name = "id_vaga"))
    private List<Vacancy> vacancies;

}
