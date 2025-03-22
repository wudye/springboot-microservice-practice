package com.mwu.corebankingservice.model;

import java.math.BigDecimal;

import com.mwu.corebankingservice.enums.AccountStatus;
import com.mwu.corebankingservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "banking_core_account")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;


    private BigDecimal availableBalance;

    private BigDecimal actualBalance;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
