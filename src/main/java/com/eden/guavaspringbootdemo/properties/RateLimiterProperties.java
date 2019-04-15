package com.eden.guavaspringbootdemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @created by eden
 * @since 2019-04-15 下午 5:03:33
 */

@ConfigurationProperties(prefix = "rate")
@Data
public class RateLimiterProperties {

    private Integer count;


}
