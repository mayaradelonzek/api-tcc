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
@Table(name = "EMPRESA")
public class Company extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_fantasia")
    private String tradingName;
    @Column(name = "razao_social")
    private String companyName;
    @Column(unique = true)
    private String cnpj;
    @Enumerated(EnumType.STRING)
    @Column(name = "plano")
    private PaymentTierEnum paymentTier;
    @OneToMany(mappedBy = "company")
    private List<Vacancy> vacancies;

}
