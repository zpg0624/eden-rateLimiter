package com.eden.guavaspringbootdemo;

import com.eden.guavaspringbootdemo.properties.RateLimiterProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RateLimiterProperties.class)
public class GuavaSpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavaSpringBootDemoApplication.class, args);
    }

}
