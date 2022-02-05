package com.eden.ratelimiter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @created by eden
 * @since 2019-04-15 下午 5:03:33
 */

@ConfigurationProperties(prefix = "rate")
@Data
public class RateLimiterProperties {

    /**
     * 每秒生成令牌數
     */
    private Integer count;

}
