package org.vincent.ehcache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.common.config.EhcacheConfiguration;
import org.vincent.service.ehcacheService.EhcacheService;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache 测试案例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheTest {
    private Logger logger =LoggerFactory.getLogger(EhcacheTest.class);
    @Autowired
    private EhcacheService ehcacheService;

    /**
     * 获取到 Ehcache 的 CacheManager 包装类，已经被SpringCache 包装 为 EhCacheCacheManager 类
     */
    @Autowired
    @Qualifier(EhcacheConfiguration.EHCACHE_CACHE_MANAGER)
    private CacheManager cacheManager;
    @Test
    public void test() {
        logger.error("begin ");
        String value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");
        /**
         * 强转 获取到ehcache 的包装类
         */
        EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager) cacheManager;
        /**
         * 获取到真正的 Ehcache 库的 CacheManager,并输出 其名称
         */
        net.sf.ehcache.CacheManager xx = ehCacheCacheManager.getCacheManager();
        System.out.println(xx.getName());

        // 从缓存里面取值和第一次接口访问产生返回的值对比
        Cache cache = cacheManager.getCache(EhcacheConfiguration.EHCACHE_CACHE_NAME);
        // 第一种方法
        String temp1 = cache.get("C024",String.class);// 简单直接说明返回值期望数据类型
        Assert.assertEquals("期望value =1",value,temp1);
        // 第二种方式
        Cache.ValueWrapper wrapper =cache.get("C024");
        if (wrapper !=null){
          String temp2 = (String) wrapper.get();// null 说明 缓存value 可以为 null
          Assert.assertEquals("期望value =1",value,temp2);
        }
    }
}
