package com.mwu.corebankingservice.service;
import com.mwu.corebankingservice.dto.BankAccount;
import com.mwu.corebankingservice.dto.UtilityAccount;
import com.mwu.corebankingservice.exception.EntityNotFoundException;
import com.mwu.corebankingservice.mapper.BankAccountMapper;
import com.mwu.corebankingservice.mapper.UtilityAccountMapper;
import com.mwu.corebankingservice.model.BankAccountEntity;
import com.mwu.corebankingservice.model.UtilityAccountEntity;
import com.mwu.corebankingservice.repository.BankAccountRepository;
import com.mwu.corebankingservice.repository.UtilityAccountRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();
    private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

    private final BankAccountRepository bankAccountRepository;
    private final UtilityAccountRepository utilityAccountRepository;

    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        return bankAccountMapper.convertToDto(entity);
    }

    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).orElseThrow(EntityNotFoundException::new);
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    public UtilityAccount readUtilityAccount(Long id) {
        return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
