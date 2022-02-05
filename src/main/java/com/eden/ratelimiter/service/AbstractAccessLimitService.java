package com.eden.ratelimiter.service;

import com.eden.ratelimiter.handler.RateLimiterHandler;
import com.eden.ratelimiter.properties.AccessLimitProperties;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class AbstractAccessLimitService {
    @Autowired
    RateLimiterHandler rateLimiterHandler;
    @Autowired
    AccessLimitProperties accessLimitProperties;
    protected static RateLimiter rateLimiterStatic;

    public RateLimiter determineRateLimiter() {
        RateLimiter rateLimiter = this.rateLimiterHandler.getRateLimiter();
        rateLimiterStatic = rateLimiter;
        return rateLimiter;
    }

    public RateLimiter getRateLimiter() {
        RateLimiter rateLimiter = Optional.ofNullable(rateLimiterStatic)
                .orElseGet(this::determineRateLimiter);
        return rateLimiter;
    }

    public abstract boolean tryAcquire();
}
