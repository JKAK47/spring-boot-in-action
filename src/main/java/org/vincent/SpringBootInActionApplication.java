package org.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import org.vincent.common.util.DiretoryUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @author PengRong
 *         Spring boot 启动入口 main 函数;
 *         MapperScan 注解 通过 {} 可以扫描多个package下的mapper， 如果只有一个package @MapperScan("org.vincent.dao.impl")
 */
@SpringBootApplication
@MapperScan({"org.vincent.dao.impl", "org.vincent.dao.imapper"})
public class SpringBootInActionApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringBootInActionApplication.class);

    public static void main(String[] args) throws IOException {
        logger.debug("start spring boot");
        SpringApplication.run(SpringBootInActionApplication.class, args);
        /**
         * 下面是测试方法
         */
        String path = SpringBootInActionApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        logger.error(path);
        path = URLDecoder.decode(path, "UTF-8");
        logger.error(path);
        URL jarUrl = SpringBootInActionApplication.class.getProtectionDomain().getCodeSource().getLocation();
        /** jar包classpath 所在路径  jar:file:/D:/Dev/WorkStation/OneLife/spring-boot-in-action/target/springboot-in-action.jar!/BOOT-INF/classes!/  */
        logger.error(jarUrl.toString());

        /**
         * 读取jar包里面的文件
         */
        logger.error("jarUrl--="+jarUrl.toString()+"!/resources/config/application-test.properties");
        jarUrl=new URL(jarUrl.toString()+"!/resources/config/application-test.properties");
        logger.error(jarUrl.toString());
        InputStream inputStream =jarUrl.openStream();
        Assert.notNull(inputStream,"inputStream is not null");
        logger.error(inputStream.toString());
        // URL url = new URL("jar:file" + path + "!/resources/config/application-test.properties");
        // System.out.println(url);
        logger.error("jarPath="+ DiretoryUtils.getJarDiretory());
    }
}
