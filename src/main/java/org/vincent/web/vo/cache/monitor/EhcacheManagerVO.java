package org.vincent.web.vo.cache.monitor;

import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.web.vo.cache.monitor
 * @date 2018/12/6 - 1:12
 * @ProjectName spring-boot-in-action
 * @Description: Ehcache下一个EhcacheManager所有相关的信息
 */
public class EhcacheManagerVO {
    private  String cacheManagerName;
    List<CacheInfoVO> cacheInfoVOs;

    public EhcacheManagerVO() {
    }

    public String getCacheManagerName() {
        return cacheManagerName;
    }

    public void setCacheManagerName(String cacheManagerName) {
        this.cacheManagerName = cacheManagerName;
    }

    public List<CacheInfoVO> getCacheInfoVOs() {
        return cacheInfoVOs;
    }

    public void setCacheInfoVOs(List<CacheInfoVO> cacheInfoVOs) {
        this.cacheInfoVOs = cacheInfoVOs;
    }
}
