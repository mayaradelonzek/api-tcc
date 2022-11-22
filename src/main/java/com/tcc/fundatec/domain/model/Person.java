package com.tcc.fundatec.domain.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    protected String name;
    protected String cpf;
    protected String email;
    protected String linkedin;
    protected String phone;
    protected String resume;
}
