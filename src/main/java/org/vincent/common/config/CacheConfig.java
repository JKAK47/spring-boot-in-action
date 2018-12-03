package org.vincent.common.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.cache.RedisCacheManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by PengRong on 2018/11/27.
 * 统一 redis 和ehcache 两者缓存框架,
 * 其他的缓存框架如果需要集成在一次也是需要在这个集成进来
 */
@Configuration
@EnableCaching
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CacheConfig implements ApplicationRunner {

    @Resource
    private List<CacheManager> cacheManagers;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("cacheManagers.Size :"+cacheManagers.size());
    }
    @Bean(name = "cacheManager")
    @Primary
    public CompositeCacheManager cacheManager(RedisCacheManager redisCacheManager, EhCacheCacheManager ehCacheCacheManager) {
        CompositeCacheManager cacheManager = new CompositeCacheManager(redisCacheManager, ehCacheCacheManager);
        return cacheManager;
    }
}
