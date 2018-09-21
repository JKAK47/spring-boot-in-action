package org.vincent.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.dao.model.TbUser;

/**
 * Created by PengRong on 2018/9/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserIMapperTest {
    @Autowired
    private  TbUserIMapper tbUserIMapper;
    @Test
    public void  testgetTbUsers(){
        TbUser lists=tbUserIMapper.getTbUser(1);
        System.out.println(lists.toString());
    }
}
