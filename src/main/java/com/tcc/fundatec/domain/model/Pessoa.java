package com.tcc.fundatec.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @Embedded
    private Contato contato;

    private Enum<TipoPessoaEnum> tipoPessoaEnum;
}
