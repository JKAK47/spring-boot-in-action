package org.vincent.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;


import java.time.Duration;

/**
 * Created by PengRong on 2018/11/26.
 * Redis 单机版配置
 * SpringBoot2.0.5 集成 Redis Config
 * @author PengRong
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    /** Redis 的 CacheManager bean 名称 */
    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";
    /** Ehcache 设定的默认cache 名称 ; 和ehcache 配置文件设置的 cache 名称一致 */
    public static final String REDIS_CACHE_NAME = "redisCache";
    /**
     * Logger
     */
    private static final Logger lg = LoggerFactory.getLogger(RedisConfiguration.class);
    /**
     * 和 application-xxx.properties 文件中 关于 druid 配置项前缀对应
     */
    private static final String DB_PREFIX = "spring.redis";

    /**
     * // 异常处理，当Redis发生异常时，打印日志，但是程序正常走
     *
     * @return CacheErrorHandler
     */
    @Override
    @Bean
    public CacheErrorHandler errorHandler() {

        lg.info("初始化 -> [{}]", "Redis CacheErrorHandler");
        CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                lg.error("Redis occur handleCacheGetError：key -> [{}]", key, e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                lg.error("Redis occur handleCachePutError：key -> [{}]；value -> [{}]", key, value, e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                lg.error("Redis occur handleCacheEvictError：key -> [{}]", key, e);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                lg.error("Redis occur handleCacheClearError：", e);
            }
        };
        return cacheErrorHandler;
    }

    /**
     * 生成key 规则
     *
     * @return
     */
    @Override
    @Bean(name = "redisKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    // 设置redis的cacheManager
    @Bean(name = "redisCacheManager")
    public RedisCacheManager cacheManager(JedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ZERO)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                .disableCachingNullValues();

        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();

        redisCacheManager.afterPropertiesSet();
        return redisCacheManager;
    }


    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        // key 序列化, 必须设置不然key 乱码
        redisTemplate.setKeySerializer(stringSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * stringRedisTemplate 模板
     *
     * @param factory
     * @return
     */
    @Bean("stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        //设置value序列化工具
        setSerializer(stringRedisTemplate);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        // key序列化
        stringRedisTemplate.setKeySerializer(stringSerializer);
        // Hash key序列化
        stringRedisTemplate.setHashKeySerializer(stringSerializer);
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }

    /**
     * 设置 value 序列化工具
     * */
    private void setSerializer(StringRedisTemplate template) {
        @SuppressWarnings({"rawtypes", "unchecked"})
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
    }

    /**
     * 此内部类就是把yml的配置数据，进行读取，创建JedisConnectionFactory和JedisPool，以供外部类初始化缓存管理器使用
     * 不了解的同学可以去看@ConfigurationProperties和@Value的作用
     */
    @Component
    @ConfigurationProperties(prefix = DB_PREFIX)
    class DataJedisProperties {
        @Value("${spring.redis.host}")
        private String host;
        @Value("${spring.redis.password}")
        private String password;
        @Value("${spring.redis.port}")
        private int port;
        @Value("${spring.redis.timeout}")
        private int timeout;
        @Value("${spring.redis.jedis.pool.max-idle}")
        private int maxIdle;
        @Value("${spring.redis.jedis.pool.max-wait}")
        private long maxWaitMillis;
        @Value("${spring.redis.jedis.pool.max-active}")
        private int maxActive;

        /**
         * 用于创建链接单个 redis 实例的  JedisConnectionFactory
         * @return
         */
        @Bean
        JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
            lg.info("Create JedisConnectionFactory successful");
            /**
             * 配置 jedis 客户端功能配置
             */
            JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().
                    readTimeout(Duration.ofMillis(timeout)).connectTimeout(Duration.ofMillis(timeout)).usePooling()
                    .poolConfig(jedisPoolConfig).build();

            /**用于配置创建Redis 链接 的设置  */
            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
            configuration.setHostName(host);
            configuration.setPort(port);
            configuration.setPassword(RedisPassword.of(password));

            /** Jedis ConnectionFactory */
            JedisConnectionFactory factory = new JedisConnectionFactory(configuration,jedisClientConfiguration);
            return factory;
        }

        /**
         * 设置JedisPool 线程池 配置 类
         * @return
         */
        @Bean
        public JedisPoolConfig redisPoolConfig() {
            lg.info("JedisPool init successful，host -> [{}]；port -> [{}]", host, port);
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            jedisPoolConfig.setMaxTotal(maxActive);
            jedisPoolConfig.setTestOnBorrow(true);
            jedisPoolConfig.setTestWhileIdle(true);
            jedisPoolConfig.setTestOnCreate(true);
            /*JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);*/
            return jedisPoolConfig;
        }
    }


}
