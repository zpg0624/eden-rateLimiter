package com.eden.ratelimiter.dto;

import com.eden.ratelimiter.annotation.Limit;
import com.eden.ratelimiter.enums.LimitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public class RateLimitParamDto {

    private String defaultKey;

    private Limit limitAnnotation;

    private LimitType limitType;
}
