package com.tcc.fundatec.api.dto;

import com.tcc.fundatec.domain.model.Company;
import com.tcc.fundatec.domain.model.PaymentTier;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class CreateCompanyOutput {

    private String tradingName;
    private String companyName;
    private String cnpj;
    private String paymentTier;
    private String email;
    private String linkedin;
    private String phone;
    private String address;
    private List<Long> vacanciesIds;

    public CreateCompanyOutput(Company company) {
        this.tradingName = company.getTradingName();
        this.companyName = company.getCompanyName();
        this.cnpj = company.getCnpj();
        this.email = company.getEmail();
        this.linkedin = company.getLinkedin();
        this.phone = company.getPhone();
        this.address = company.getAddress();
        this.paymentTier = Optional.ofNullable(company.getPaymentTier())
                .orElse(new PaymentTier())
                .getName();
    }
}
