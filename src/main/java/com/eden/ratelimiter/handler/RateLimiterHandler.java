package com.eden.ratelimiter.handler;

import com.eden.ratelimiter.properties.RateLimiterProperties;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @created by eden
 * @since 2019-04-15 下午 4:58:54
 */

@Component
public class RateLimiterHandler extends AbstractRateLimiter {

    @Override
    public RateLimiter getRateLimiter(){
        RateLimiter rateLimiter = RateLimiter.create(rateLimiterProperties.getCount());
        return rateLimiter;
    }

}
