package com.tcc.fundatec.domain.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    protected String linkedin;
    @Column(name = "telefone")
    protected String phone;
    protected String email;
    @Column(name = "data_criacao")
    @CreatedDate
    protected LocalDateTime createDate;
    @Column(name = "data_ultima_atualizacao")
    @LastModifiedDate
    protected LocalDateTime lastUpdateDate;
    @Column(name = "endereco")
    protected String address;
}
