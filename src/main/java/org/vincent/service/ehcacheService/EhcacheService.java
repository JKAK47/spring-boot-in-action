package org.vincent.service.ehcacheService;

/**
 * Created by PengRong on 2018/11/27.
 */
public interface EhcacheService {
    public String save(String key);
    public  String putData(String key);
    public  void  Evict(String key);
}
