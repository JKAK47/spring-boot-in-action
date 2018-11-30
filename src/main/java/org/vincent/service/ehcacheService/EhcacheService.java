package org.vincent.service.ehcacheService;

/**
 * Created by PengRong on 2018/11/27.
 */
public interface EhcacheService {
    public String save(String key);
    public  String putData(String key);
    public  void  Evict(String key);


    /**
     *  下面两个方法用于测试 同一个key 不同返回值类型造成缓存 失败
     * @param key
     * @return
     */
    public  String saveString(String key) ;

    public  int saveint(String key);
}
