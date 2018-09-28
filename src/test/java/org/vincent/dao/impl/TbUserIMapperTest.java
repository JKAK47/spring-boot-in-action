package org.vincent.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.dao.imapper.TbUserIMapper;
import org.vincent.dao.model.TbUser;

/**
 * Created by PengRong on 2018/9/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserIMapperTest {
    @Autowired
    private TbUserIMapper tbUserIMapper;

    /**
     *  一开始 执行 报错没找到对应的org.vincent.dao.imapper.TbUserIMapper.getTbUser 是因为 映射xml 文件 TbUserICustomMapper 没有文件
     *  后缀名 .xml ; 只需要添加上后就好啦。
     */
    @Test
    public void  testgetTbUsers(){
        TbUser lists=tbUserIMapper.getTbUser(1);
        System.out.println(lists.toString());
    }
}
