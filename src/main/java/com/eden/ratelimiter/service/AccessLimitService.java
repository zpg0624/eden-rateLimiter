package com.eden.ratelimiter.service;

import com.eden.ratelimiter.RequestUtil;
import com.eden.ratelimiter.annotation.Limit;
import com.eden.ratelimiter.enums.LimitType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @created by eden
 * @since 2019-04-15 上午 11:16:08
 */

@Service
@Slf4j
public class AccessLimitService extends AbstractAccessLimitService {


    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 单机限流
     * @return
     */
    @SneakyThrows
    @Override
    public boolean executeSingleRateLimit() {
        return getRateLimiter().tryAcquire(accessLimitProperties.getPermits(),
                accessLimitProperties.getTimeout(), accessLimitProperties.getUnit());
    }


    /**
     * 分布式redis做限流
     * @param limitAnnotation
     */
    @SneakyThrows
    @Override
    public void executeRedisDistributedRateLimit(Limit limitAnnotation)  {
        LimitType limitType = limitAnnotation.limitType();
        String key = RequestUtil.determineKey("executeRedisDistributedRateLimit", limitAnnotation, limitType);
        List<String> keys = Arrays.asList(StringUtils.join(limitAnnotation.prefix(), key));
        String luaScript =  RequestUtil.buildLuaScript();
        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
        Number count = redisTemplate.execute(redisScript, keys, limitAnnotation.count(),  limitAnnotation.period());
        if (Objects.isNull(count) || count.intValue() > limitAnnotation.count()) {
           throw new RuntimeException("该接口请求太频繁");
        }
    }
}
