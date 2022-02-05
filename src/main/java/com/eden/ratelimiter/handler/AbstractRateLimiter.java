package com.eden.ratelimiter.handler;

import com.eden.ratelimiter.properties.RateLimiterProperties;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRateLimiter {

    @Autowired
    RateLimiterProperties rateLimiterProperties;

    public abstract RateLimiter getRateLimiter();
}
