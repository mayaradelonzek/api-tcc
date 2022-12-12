package com.tcc.fundatec.api.dto;

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

    @NotBlank(message = "A razão social é obrigatória")
    private String companyName;

    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "O tipo do plano é obrigatório")
    private Long paymentTierId;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O LinkedIn é obrigatório")
    private String linkedin;

    @NotBlank(message = "O celular é obrigatório")
    private String phone;

    @NotBlank(message = "O endereço é obrigatório")
    private String address;

    private List<Long> vacanciesIds;
}
