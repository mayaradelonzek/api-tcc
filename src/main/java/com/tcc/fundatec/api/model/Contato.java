package com.tcc.fundatec.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class Contato {

    @NotNull
    private String email;

    @NotNull
    private String linkedin;

    @NotNull
    private String celular;
}
