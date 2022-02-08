package com.eden.ratelimiter.service;

import com.eden.ratelimiter.annotation.Limit;
import com.eden.ratelimiter.dto.RateLimitParamDto;
import com.eden.ratelimiter.handler.AbstractRateLimiter;
import com.eden.ratelimiter.properties.AccessLimitProperties;
import com.eden.ratelimiter.provider.RateLimitBuildProvider;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class AbstractAccessLimitService {
    @Autowired
    AbstractRateLimiter abstractRateLimiter;

    @Autowired
    AccessLimitProperties accessLimitProperties;

    @Autowired
    RateLimitBuildProvider rateLimitBuildProvider;


    protected static RateLimiter rateLimiterStatic;

    public RateLimiter determineRateLimiter() {
        RateLimiter rateLimiter = this.abstractRateLimiter.getRateLimiter();
        rateLimiterStatic = rateLimiter;
        return rateLimiter;
    }

    public RateLimiter getRateLimiter() {
        RateLimiter rateLimiter = Optional.ofNullable(rateLimiterStatic)
                .orElseGet(this::determineRateLimiter);
        return rateLimiter;
    }

    public abstract boolean executeSingleRateLimit();

    public abstract void executeRedisDistributedRateLimit(RateLimitParamDto limitParamDto);
}
