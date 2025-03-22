package com.mwu.config.audit;

import com.mwu.config.filter.ApiRequestContextHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        if (StringUtils.isEmpty(ApiRequestContextHolder.getContext().getAuthId())) {
            return Optional.of("SYSTEM_USER");
        }
        return Optional.of(ApiRequestContextHolder.getContext().getAuthId());
    }
}
