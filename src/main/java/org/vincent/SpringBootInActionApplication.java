package org.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PengRong
 */
@RestController
@SpringBootApplication
@MapperScan("org.vincent.dao.mapper")
public class SpringBootInActionApplication {

	@RequestMapping("/")
	@ResponseBody
	String index() {
		return "Hello Spring Boot";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInActionApplication.class, args);
	}
}
