package com.zr.gansu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author USER
 */
@SpringBootApplication(scanBasePackages={"com.zr.gansu"})
@PropertySource(value = { "application.properties"})
@MapperScan("com.zr.gansu.dao")
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
