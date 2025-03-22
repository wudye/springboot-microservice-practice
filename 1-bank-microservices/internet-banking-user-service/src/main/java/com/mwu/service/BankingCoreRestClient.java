package com.mwu.service;

import com.mwu.pojo.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "core-banking-service")
public interface BankingCoreRestClient {

    @GetMapping("/api/v1/user/{identification}")
    UserResponse readUser(@PathVariable("identification") String identification);

}
