package org.vincent.web.vo.cache.monitor;

import java.util.Collection;


/**
 * Created by PengRong on 2018/12/5.
 * 返回给页面的 CacheManagerVo 页面显示对象
 */
public class CacheManagerVO {
    /**
     * cacheManager Name
     */
    private  String cacheManagerName;
    /**
     * 改 cacheManager 下的所欲 Cache Name
     */
    private Collection<String> cacheNames;

    public CacheManagerVO() {
    }

    public String getCacheManagerName() {
        return cacheManagerName;
    }

    public void setCacheManagerName(String cacheManagerName) {
        this.cacheManagerName = cacheManagerName;
    }

    public Collection<String> getCacheNames() {
        return cacheNames;
    }

    public void setCacheNames(Collection<String> cacheNames) {
        this.cacheNames = cacheNames;
    }
}
