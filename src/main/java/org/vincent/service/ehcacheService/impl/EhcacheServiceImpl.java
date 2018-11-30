package org.vincent.service.ehcacheService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
     * CachePut 注解能保证每次调用方法都会执行方法体。
     * @param key
     * @return
     */
    @CachePut(key = "#root.methodName + #key")
    @Override
    public String putData(String key) {
        /** 返回入参和 value */
        logger.info("putData print");
        return "key :"+key +", value: "+123;
    }

    /**
     * 删除缓存,在方法執行前進行刪除緩存
     * @param key
     */
    @CacheEvict(key = "#key",beforeInvocation = true)
    @Override
    public void Evict(String key) {
        logger.debug("删除了 key  为"+key+"的缓存，");
    }

    /**
     * 测试一个 key相同但是返回值类型不同的缓存项，测试 key
     */
    /**
     * 返回 String
     * @param key
     * @return
     */
    @Cacheable(key = "#key")
    @Override
    public  String saveString(String key){
        logger.debug("saveString invoke");
        return  "Vicent";
    }

    /**
     * 返回 int
     * @param key
     * @return
     */
    @Cacheable(key = "#key")
    @Override
    public  int saveint(String key){
        logger.debug("saveint invoke");
        return  555;
    }




}
