package org.vincent.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.common.config.EhcacheConfiguration;
import org.vincent.common.util.ResponseCode;
import org.vincent.web.out.JsonResult;
import org.vincent.web.vo.cache.monitor.CacheManagerVO;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by PengRong on 2018/12/5.
 * 用于Ehcache  cache监控 ,将信息以Json 格式Export 给页面
 */
@RestController
@RequestMapping("/ehcache")
public class EhCacheMonitorController implements InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(EhCacheMonitorController.class);
    /**
     * EhcacheManager
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
                CacheManagerVO vo = new CacheManagerVO();
                vo.setCacheManagerName(name);
                vo.setCacheNames(cacheNames);
                result.getResult().put("cacheManager[" + (i++) + "]", vo);

            }
        }
        return ResponseEntity.ok(result);
    }


}
