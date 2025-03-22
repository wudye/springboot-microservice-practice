package com.mwu.corebankingservice.repository;


import com.mwu.corebankingservice.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
