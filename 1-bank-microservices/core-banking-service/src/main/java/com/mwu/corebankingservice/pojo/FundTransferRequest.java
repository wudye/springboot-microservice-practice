package com.mwu.corebankingservice.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
