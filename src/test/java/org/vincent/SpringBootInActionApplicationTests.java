package org.vincent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.vincent.dao.impl.TbUserMapper;
import org.vincent.dao.model.TbUser;
import org.vincent.dao.model.TbUserExample;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 单表 db 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootInActionApplicationTests {
    @Autowired
    private TbUserMapper mapper;

    @Test
    public void contextLoads() {
        TbUserExample example=new TbUserExample();
        List<TbUser> lists=mapper.selectByExample(example);
        assertNotNull(lists);
        assertNotNull(lists);
        assertNotEquals(0,lists.size());
    }

}
