package org.vincent.service.ehcacheService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.vincent.common.config.EhcacheConfiguration;
import org.vincent.dao.impl.TbUserMapper;
import org.vincent.dao.model.TbUser;
import org.vincent.dao.model.TbUserExample;
import org.vincent.service.ehcacheService.EhcacheService;

import java.util.List;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache测试服务类
 */
@Service
@CacheConfig(cacheManager = EhcacheConfiguration.EHCACHE_CACHE_MANAGER, cacheNames = EhcacheConfiguration.EHCACHE_CACHE_NAME)
public class EhcacheServiceImpl implements EhcacheService {
    private Logger logger = LoggerFactory.getLogger(EhcacheServiceImpl.class);

    @Autowired
    private TbUserMapper tbUserMapper;
    /**
     * 定义一个方法用于产生缓存key前缀保证key的唯一性 ，勿作他用
     * 必须保证方法是用  public 修饰的，
     * @return
     */
    public String getPrefix() {
        String result = null;
        result = this.getClass().getName();
       // result = result.replace('.', ':');
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        EhcacheServiceImpl b = new EhcacheServiceImpl();
        System.out.println(b.getPrefix());

    }

    /**
     * 缓存一个对象，同时通过
     * @param user
     * @return
     */
    @Cacheable(key = "#root.target.getPrefix()+ #user.username + #user.age + #user.id")
    @Override
    public String save(TbUser user) {
        TbUser temp = null;
        TbUserExample example=new  TbUserExample();
        example.createCriteria().andAgeEqualTo(user.getAge()).andUsernameEqualTo(user.getUsername()).andIdEqualTo(user.getId());
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if (tbUsers!=null && tbUsers.size()>0){
              temp = tbUsers.get(0);
        }
        return temp.toString();
    }

    /**
     * 用于缓存对象，每次缓存之前需要先检查是否存在缓存，如果存在缓存将不会再次执行方法体。
     * 调用当前类的 的全类名作为key 防止冲突
     * @param key
     * @return
     */
    @Override
    @Cacheable(key = "#root.target.getPrefix() + #key")
    public String save(String key) {
        logger.error("not use ehcache . key " + key);

        return key + "value";
    }

    /**
     * CachePut 注解能保证每次调用方法都会执行方法体。
     *
     * @param key
     * @return
     */
    @CachePut(key = "#root.target.getPrefix() + #key")
    @Override
    public String putData(String key) {
        /** 返回入参和 value */
        logger.info("putData print");
        return "key :" + key + ", value: " + 123;
    }

    /**
     * 删除缓存,在方法執行前進行刪除緩存
     *
     * @param key
     */
    @CacheEvict(key = "#root.target.getPrefix()+#key", beforeInvocation = true)
    @Override
    public void Evict(String key) {
        logger.debug("删除了 key  为" + key + "的缓存，");
    }

    /**
     * 测试一个 key相同但是返回值类型不同的缓存项，测试 key
     */
    /**
     * 返回 String
     *
     * @param key
     * @return
     */
    @Cacheable(key = "#root.target.getPrefix() + #key")
    @Override
    public String saveString(String key) {
        logger.debug("saveString invoke");
        return "Vicent";
    }

    /**
     * 返回 int
     *
     * @param key
     * @return
     */
    @Cacheable(key = "#root.target.getPrefix() + #key")
    @Override
    public int saveint(String key) {
        logger.debug("saveint invoke");
        return 555;
    }


}
