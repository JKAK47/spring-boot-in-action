package org.vincent.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

/**
 * 获取一些基目录 工具类
 *
 * @author S0076
 *
 */
public class DiretoryUtils {
    private final static Logger logger = LoggerFactory.getLogger(DiretoryUtils.class);

    /**
     * 获取<b>可执行jar包 </b>所在目录 绝对路径字符串
     *
     * @author S0076
     * @return
     */
    public static String getJarDiretory() {
        String jarPath = "";

        try {
            // 获取jar 文件所在 目录
            File path = new File(ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath());
            if (!path.exists())
                path = new File("");
            // basePath = "file:/"+path.getAbsolutePath();
            jarPath = path.getAbsolutePath();
            jarPath = URLDecoder.decode(jarPath, "utf-8");
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        /** 字符串以分隔符结尾 */
        if (!jarPath.endsWith(File.separator)) {
            jarPath = jarPath + File.separator;
        }
        logger.info("jarPath:" + jarPath);
        return jarPath;
    }

    /**
     * D:\Dev\WorkStation\OneLife\iModule-proposal-service\target\classes\
     file:/D:/Dev/WorkStation/OneLife/iModule-proposal-service/target/classes/
     \
     /D:/Dev/WorkStation/OneLife/iModule-proposal-service/target/classes/
     file:/C:/app/service/iModule-proposal-service-proposal/logs
     file:/D:/Dev/WorkStation/OneLife/iModule-proposal-service/target/classes/
     * @param args
     * @throws MalformedURLException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
        /** 单侧结果： 工程目录/target/classes 目录: D:\Dev\WorkStation\OneLife\iModule-proposal-service\target\classes\ */
        System.out.println(getJarDiretory());
        System.out.println(new File(getJarDiretory()).toURI());
        System.out.println(File.separator);
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(new URL("file:/C:\\app\\service\\iModule-proposal-service-proposal\\logs"));
        /** File 转 URI */
        System.out.println(new File(getJarDiretory()).toURI().toURL());
        System.getProperty("user.dir");
        File upload = new File(getJarDiretory(),"static/images/upload/");
        System.out.println(upload.toPath());
        System.out.println(upload.toPath().getFileName());
        System.out.println(upload.toURI());
        System.out.println("--------++++++++");
        /** 这个方法返回 空不能用 */
        ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println("--------++++++++");
        ApplicationHome home = new ApplicationHome(DiretoryUtils.class);
        System.out.println( home.getSource());
    }

}
