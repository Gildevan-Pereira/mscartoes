package com.eureka.mscartoes.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestDataForCardIssue {

    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal limitReleased;

}