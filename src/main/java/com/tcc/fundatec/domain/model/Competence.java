package com.tcc.fundatec.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "COMPETENCIA")
public class Competence {

    public Competence(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @ManyToMany(mappedBy = "competences")
    private List<Candidate> candidates;

}
