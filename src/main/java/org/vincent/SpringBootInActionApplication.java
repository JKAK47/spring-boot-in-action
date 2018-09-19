package org.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PengRong
 * Spring boot 启动入口 main 函数
 */
@SpringBootApplication
@MapperScan("org.vincent.dao.mapper")
public class SpringBootInActionApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringBootInActionApplication.class);
    public static void main(String[] args) {
        logger.debug("start spring boot");
        SpringApplication.run(SpringBootInActionApplication.class, args);
    }
}
