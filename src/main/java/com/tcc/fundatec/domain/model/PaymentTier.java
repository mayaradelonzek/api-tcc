package com.tcc.fundatec.domain.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "PLANO")
public class PaymentTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "prioridade")
    private Long priority;

    public PaymentTier(Long id) {
        this.id = id;
    }
}
