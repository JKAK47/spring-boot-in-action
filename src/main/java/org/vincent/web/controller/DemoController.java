package org.vincent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.service.DBConnector;

/**
 * Created by PengRong on 2018/9/28.
 */
@RestController
@RequestMapping("/task")
public class DemoController {
    @Autowired
    private DBConnector connector;
    @RequestMapping(value = {"/cusvar", "/c"})
    public String hellTask(@Value("${cusvar}") String cusvar) {/** 通过value 注解获取到 *.properties 文件的值赋值给函数形参。 */
        connector.configure();//根据环境获取到不同接口实现  DBConnector 实例。
        return "hello task !! myage is " + cusvar;
    }
}
