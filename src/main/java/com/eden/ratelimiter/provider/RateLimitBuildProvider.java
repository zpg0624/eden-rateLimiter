package com.eden.ratelimiter.provider;

import com.eden.ratelimiter.dto.RateLimitParamDto;

/**
 * 限流基础构建
 */
public interface RateLimitBuildProvider extends RequestBaseProvider{


    String determineKey(RateLimitParamDto limitParamDto);


    String buildScript();
}
