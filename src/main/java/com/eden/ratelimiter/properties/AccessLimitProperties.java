package com.eden.ratelimiter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

@ConfigurationProperties(prefix = "access")
@Data
public class AccessLimitProperties {

    /**
     * 尝试获取令牌的次数
     */
    int permits;

    /**
     * 尝试等待获取令牌的超时时间
     */
    long timeout;

    TimeUnit unit = TimeUnit.SECONDS;
}
