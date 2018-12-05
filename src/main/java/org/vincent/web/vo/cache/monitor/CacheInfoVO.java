package org.vincent.web.vo.cache.monitor;

import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.web.vo.cache.monitor
 * @date 2018/12/6 - 1:14
 * @ProjectName spring-boot-in-action
 * @Description: 关于一个Cache 相关的信息
 */
public class CacheInfoVO {
    public CacheInfoVO() {
    }

    String cacheName;
    String cacheConfig;
    List<ElementVO> elementVOs;

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheConfig() {
        return cacheConfig;
    }

    public void setCacheConfig(String cacheConfig) {
        this.cacheConfig = cacheConfig;
    }

    public List<ElementVO> getElementVOs() {
        return elementVOs;
    }

    public void setElementVOs(List<ElementVO> elementVOs) {
        this.elementVOs = elementVOs;
    }
}
