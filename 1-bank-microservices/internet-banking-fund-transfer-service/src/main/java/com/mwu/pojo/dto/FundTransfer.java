package com.mwu.pojo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FundTransfer extends AuditAware {
    private Long id;
    private String transactionReference;
    private String status;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
