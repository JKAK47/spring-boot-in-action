package org.vincent.dao.imapper;

import org.vincent.dao.model.TbUser;

/**
 * Created by PengRong on 2018/9/21.
 * @author PengRong
 * 自定义 的mapper，映射到xml 文件 (TbUserICustomMapper.xml) 执行
 */

public interface TbUserIMapper {
    TbUser getTbUser(int id);
}
