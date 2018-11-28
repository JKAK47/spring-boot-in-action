package org.vincent.service.redisService.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.vincent.common.config.RedisConfiguration;
import org.vincent.service.redisService.ServiceRedisCache;

/**
 * Created by PengRong on 2018/11/27.
 * https://blog.csdn.net/wgxaszc8/article/details/68924779
 *
 */
@Service
@CacheConfig(cacheManager = RedisConfiguration.REDIS_CACHE_MANAGER,cacheNames = RedisConfiguration.REDIS_CACHE_NAME)
public class ServiceRedisCacheImpl implements ServiceRedisCache{
    private Logger logger= LoggerFactory.getLogger(ServiceRedisCacheImpl.class);
    @Override
    @Cacheable(key="#key")
    public String getName(String key) {
        logger.error("不从缓存去");
        return key+" : value";
    }
}
