package org.vincent.dao.impl;

import org.vincent.dao.model.TbUser;

/**
 * Created by PengRong on 2018/9/21.
 * @author PengRong
 * 自定义 的mapper，映射到xml 文件执行
 */

public interface TbUserIMapper {
    TbUser getTbUser(int id);
}
