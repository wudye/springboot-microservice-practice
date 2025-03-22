package com.mwu.config.audit;

import com.mwu.config.filter.AppAuthUserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareConfig();
    }

    @Bean
    public FilterRegistrationBean<AppAuthUserFilter> auditorFilter() {


        FilterRegistrationBean<AppAuthUserFilter> registrationBean = new FilterRegistrationBean<>();
        AppAuthUserFilter appAuthUserFilter = new AppAuthUserFilter();
        registrationBean.setFilter(appAuthUserFilter);
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
