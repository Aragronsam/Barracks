package com.binaryhunter.framework.cache.redis;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis缓存配置类
 * @author BinaryHunter
 * 2017年1月3日
 */
@Configuration  
@EnableCaching  
public class RedisCacheConfig extends CachingConfigurerSupport {  
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
	
    @SuppressWarnings("rawtypes")
	@Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
        // Number of seconds before expiration. Defaults to unlimited (0)  
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)  
        return cacheManager;  
    }
    
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {  
            @Override  
            public Object generate(Object o, Method method, Object... objects) {  
                StringBuilder sb = new StringBuilder();  
                sb.append(o.getClass().getName());  
                sb.append(".").append(method.getName());  
                for (Object obj : objects) {  
                    sb.append(obj.toString());  
                }  
                logger.debug("Key generator " + sb.toString());
                return sb.toString();  
            }  
        };  
    } 
} 