package org.vincent.service.ehcacheService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.vincent.service.ehcacheService.EhcacheService;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache测试服务类
 */
@Service
@CacheConfig(cacheManager = "ehCacheCacheManager",cacheNames = "demo")
public class EhcacheServiceImpl implements EhcacheService {
    private Logger logger = LoggerFactory.getLogger(EhcacheServiceImpl.class);
    @Override
    @Cacheable(key = "#key")
    public String save(String key) {
        logger.error("not use ehcache . key "+key);
        return key + "value";
    }
}
