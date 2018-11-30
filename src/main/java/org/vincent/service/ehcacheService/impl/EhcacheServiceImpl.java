package org.vincent.service.ehcacheService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.vincent.common.config.EhcacheConfiguration;
import org.vincent.service.ehcacheService.EhcacheService;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache测试服务类
 */
@Service
@CacheConfig(cacheManager = EhcacheConfiguration.EHCACHE_CACHE_MANAGER,cacheNames = EhcacheConfiguration.EHCACHE_CACHE_NAME)
public class EhcacheServiceImpl implements EhcacheService {
    private Logger logger = LoggerFactory.getLogger(EhcacheServiceImpl.class);

    /**
     * 用于缓存对象，每次缓存之前需要先检查是否存在缓存，如果存在缓存将不会再次执行方法体。
     * @param key
     * @return
     */
    @Override
    @Cacheable(key = "#root.methodName + #key")
    public String save(String key) {
        logger.error("not use ehcache . key "+key);
        return key + "value";
    }

    /**
     * CachePut 能保证每次调用方法都会执行方法体。
     * @param key
     * @return
     */
    @CachePut(key = "#root.methodName + #key")
    @Override
    public String putData(String key) {
        return null;
    }

    /**
     *
     * @param key
     */
    @Override
    public void Evict(String key) {

    }


}
