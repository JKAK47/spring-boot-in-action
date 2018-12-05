package org.vincent.web.controller.monitor;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.common.ResponseCode;
import org.vincent.common.config.EhcacheConfiguration;
import org.vincent.web.out.JsonResult;
import org.vincent.web.vo.cache.monitor.CacheInfoVO;
import org.vincent.web.vo.cache.monitor.CacheManagerInfoVO;
import org.vincent.web.vo.cache.monitor.EhcacheManagerVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by PengRong on 2018/12/5.
 * 用于Ehcache  cache监控 ,将信息以Json 格式Export 给页面
 * https://blog.csdn.net/wiker_yong/article/details/52068420
 */
@RestController
@RequestMapping("/monitor/ehcache")
public class EhCacheMonitorController implements InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(EhCacheMonitorController.class);
    /**
     * EhcacheManagerVO
     */
    @Autowired
    @Qualifier(EhcacheConfiguration.EHCACHE_CACHE_MANAGER)
    private CacheManager cacheManager;

    @Resource
    private List<CacheManager> cacheManagers;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cacheManager, "cacheManager is not null");
        Assert.notNull(cacheManagers, "cacheManagers is not null");
    }

    /**
     * 获取所有的CacheManager Name 以及该 CacheManager 下所有的Cache Name
     *
     * @return
     */
    @RequestMapping(name = "getCacheManagerInfos", path = {"/cacheManagers"}, method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getCacheManager(HttpServletRequest request) {
        JsonResult result = new JsonResult();
        result.setCode(ResponseCode.OK);
        if (logger.isDebugEnabled()) {
            logger.debug("get All CacheManager, requestMethod: " + request.getMethod() + " ");
        }
        if (Objects.nonNull(cacheManagers)) {
            int i = 0;
            for (CacheManager cacheManager : cacheManagers) {
                String name = cacheManager.getClass().getSimpleName();
                Collection<String> cacheNames = cacheManager.getCacheNames();
                CacheManagerInfoVO vo = new CacheManagerInfoVO();
                vo.setCacheManagerName(name);
                vo.setCacheNames(cacheNames);
                result.getResult().put("cacheManager[" + (i++) + "]", vo);

            }
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 获取到当前Ehcache 所有的Cache
     *
     * @param request
     * @return
     */
    @RequestMapping(name = "listEhcacheAllCacheInfo", path = {"/allCache"}, method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getEhcacheCache(HttpServletRequest request) {
        JsonResult result = new JsonResult();
        /** 将SpringCache 类型 CacheManager 强转为  ehcache 对应包装类EhCacheCacheManager */
        EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager) cacheManager;
        /** Ehcache Manager */
        net.sf.ehcache.CacheManager ehcacheCacheManager = ehCacheCacheManager.getCacheManager();
        /**  Ehcache Manager Name */
        String ehcacheCacheManagerName = ehcacheCacheManager.getName();
        EhcacheManagerVO vo = new EhcacheManagerVO();
        vo.setCacheManagerName(ehcacheCacheManagerName);
        vo.setCacheInfoVOs(new ArrayList<>());
        /** 获取到ehcache Manager 下所有的Cache 实例名称 */
        String[] cacheNames = ehcacheCacheManager.getCacheNames();
        if (Objects.nonNull(cacheNames)) {
            for (String cacheName : cacheNames) {
                Ehcache ehcache = getEhcache(ehcacheCacheManager, cacheName);
                CacheInfoVO cacheInfoVO = new CacheInfoVO();
                cacheInfoVO.setCacheName(ehcache.getName());
                cacheInfoVO.setCacheConfig(ehcache.toString());
                /** 获取该cache 下所有key */
                List keys = ehcache.getKeys();
                /** 每个key 对应 一个元素 */
                for (Object key : keys) {
                    String keyStr = key.toString();
                    Element element = getElement(ehcache, keyStr);
                    element.getHitCount();
                    element.getCreationTime();
                    element.getLastAccessTime();
                    element.getTimeToIdle();
                    element.getTimeToLive();
                    element.getLastUpdateTime();
                    element.getObjectKey();
                    element.getObjectValue();
                }
                vo.getCacheInfoVOs().add(cacheInfoVO);
            }
        }
        result.getResult().put("EhcacheManager", vo);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据名称获取EhCache的缓存对象 Ehcache
     *
     * @param cacheManager Ehcache 管理器
     * @param cacheName    cache 名称
     * @return
     */
    private Ehcache getEhcache(net.sf.ehcache.CacheManager cacheManager, String cacheName) {
        return cacheManager.getEhcache(cacheName);
    }

    private Element getElement(Ehcache cache, String key) {
        if (cache == null) {
            return null;
        }
        return cache.getQuiet(key);
    }


}
