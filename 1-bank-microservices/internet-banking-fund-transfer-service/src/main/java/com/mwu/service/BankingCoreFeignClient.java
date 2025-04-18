package com.mwu.service;


import com.mwu.config.CustomFeignClientConfiguration;
import com.mwu.pojo.request.FundTransferRequest;
import com.mwu.pojo.response.AccountResponse;
import com.mwu.pojo.response.FundTransferResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "core-banking-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreFeignClient {

    @RequestMapping(path = "/api/v1/account/bank-account/{account_number}", method = RequestMethod.GET)
    AccountResponse readAccount(@PathVariable("account_number") String accountNumber);

    @RequestMapping(path = "/api/v1/transaction/fund-transfer", method = RequestMethod.POST)
    FundTransferResponse fundTransfer(@RequestBody FundTransferRequest fundTransferRequest);

}
