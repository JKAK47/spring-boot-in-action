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
import org.vincent.dao.model.TbUser;
import org.vincent.service.ehcacheService.EhcacheService;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache 测试案例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheTest {
    private Logger logger = LoggerFactory.getLogger(EhcacheTest.class);
    @Autowired
    private EhcacheService ehcacheService;


    /**
     * 欺骗缓存框架
     */
    @Test
    public void test() {
        /**
         * key 都是一样 sdfd，第一次调用  saveString 方法以 key = sdfd ，将该函数返回值返回并缓存；
         * 第二次调用  saveint 也是以  key = sdfd  将 缓存，但是因为  saveString 已经缓存了 key = sdfd,value 为字符串类型的缓存对了。 saveint方法将不再调用
         * 直接将  saveString 方法的返回值 作为返回值，然后发生了类型 从String 到 Integer 强转 的错误。
         */
        String value = ehcacheService.saveString("sdfd");
        Integer integer = ehcacheService.saveint("sdfd");
    }

    /**
     * 测试缓存类
     * 获取到 Ehcache 的 CacheManager 包装类，已经被SpringCache 包装 为 EhCacheCacheManager 类
     */
    @Autowired
    @Qualifier(EhcacheConfiguration.EHCACHE_CACHE_MANAGER)
    private CacheManager cacheManager;

    @Test
    public void testsave() {
        logger.error("begin ");
        String value = null;

        String key = "C024";
        String cacheKeyPrefix = "org.vincent.service.ehcacheService.impl.EhcacheServiceImpl";
        String cacheKey = cacheKeyPrefix + key;
        value = ehcacheService.save(key);

        value = ehcacheService.save(key);

        value = ehcacheService.save(key);
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
        String temp1 = cache.get(cacheKey, String.class);// 简单直接说明返回值期望数据类型
        Assert.assertEquals("期望value =1", value, temp1);
        // 第二种方式
        Cache.ValueWrapper wrapper = cache.get(cacheKey);
        if (wrapper != null) {
            String temp2 = (String) wrapper.get();// null 说明 缓存value 可以为 null
            Assert.assertEquals("期望value =1", value, temp2);
        }

        /**
         * 改变key 看是否可以再次执行方法
         */
        key = "C024XX";
        value = ehcacheService.save(key);
        // 第一种方法
        temp1 = cache.get(cacheKeyPrefix + key, String.class);// 简单直接说明返回值期望数据类型
        Assert.assertEquals("期望value =1", value, temp1);
        cache.getNativeCache();
    }

    /**
     * 测试 CachePut 注解的作用
     */
    @Test
    public void testPut() throws InterruptedException {
        String value = null;
        String cacheKeyPrefix = "org.vincent.service.ehcacheService.impl.EhcacheServiceImpl";
        String key = "C024";
        value = ehcacheService.putData(key);
        value = ehcacheService.putData(key);
        logger.debug(value);/** 获取值 */
        Cache cache = cacheManager.getCache(EhcacheConfiguration.EHCACHE_CACHE_NAME);
        /**
         * 取值需要加key 前缀
         */
        Thread.sleep(10000);
        String temp = cache.get(cacheKeyPrefix + key, String.class);
        Assert.assertEquals(value, temp);
    }

    /**
     * 测试 从缓存中 删除缓存案例
     */
    @Test
    public void testEvict() {
        String key = "asdfasd";
        String value = null;
        String cacheKeyPrefix = "org.vincent.service.ehcacheService.impl.EhcacheServiceImpl";
        String cacheKey = cacheKeyPrefix + key;
        /**
         * 增加缓存
         */
        value = ehcacheService.save(key);
        value = ehcacheService.save(key);
        value = ehcacheService.save(key);
        value = ehcacheService.save(key);
        // 从缓存里面取值和第一次接口访问产生返回的值对比
        Cache cache = cacheManager.getCache(EhcacheConfiguration.EHCACHE_CACHE_NAME);
        // 第一种方法
        String temp1 = cache.get(cacheKey, String.class);// 简单直接说明返回值期望数据类型
        Assert.assertEquals("期望value =1", value, temp1);
        /**
         * 刪除緩存，务必用cacheKey，因为你存储的时候key 并不是用的参数，而是加了方法前缀
         */
        ehcacheService.Evict(key);
        /*
        再次去取，为空
         */
        temp1 = cache.get(cacheKey, String.class);// 简单直接说明返回值期望数据类型
        // 判断是否已经从缓存删除了数据
        Assert.assertNull(temp1);
    }

    /**
     * 缓存 对象 TbUser
     */
    @Test
    public void testsaveTbUser() {
        TbUser user = new TbUser();
        user.setId(1);
        user.setUsername("张三");
        user.setAge(18);
        String value = ehcacheService.save(user);
        String temp = ehcacheService.save(user);
        Assert.assertEquals("不等",value,temp);
        Cache cache = cacheManager.getCache(EhcacheConfiguration.EHCACHE_CACHE_NAME);
        String cacheValue = cache.get("org.vincent.service.ehcacheService.impl.EhcacheServiceImpl"+user.getUsername()+user.getAge()+user.getId(),String.class);
        Assert.assertEquals("",value,cacheValue);
    }
}
