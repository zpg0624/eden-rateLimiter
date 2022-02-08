package com.eden.ratelimiter.dto;

import com.eden.ratelimiter.annotation.Limit;
import com.eden.ratelimiter.enums.LimitType;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@RequiredArgsConstructor(staticName = "ofAnnotation")
public class RateLimitParamDto {

    private String defaultKey;

    @NonNull
    private Limit limitAnnotation;

    private LimitType limitType;
}
