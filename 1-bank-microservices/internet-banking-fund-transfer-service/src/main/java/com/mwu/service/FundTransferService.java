package com.mwu.service;

import com.mwu.pojo.FundTransferEntity;
import com.mwu.pojo.TransactionStatus;
import com.mwu.pojo.dto.FundTransfer;
import com.mwu.pojo.mapper.FundTransferMapper;
import com.mwu.pojo.request.FundTransferRequest;
import com.mwu.pojo.response.FundTransferResponse;
import com.mwu.repository.FundTransferRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundTransferService {

    private final FundTransferRepository fundTransferRepository;
    private final BankingCoreFeignClient bankingCoreFeignClient;

    private FundTransferMapper mapper = new FundTransferMapper();

    public FundTransferResponse fundTransfer(FundTransferRequest request) {
        log.info("Sending fund transfer request {}" + request.toString());

        FundTransferEntity entity = new FundTransferEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setStatus(TransactionStatus.PENDING);
        FundTransferEntity optFundTransfer = fundTransferRepository.save(entity);

        FundTransferResponse fundTransferResponse = bankingCoreFeignClient.fundTransfer(request);
        optFundTransfer.setTransactionReference(fundTransferResponse.getTransactionId());
        optFundTransfer.setStatus(TransactionStatus.SUCCESS);
        fundTransferRepository.save(optFundTransfer);

        fundTransferResponse.setMessage("Fund Transfer Successfully Completed");
        return fundTransferResponse;

    }

    public List<FundTransfer> readAllTransfers(Pageable pageable) {
        return mapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
    }
}
