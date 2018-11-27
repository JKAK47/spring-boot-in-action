package org.vincent.service.redisService.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.vincent.service.redisService.ServiceRedisCache;

/**
 * Created by PengRong on 2018/11/27.
 * https://blog.csdn.net/wgxaszc8/article/details/68924779
 *
 */
@Service
public class ServiceRedisCacheImpl implements ServiceRedisCache{
    private Logger logger= LoggerFactory.getLogger(ServiceRedisCacheImpl.class);
    @Override
    @Cacheable(value = "ServiceRedisCache#2#5", key="#key")
    public String getName(String key) {
        logger.error("不从缓存去");
        return key+" : value";
    }
}
