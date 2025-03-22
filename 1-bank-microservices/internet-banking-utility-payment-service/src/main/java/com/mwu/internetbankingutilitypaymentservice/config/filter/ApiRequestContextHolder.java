package com.mwu.internetbankingutilitypaymentservice.config.filter;

import com.mwu.config.filter.ApiRequestContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiRequestContextHolder {
    private ApiRequestContextHolder() {
    }

    private static final  ThreadLocal<ApiRequestContext> contextHolder = new ThreadLocal<>();

    public static void clearContext() {
        contextHolder.remove();
    }


    public static ApiRequestContext getContext() {
        ApiRequestContext context = contextHolder.get();
        if (context == null) {
            context = new ApiRequestContext();
            contextHolder.set(context);
        }
        return context;
    }

}
