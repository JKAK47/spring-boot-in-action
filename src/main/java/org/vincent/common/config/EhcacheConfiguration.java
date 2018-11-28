package org.vincent.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by PengRong on 2018/11/27.
 * Encache Config 集成配置
 */
@Configuration
@EnableCaching
public class EhcacheConfiguration {
    /** Ehcache 的cacheManager bean 名称 */
    public static final String EHCACHE_CACHE_MANAGER = "ehCacheCacheManager";
    /** Ehcache 设定的默认cache 名称 ; 和ehcache 配置文件设置的 cache 名称一致 */
    public static final String EHCACHE_CACHE_NAME = "demo";
    /**
     * java bean 配置 Ehcache 不使用 xml 配置文件进行配置
     * @return
     */
    /*@Bean(destroyMethod = "shutdown", name = "ehcache")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("demo");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }*/
    @Bean(name = "ehcache")
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheBean = new EhCacheManagerFactoryBean();
        cacheBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return cacheBean;
    }

    @Bean("ehCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(@Qualifier("ehcache") net.sf.ehcache.CacheManager ehcacheManager) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehcacheManager);
        return ehCacheCacheManager;
    }
}
