package com.mwu.corebankingservice.pojo;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class UtilityPaymentRequest {

    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;

}
