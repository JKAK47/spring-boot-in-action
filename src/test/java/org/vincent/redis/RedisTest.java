package org.vincent.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.service.redisService.ServiceRedisCache;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by PengRong on 2018/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ServiceRedisCache serviceRedisCache;

    @Test
    public void testRedis() {
        //  stringRedisTemplate 插入string 设置了key 和value 序列化，不会乱码
        String key = "demo:01";
        stringRedisTemplate.opsForValue().set(key, "s0fasdfasdfasdf0dlf");
        stringRedisTemplate.expire(key, 10000, TimeUnit.SECONDS);
        stringRedisTemplate.opsForList().leftPush(key+":list:str", "aaaa");
        stringRedisTemplate.opsForList().leftPush(key+":list:str", "bbb");
        stringRedisTemplate.opsForList().leftPush(key+":list:str", "ccc");
        // redisTemplate 插入list 和 str 值以hex 显示
        redisTemplate.opsForList().leftPush(key+":list", Arrays.asList("aaaaa","bbbbbbb","cccccccc"));
        redisTemplate.opsForList().leftPush(key+":list", Arrays.asList("BBB","CC","DD"));
        redisTemplate.opsForValue().set("pr","asdfsd");//redisTemplate 设置的value 会乱码
    }

    @Test
    public void testgetName() throws InterruptedException {
        System.out.println("sdfs");
        String value = serviceRedisCache.getName("demo:02:key");
        value = serviceRedisCache.getName("demo:02:key");
        value = serviceRedisCache.getName("demo:02:key");
        value = serviceRedisCache.getName("demo:02:key");
        Thread.sleep(20);
        Thread.sleep(20);
        value = serviceRedisCache.getName("demo:02:key");
    }

    public static Date getExpirationtime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, 1);
        Date clear_point = calendar.getTime();
        Date now = new Date();
        while (clear_point.getTime() - now.getTime() < 3 * 3600 * 1000) {
            calendar.add(Calendar.DATE, 1);
            clear_point = calendar.getTime();
        }
        return clear_point;
    }
}
