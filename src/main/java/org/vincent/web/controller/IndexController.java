package org.vincent.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PengRong on 2018/9/19.
 * 首页 index 响应
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Hello Spring Boot";
    }
}
