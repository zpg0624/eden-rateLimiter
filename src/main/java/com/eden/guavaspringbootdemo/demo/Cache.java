package com.eden.guavaspringbootdemo.demo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @created by eden
 * @since 2019-04-18 下午 2:27:29
 */
@Slf4j
public class Cache {

    public static com.google.common.cache.CacheLoader<String, Employee> createCacheLoader() {
        return new com.google.common.cache.CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                log.info("加载创建key:" + key);
                return new Employee(key, key + "dept", key + "id");
            }
        };
    }

    LoadingCache<String, Employee> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(30L, TimeUnit.MILLISECONDS)
            .build(createCacheLoader());
}
