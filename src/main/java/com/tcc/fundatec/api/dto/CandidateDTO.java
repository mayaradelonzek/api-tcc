package com.tcc.fundatec.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O LinkedIn é obrigatório")
    private String linkedin;

    @NotBlank(message = "O celular é obrigatório")
    private String phone;

    private String resume;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}