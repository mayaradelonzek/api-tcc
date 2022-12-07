package com.tcc.fundatec.api.dto;

import com.tcc.fundatec.domain.model.PaymentTierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyInput {
    @NotBlank(message = "O nome é obrigatório")
    private String tradingName;
    @NotBlank(message = "O nome é obrigatório")
    private String companyName;

    @NotBlank(message = "O CPF é obrigatório")
    private String cnpj;
    @NotBlank(message = "O CPF é obrigatório")
    private PaymentTierEnum paymentTier;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O LinkedIn é obrigatório")
    private String linkedin;

    @NotBlank(message = "O celular é obrigatório")
    private String phone;

    @NotBlank(message = "O celular é obrigatório")
    private String address;

    private String resume;

    private List<Long> vacanciesIds;
}
