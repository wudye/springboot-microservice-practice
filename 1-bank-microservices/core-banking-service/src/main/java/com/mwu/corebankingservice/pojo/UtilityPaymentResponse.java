package com.mwu.corebankingservice.pojo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UtilityPaymentResponse {
    private String message;
    private String transactionId;
}
