package com.eden.guavaspringbootdemo.service;

import com.eden.guavaspringbootdemo.utils.RateLimiterUtils;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @created by eden
 * @since 2019-04-15 上午 11:16:08
 */

@Service
public class AccessLimitService {


    @Autowired
    RateLimiterUtils rateLimiterUtils;

    private static RateLimiter rateLimiterStatic;

    public  RateLimiter  determineRateLimiter(){
        RateLimiter rateLimiter = rateLimiterUtils.getRateLimiter();
        rateLimiterStatic  = rateLimiter;
        return  rateLimiter;
    }

    public synchronized RateLimiter getRateLimiter(){
        RateLimiter rateLimiter = Optional.ofNullable(rateLimiterStatic)
                .orElseGet(this::determineRateLimiter);
        return rateLimiter;
    }


    /**
     * 模拟业务
     *
     */
    public void  addData(){
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
