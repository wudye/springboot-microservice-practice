package com.mwu.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Configuration
public class GateWayConfiguration {

    private static final String HTTP_HEADER_AUTH_USER_ID = "X-Auth-Id";
    private static final String UNAUTHORIZED_USER_NAME = "SYSTEM USER";

    @Bean
    public GlobalFilter customFilter() {

        return ((exchange, chain) ->
                exchange.getPrincipal().map(
                        Principal::getName
                ).defaultIfEmpty(UNAUTHORIZED_USER_NAME).map(
                        principal -> {
                            exchange.getRequest()
                                    .mutate()
                                    .header(HTTP_HEADER_AUTH_USER_ID, principal)
                                    .build();
                            return exchange;
                        }
                ).flatMap(chain::filter).then(Mono.fromRunnable(() -> {

                }) )
                );
    }


}
