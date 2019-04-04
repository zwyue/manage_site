package com.zr.gansu.manage;

import com.zr.gansu.manage.configs.UploadSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author USER
 */
@SpringBootApplication(scanBasePackages="com.zr.gansu",exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class})
@PropertySource(value = { "application.properties"})
@MapperScan("com.zr.gansu.dao")
public class GansuManageApplication {

    @Bean
    @ConfigurationProperties(prefix = "upload")
    public UploadSettings uploadSettings(){
        return new UploadSettings();
    }
    public static void main(String[] args) {
        SpringApplication.run(GansuManageApplication.class, args);
    }
}
