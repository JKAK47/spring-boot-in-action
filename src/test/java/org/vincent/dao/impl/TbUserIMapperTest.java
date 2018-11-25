package org.vincent.dao.impl;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.dao.imapper.TbUserIMapper;
import org.vincent.dao.model.BatchJobInstance;
import org.vincent.dao.model.BatchJobInstanceExample;
import org.vincent.dao.model.TbUser;

/**
 * Created by PengRong on 2018/9/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserIMapperTest {
    @Autowired
    private TbUserIMapper tbUserIMapper;

    @Autowired
    private  BatchJobInstanceMapper batchJobInstanceMapper;
    /**
     *  一开始 执行 报错没找到对应的org.vincent.dao.imapper.TbUserIMapper.getTbUser 是因为 映射xml 文件 TbUserICustomMapper 没有文件
     *  后缀名 .xml ; 只需要添加上后就好啦。
     */
    @Test
    public void  testgetTbUsers(){
        TbUser lists=tbUserIMapper.getTbUser(1);
        System.out.println(lists.toString());
    }
    @Test
    public  void  testselectByExample(){
        BatchJobInstanceExample example =new  BatchJobInstanceExample();
        example.createCriteria().andJobInstanceIdEqualTo(1L);
        List<BatchJobInstance> instances = batchJobInstanceMapper.selectByExample(example);
        System.out.println(instances.size());
    }
}
