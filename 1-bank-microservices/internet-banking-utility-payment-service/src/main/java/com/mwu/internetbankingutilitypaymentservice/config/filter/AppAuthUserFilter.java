package com.mwu.internetbankingutilitypaymentservice.config.filter;

import com.mwu.config.filter.ApiRequestContextHolder;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
public class AppAuthUserFilter  implements Filter {
    private static final String HTTP_HEADER_AUTH_USER_ID = "X-Auth-Id";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authId = httpServletRequest.getHeader(HTTP_HEADER_AUTH_USER_ID);
        log.info("Current Auditor : {}", authId);
        if (!StringUtils.isEmpty(authId)) {
            ApiRequestContextHolder.getContext().setAuthId(authId);
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            ApiRequestContextHolder.clearContext();
        }
    }
}
