package com.mwu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkUri;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        ServerHttpSecurity httpSecurity = http
                .authorizeExchange(exchange -> {
                    exchange.pathMatchers("/user/api/v1/bank-users/register").permitAll();
                    exchange.pathMatchers("/actuator/**").permitAll()
                            .pathMatchers("/user/actuator/**").permitAll()
                            .pathMatchers("/fund-transfer/actuator/**").permitAll()
                            .pathMatchers("/banking-core/actuator/**").permitAll()
                            .pathMatchers("/utility-payment/actuator/**").permitAll()
                            .anyExchange().authenticated();

                });
        httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);
        httpSecurity.oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec
                .jwt(jwt->jwt.jwkSetUri(jwkUri)));
        return httpSecurity.build();
    }
}
