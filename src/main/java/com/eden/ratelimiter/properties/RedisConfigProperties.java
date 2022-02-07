package com.eden.ratelimiter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = RedisConfigProperties.PREFIX)
public class RedisConfigProperties {


    static final String PREFIX = "redisconfig";

    private String hosts;

    private String keyPrefix;

    private Integer defaultTTL;

}
