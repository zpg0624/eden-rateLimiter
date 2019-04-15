package com.eden.guavaspringbootdemo.utils;

import com.eden.guavaspringbootdemo.properties.RateLimiterProperties;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @created by eden
 * @since 2019-04-15 下午 4:58:54
 */

@Component
public class RateLimiterUtils {

    @Autowired
    RateLimiterProperties rateLimiterProperties;


    public  RateLimiter  getRateLimiter(){
        RateLimiter rateLimiter = RateLimiter.create(rateLimiterProperties.getCount());
        return rateLimiter;
    }



}
