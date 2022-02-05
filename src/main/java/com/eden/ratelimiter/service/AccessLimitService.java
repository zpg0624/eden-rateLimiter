package com.eden.ratelimiter.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @created by eden
 * @since 2019-04-15 上午 11:16:08
 */

@Service
public class AccessLimitService extends AbstractAccessLimitService {

    @SneakyThrows
    @Override
    public boolean tryAcquire() {
        return getRateLimiter().tryAcquire(accessLimitProperties.getPermits(),
                accessLimitProperties.getTimeout(), accessLimitProperties.getUnit());
    }
}
