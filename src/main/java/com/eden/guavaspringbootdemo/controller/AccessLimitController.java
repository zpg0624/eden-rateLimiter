package com.eden.guavaspringbootdemo.controller;

import com.eden.guavaspringbootdemo.service.AccessLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @created by eden
 * @since 2019-04-15 上午 11:18:13
 */

@RestController
public class AccessLimitController {


    @Autowired
    AccessLimitService accessLimitService;


    @GetMapping("/access")
    public String access() throws IllegalAccessException {
        boolean tryAcquire = accessLimitService.getRateLimiter()
                .tryAcquire();
        if (tryAcquire) {
            accessLimitService.addData();
            return "success";
        } else {
            throw new IllegalAccessException("failed");
        }

    }
}
