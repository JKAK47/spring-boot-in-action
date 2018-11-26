package org.vincent.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public  void  testRedis(){
        String key="demo:01";
        stringRedisTemplate.opsForValue().set(key,"sdlf");
        stringRedisTemplate.expire(key,10000, TimeUnit.MILLISECONDS);


    }
    public static Date getExpirationtime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE,1);
        Date clear_point=calendar.getTime();
        Date now=new Date();
        while (clear_point.getTime()-now.getTime()<3*3600*1000){
            calendar.add(Calendar.DATE,1);
            clear_point=calendar.getTime();
        }
        return clear_point;
    }
}
