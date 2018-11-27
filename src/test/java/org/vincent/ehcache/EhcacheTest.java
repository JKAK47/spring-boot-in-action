package org.vincent.ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.service.ehcacheService.EhcacheService;

/**
 * Created by PengRong on 2018/11/27.
 * Ehcache 测试案例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheTest {
    private Logger logger =LoggerFactory.getLogger(EhcacheTest.class);
    @Autowired
    private EhcacheService ehcacheService;

    @Test
    public void test() {
        logger.error("begin ");
        String value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");

        value = ehcacheService.save("C024");
    }
}
