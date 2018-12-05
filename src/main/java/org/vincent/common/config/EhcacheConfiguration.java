package org.vincent.common.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
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
    /**
     * Ehcache 的cacheManager bean 名称
     */
    public static final String EHCACHE_CACHE_MANAGER = "ehCacheCacheManager";
    /**
     * Ehcache 设定的默认cache 名称 ; 和ehcache 配置文件设置的 cache 名称一致
     */
    public static final String EHCACHE_CACHE_NAME = "demo";

    /**
     * java bean 配置 Ehcache 不使用 xml 配置文件进行CacheConfiguration配置
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown", name = "ehcache")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        /**
         * 设置一个 CacheConfig  配置
         */
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        /** 设置Cache 名字 */
        cacheConfiguration.setName(EHCACHE_CACHE_NAME);
        /** 设置在JVM Heap 内存中能缓存的最大元素个数 */
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        // 和setMaxEntriesLocalHeap方法设置的属性一致， 使用 setMaxEntriesLocalHeap 方法替代
        cacheConfiguration.setMaxElementsInMemory(1000);
        /** 设置元素是否永远存在,如果永远，超时设置忽略 ，元素永不过期 */
        cacheConfiguration.setEternal(false);
        /** 设置 内存存储达到设置元素个数后是否持久化到硬盘 */
        cacheConfiguration.setOverflowToDisk(false);

        /**
         * timeToIdleSeconds : 表示该缓存不被访问空闲多久
         * timeToLiveSeconds : 表示该缓存项可以存活的最长时间
         */
        /** 设置元素到过期删除之间的空闲时间需要多久 */
        cacheConfiguration.setTimeToIdleSeconds(60 * 60 * 2);
        /** 设置缓存元素 在JVM 生存的时间 */
        cacheConfiguration.setTimeToLiveSeconds(60 * 60 * 24);
        /** 设置 磁盘失效线程运行时间间隔，默认为120秒 */
        cacheConfiguration.setDiskExpiryThreadIntervalSeconds(120);
        /** 设置cache 过期策略 LRU LFU FIFO */
        cacheConfiguration.setMemoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU.toString());
        cacheConfiguration.setTransactionalMode("OFF");
        /**
         * 设置Ehcache 的配置类, 并设置CacheManager Name
         * */
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration()
                .name(EHCACHE_CACHE_MANAGER).cache(cacheConfiguration);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    /**
     * Ehcache Cache 配置从 xml 配置导入
     * @return
     */
    @Bean(name = "Xmlehcache")
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();

        /**
         * 获取配置文件资源也可以通过这个方法
         * URL ehcacheUrl = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "cache/ehcache.xml");
         * logger.debug(ehcacheUrl.toString());
         * cacheManagerFactoryBean.setConfigLocation(new UrlResource(ehcacheUrl));
         */
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        // 给 EhcacheManager 设置名称
        cacheManagerFactoryBean.setCacheManagerName("ehCacheManager");

        return cacheManagerFactoryBean;
    }
    /**
     *Spring cache lib 对 ehCacheCacheManager EhCache Manager的包装类
     */
    @Bean("ehCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(@Qualifier("ehcache") net.sf.ehcache.CacheManager ehcacheManager) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehcacheManager);
        return ehCacheCacheManager;
    }
}
