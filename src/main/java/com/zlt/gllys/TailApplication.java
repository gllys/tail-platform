package com.zlt.gllys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource(locations = "classpath:/mappers.xml")
public class TailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TailApplication.class, args);
    }
}
