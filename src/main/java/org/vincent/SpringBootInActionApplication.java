package org.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author PengRong
 *         Spring boot 启动入口 main 函数;
 *         MapperScan 注解 通过 {} 可以扫描多个package下的mapper， 如果只有一个package @MapperScan("org.vincent.dao.impl")
 */
@SpringBootApplication
@MapperScan({"org.vincent.dao.impl", "org.vincent.dao.imapper"})
public class SpringBootInActionApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringBootInActionApplication.class);

    public static void main(String[] args){
        logger.debug("start spring boot");
        SpringApplication.run(SpringBootInActionApplication.class, args);
    }
}
