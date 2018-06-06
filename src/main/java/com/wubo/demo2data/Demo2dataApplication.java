package com.wubo.demo2data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wubo.demo2data")
public class Demo2dataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo2dataApplication.class, args);
    }
}
