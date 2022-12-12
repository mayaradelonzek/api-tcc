package com.tcc.fundatec.api.dto;

import com.tcc.fundatec.domain.model.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateInput {

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

//    @NotBlank(message = "O endereço é obrigatório")
    private String address;
    private List<Competence> competences;



}
