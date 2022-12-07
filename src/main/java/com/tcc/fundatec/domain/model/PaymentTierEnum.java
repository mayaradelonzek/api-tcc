package com.tcc.fundatec.domain.model;

public enum PaymentTierEnum {

    SUPER_PREMIMUM(2),
    PREMIUM(1),
    FREE(0);

    private Integer priority;

    PaymentTierEnum(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return this.priority;
    }

}
