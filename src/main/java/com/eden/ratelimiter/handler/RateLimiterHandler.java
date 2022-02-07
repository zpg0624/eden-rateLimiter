package com.eden.ratelimiter.handler;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

/**
 * @created by eden
 * @since 2019-04-15 下午 4:58:54
 */

@Component
public class RateLimiterHandler extends AbstractRateLimiter {

    /**
     * 单机版限流
     * @return
     */
    @Override
    public RateLimiter getRateLimiter(){
        RateLimiter rateLimiter = RateLimiter.create(rateLimiterProperties.getCount());
        return rateLimiter;
    }

}
