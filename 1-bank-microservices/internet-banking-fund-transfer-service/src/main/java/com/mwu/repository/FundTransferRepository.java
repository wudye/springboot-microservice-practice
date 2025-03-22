package com.mwu.repository;

import com.mwu.pojo.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FundTransferRepository extends JpaRepository<FundTransferEntity, Long> {
}
