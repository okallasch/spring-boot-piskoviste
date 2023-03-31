package org.gopas.springbootdemo.config;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Configuration
@EnableCaching
public class CacheConfig {

    // Caffeine Cache, EHCache

//    private final ConcurrentMap<Long, List<Person>> map = new ConcurrentHashMap<>();

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("persons");
    }
}
