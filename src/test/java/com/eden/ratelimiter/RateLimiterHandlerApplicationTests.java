package com.eden.ratelimiter;

import com.eden.ratelimiter.service.AccessLimitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateLimiterHandlerApplicationTests {


    @Autowired
    AccessLimitService accessLimitService;

    @Test
    public void contextLoads() {

        boolean tryAcquire = accessLimitService.getRateLimiter().tryAcquire();
        if (tryAcquire) {
            /**
             * 模拟业务
             */
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

}
