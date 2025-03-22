package com.mwu.internetbankingutilitypaymentservice.repository;

import com.mwu.internetbankingutilitypaymentservice.pojo.UtilityPayment;
import com.mwu.internetbankingutilitypaymentservice.pojo.UtilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, UtilityPayment> {
}
